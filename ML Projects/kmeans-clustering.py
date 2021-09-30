#importing libraries
import pandas as pd
import numpy as np
from sklearn.naive_bayes import GaussianNB
from sklearn.model_selection import train_test_split
from sklearn import metrics
import matplotlib.pyplot as plt
import io
import random as rd

# loading dataset

class1_data = pd.read_csv("Class1.txt", sep="\t", names=["A", "B", "C"])
class2_data = pd.read_csv("Class2.txt", sep="\t", names=["A", "B", "C"])

data = pd.DataFrame(class1_data[["A","B"]])
data = data.append(class2_data[["A","B"]])
# print(data)

X = data.values
print(X.shape)

# Plot of data set

plt.figure()
plt.scatter(data[["A"]],data[["B"]],label="data points")
plt.xlabel("Feature 1")
plt.ylabel("Feature 2")
plt.legend())

# K-Means Algorithm

class Kmeans:
    def __init__(self,X,K):
        self.X = X
        self.Output = {}
        self.Centroids = np.array([]).reshape(self.X.shape[1],0)
        self.K = K
        self.m = self.X.shape[0]
      
    
    def fit(self,n_iter):
        
        # randomly Initialize the centroids        
        for i in range(self.K):
            rand=rd.randint(0,self.m-1)
            self.Centroids=np.c_[self.Centroids,self.X[rand]]

        for n in range(n_iter):
            EuclidianDistance=np.array([]).reshape(self.m,0)
            for k in range(self.K):
                tempDist = np.sum((self.X-self.Centroids[:,k])**2,axis=1)
                EuclidianDistance = np.c_[EuclidianDistance,tempDist]
            C = np.argmin(EuclidianDistance,axis=1)+1
            
            # adjust the centroids
            Y = {}
            for k in range(self.K):
                Y[k+1] = np.array([]).reshape(2,0)
            for i in range(self.m):
                Y[C[i]] = np.c_[Y[C[i]],self.X[i]]
        
            for k in range(self.K):
                Y[k+1] = Y[k+1].T
            for k in range(self.K):
                self.Centroids[:,k] = np.mean(Y[k+1],axis=0)
                
            self.Output = Y

    # for plotting clusters on graph
    def plot_graph(self, K):
        color = ['red','blue','green','cyan','magenta','black','pink','brown']
        labels = ['cluster1','cluster2','cluster3','cluster4','cluster5','cluster6','cluster7','cluster8']
        for k in range(K):
            plt.scatter(self.Output[k+1][:,0], self.Output[k+1][:,1], c = color[k], label = labels[k])
        plt.scatter(self.Centroids[0,:],self.Centroids[1,:],s=200,c='yellow',label='Centroids')
        plt.xlabel('Feature 1')
        plt.ylabel('Feature 2')
        plt.legend()
        plt.show()
    
    def predict(self):
        return self.Output, self.Centroids.T
    
    def WCSS(self):
        wcss = 0
        for k in range(self.K):
            wcss += np.sum((self.Output[k+1]-self.Centroids[:,k)])**2)
        return wcss

WCSS_array = np.array([])
for K in range(1,9):
    kmeans = Kmeans(X,K)
    kmeans.fit(n_iter)
    kmeans.plot_graph(K)
    Output,Centroids = kmeans.predict()
    wcss = 0
    for k in range(K):
        wcss += np.sum((Output[k+1]-Centroids[k,:])**2)
    WCSS_array = np.append(WCSS_array,wcss)

K_array = np.arange(1,9,1)
plt.plot(K_array,WCSS_array)
plt.xlabel('Number of Clusters')
plt.ylabel('within-cluster sums of squares (WCSS)')
plt.title('Elbow method to determine optimum number of clusters')
plt.show()

