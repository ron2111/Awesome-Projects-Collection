let form = document.getElementById("fForm");
let title;
//on document loaded
document.addEventListener('DOMContentLoaded', function(e){
    fetch(`http://www.omdbapi.com/?apikey=87977ec5&t=${title}`)
})
//after the btton is pressed
form.addEventListener("submit",function(e){
    e.preventDefault();
    title = document.forms["myForm"]["fname"].value;
    if (title == "") {
        return false;
    }
    fetch(`http://www.omdbapi.com/?apikey=87977ec5&t=${title}`)
    .then(res => res.json())
    .then(data => {
        document.getElementById("demo").innerHTML = `<img src = ${data.Poster}>
            <h3>${data.Title}</h3>
            <p><span>Released Year</span>: ${data.Released}</p>
            <p><span>Genre</span>: ${data.Genre}</p>
            <p><span>Director</span>: ${data.Director}</p>
            <p><span>Ratings</span>: ${data.Ratings[0].Value}</p>
            <p><span>Awards</span>: ${data.Awards}</p>
            <p> <span>Plot</span>: ${data.Plot}</p>
            `;
    })
    .catch(err => console.log(err))
    document.forms["myForm"]["fname"].value="";
})