import requests

from datetime import datetime

api_key = 'a1619bd8508077bfedf3bef76678f05e'

location = input("Enter Your Location : ")

api_link = "https://api.openweathermap.org/data/2.5/weather?q=" + \
    location+"&appid="+api_key
api_link = requests.get(api_link)
api_data = api_link.json()

temp_city = ((api_data['main']['temp'])-273.15)
weather = api_data['weather'][0]['description']
hmdt = api_data['main']['humidity']
wind_speed = api_data['wind']['speed']
date_time = datetime.now().strftime("%d %b %Y | %I:%M:%S %p")


print("Weather Stats for - {} || {}".format(location.upper(), date_time))

print('***********************************************************************************')

print("Current Temperature : {:.2f} deg C".format(temp_city))
print("Current Weather : ", weather)
print("Current Humidity : ", hmdt, '%')
print("Current Wind Speed : ", wind_speed, 'kmph')
print('***********************************************************************************')
