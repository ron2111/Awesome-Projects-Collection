const api='https://data.covid19india.org/data.json';

async function getapi(url) {
    const result = await fetch(url);
    const data = await result.json();
    var s=document.getElementById("totalcases")
    s.innerHTML=data.statewise[0].active;
    document.getElementById("totalconfirmed").innerHTML=data.statewise[0].confirmed;
    document.getElementById("totaldeaths").innerHTML=data.statewise[0].deaths;
    document.getElementById("last-updated").innerHTML=data.statewise[0].lastupdatedtime;
   
}
getapi(api);
  


