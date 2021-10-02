const musicContainer = document.querySelector(".music-container");
const playBtn = document.querySelector("#play");
const prevBtn = document.querySelector("#prev");
const nextBtn = document.querySelector("#next");
const song = document.querySelector("#song");
const progress = document.querySelector(".progress");
const progressContainer = document.querySelector(".progress-container");
const title = document.querySelector("#title");
const cover = document.querySelector(".music-cover");
const loading = document.querySelector(".loading");


// songs titles
const songs = [
	"Hey there Delilah",
	"Yellow",
	"Maneskin - Beggin"
];

//track song
let songIndex = 0;

// loading song info in DOM
loadSong(songs[songIndex]);

//update song details
function loadSong(songName) {
	title.innerText = songName;
	song.src = `songs/${songName}.mp3`;
	cover.src = `images/${songName}.jpg`;
}

function playSong() {
	musicContainer.classList.add("play");
	playBtn.querySelector("i.fa").classList.remove("fa-play");
	playBtn.querySelector("i.fa").classList.add("fa-pause");
	song.play();
}

function pauseSong() {
	musicContainer.classList.remove("play");
	playBtn.querySelector("i.fa").classList.add("fa-play");
	playBtn.querySelector("i.fa").classList.remove("fa-pause");
	song.pause();
}

function nextSong() {
	if (songIndex < 2) {
		songIndex++;
		loadSong(songs[songIndex]);
	} else {
		songIndex = 0;
		loadSong(songs[songIndex]);
	}
	playSong();
}

function prevSong() {
	if (songIndex > 0) {
		songIndex--;
		loadSong(songs[songIndex]);
	} else {
		songIndex = 2;
		loadSong(songs[songIndex]);
	}
	playSong();
}

function updateProgress(e) {
	const { duration, currentTime } = e.srcElement;
	const progressPercent = (currentTime / duration) * 100;
	progress.style.width = `${progressPercent}%`;
}

function setProgress(e) {
	const width = this.clientWidth;
	const clickX = e.offsetX;
	const duration = song.duration;

	song.currentTime = (clickX / width) * duration;
}

//event listeners

playBtn.addEventListener("click", () => {
	const isPlaying = musicContainer.classList.contains("play");
	if (isPlaying) {
		pauseSong();
	} else {
		playSong();
	}
});

//change songs
prevBtn.addEventListener("click", prevSong);
nextBtn.addEventListener("click", nextSong);
song.addEventListener("timeupdate", updateProgress);
progressContainer.addEventListener("click", setProgress);
song.addEventListener("ended", nextSong);
