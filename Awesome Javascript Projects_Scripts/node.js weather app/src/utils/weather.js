const request = require('postman-request')

const weather = (address, callback) => {
    const url = `https://api.openweathermap.org/data/2.5/weather?q=${address}&appid=de4a179429fd1bdb2086484d12cce3ed`
    request({url, json: true} , (error, {body}={}) => {
        if(error) {
            callback('Could not connect to the weather api', undefined)
        }
        else if(body.cod !== 200) {
            callback('Could not fetch data for this location', undefined)
        }
        else {
            callback(undefined, {
                temperature: body.main.temp,
                description: body.weather[0].description
            })
        }        
    })
}    

module.exports = weather