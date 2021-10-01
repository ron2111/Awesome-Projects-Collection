const searchInput = document.querySelector('.input')
const submitbtn = document.querySelector('.search')
const result = document.querySelector('.searchResult')

submitbtn.addEventListener("click", (e) =>{
    e.preventDefault();
    const search = searchInput.value;
    console.log(search)

    let html = ""
    fetch(`/weather?address=${search}`)
    .then(response => response.json())
    .then(data => {
        if(data.error) {
            html += data.error
            result.innerHTML = html
        }
        else {
            html += `<div class="temp">Temperature : <b>${(data.temperature-273).toFixed(2)} C</b></div><div class="weatherdesc">Weather : <b>${data.description}</b></div>`
            result.innerHTML = html
        }
    })
})