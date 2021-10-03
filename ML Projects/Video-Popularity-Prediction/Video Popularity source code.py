#!/usr/bin/env python
# coding: utf-8

# In[3]:


#installing dependencies
import pandas as pd
import seaborn as sns
import numpy as np
from numpy import savetxt


# In[5]:


#importing training file
#input location of the files based on your own system and environment
data = pd.read_csv("C:/Users/Admin/Desktop/Video Popularity contest MACS bitgri/Final submission/Testing and training files/train_meta_df.csv")


# In[6]:


#checking the data
data.head()


# In[5]:


#checking the data
data.tail()


# In[6]:


#checking data dimensions
data.shape


# In[7]:


#listing all the columns
data.columns


# In[8]:


#to get more insights on the data
data.describe()


# In[9]:


#visualisation


# In[10]:





# In[11]:


#checking for null data issues
data.isnull().sum()


# In[30]:


#finding relation between parameters to views for each factor
#Here the relation between the average of pixel value is checked with views to draw out a relation
sns.relplot(x='views', y = 'Average', data =data)


# In[12]:


#Here the relation between the average of description value is checked with views to draw out a relation
sns.relplot(x='views', y = 'average_d', data =data)


# In[31]:


sns.relplot(x='views', y = 'ad_blocked', data =data)


# In[32]:


sns.relplot(x='views', y = 'embed', data =data)


# In[33]:


sns.relplot(x='views', y = 'ratio', data =data)


# In[34]:


sns.relplot(x='views', y = 'duration', data =data)


# In[35]:


sns.relplot(x='views', y = 'language', data =data)


# In[36]:


sns.relplot(x='views', y = 'partner', data =data)


# In[37]:


sns.relplot(x='views', y = 'partner_active', data =data)


# In[38]:


sns.relplot(x='views', y = 'n_likes', data =data)


# In[39]:


sns.relplot(x='views', y = 'n_tags', data =data)


# In[40]:


sns.relplot(x='views', y = 'n_formats', data =data)


# In[41]:


sns.relplot(x='views', y = 'dayofweek', data =data)


# In[42]:


sns.relplot(x='views', y = 'hour', data =data)


# In[43]:


#Here the relation between the average of title value is checked with views to draw out a relation
sns.relplot(x='views', y = 'average_t', data = data)


# In[10]:


#importing LinearRegression model from sklearn library
from sklearn.linear_model import LinearRegression


# In[11]:


min_threshold, max_threshold = data.average_d.quantile([0.01,0.99])
minv_threshold, maxv_threshold = data.Average.quantile([0.01,0.99])


# In[9]:


data[data.average_d < min_threshold]


# In[16]:


data[data.average_d > max_threshold]


# In[12]:


#removing outliers and unnecessary data to enhance model
data2 = data[(data.Average > minv_threshold) & (data.Average < maxv_threshold) & (data.average_d > min_threshold) & (data.average_d < max_threshold) ]
data2.shape


# In[13]:


#removing features which are not required
X_train = data2.drop(['views','ad_blocked','partner_active','dayofweek','comp_id','average_t'], axis=1)
#uploading testing data set to get predictions
test = pd.read_csv("C:/Users/Admin/Desktop/Video Popularity contest MACS bitgri/Final submission/Testing and training files/public_meta_df.csv")
X_test = test.drop(columns=['ad_blocked','partner_active','dayofweek','comp_id','average_t'])


# In[14]:


Y_train = data2['views']


# In[15]:


#calling the model
regr = LinearRegression()


# In[16]:


#training the model
regr.fit(X_train,Y_train)


# In[17]:


#making predictions
pred = regr.predict(X_test).astype(int)


# In[18]:


pred


# In[19]:


#removing negative values and setting minimum number of views based on observation and 25% percentile of views in training dataset
for x in range(986):
    if pred[x-1] > -1:
        if pred[x-1] < 70:
            pred[x-1] = 70
    else:
        pred[x-1] = -pred[x-1]
        if (pred[x-1]) < 70:
            pred[x-1] = 70
            


# In[20]:


#final predictions
pred


# In[34]:


#saving to the output file in .csv format
#after this we convert it to the asked to solution format
dataset = pd.DataFrame({'comp_id':test.comp_id, 'views':pred})
dataset.to_csv('solution.csv', index = False)


# In[33]:





# In[ ]:




