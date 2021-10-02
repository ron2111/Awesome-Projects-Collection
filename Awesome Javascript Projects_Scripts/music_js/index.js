const music = document.querySelector('audio');
const play = document.getElementById('play');
const img = document.querySelector('img');
const prev = document.getElementById('prev');
const next = document.getElementById('next');
const title = document.getElementById('title');
const artist = document.getElementById('artist');

const songs = [{
    name: '1',
    title: 'song1',
    artist: 'artist1',
},
{
    name: '2',
    title: 'song2',
    artist: 'artist2',
    },
    {
        name: '3',
        title: 'song3',
        artist: 'artist3',
        },

{
    name: '4',
    title: 'song4',
    artist: 'artist4',
    },
    {
        name: '5',
        title: 'song5',
        artist: 'artist5',
        },
        {
            name: '6',
            title: 'song6',
            artist: 'artist6',
            },
            {
                name: '7',
                title: 'song7',
                artist: 'artist7',
                },
                {
                    name: '8',
                    title: 'song8',
                    artist: 'artist8',
                    },
]

let isPlaying = false;

play.addEventListener('click', () => {
    if(isPlaying) {
        music.pause();
        isPlaying = false;
        play.classList.replace('fa-pause', 'fa-play');
        img.classList.remove('animations');
    }
    else{
        music.play();
        isPlaying = true;
        play.classList.replace('fa-play', 'fa-pause');
        img.classList.add('animations');
    }
});
songIndex = 0;
const loadSong = (song) => {
    music.src = `playlist/${song.name}.mp3`;
    title.textContent = song.title;
    artist.textContent = song.artist;
}


const nextSong = () => {
   loadSong(songs[songIndex +1]);
   songIndex++;
   if(songIndex > songs.length) {
       songIndex = 0;
   }
   music.play();
}

const prevSong = () => {
    loadSong(songs[songIndex -1]);
    songIndex--;
    if(songIndex < 0) {
        songIndex = songs.length -1;
    }
    music.play();
 }

 next.addEventListener('click', nextSong);
 prev.addEventListener('click', prevSong);





