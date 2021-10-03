#!/usr/bin/env python
# coding: utf-8

# In[1]:


import numpy as np
import pandas as pd


# In[2]:


dataset=pd.read_csv("50_Startups AI.csv")


# In[3]:


dataset


# In[4]:


dataset.head(2)


# In[5]:


dataset.isnull().any()


# In[6]:


from sklearn.preprocessing import LabelEncoder
le=LabelEncoder()
dataset["State"]=le.fit_transform(dataset["State"])


# In[7]:


dataset.head(2)


# In[8]:


x=dataset.iloc[:,0:4].values
y=dataset.iloc[:,4].values


# In[9]:


from sklearn.preprocessing import OneHotEncoder
one=OneHotEncoder()
z=one.fit_transform(x[:,3:4]).toarray()
x=np.delete(x,3,axis=1)
x=np.concatenate((z,x),axis=1)


# In[10]:


from sklearn.model_selection import train_test_split
x_train,x_test,y_train,y_test=train_test_split(x,y,test_size=0.2,random_state=0)


# In[11]:


import keras
from keras.models import Sequential
from keras.layers import Dense


# In[12]:


model=Sequential()


# In[13]:


x_train.shape


# In[14]:


model.add(Dense(units=6,init = "random_uniform",activation="relu"))


# In[15]:


model.add(Dense(units=3,init = "random_uniform",activation="relu"))


# In[16]:


model.add(Dense(units=1,init = "random_uniform"))


# In[17]:


model.compile(optimizer="adam",loss="mse",accuracy=["mse"])


# In[18]:


model.fit(x_train,y_train,batch_size=10,epochs=10)


# In[19]:


y_pred=model.predict(x_test)


# In[20]:


y_pred


# In[21]:


y_test


# In[22]:


from sklearn.metrics import r2_score
accuracy=r2_score(y_test,y_pred)


# In[23]:


accuracy #0.752295052747021 *100=75% is accuracy


# In[25]:


model.save('regressor.h5')


# In[26]:


x_train.shape


# In[ ]:




