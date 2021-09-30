const playbtn=document.getElementById("play");
const music=document.querySelector("audio");
const img=document.querySelector('img');
const songname=document.getElementById("song");
const artist=document.getElementById("artist");

const backward=document.getElementById("back");
const forward=document.getElementById("front");



 var check=true;

 const playmusic=()=> {   
   check=false;
   music.play();
   playbtn.classList.replace('fa-play','fa-pause');
   img.classList.add("anime");
}
   

const pausemusic=()=>{
    check=true;
    music.pause();
    playbtn.classList.replace('fa-pause','fa-play');
    img.classList.remove("anime");
}


playbtn.addEventListener('click',()=>{
    if(check==true){
        playmusic();
    }
    else{
        pausemusic();
    }
})


const songs=[
    {
    id:"Dil Diyan Gallan",   
    songname:"Dil Diyan Gallan",
    artist:"Atif Aslam"
    },
    
    {
     id:"Raabta",   
    songname:"Raabta",
    artist:"Nikita Gandhi"
    },
    
    {
     id:"Channa Mereya",   
    songname:"Channa Mereya",
    artist:"Arjit Singh"
    },
]
  

const changedata=(songs)=>{
    songname.textContent=songs.songname;
    artist.textContent=songs.artist;
    music.src="music/"+ songs.id + ".mp3";
    img.src="img/"+ songs.id + ".jpg";
}




var count=0;

const nextsong=()=>{
   count=(count+1)%songs.length;
   changedata(songs[count]);
   playmusic();
    
}

const previoussong=()=>{
    count=(count-1+songs.length)%songs.length;
    changedata(songs[count]);
    playmusic();
}

forward.addEventListener('click',nextsong);
backward.addEventListener('click',previoussong);

