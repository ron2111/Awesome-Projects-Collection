
let cards = []
let sum = 0
let hasBlackJack = false
let isAlive = false
let message = ''
let messageEl = document.getElementById('message-el')
let sumEl = document.getElementById('sum-el')
let cardsEl = document.getElementById('cards-el')
let player = {
    name: "Harsha",
    chips: 145
}
let playerEl = document.getElementById("player-el")
playerEl.textContent = player.name + ": $" + player.chips


function getRandomCard() {
    let randomNumber = Math.floor(Math.random() * 13) + 1
    if (randomNumber == 1) return 11;
    else if (randomNumber > 10) return 10;
    else return randomNumber;
}

function startGame() {
    isAlive = true
    let firstCard = getRandomCard()
    let secondCard = getRandomCard()
    cards = [firstCard, secondCard]
    sum = firstCard + secondCard
    renderGame()
}

function renderGame() {

    if (sum < 21)
        message = "Do you want to draw a new card?"
    else if (sum == 21) {
        message = "Wohoo! You've got Blackjack!"
        hasBlackJack = true
    }
    else {
        message = "You're out of the game!"
        isAlive = false
    }


    cardsEl.textContent = `Cards:`
    for (let i = 0; i < cards.length; i++) {
        cardsEl.textContent += ` ${cards[i]}`
    }
    sumEl.textContent = `Sum: ${sum}`
    messageEl.textContent = message
}

function newCard() {
    if (!(hasBlackJack) && isAlive) {
        let card = getRandomCard()
        cards.push(card)
        sum += cards[cards.length - 1]
        renderGame()
    }
}

function resetGame() {
    cards = []
    sum = 0
    cardsEl.textContent = `Cards:`
    sumEl.textContent = `Sum:`
    messageEl.textContent = `Want to play a round again?`
}