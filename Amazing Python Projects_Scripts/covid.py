from collections import namedtuple
import requests
from lxml import html

covid_data = namedtuple("covid_data", "cases deaths recovered")
def covid_stats(url: str = "https://www.worldometers.info/coronavirus/") -> covid_data:
    xpath_str = '//div[@class = "maincounter-number"]/span/text()'
    return covid_data(*html.fromstring(requests.get(url).content).xpath(xpath_str))
fmt = """\nTotal COVID-19 cases in the world: {}
\nTotal deaths due to COVID-19 in the world: {}
\nTotal COVID-19 patients recovered in the world: {}"""
print(fmt.format(*covid_stats()))
