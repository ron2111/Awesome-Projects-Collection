 const game=() =>{
     let pscore=0;
     let cscore=0;


     const startgame =()=>
     {
         const playbtn = document.querySelector(".intro button");
         const introscreen =document.querySelector(".intro");
         const match=document.querySelector(".match");
         playbtn.addEventListener('click',()=>{
             introscreen.classList.add("fadeout");
             match.classList.add("fadein");
       
         });
         };

         const playgame =()=>{
             const options=document.querySelectorAll(".options button");
             const playerhand=document.querySelector(".player-hand");
             const computerhand=document.querySelector(".computer-hand");
             const computeroptions=["rock","paper","scissor"];
            const hands =  document.querySelectorAll(".hands img")


            hands.forEach(hand=>{
                hand.addEventListener('animationend',function(){
                    this.style.animation="";
                });
            });

            options.forEach((option)=>{
                option.addEventListener("click",function(){
                    
                    const computernumber=Math.floor(Math.random()*3);
            
                    const computerchoice=computeroptions[computernumber];

                    //  console.log(this.textContent);
                    //  console.log(computerchoice);
               
setTimeout(()=>{

    playerhand.src = `images/${this.textContent}sss.png`;
    computerhand.src = `images/${computerchoice}sss.png`;
    comparescore(this.textContent,computerchoice);
},2000)



                     playerhand.style.animation="shakeplayer 2s ease";
                    computerhand.style.animation="shakecomputer 2s ease";
                   
                    


                });

            });
            
             
         };
/////////////////update score////////////
const updatescore=()=>{

const playerscore=document.querySelector(".player-score p");

const computerscore=document.querySelector(".computer-score p");
playerscore.textContent=pscore;
computerscore.textContent=cscore;

}




         /////compare score///////////////////
         const comparescore=(playerchoice,computerchoice)=>{
             const winner =document.querySelector(".winner");
             if(playerchoice === computerchoice)
             {
                 winner.textContent=" It's a tie";updatescore();
                 return ;
             }
             if(playerchoice==='rock')
             {
                 if(computerchoice==='scissor')
                { 
                    winner.textContent="woah!!! you win";pscore++;updatescore();
                    return ;
                }
                 else
                 {
                    winner.textContent="Oops!! computer win";cscore++;updatescore();
                    return ;

                 }
             }
             if(playerchoice==='paper')
             {
                 if(computerchoice==='rock')
                { 
                    winner.textContent="woah!!! you win";pscore++;updatescore();
                    return ;
                }
                 else
                 {
                    winner.textContent="Oops!! computer win";cscore++;updatescore();
                    return ;

                 }
             }
             if(playerchoice==="scissor")
             {
                 if(computerchoice==='paper')
                { 
                    winner.textContent="woah!!! you win";pscore++;updatescore();
                    return ;
                }
                 else
                 {
                    winner.textContent="Oops!! computer win";cscore++;updatescore();
                    return ;

                 }
             }

         }
startgame();
playgame();
     };

game();
