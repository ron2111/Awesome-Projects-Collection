var video = document.getElementById("video");
var screenshot = document.getElementById("ss");
var screen = document.getElementById("screen-panel");

navigator.mediaDevices.getUserMedia({
    video:true
}).then(function (stream){
    video.srcObject = stream; 
    video.play();

    screenshot.addEventListener("click",function(){
        var snap = document.createElement("canvas");
        snap.width = video.videoWidth;
        snap.height = video.videoHeight;
        var location = snap.getContext("2d");
        location.drawImage(video, 0, 0, 550, 400);

        screen.innerHTML = "";
        screen.appendChild(snap);
    });
})
.catch(function(err){
    console.log(err);
});