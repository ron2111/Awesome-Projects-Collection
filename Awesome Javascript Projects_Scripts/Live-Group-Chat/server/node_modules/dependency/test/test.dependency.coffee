[Dependency, chai, path] = (
  require(v) for v in [
    '../src/dependency', 'chai', 'path'
  ]
)

should = chai.should()
describe('Dependency', ->
  dependency = new Dependency()
  beforeEach(()->
    dependency = new Dependency()
  )
  it('init test', () ->
      Dependency.should.be.a('function')
  )
  it('should instanciate', () ->
      dependency.should.be.a('object')
  )
)