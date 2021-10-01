// Node server which will handle socket io connections
const io = require('socket.io')(8000, {
    cors: {
        origin: "http://localhost",
        methods: ["GET,HEAD,PUT,PATCH,POST,DELETE"]
    }
})

const users = {};

io.on('connection', socket => {
    // If any new user joins, let other users connected to the server know!
    socket.on('new-user-joined', name => {
        users[socket.id] = name;
        console.log("Joined", name)
        socket.broadcast.emit('user-joined', name);
    });

    // If someone sends a message, broadcast it to other people
    socket.on('send', message => {
        socket.broadcast.emit('receive', { message: message, name: users[socket.id] })
    });

    // If someone leaves the chat, let others know 
    socket.on('disconnect', message => {
        socket.broadcast.emit('left', users[socket.id]);
        delete users[socket.id];
    });


})