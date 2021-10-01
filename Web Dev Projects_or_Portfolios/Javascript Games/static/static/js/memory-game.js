// List of all memory-card elements and store in constant "card"
const cards = document.querySelectorAll('.memory-card');

// Initially all cards will be unflipped
let hasFlipped = false;
var points = 0;
var chances = 10;
var cardsMatched = 0;
document.getElementById("totalpoints").innerHTML = "Total Points = "+points+" Chances Left = "+chances
let lockBoard = false;

// we declare both the card variables
let firstCard, secondCard;

function flipCard(){
    /* we access classList of memory card and toogle the flipped class
    toggles : if class is there => (remove it) & if class is not there => (add it)
    this.classList.toggle('flip'); */

    if(lockBoard) return;

    if (this === firstCard) return;
    this.classList.add('flip');

    if(!hasFlipped){
        // First click
        hasFlipped = true;
        // HERE "this" IS A "memory-card" CLASS 
        firstCard = this;
        return;
    }   // Second click
    secondCard = this;
    if(chances!=0){
        if(cardsMatched === 5){
            if(confirm("Wohhhoo...! You Won")){
                location.reload();
            }
        }
        checkForMatch();
    }else{
        if(confirm("Oopss...! You Lost the game, try again?")){
            location.reload();
        }
    }
}

// Now we check if the cards match
// To access "data" attribute in html file we use dataset.""
function checkForMatch(){
    let isMatch = firstCard.dataset.name === secondCard.dataset.name;
    if(isMatch){
        disableCards();
    } else{
        unflipCards();
    }
    document.getElementById("totalpoints").innerHTML = "Total Points = "+points+" Chances Left = "+chances
}
function disableCards(){
    points+= 1;
    cardsMatched+=1;
    firstCard.removeEventListener('click', flipCard);
    secondCard.removeEventListener('click', flipCard);
    resetBoard();
}
function unflipCards(){
    lockBoard = true;

    setTimeout(() => {
        chances-= 1;
        firstCard.classList.remove('flip');
        secondCard.classList.remove('flip');
        resetBoard();
      }, 1000);
}
function resetBoard() {
    [hasFlipped, lockBoard] = [false, false];
    [firstCard, secondCard] = [null, null];
}
(function shuffle() {
    cards.forEach(card => {
      let ramdomPos = Math.floor(Math.random() * 12);
      card.style.order = ramdomPos;
    });
})();
/* We loop through list and to each element we add an event listener for "click" event
When that event is fired we call the func flipCard() */
cards.forEach(card => card.addEventListener('click', flipCard));