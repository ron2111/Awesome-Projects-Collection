const express = require('express')
const path = require('path')
const hbs = require('hbs')
const weather = require('./utils/weather')

const app = express()
const port = process.env.PORT || 3000

const staticPath = path.join(__dirname, '../public')
const viewsPath = path.join(__dirname, '../templates/views')
const partialsPath = path.join(__dirname, '../templates/partials')

app.set('view engine', 'hbs')
app.set('views', viewsPath)
hbs.registerPartials(partialsPath)

app.use(express.static(staticPath))

app.get('', (req, res) => {
    res.render('index', {
        title: 'CurrWeather'
    })
})

app.get('/weather', (req,res) =>{
    if(!req.query.address) {
        return res.send('Error: You must povide a location!')
    }
    weather(req.query.address, (error, {temperature, description}={}) => {
        if(error) {
            return res.send({
                error
            })    
        }

        res.send({
            temperature,
            description
        })
    })
})

app.get('/about', (req, res) =>{
    res.render('about')
})

app.get('/help', (req, res) =>{
    res.render('help')
})

app.get('*', (req, res) =>{
    res.render('404')
})

app.listen(port, () => {
    console.log(`port ${port} working successfully`)
})