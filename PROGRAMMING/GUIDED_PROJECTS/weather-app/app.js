//UVvmKUJwyHfJX0hoI3mgZwcrtfXqGm6K
//178556
//http://dataservice.accuweather.com/currentconditions/v1/178556

const express = require("express");
const request = require("request");
const path = require('path'); 

const app = express()
const port = 3000

app.engine('pug', require('pug').__express)
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug'); 

app.use(express.static(path.join(__dirname,'public')));

app.get('/sendWeatherAPI', (req, res) => {
    var options = {
        'method' : 'GET',
        'url' : "http://dataservice.accuweather.com/currentconditions/v1/178556?apikey=UVvmKUJwyHfJX0hoI3mgZwcrtfXqGm6K"
    };
    
    request(options, function(error, response){
        if (error) throw new Error(error);
        var weatherResponse = JSON.parse(response.body); 
        var weather = weatherResponse[0].WeatherText;
        var temp = weatherResponse[0].Temperature.Metric.Value;
        var unit = weatherResponse[0].Temperature.Metric.Unit;
        var timestamp = weatherResponse[0].LocalObservationDateTime;
        var year = timestamp.substring(0,4);
        var month = timestamp.substring(5,7);
        var day = timestamp.substring(8,10);
        var time = timestamp.substring(11,16);
        var date = year + "-" + month + "-" + day;
        console.log(weatherResponse);
        res.render('weather', {title: 'Weather App', city: "Hamburg", weather:weather, temp:temp, unit:unit, time:time, date:date})
    });
})
app.get('/', (req,res) => {
    res.render('index', {title: 'Weather App', city: "Hamburg"})
});

app.listen(port, () => {
    console.log(`Weather app listening at http://localhost:${port}`)
});

