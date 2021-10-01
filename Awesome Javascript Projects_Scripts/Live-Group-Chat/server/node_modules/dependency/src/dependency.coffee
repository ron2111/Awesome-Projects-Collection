[fs,path, coffee, js2coffee, util, async, _] = (
  require(v) for v in [
    'fs', 'path', 'coffee-script', 'js2coffee', 'util', 'async', 'underscore'
  ]
)
module.exports = class Dependency

  constructor : (@localOnly = false) ->
    @dependencies = {}
  read : (file, cb) ->
    files = []
    if not util.isArray(file)
      file = [file]
    for v in file
      files.push(path.resolve(v))

    @asyncRead(files, () =>
      cb(@dependencies)
    )

  readFile : (file, cb) ->
    extname = path.extname(file)
    rfile = file
    if extname is ''
      rfile = file + '.coffee'
    fs.readFile(rfile, 'utf8', (err, body)=>
      if not err
        cb(err, '.coffee', body)
      else
        rfile = file + '.js'
        fs.readFile(rfile, 'utf8', (err, body)=>
          cb(err, '.js', body)
        )
    )

  _read : (file, cb) ->
    @readFile(file, (err, extname, body) =>
      if err
        console.log(err)
        cb()
      else
        @dependencies[file] = {children: [], extname : extname}
        jserror = false
        files = []
        if extname is '.js'
          try
            body = js2coffee.build(body)
          catch e
            jserror = true
            console.log(e)
        if jserror
          cb()
        else
          nodes = coffee.nodes(body)
          @_parseNode(nodes, file, false, false, files)
          files = _(files).uniq()
          if files.length isnt 0
            @asyncRead(files, cb)
          else
            cb()
    )

  asyncRead: (files, cb) ->
    async.forEach(
      files
      (v, callback) =>
        @_read(v, () =>
          callback()
        )
      () =>
        cb()
    )

  trim: (str) ->
    return str.replace(/^\'/,'').replace(/\'$/,'').replace(/^\"/,'').replace(/\"$/,'')

  isRequire: (node, file, parent, gparent, files) ->
    if node.value is 'require'
      for v in gparent.args
        if v.base?.value? and (v.base.value.match(/^'.*'$/) isnt null or v.base.value.match(/^'.*'$/) isnt null)
          moduleName = @trim(v.base.value)
          if moduleName.match(/\.{1,2}/) isnt null
            fname = path.join(path.dirname(file),moduleName)
            if not @dependencies[fname]?
              files.push(fname)
          else if not @localOnly
            fname = moduleName
          else
            fname = false
          unless fname is false
            @dependencies[file].children.push(fname)
            @dependencies[file].children = _(@dependencies[file].children).uniq()
  
  _parseNode: (node, file, parent, gparent, files) ->
    @isRequire(node, file, parent, gparent, files)
    if util.isArray(node)
      for v, i in node
        @_parseNode(v, file, node, parent, files)
    else if typeof(node) is 'object'
      for k, v of node
        if v?
          @_parseNode(v, file, node, parent, files)
  addExtname : (file, extname)->
    if path.extname(file) is ''
      return  file + extname
    else
      return file
  listLocalFiles : ->
    locals = []
    for k, v of @dependencies
      if k.match(/^\//) isnt null
        locals.push(@addExtname(k, v.extname))
      for v2 in v.children
        if v2.match(/^\//) isnt null and @dependencies[v2]?
          locals.push(@addExtname(v2, @dependencies[v2].extname))
    return _(locals).uniq()
  listNodeModules : ->
    modules = []
    for k, v of @dependencies
      if k.match(/^\//) is null
        modules.push(k)
      for v2 in v.children
        if v2.match(/^\//) is null
          modules.push(v2)
    return _(modules).uniq()
    