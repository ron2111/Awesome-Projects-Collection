// alert('connected')
//api =  http://api.tvmaze.com/search/shows?q=girls

// const { default: axios } = require("axios")

let form = document.addEventListener('submit',(default1)=>{
    default1.preventDefault();
    // console.log(1);
    let query = document.querySelector('#query').value;
    // console.log(query);
    for (var i= document.images.length; i-->0;)
    document.images[i].parentNode.removeChild(document.images[i]);
    getMovie(query);
})
let getMovie =async (query)=>{
    let res = await axios.get(`http://api.tvmaze.com/search/shows?q=${query}`);
    // console.log(res);
    for(let i=0;i<10;i++){
        if(res.data[i].show.image){
            let link = res.data[i].show.url;
            let a = document.createElement('A');
            a.href = link;
            a.target="_blank";
            let image = res.data[i].show.image.medium;
            let img = document.createElement('IMG');
            img.src = image;
            a.append(img);
            document.body.append(a);
            
        }
    }
    
}

// getMovie()