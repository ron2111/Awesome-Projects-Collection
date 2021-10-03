const users = []

const addUser = ({id, username, room}) => {
    username = username.trim().toLowerCase()
    room = room.trim().toLowerCase()

    if(!username || !room)
    return {
        error: 'Username and room are required'
    }

    const existingUser = users.find((user) =>{
        return user.room === room && user.username === username
    })

    if(existingUser){
        return {
            error: 'Username is already taken'
        }
    }


    const user = {id, username, room}
    users.push(user)
    return {user}

}

const removeUser = (id) =>{
    const index = users.findIndex((user)=> user.id === id )
    if(index != -1){
        return users.splice(index, 1)[0]
    }
}

const getUser = (id) =>{
    return users.find((user) => user.id === id)
}

const getUsersInRoom = (room) =>{
    return users.filter((user) => user.room === room)
}
// addUser({
//     id: 22,
//     username: "milan",
//     room: "sacred"
// })

// addUser({
//     id: 32,
//     username: "mil",
//     room: "sacred"
// })

// addUser({
//     id: 42,
//     username: "mila",
//     room: "sacred"
// })

// const user = getUser(42)
// console.log(user)
// const userList = getUsersInRoom("sacred")
// console.log(userList)

module.exports = {
    addUser,
    removeUser,
    getUser,
    getUsersInRoom
}