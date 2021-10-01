import yts from "yt-search";
import fs from "fs";
const data = await yts("C++ Course playlist");
let PlaylistCategory = ["Language"]
let incrementer = 992;
// Playlist Category
//  "Language","Frontend","Backend","Web Development, "Frameworks"
//  "Machine Learning", "DevOps", "Cloud", "Data Structures", "Android Developement", "CS50", "iOS Developement"
// loop over all playlists
let playlists = data.playlists;
for (let playlist of playlists) {
	// take playlist title, url, thumbnalimage url and assign to variables
	let playlistId = incrementer;
	let playlistTitle = playlist.title;
	let playlistUrl = playlist.url;
	let playlistThumb = playlist.thumbnail;
	// convert above to json format
	incrementer++;
	let playlistJson = JSON.stringify({
		"playlistId": playlistId,
		"playlistTitle": playlistTitle,
		"playlistUrl": playlistUrl,
		"playlistThumb": playlistThumb,
		"playlistCategory": PlaylistCategory
	});
	// console log the playlist json
	// console.log(playlistJson);
	// write the playlist json to a file
	fs.appendFile(`dataset.json`, playlistJson, (err) => {
		if (err) {
			console.log(err);
		}
	}
	);
	fs.appendFile(`dataset.json`, ",", (err) => {
		if (err) {
			console.log(err);
		}
	}
	);
}
