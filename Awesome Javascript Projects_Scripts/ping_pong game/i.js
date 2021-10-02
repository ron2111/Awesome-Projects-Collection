var score=0;
document.getElementById('score').innerHTML=String(score);

var play_x= 45;  
var chg=3;                      
window.addEventListener("keydown", function (e){
    switch(e.key){
        case 'ArrowLeft':
            if(play_x>3){
                play_x=play_x-chg;
            }                    
            document.getElementById('b2').style.left= String(play_x)+"%";    
            document.getElementById('b1').style.left= String(play_x)+"%";    
            break;
        case 'ArrowRight':
            if(play_x<75){
                play_x=play_x+chg;
            }   
            document.getElementById('b2').style.left= String(play_x)+"%";                        
            document.getElementById('b1').style.left= String(play_x)+"%";    
            break;
        }
    //    console.log(x);
} );

var tl= document.getElementById('ball');
var t=50;
var l=50;

var time=0;
var velx=1;
var vely=5;
function sim(){
    if(t<=0 || t>=95){
        if(play_x-3<=l && l<=play_x+18){
            velx+=0.2;
            score+=1;
            document.getElementById('score').innerHTML=String(score);
        }
        else{
            game_end();
            id.clearInterval();
            score=0;
            document.getElementById('score').innerHTML=String(score);
        }
        vely*=-1;
    }
    if(l<=0 || l>=95){
        velx*=-1;        
    }
    t= t+vely;
    l= l+velx;
    time++;

    tl.style.top= t+"%";
    tl.style.left= l+"%";
}

var id=setInterval( sim ,45);

function game_end(){
    // document.getElementById('n').style.position="relative";
    document.getElementsByClassName('game')[0].style.height="100vh";

    n=document.getElementById('navbar');
    n.style.position="Absolute";
    n.style.zIndex="10";
    n.style.backgroundColor="black";
    n.style.borderRadius="10px";
    n.style.display="flex";
    n.style.justifyContent="center";
    n.style.alignItems="center";
    n.style.height="300px";
    n.style.width="500px";
    n.style.top="25%";
    n.style.left="30%";    

    n.innerHTML="GAME OVER <br><br> Score: &ensp;"+score+" ";
}