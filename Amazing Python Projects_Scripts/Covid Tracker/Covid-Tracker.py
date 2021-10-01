# Covid Tracker - Sharoni Bose

import requests
import json
import sys
def getStatistics(country):
    r = requests.get(f'https://api.covid19api.com/country/{country}')
    try:
       	data = r.json()[-1]
    except KeyError:
       	print('Incorrect Country Name')
        sys.exit()
    countryCode = data['CountryCode']
    province = data['Province']
    city = data['City']
    cityCode = data['CityCode']
    lat = data['Lat']
    lon = data['Lon']
    confirmed = data['Confirmed']
    deaths = data['Deaths']
    recovered = data['Recovered']
    active = data['Active']
    date = data['Date']
    print(f'\n\nCountry: {country}\nCountry Code: {countryCode}')
    print(f'City: {city}\nCity Code: {cityCode}')
    print(f'Longitude: {lon}\nLatitude: {lat}')
    print(f'Confirmed Cases: {confirmed}\nDeaths: {deaths}')
    print(f'Recovered: {recovered}\nActive Cases: {active}\nDate: {date}')
if __name__ == '__main__':
    country = input('Country Name: ')
    getStatistics(country)