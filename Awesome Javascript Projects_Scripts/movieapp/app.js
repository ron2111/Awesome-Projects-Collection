    let form = document.getElementById("fForm");
    let title;
    form.addEventListener("submit",function(e){
        e.preventDefault();
        
        title = document.forms["myForm"]["fname"].value;
        if (title == "") {
            return false;
        }
        let url = `http://www.omdbapi.com/?apikey=87977ec5&t=${title}`
        const xhr = new XMLHttpRequest();
        xhr.open('GET',url,true);
        xhr.onload = function(){
            if(this.status == 200){
                // document.getElementById("demo").innerHTML = this.responseText;
                let res = JSON.parse(this.responseText);
                    document.getElementById("demo").innerHTML = `
                  <div class="image">
                    <img src = ${res.Poster}>
                    <h3>${res.Title}</h3>
                  </div>
                    <div class="description">
                        <p><span>Released Year</span>: ${res.Released}</p>
                        <p><span>Genre</span>: ${res.Genre}</p>
                        <p><span>Director</span>: ${res.Director}</p>
                        <p><span>Ratings</span>: ${res.Ratings[0].Value}</p>
                        <p><span>Awards</span>: ${res.Awards}</p>
                    </div>
                    <div class="plot">
                        <p> <span>Plot</span>: ${res.Plot}</p>
                    </div>
                `;
            }
            else if(this.status == 404){
                alert("Connection Error!")
            }
            else{
                console.log("Nothing Happened");
            }
        }
        xhr.send();

        document.forms["myForm"]["fname"].value="";
    })