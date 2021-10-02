import bs4
import requests
import pandas as pd

url = "https://quotes.toscrape.com/"

data = requests.get(url).content
html_data = bs4.BeautifulSoup(data, 'lxml')

# print(html_data)

quotes_data = html_data.findAll("span", class_="text")
author_data = html_data.findAll("small", class_="author")
tags_data = html_data.findAll("div", class_="tags")

alist = []
qlist = []
tlist = []

for i in range(len(quotes_data)):
    alist.append(author_data[i].text)
    qlist.append(quotes_data[i].text)
    tlist.append(tags_data[i].text.replace("Tags:", "").replace("\n", " ").replace("      ", "").strip())

for j in range(len(quotes_data)):
    print("Author- ", alist[j])
    print("Quote- ", qlist[j])
    print("Tags- ", tlist[j])
