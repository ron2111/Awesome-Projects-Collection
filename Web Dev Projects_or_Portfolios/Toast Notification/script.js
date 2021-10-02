const button = document.getElementById('button')
const toasts = document.getElementById('toasts')

const messages = [
    'Message one',
    'Message two',
    'Message three',
    'Message four'
]

const types = ['info','success','error']

button.addEventListener('click', () => createNotification())

function createNotification() {
    const notif = document.createElement('div')
    notif.classList.add('toast')
    notif.classList.add(getrandomtype())

    notif.innerText = getrandom()
    toasts.appendChild(notif)

    setTimeout(() => {
        notif.remove()
    },3000)
}

function getrandom() {
    return messages[Math.floor(Math.random() * messages.length)]
}

function getrandomtype() {
    return types[Math.floor(Math.random() * types.length)]
}