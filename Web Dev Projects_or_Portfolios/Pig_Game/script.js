'use strict';
//selecting elements
const player0El = document.querySelector('.player--0');
const player1El = document.querySelector('.player--1');
const score0El = document.querySelector('#score--0');
const score1El = document.getElementById('score--1'); //faster than queryselector but both work same
const current0El = document.getElementById('current--0');
const current1El = document.getElementById('current--1');
const diceEl = document.querySelector('.dice');

const btnNew = document.querySelector('.btn--new');
const btnRoll = document.querySelector('.btn--roll');
const btnHold = document.querySelector('.btn--hold');

let currentScore, scores, activePlayer, playing;
const init = function () {
  //initialisation

  //starting conditions

  //array to store scores
  scores = [0, 0];
  currentScore = 0;
  activePlayer = 0;

  //by using 'playing' button we only be able to click on the buttons if playing state is true
  playing = true; //it will keep track that whether we are in the state of playing the game or not

  //set total score to zero
  score0El.textContent = 0;
  score1El.textContent = 0;

  current0El.textContent = 0;
  current1El.textContent = 0;

  //to hide dice we are just adding hidden class to the dice class
  diceEl.classList.add('hidden');
  player0El.classList.remove('player--winner');
  player1El.classList.remove('player--winner');

  //if add the class which is already there it will do nothing and if it is not there it will simply add it---->and same for remove
  player0El.classList.add('player--active');
  player1El.classList.remove('player--active');
};

//calling the functions to initialise all the variables
init();

const switchPlayer = function () {
  //switch to the next player
  //set the current score 0 of both (active and non-active) players
  document.getElementById(`current--${activePlayer}`).textContent = 0;
  currentScore = 0;
  activePlayer = activePlayer == 0 ? 1 : 0;

  //toggle method will add player--active class if it not there or if it is there it will remove it
  player0El.classList.toggle('player--active');
  player1El.classList.toggle('player--active');
};

//rolling dice functionality
btnRoll.addEventListener('click', function () {
  if (playing) {
    //1.generating a random dice roll
    const dice = Math.trunc(Math.random() * 6) + 1;

    //2. Display dice
    diceEl.classList.remove('hidden');
    diceEl.src = `dice-${dice}.png`;

    //3.Check for rolled 1 :if true, switch to next player
    if (dice != 1) {
      //add dice to current score
      currentScore = currentScore + dice;
      //taking active player dynamically
      document.getElementById(`current--${activePlayer}`).textContent =
        currentScore;
      // current0El.textContent = currentScore; // chage later
    } else {
      switchPlayer();
    }
  }
});

btnHold.addEventListener('click', function () {
  if (playing) {
    //1. Add current score to active palyer's score
    scores[activePlayer] += currentScore;

    // console.log(scores[activePlayer]);
    // scores[1] = scores[1] + currentScore;
    document.getElementById(`score--${activePlayer}`).textContent =
      scores[activePlayer];

    //2.check if player's score is >=100

    if (scores[activePlayer] >= 100) {
      //finish the game
      playing = false; //we are not gonna paly the game anymore
      //add a special class to the player who wins the game
      diceEl.classList.add('hidden');
      document
        .querySelector(`.player--${activePlayer}`)
        .classList.add('player--winner');
      document
        .querySelector(`.player--${activePlayer}`)
        .classList.remove('player--active');
    } else {
      //3.Switch to the next player
      switchPlayer();
    }
  }
});

btnNew.addEventListener('click', init); //javascript will automatically call the init function as soon as user will click on the NEW GAME button
