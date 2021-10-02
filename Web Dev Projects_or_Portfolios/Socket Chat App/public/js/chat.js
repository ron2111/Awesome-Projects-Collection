const socket = io()

//elements
const _messageForm = document.querySelector('#message-form')
const _messageFormInput = document.querySelector('input')
const _messageFormButton = document.querySelector('#sendButton')
const _sendLocationButton = document.querySelector('#send-location')
const _messages = document.querySelector('#messages')

//templates
const messageTemplate = document.querySelector('#msg-template').innerHTML
const locationTemplate =  document.querySelector('#loc-msg-template').innerHTML
const sidebarTemplate = document.querySelector('#sidebar-template').innerHTML

//options
const { username, room} = Qs.parse(location.search, { ignoreQueryPrefix: true})

const autoscroll = () =>{
    const _newMessage = _messages.lastElementChild

    const newMessageStyles = getComputedStyle(_newMessage)
    const newMessageMargin = parseInt(newMessageStyles.marginBottom)

    const newMessageHeight = _newMessage.offsetHeight + newMessageMargin

    const visibleHeight = _messages.offsetHeight


    const containerHeight = _messages.scrollHeight


    const scrolloffset = _messages.scrollTop + visibleHeight

    if(containerHeight - newMessageHeight <= scrolloffset){

        _messages.scrollTop = _messages.scrollHeight

    }





}


socket.on('locationMessage', (urlLocation)=>{
    console.log(urlLocation)

    const html = Mustache.render(locationTemplate, {
        username: urlLocation.username,
        urlLocation: urlLocation.url,
        createdAt: moment(urlLocation.createdAt).format('hh:mm A')
    })
    _messages.insertAdjacentHTML('beforeend', html)
    autoscroll()
})


socket.on('message', (msg)=>{

    const html = Mustache.render(messageTemplate,{
        username: msg.username,
        message: msg.text,
        createdAt: moment(msg.createdAt).format('hh:mm A')
    })
    _messages.insertAdjacentHTML('beforeend', html)
    autoscroll()
})

socket.on('roomdata', ({room, users}) =>{
    // console.log(room)
    // console.log(users)

    const html = Mustache.render(sidebarTemplate, {
        room,
        users
    })
    document.querySelector('#sidebar').innerHTML = html
})

_messageForm.addEventListener('submit', (e)=>{

    e.preventDefault()

    _messageFormButton.setAttribute('disabled', 'disabled')

    let data = document.querySelector('input').value 
    socket.emit('sendMessage', data, (msg)=>{
    _messageFormButton.removeAttribute('disabled')
    _messageFormInput.value = ''
    _messageFormInput.focus()

        if(msg){
            return console.log(msg)
        }
        console.log('the message has been acknowledged')
    })

})

_sendLocationButton.addEventListener('click', ()=>{
    if(!navigator.geolocation)
    {
        return alert('geolocation not supported')
    }

    _sendLocationButton.setAttribute('disabled', 'disabled')
    navigator.geolocation.getCurrentPosition((position)=> {
       socket.emit('sendlocation', 
       { lat: position.coords.latitude, lon: position.coords.longitude },
       ()=>{

           _sendLocationButton.removeAttribute('disabled')
           console.log('location shared')
       })
    })
})

socket.emit('join', {username, room}, (error) =>{
    if(error){
        alert(error)
        location.href = '/'
    }
})