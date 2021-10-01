//for sound when click on color buttons
function sound(button){
  color = $(button).attr("id");

  switch (color) {
    case "green":
      var audio = new Audio("sounds/green.mp3")
      audio.play();
      break;
    case "red":
      var audio = new Audio("sounds/red.mp3")
      audio.play();
      break;
    case "yellow":
      var audio = new Audio("sounds/yellow.mp3")
      audio.play();
      break;
    case "blue":
      var audio = new Audio("sounds/blue.mp3")
      audio.play();
      break;
  }
}

//when button is click/pressed
function pressed(button) {
  //console.log($(button).attr("id")+" is pressed!");
  sound(button);

  //adding small animation of pressing button
  $(button).addClass("pressed");
  setTimeout(function () {
    $(button).removeClass("pressed");
  }, 80);
}

colors=['red','green','blue','yellow'];
levelColor = []; //store level color
userColor = []; //store user input color
globalLevel = 1; //store game level
highestLevel = 0;

//create level
function create(level)
{
  $("button").off("click"); //disable click on start button
  $("button").text("IN PROGRESS");
  $("h1").html("HIGHEST LEVEL: "+highestLevel+"<br> LEVEL: "+globalLevel ) //update score on screen

  console.log("\nCREATING LEVEL..... "+level);

  let i = 0;
  for(;i<level;++i)
  {
    let n = Math.floor(Math.random()*4) //create numb 0 to 3
    levelColor.push(colors[n]) //push new color

    //do animation of current level color button in a gap of i*500
    setTimeout(function () {
      pressed($("#"+colors[n]));
    }, i*500);
  }
  console.log("Current level color: ",levelColor);

  //enable click for color button and start button
  setTimeout(function(){
    console.log("NOW USER CAN CLICK COLORS !")
    enableClick();
    enableStartButton();
    $("button").text("RESTART GAME");
  },i*500)
}


//when user input wrong sequence of colors
function gameover(){
  console.log("\n!!! WRONG INPUT !!!");
  let audio = new Audio("sounds/wrong.mp3");
  audio.play();

  $("h1").html("!!!GAME OVER!!!<br> LEVEL: "+globalLevel);

  //do game over animation
  $("body").addClass("game-over");
  setTimeout(function () {
    $("h1").html("HIGHEST LEVEL: "+highestLevel+"<br> Press any Key to Start");
    $("body").removeClass("game-over");
  }, 1500);

  if(globalLevel > highestLevel) highestLevel=globalLevel; //update high score

  //starting keypress again to begin new game
  beginGame();
}

function reset(){
  userColor = [];
  levelColor = [];
}

//check if sequence of colors get clicked are right or not
function check(level){
  console.log("\nCHECKING... !");
  console.log("LEVEL COLOR: "+JSON.stringify(levelColor));
  console.log("USER COLOR: "+JSON.stringify(userColor));

  //check both are equal or not
  if(JSON.stringify(userColor) === JSON.stringify(levelColor)){
    console.log("RIGHT");
    ++globalLevel; //increase level

    //create next level
    setTimeout(
      function(){
        create(globalLevel);
      } ,1000);
  }
  else{
    gameover();
  }
  reset();
}

//to enable click on color buttons
function enableClick(){
  $(".btn").off("click");
  $(".btn").click(function(event){
    pressed(event.target);
    userColor.push($(event.target).attr("id")); //push clicked button color
    let lastIndex = userColor.length-1;

    //check all click are used by user
    if(userColor.length === globalLevel){
      $(".btn").off("click");
      //console.log(userColor.length);
      check(globalLevel);
    }
    else if(userColor[lastIndex] !== levelColor[lastIndex]) //if last click was right or not!
    {
      $(".btn").off("click");
      gameover();
    }
  });
}

//key press for starting game
function beginGame(){
  $(document).off("keypress"); //offing such that no muliple event listener get attached
  $(document).keypress(function(){
    $(document).off("keypress"); //disabling keypress during game
    setTimeout(
      function(){
        create(globalLevel);
      } ,1000);
    });

  globalLevel=1;
  reset();
}

//enable start button to re'start game
function enableStartButton(){
  $("button").off("click");
  $("button").click(function(){
    reset();

    //disable keypress and mouse press on buttons
    $(document).off("keypress");
    $(".btn").off("click");

    globalLevel = 1;
    setTimeout(
      function(){
        create(globalLevel);
      } ,800);
  })
}

enableStartButton();
beginGame();
