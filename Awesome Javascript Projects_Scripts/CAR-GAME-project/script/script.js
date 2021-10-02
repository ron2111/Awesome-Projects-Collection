const score = document.querySelector(".score");//score card in the left-top
        const startScreen =  document.querySelector(".startScreen");//pop screen on the road
        const gameArea = document.querySelector(".gameArea");//road on which car runs
        const player = {speed:5,score:0};
        //song that is playing
        let song = new Audio("music/main_song.mp3");
        song.volume = 0.1;
        //buttons in mobile view
        let right = document.getElementById("rightbtn");
        let left = document.getElementById("leftbtn");
        
        let road = gameArea.getBoundingClientRect();
        let car = document.createElement('div');
            car.setAttribute("class","car");
            car.style.display = "none"; 
            gameArea.appendChild(car);    
        let keys = {
            ArrowUp:false,
            ArrowDown:false,
            ArrowRight:false,
            ArrowLeft:false
        }
        document.addEventListener("keydown",keyDown);//call keyDown function on a key press
        document.addEventListener("keyup",keyUp);//call keyUp function on key release
        startScreen.addEventListener("click",start);//when you click on popup game will start
        /* function to move the road lines */
        function move(){
            let lines = document.querySelectorAll(".lines");
            lines.forEach(function(item){
                if(item.y>750) item.y =0;  
                item.y += player.speed;
                item.style.top = item.y + "px";
            });
        }
         //function to check whether the hero car collide the enemy car or not */
          function isCollide(a,b){
             let hero = a.getBoundingClientRect();
             let enemy = b.getBoundingClientRect();
             return !((hero.top > enemy.bottom)||(hero.bottom<enemy.top)||(hero.right<enemy.left)||(hero.left>enemy.right));
         }
        /* function to move the enemy cars */
        function enemyCar(){
            let enemyCar = document.querySelectorAll(".enemyCar");
            enemyCar.forEach(function(carx){
                if(carx.y>750){
                    carx.style.left = Math.floor(Math.random()*350) +"px"; 
                    carx.y=0;
                }  
                 if(isCollide(car,carx)) {
                    song.pause();
                   player.start=false;
                   startScreen.classList.remove('hide');
                }             
                carx.y +=player.speed;
                carx.style.top = carx.y + "px";
            });
        }
       
        function keyDown(event){
            keys[event.key]=true;
            // console.log(keys);
        }
        function keyUp(event){
            keys[event.key]=false;
        }
        /* function to start the gamePlay */
        function gamePlay(){
            player.y = car.offsetTop;
            player.x = car.offsetLeft;
            if(player.start){ 
                move();//to move all the road lines
                enemyCar();//to move all the enemy cars
                if( keys["ArrowUp"] && player.y>70 ){
                  player.y -=player.speed;
                }
                if( keys["ArrowDown"] && player.y<(road.height-80)){
                    player.y +=player.speed;
                }
                if( keys["ArrowRight"] && player.x<(road.width-65) ){
                    player.x +=player.speed;
                }
                if( keys["ArrowLeft"] && player.x>0 ){
                    player.x -=player.speed;
                }
                car.style.top = player.y + "px";
                car.style.left = player.x + "px";  
                player.score++;
                score.innerHTML="Score<br>"+player.score;            
                window.requestAnimationFrame(gamePlay);//recursive call to requestAnimationFrame function until player.first!=false
                
            }
        }
        /* function to hide the popup and to start the gameArea */
        function start(){
            song.play();
            car.style.top="70%";
            car.style.left="45%";
            gameArea.innerHTML = "";
            gameArea.appendChild(car);
            gameArea.style.overflow="hidden";
            for(let x = 0;x<5;x++){
                /* creation of roadlines */
                let roadLine = document.createElement('div');//creating roadlines
                roadLine.setAttribute('class','lines');//setting a class to road lines
                roadLine.y = (x*150);//this will create a property in roadLine element(object) as y
                roadLine.style.top = roadLine.y + "px";
                gameArea.appendChild(roadLine);
            }
            for(let x = 0;x<3;x++){
                let enemyCar = document.createElement('div');
                enemyCar.setAttribute('class','enemyCar');
                enemyCar.y = (x*250)*(-1);
                enemyCar.style.top = enemyCar.y + "px";
                enemyCar.style.left = Math.floor(Math.random()*(road.width-50)) +"px";
                gameArea.appendChild(enemyCar);
            }
            this.classList.add("hide");//this is poiniting to startScreen
            score.classList.remove('hide');
            player.start=true;
            player.score=0;
            car.style.display = "block";  
            window.requestAnimationFrame(gamePlay);
        }
        /* gameplay for mobile game */
        right.addEventListener("touchstart",function(){
            keys["ArrowRight"]=true;
        });
        right.addEventListener("touchend",function(){
            keys["ArrowRight"]=false;
        });
        left.addEventListener("touchstart",function(){
            keys["ArrowLeft"]=true;
        });
        left.addEventListener("touchend",function(){
            keys["ArrowLeft"]=false;
        });
