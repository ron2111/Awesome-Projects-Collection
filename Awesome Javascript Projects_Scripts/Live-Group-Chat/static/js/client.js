const socket = io('http://localhost:8000');

// Get DOM elements in respective Js variables
const form = document.getElementById('send-container');
const messageInput = document.getElementById('messageInp')
const messageContainer = document.querySelector(".container")

// Audio that will play on receiving messages
var audio = new Audio('alert.mp3');

// Function which will append event info to the contaner
const append = (message, position) => {
    const messageElement = document.createElement('div');
    messageElement.innerText = message;
    messageElement.classList.add('message');
    messageElement.classList.add(position);
    messageContainer.append(messageElement);
    if (position == 'left') {
        audio.play();
    }
}



//getname() function
function getname() {
    //taking input
    const tname = prompt("Enter your name to join\n(5-20 characters)");
    //if input is not null
    if ((tname != null)) {
        //removing extra whitespaces
        const tempname = tname.trim();
        //if input is greater than 5
        if ((tempname.length) >= 5) {
            if ((tempname.length) > 20) {
                //trim tempname to 20 charecters and save it to name
                name = (tempname.substring(0, 20));
            } else {
                //name is < 20
                name = tempname;
            }
            socket.emit('new-user-joined', name);
        } else {
            //retry if input is less than 5
            getname();
        }
    } else {
        //retry if input is null
        getname();
    }
}
//calling getname() function
getname()






// If a new user joins, receive his/her name from the server
socket.on('user-joined', name => {
    append(`${name} joined the chat`, 'left')
})

// If server sends a message, receive it
socket.on('receive', data => {
    append(`${data.name}: ${data.message}`, 'left')
})

// If a user leaves the chat, append the info to the container
socket.on('left', name => {
    append(`${name} left the chat`, 'left')
})

// If the form gets submitted, send server the message
form.addEventListener('submit', (e) => {
    e.preventDefault();
    const message = messageInput.value;
    append(`You: ${message}`, 'right');
    socket.emit('send', message);
    messageInput.value = ''
})