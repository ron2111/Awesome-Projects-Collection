# This is a Corona disease information chat bot.

from newspaper import Article
import random
import string
import nltk
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics.pairwise import cosine_similarity
import numpy as np
import warnings
warnings.filterwarnings('ignore')

# Download the punkt package
nltk.download('punkt', quiet=True)

# Get the article
article = Article('https://www.who.int/health-topics/coronavirus#tab=tab_3')
article.download()
article.parse()
article.nlp()
corpus = article.text

# print the article text
# print(corpus)
# tokennisation
test = corpus
sentence_list = nltk.sent_tokenize(test)  # A list of sentence_list
# print(sentence_list)

# A function to return a random greeting to a user text


def greeting_respose(text):
    text = text.lower()

    # Bots greeting respose
    bot_greetings = ['hello', 'hi', 'hey']
    # users greeting
    user_greetings = ['hi', 'hello', 'hey', 'wassup']

    for word in text.split():
        if word in user_greetings:
            return random.choice(bot_greetings)

# index sort


def index_sort(list_var):
    length = len(list_var)
    list_index = list(range(0, length))

    x = list_var
    for i in range(length):
        for j in range(length):
            if x[list_index[i]] > x[list_index[j]]:
                # swap
                temp = list_index[i]
                list_index[i] = list_index[j]
                list_index[j] = temp

    return list_index

# create bot response


def bot_response(user_input):
    user_input = user_input.lower()
    sentence_list.append(user_input)
    bot_response = ''
    cm = CountVectorizer().fit_transform(sentence_list)
    similarity_score = cosine_similarity(cm[-1], cm)
    similarity_score_list = similarity_score.flatten()
    index = index_sort(similarity_score_list)
    index = index[1:]
    response_flag = 0

    j = 0
    for i in range(len(index)):
        if similarity_score_list[index[i]] > 0.0:
            bot_response = bot_response+' '+sentence_list[index[i]]
            response_flag = 1
            j = j+1
        if j > 2:
            break

    if response_flag == 0:
        bot_response = bot_response+' '+"I apologize, that I don't understand"

    sentence_list.remove(user_input)

    return bot_response


# start the chat
print('Covid Helpline: I am here to help you. Type exit or bye if you want to close the chat.')

exit_list = ['bye', 'exit', 'see you later', 'break', 'quit']
while(True):
    user_input = input()
    if user_input.lower() in exit_list:
        print('Bot: Thanks for your query. See you later')
        break
    else:
        if greeting_respose(user_input) != None:
            print('Bot: '+greeting_respose(user_input))
        else:
            print('Bot: '+bot_response(user_input))
