#!/usr/bin/env python
# coding: utf-8

# In[2]:


import warnings
warnings.filterwarnings('ignore')


# In[3]:


import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns


# In[4]:


df = pd.read_csv("https://raw.githubusercontent.com/ingledarshan/AIML-B2/main/data.csv")


# In[5]:


df.head()


# In[6]:


df.columns


# In[7]:


df.info()


# In[8]:


df['Unnamed: 32']


# In[9]:


df = df.drop("Unnamed: 32", axis=1)


# In[10]:


df.head()


# In[11]:


df.columns


# In[12]:


df.drop('id', axis=1, inplace=True)
# df = df.drop('id', axis=1)


# In[13]:


df.columns


# In[14]:


type(df.columns)


# In[15]:


l = list(df.columns)
print(l)


# In[16]:


features_mean = l[1:11]

features_se = l[11:21]

features_worst = l[21:]


# In[17]:


print(features_mean)


# In[18]:


print(features_se)


# In[19]:


print(features_worst)


# In[20]:


df.head(2)


# In[21]:


df['diagnosis'].unique()
# M= Malignant, B= Benign


# In[22]:


sns.countplot(df['diagnosis'], label="Count",);


# In[23]:


df['diagnosis'].value_counts()


# In[24]:


df.shape


# In[26]:


# Explore the Data
df.describe()
# summary of all the numeric columns


# In[27]:


len(df.columns)


# In[28]:


# Correlation Plot
corr = df.corr()
corr


# In[29]:


corr.shape


# In[30]:


plt.figure(figsize=(8,8))
sns.heatmap(corr);


# In[31]:


df.head()


# In[32]:


df['diagnosis'] = df['diagnosis'].map({'M':1, 'B':0})


# In[33]:


df.head()


# In[34]:


df['diagnosis'].unique()


# In[35]:


X = df.drop('diagnosis', axis=1)
X.head()


# In[36]:


y = df['diagnosis']
y.head()


# In[37]:


from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3)


# In[38]:


df.shape


# In[39]:


X_train.shape


# In[40]:


X_test.shape


# In[41]:


y_train.shape


# In[42]:


y_test.shape


# In[43]:


X_train.head(1)


# In[44]:


from sklearn.preprocessing import StandardScaler
ss = StandardScaler()
X_train = ss.fit_transform(X_train)
X_test = ss.transform(X_test)


# In[45]:


X_train


# In[46]:


# Logistic Regression
from sklearn.linear_model import LogisticRegression
lr = LogisticRegression()
lr.fit(X_train, y_train)


# In[47]:


y_pred = lr.predict(X_test)


# In[48]:


y_pred


# In[49]:


y_test


# In[50]:


from sklearn.metrics import accuracy_score
print(accuracy_score(y_test, y_pred))


# In[51]:


lr_acc = accuracy_score(y_test, y_pred)
print(lr_acc)


# In[52]:


results = pd.DataFrame()
results


# In[53]:


tempResults = pd.DataFrame({'Algorithm':['Logistic Regression Method'], 'Accuracy':[lr_acc]})
results = pd.concat( [results, tempResults] )
results = results[['Algorithm','Accuracy']]
results


# In[54]:


# Decision Tree Classifier
from sklearn.tree import DecisionTreeClassifier
dtc = DecisionTreeClassifier()
dtc.fit(X_train, y_train)


# In[55]:


y_pred = dtc.predict(X_test)
y_pred


# In[56]:


from sklearn.metrics import accuracy_score
print(accuracy_score(y_test, y_pred))


# In[57]:


dtc_acc = accuracy_score(y_test, y_pred)
print(dtc_acc)


# In[58]:


tempResults = pd.DataFrame({'Algorithm':['Decision tree Classifier Method'], 'Accuracy':[dtc_acc]})
results = pd.concat( [results, tempResults] )
results = results[['Algorithm','Accuracy']]
results


# In[59]:


# Random Forest Classifier
from sklearn.ensemble import RandomForestClassifier
rfc = RandomForestClassifier()
rfc.fit(X_train, y_train)


# In[60]:


y_pred = rfc.predict(X_test)
y_pred


# In[61]:


from sklearn.metrics import accuracy_score
print(accuracy_score(y_test, y_pred))


# In[62]:


rfc_acc = accuracy_score(y_test, y_pred)
print(rfc_acc)


# In[63]:


tempResults = pd.DataFrame({'Algorithm':['Random Forest Classifier Method'], 'Accuracy':[rfc_acc]})
results = pd.concat( [results, tempResults] )
results = results[['Algorithm','Accuracy']]
results


# In[64]:


# Support Vector Classifier
from sklearn import svm
svc = svm.SVC()
svc.fit(X_train,y_train)


# In[65]:


y_pred = svc.predict(X_test)
y_pred


# In[66]:


from sklearn.metrics import accuracy_score
print(accuracy_score(y_test, y_pred))


# In[67]:


svc_acc = accuracy_score(y_test, y_pred)
print(svc_acc)


# In[68]:


tempResults = pd.DataFrame({'Algorithm':['Support Vector Classifier Method'], 'Accuracy':[svc_acc]})
results = pd.concat( [results, tempResults] )
results = results[['Algorithm','Accuracy']]
results
