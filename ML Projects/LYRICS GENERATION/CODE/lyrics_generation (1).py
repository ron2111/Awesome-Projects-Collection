#!/usr/bin/env python
# coding: utf-8

# In[1]:


#importing the necessary libraries required
from tensorflow.keras.preprocessing.sequence import pad_sequences
from tensorflow.keras.layers import Embedding, LSTM, Dense, Dropout, Bidirectional
from tensorflow.keras.preprocessing.text import Tokenizer
from tensorflow.keras.models import Sequential
from tensorflow.keras.optimizers import Adam
from tensorflow.keras import regularizers
import tensorflow.keras.utils as ku
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import tensorflow as tf


# In[2]:


# importing dataset in .txt format
# loading the dataset file and display lyrics
lyric=open('lorde.txt').read()
print(lyric[:2000])


# In[3]:


# pre-processing datset
# converting into lowercase and split the datset
corpus=lyric.lower().split('\n')
for i in range(40,60):
 print(corpus[i])


# In[4]:


# tokenizing
tokenizer = Tokenizer()
tokenizer.fit_on_texts(corpus)
total_words = len(tokenizer.word_index) + 1
total_words
word_index = tokenizer.word_index
print(word_index)


# In[5]:


# using list of tokens create input sequences
input_sequences = []
for line in corpus:
 token_list = tokenizer.texts_to_sequences([line])[0]
 
 for i in range(1, len(token_list)):
     n_gram_sequence = token_list[:i+1]
     input_sequences.append(n_gram_sequence)
for i in range(20):
 print(input_sequences[i])


# In[6]:


# padding either post-padding or pre-padding
max_sequence_len = max([len(x) for x in input_sequences])
input_sequences = np.array(pad_sequences(input_sequences, maxlen=max_sequence_len,
padding='pre'))
print(max_sequence_len)
print(input_sequences)


# In[7]:


# Model building
model = Sequential()
model.add(Embedding(1372, 160, input_length=max_sequence_len-1))
model.add(Bidirectional(LSTM(200, return_sequences = True)))
model.add(Dropout(0.2))
model.add(LSTM(100))
model.add(Dense(1372/2, activation='relu', kernel_regularizer=regularizers.l2(0.001)))
model.add(Dense(93, activation='softmax'))
model.compile(loss='binary_crossentropy', optimizer='adam', metrics=['accuracy'])
print(model.summary())


# In[8]:


# create predictors and label
predictors, label = input_sequences[:,:-1],input_sequences[:,-1]
label = ku.to_categorical(label, num_classes=total_words)


# In[9]:


# model training
history = model.fit(predictors, label, epochs=50, verbose=1)


# In[10]:


# result analysis
acc = history.history['accuracy']
loss = history.history['loss']
epochs = range(len(acc))
plt.plot(epochs, acc, 'b', label='Training accuracy')
plt.title('Training accuracy')
plt.figure()
plt.plot(epochs, loss, 'b', label='Training Loss')
plt.title('Training loss')
plt.legend()
plt.show()


# In[11]:


# model testing
next_words = 20
seed_text = "watch the wasters blow the speakers "
for _ in range(next_words):
 token_list = tokenizer.texts_to_sequences([seed_text])[0]
 token_list = pad_sequences([token_list], maxlen=max_sequence_len-1, padding='pre')
 predicted = model.predict_classes(token_list, verbose=0)
 output_word = ""
 for word, index in tokenizer.word_index.items():
     if index == predicted:
         output_word = word
         break
 seed_text += " " + output_word
print(seed_text)
next_words = 100
seed_text = "diamond in the flesh"
for _ in range(next_words):
 token_list = tokenizer.texts_to_sequences([seed_text])[0]
 token_list = pad_sequences([token_list], maxlen=max_sequence_len-1, padding='pre')
 predicted = model.predict_classes(token_list, verbose=0)
 output_word = ""
 for word, index in tokenizer.word_index.items():
     if index == predicted:
         output_word = word
         break
 seed_text += " " + output_word
print(seed_text)


# In[12]:


# testing random samples using model
next_words = 10
seed_text = "ive never seen a diamond in the flesh i cut my"
for _ in range(next_words):
 token_list = tokenizer.texts_to_sequences([seed_text])[0]
 token_list = pad_sequences([token_list], maxlen=max_sequence_len-1, padding='pre')
 predicted = model.predict_classes(token_list, verbose=0)
 output_word = ""
 for word, index in tokenizer.word_index.items():
     if index == predicted:
         output_word = word
         break
 seed_text += " " + output_word
print(seed_text)


# In[ ]:


# saving the model
import time
saved_model_path = "./{}.h5".format(int(time.time()))
model.save(saved_model_path)
get_ipython().system('tensorflowjs_converter --input_format=keras {saved_model_path} ./')
# !pip install h5py
# import tensorflow as tf
# training model is being loaded
# load json and create model
'''json_file = open('model.json', 'r')
loaded_model_json = json_file.read()
json_file.close()
loaded_model = tf.keras.models.model_from_json(loaded_model_json)
# load weights into new model
loaded_model.load_weights("model.h5")
print("Loaded model from disk")
loaded_model.summary()'''

