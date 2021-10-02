const path = require('path')

const http = require('http')


const express = require('express')
const socketio = require('socket.io')
const Filter  = require('bad-words')
const {generateMessage, generateLocation} = require('./utils/messages')

const { addUser, removeUser, getUser, getUsersInRoom } = require('./utils/users')
const app  =  express()

const server = http.createServer(app)
const io = socketio(server)

const port = process.env.PORT  || 3000
const publicDirectoryPath = path.join(__dirname, '../public')

app.use(express.static(publicDirectoryPath))

let count = 0
io.on('connection', (socket) =>{
    console.log('New web socket connection')

   

    socket.on('join', ({username, room}, callback)=>{

        const {error, user} = addUser({ id: socket.id, username, room})

        if(error){
            return callback(error)

        }
        socket.join(user.room)

        socket.emit('message', generateMessage('Chat Bot', 'Welcome'))

        socket.broadcast.to(user.room).emit('message', generateMessage('Chat Bot', `${user.username} has joined!!!`))
        io.to(user.room).emit('roomdata', {
            room: user.room,
            users: getUsersInRoom(user.room)
        })

        callback()


    })

    // socket.on('increment', () =>{
    //     count++
    //     //socket.emit('countUpdated', count)

    //     io.emit('countUpdated', count)
    // })
    
    socket.on('sendMessage', (msg, callback)=>{
        const user = getUser(socket.id)
        const filter = new Filter()

        if(filter.isProfane(msg))
        {
            return callback('bad-words not allowed')
        }
        io.to(user.room).emit('message', generateMessage(user.username, msg))
        callback()
    })

    socket.on('sendlocation', (coords, callback)=>{
        const user = getUser(socket.id)
        io.to(user.room).emit('locationMessage', generateLocation(user.username,`https://google.com/maps?q=${coords.lat},${coords.lon}`))
        callback()
    })

    socket.on('disconnect', ()=>{
        const user = removeUser(socket.id)
        if(user){
            io.to(user.room).emit('message', generateMessage('Chat Bot', `${user.username} has left!!!`))
            io.to(user.room).emit('roomdata', {
                room: user.room,
                users: getUsersInRoom(user.room)
            })

        }
        
    })
})

server.listen(port, ()=> {
    console.log(`listening on port ${port}`)
})

