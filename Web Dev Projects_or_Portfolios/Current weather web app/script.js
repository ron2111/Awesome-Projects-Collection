window.addEventListener('load', ()=> {
    let long;
    let lat;
    let temperatureDescription = document.querySelector(".temperature-description");
    let temperatureDegree = document.querySelector(".temperature-degree");
    let locationTimezone = document.querySelector(".location-timezone");
    let weatherIcon = document.querySelector(".icon");

    if(navigator.geolocation){
        navigator.geolocation.getCurrentPosition(position =>{
            long= position.coords.longitude;
            lat= position.coords.latitude;

            
            const api = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${long}&appid=de4a179429fd1bdb2086484d12cce3ed` ;
        

        fetch(api)
          .then(Response => {
              return Response.json();
          })
          .then(data => {
              console.log(data);
              const {description, icon} = data.weather[0] ;
              const {temp} = data.main;
              const temperature = (temp - 273.15).toFixed(2) ;

              temperatureDegree.textContent = temperature;
              temperatureDescription.textContent = description;
              locationTimezone.textContent = data.name + ", " + data.sys.country ;

              const iconurl = "http://openweathermap.org/img/wn/" + icon + ".png";

              weatherIcon.innerHTML = `<img src="${iconurl}">` ;

          });

        });  
    }

});