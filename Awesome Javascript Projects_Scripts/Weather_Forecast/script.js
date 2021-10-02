
//API information 

const api = {
  key: "9bd0820808b373c9bee4bdb7c00915a0",
  base: "https://api.openweathermap.org/data/2.5/",
};

// Adding Action to the Form Section 
const search = document.querySelector(".search");
const btn = document.querySelector(".btn");
btn.addEventListener("click", getInput);


// Function triggers and requests Data from the openweather API

function getInput(event) {
  event.preventDefault();
  if (event.type == "click") {
    getData(search.value);
    console.log(search.value);
  }
}

function getData() {
  fetch(`${api.base}weather?q=${search.value}&units=metric&appid=${api.key}`)
    .then((response) => {
      return response.json();
    })
    .then(displayData);
}


// Requested Data gets displayed in the Information Section 


function displayData(response) {
  console.log(response);
  if (response.cod == "404") {
    const error = document.querySelector(".error");
    error.textContent = "enter valid city";
    search.value = "";
  } else {
    const city = document.querySelector(".city");
    city.innerText = `${response.name}, ${response.sys.country}`;

    const today = new Date();
    const date = document.querySelector(".date");
    date.innerText = dateFunction(today);

    const temp = document.querySelector(".temp");
    temp.innerHTML = `Temp: ${Math.round(response.main.temp)} <span>℃</span>`;

    const state = document.querySelector(".state");
    state.innerText = `Weather: ${response.weather[0].main}`;

    const range = document.querySelector(".range");
    range.innerText = `Range: ${Math.round(
      response.main.temp_min
    )} ℃ - ${Math.round(response.main.temp_max)}℃`;

    const weatherIcon = document.querySelector(".icon-weather");
    const iconURL = "http://openweathermap.org/img/wn/";
    weatherIcon.src = iconURL + response.weather[0].icon + "@2x.png";

    search.value = "";
  }
}

function dateFunction(d) {
  let months = [
    "Jan",
    "Feb",
    "Mar",
    "Apr",
    "May",
    "June",
    "July",
    "Aug",
    "Sep",
    "Oct",
    "Nov",
    "Dec",
  ];

  let days = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];

  let day = days[d.getDay()];
  let date = d.getDate();
  let month = months[d.getMonth()];
  let year = d.getFullYear();

  return `${day}, ${date} , ${month} , ${year}`;
}
