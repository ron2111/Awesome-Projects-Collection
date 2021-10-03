var numSquares = 6;

function getRandomColor(){
    var letter = "0123456789ABCDEF";
    var color = "#";
    for(var i=0;i<6;i++){
        color  += letter[Math.floor(Math.random()*16)];
    }
    return color;
}

$("div").removeClass("special");
$("#easy").click(function(){
    $("#hard").removeClass("selected");
    $("#medium").removeClass("selected");
    $("#easy").addClass("selected");
    $("div").removeClass("special");
    numSquares = 3;
    for(var i=1;i<=6;i++){
        if (i<=3) {
            $(".square" + i).css("background-color",getRandomColor());
        }else{
            $(".square" + i).css("display","none");
        }
    }
    pickedcolor = $(".square" + (Math.floor(Math.random()*3)+1)).css( "background-color" );
    $("#colorDisplay").text(pickedcolor);
})
$("#medium").click(function(){
    $("#hard").removeClass("selected");
    $("#easy").removeClass("selected");
    $("#medium").addClass("selected");
    $("div").addClass("special");
    
    numSquares = 4;
    for(var i=1;i<=6;i++){
        if (i<=4) {
            $(".square" + i).css("background-color",getRandomColor());
            $(".square" + i).css("display","block");
        }else{
            $(".square" + i).css("display","none");
        }
    }
    pickedcolor = $(".square" + (Math.floor(Math.random()*4)+1)).css( "background-color" );
    $("#colorDisplay").text(pickedcolor);
})

$("#hard").click(function(){
    $("#easy").removeClass("selected");
    $("#medium").removeClass("selected");
    $("#hard").addClass("selected");
    $("div").removeClass("special");
    numSquares = 6;
    for(var i=1;i<=6;i++){
        $(".square" + i).css("background-color",getRandomColor());
        $(".square" + i).css("display","block");
    }
    pickedcolor = $(".square" + (Math.floor(Math.random()*6)+1)).css( "background-color" );
    $("#colorDisplay").text(pickedcolor);
})

$("#reset").click(function(){
    for(var i=1;i<=numSquares;i++){
        $(".square" + i).css("background-color",getRandomColor());
    }
    pickedcolor = $(".square" + (Math.floor(Math.random()*numSquares)+1)).css( "background-color" );
    $("#colorDisplay").text(pickedcolor);
    $(this).text("New Colors");
    $("#message").text("");
    $("#heading").css("background-color","steelblue");
    
});

for(var i=1;i<=6;i++){
    $(".square" + i).css("background-color",getRandomColor());
}

var pickedcolor = $(".square" + (Math.floor(Math.random()*6)+1)).css( "background-color" );
$("#colorDisplay").text(pickedcolor);



for(var i=1;i<=6;i++){     
    $(".square" + i).click(function(){
        var clickedColor=$(this).css("background-color");
        if (clickedColor===pickedcolor) {
            var audio = new Audio("sounds/Correct.mp3");
            audio.play();
            $("#message").text("Correct!");
            $("#reset").text("Play Again?");
            changeColors(clickedColor);
            $("#heading").css("background-color",clickedColor);
        }else{
            var audio = new Audio("sounds/Wrong.mp3");
            audio.play();
            $(this).css("background-color", "#232323")
            $("#message").text("Try Again");
        }
    });
}
        
function changeColors(color){
    for(var i=1;i<=6;i++){
        $(".square" + i).css("background-color",color);
    }
}

function playSound(name) {

  }