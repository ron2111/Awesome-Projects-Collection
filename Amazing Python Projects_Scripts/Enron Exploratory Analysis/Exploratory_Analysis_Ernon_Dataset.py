#!/usr/bin/env python
# coding: utf-8

# # <div style="text-align: center">Exploratory Analysis - Ernon Dataset</div>

# **Importing Libraries**

# In[1]:


import os, email
import numpy as np 
import pandas as pd
import matplotlib.pyplot as plt
get_ipython().run_line_magic('matplotlib', 'inline')
import seaborn as sns; sns.set_style('whitegrid')
from nltk.tokenize.regexp import RegexpTokenizer


# **Loading Dataset**

# In[2]:


emails_df = pd.read_csv(os.getcwd()+'/Downloads/emails.csv')
print(emails_df.shape)
emails_df.head()


# In[3]:


print(emails_df['message'][0])


# **Helper Functions**

# In[4]:


def get_text(msg):
    #To get the content from email
    parts = []
    for part in msg.walk():
        if part.get_content_type() == 'text/plain':
            parts.append( part.get_payload() )
    return ''.join(parts)

def split_email_addresses(line):
    #To separate multiple email addresses
    if line:
        address = line.split(',')
        address = frozenset(map(lambda x: x.strip(), address))
    else:
        address = None
    return address

def preprocess_folder(data):
    folders = []
    for item in data:
        if item == None or item == '':
            folders.append(np.nan)
        else:
            item = item.split("\\")[-1]
            item = item.lower()
            folders.append(item)
    print("Folder cleaned!")
    return folders      

def barplot(df, X, Y, figsize, color, orient, ylabel, xlabel, font_scale, rotation):
    f, ax = plt.subplots(figsize=figsize)
    sns.set_color_codes("muted")
    sns.barplot(x = X, y = Y, data = df, color = color, orient = orient)
    ax.set(ylabel = ylabel, xlabel = xlabel)
    sns.set(font_scale = font_scale)
    plt.xticks(rotation = rotation) 
    plt.show()


# **Data Cleaning**

# In[5]:


# Parsing the emails into a list of email objects
messages = list(map(email.message_from_string, emails_df['message']))
emails_df.drop('message', axis=1, inplace=True)
# Getting fields from parsed email objects
keys = messages[0].keys()
for key in keys:
    emails_df[key] = [doc[key] for doc in messages]
# Parsing the content from emails
emails_df['content'] = list(map(get_text, messages))
# Splitting multiple email addresses
emails_df['From'] = emails_df['From'].map(split_email_addresses)
emails_df['To'] = emails_df['To'].map(split_email_addresses)

# Extract the root of file as 'user'
emails_df['user'] = emails_df['file'].map(lambda x:x.split('/')[0])
del messages


# In[6]:


emails_df["Folder Name"] = preprocess_folder(emails_df["X-Folder"])   
emails_df.head()


# **Number of unique values in each columns**
# 

# In[7]:


print('shape of the dataframe:', emails_df.shape)
for col in emails_df.columns:
    print(col, emails_df[col].nunique())


# In[8]:


# index setting and dropping columns with too few values
emails_df = emails_df.set_index('Message-ID')    .drop(['file', 'Mime-Version', 'Content-Type', 'Content-Transfer-Encoding'], axis=1)
# Parsing datetime
emails_df['Date'] = pd.to_datetime(emails_df['Date'], infer_datetime_format=True)
emails_df.dtypes


# **Count no. of emails per user, average no. of words in subjects and message content**

# In[9]:


# Count words in Subjects and Message Content
tokenizer = RegexpTokenizer(r'(?u)\b\w\w+\b')
emails_df['subject_wc'] = emails_df['Subject'].map(lambda x: len(tokenizer.tokenize(x)))
emails_df['content_wc'] = emails_df['content'].map(lambda x: len(tokenizer.tokenize(x)))
grouped_by_people = emails_df.groupby('user').agg({
        'content': 'count', 
        'subject_wc': 'mean',
        'content_wc': 'mean',
    })
grouped_by_people.rename(columns={'content': 'No. of emails', 
                                  'subject_wc': 'Avg. subject word count', 
                                  'content_wc': 'Avg, content word count'}, inplace=True)
grouped_by_people.sort_values('No. of emails', ascending=False)


# In[10]:


mail_count = emails_df["user"].value_counts()
indices = mail_count.index
count = pd.DataFrame(mail_count)
count.rename(columns = {"user": "Count"}, inplace = True)
count["Employees"] = indices
barplot(df = count[:50], X = "Count", Y = "Employees", figsize = (10, 10), color = 'orange', orient = 'h', ylabel = "Employees", xlabel = "No. of Emails", font_scale = 1.2, rotation = 90)


# In[11]:


email_count = emails_df["Folder Name"].value_counts()
count = pd.DataFrame(email_count, columns = ["Folder Name"])
count.rename(columns={'Folder Name': 'Email Count'}, inplace=True)
count


# In[12]:


# dataframe containing counts of every word in the emails dataframe
email_count = emails_df["Folder Name"].value_counts()
indices = email_count.index
count = pd.DataFrame(email_count, columns = ["Folder Name"])
count["Folder Names"] = indices

    
barplot(df = count[:20], X = "Folder Name", Y = "Folder Names", figsize = (7, 8), color = 'b', orient = 'h', ylabel = "Folders", xlabel = "Email Count", font_scale = 1.2, rotation = 90)


# In[13]:


allenp = emails_df[emails_df["user"] == "allen-p"]
allenp["Folder Name"].value_counts()[:8]


# In[14]:


emails_df.isnull().sum()


# In[15]:


emails_df.drop('To', axis=1, inplace = True)


# In[16]:


emails_df.dropna(inplace = True)
print("Rows with missing values have been removed")
emails_df.isnull().sum()


# In[17]:


emails_df


# In[18]:


table=pd.DataFrame(grouped_by_people.reset_index())


# In[19]:


sns.pairplot(table,height=3)

