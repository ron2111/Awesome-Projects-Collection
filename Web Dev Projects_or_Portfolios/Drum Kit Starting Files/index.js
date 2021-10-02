
                               // Detect Button Press

for(var i =0; i < document.querySelectorAll(".drum").length; i++) {

  document.querySelectorAll(".drum")[i].addEventListener("click" , function() {

    var buttonInnerHtml = this.innerHTML;

    makeSound(buttonInnerHtml);

    buttonAnimation(buttonInnerHtml);

  });
}


                                  // Detect Key Press

document.addEventListener("keypress", function() {
  makeSound(event.key);
  buttonAnimation(event.key);

});


                                    // Sound Play Function


function makeSound(key){
  switch (key) {
    case "w":
         var tom1 = new Audio("sounds/tom-1.mp3");
         tom1.play();
         break;

     case "a":
          var tom2 = new Audio("sounds/tom-2.mp3");
          tom2.play();
          break;

     case "s":
           var tom3 = new Audio("sounds/tom-3.mp3");
           tom3.play();
           break;

     case "d":
           var tom4 = new Audio("sounds/tom-4.mp3");
           tom4.play();
           break;

     case "j":
           var crash = new Audio("sounds/crash.mp3");
           crash.play();
           break;

     case "k":
           var snare = new Audio("sounds/snare.mp3");
           snare.play();
           break;

     case "l":
           var kickbass = new Audio("sounds/kick-bass.mp3");
           kickbass.play();
           break;

    default:  console.log(buttonInnerHtml);

  }
}


                                                // Animation


function buttonAnimation(currentKey) {
      var activeButton = document.querySelector("."+currentKey);

      activeButton.classList.add("pressed");

      setTimeout(function(){
        activeButton.classList.remove("pressed");
      },100);
}
