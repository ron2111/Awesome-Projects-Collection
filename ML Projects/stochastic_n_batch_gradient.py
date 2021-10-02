# Batch and stochastic both .
from sklearn import datasets
import pandas as pd


boston = datasets.load_boston(return_X_y=False)
boston_df = pd.DataFrame(boston.data, columns=boston.feature_names)
boston_df['PRICE'] = boston.target
print(boston_df)

train_dataset = boston_df.sample(frac=0.3)
dataframe = boston_df.drop(train_dataset.index)
validation_dataset = dataframe.sample(frac=(.1/.7))
test_dataset = dataframe.drop(validation_dataset.index)

print("train dataset\n", train_dataset)
# print("validation dataset\n", validation_dataset)
# print("test dataset\n", test_dataset)


import numpy as np

def hypothesis(w, index, dataset): #h(x)
  sample =dataset[index][:-1]
  sample = np.concatenate([[1], sample])
  array = np.multiply(w, sample)
  return np.sum(array)


w=[1,1,1]
dataset = np.array([[1,2,6], [2,10,24]])

print(hypothesis(w, 0, dataset))
print(dataset)

# to calculate the predicted value with the help of hypothesis function
def predicted_values(w, dataset):
  predicted = []
  for i in range(len(dataset)):
    predicted.append(hypothesis(w, i, dataset))
  
  return np.array(predicted)

predicted = predicted_values(w, dataset)

print(predicted)


# to calculate mean square error
def MSE(predicted, actual):
  return np.square(np.subtract(predicted, actual)).mean()/2

MSE(predicted, dataset[:,-1])

# to update w using batch gradient decendent
def update_parameter(w, alpha, dataset):
  predicted = predicted_values(w, dataset)
  m = len(dataset)
  w[0] = w[0] - (alpha /m)*(np.sum(np.subtract(predicted, dataset[:, -1])))
  for i in range(1, len(w)):
    w[i] = w[i] - (alpha /m)*(np.sum(np.multiply(np.subtract(predicted, dataset[:, -1]), dataset[:, i-1])))
  return w


#w=update_parameter(w, 0.1, dataset)
print(update_parameter(w, 0.1, dataset))

# to update w using stochastic gradient decendent
def update_parameter_stochastic(w, alpha, dataset):
  np.random.shuffle(dataset)
  m = len(dataset)
  for j in range(m):
    hy = hypothesis(w, j, dataset)
    w[0] = w[0] - (alpha /m)*(hy- dataset[:, -1][j])
    for i in range(1, len(w)):
      w[i] = w[i] - (alpha /m)*((hy- dataset[:, -1][j])* dataset[:, i-1][j])
  return w
print(update_parameter_stochastic([1,1,1], 0.1, dataset))


def linear_regression(epoch, alpha, rho, w, train_dataset):
  epochs_MSE=[]
  pre_MSE = 0
  curr_MSE = 0
  for itr in range(epoch):
    predicted = predicted_values(w, train_dataset)
    curr_MSE = MSE(predicted, train_dataset[:,-1])
    w = update_parameter_stochastic(w, alpha, train_dataset)

    epochs_MSE.append(curr_MSE)

    if abs(curr_MSE - pre_MSE) <= rho:
      break;
  return w, epochs_MSE


from sklearn import preprocessing
w=[1 for _ in range(14)]

normalized = preprocessing.normalize(train_dataset.to_numpy())
w1, trains_MSE1 = linear_regression(10, 0.1, 0.5, w, normalized)


validation = preprocessing.normalize(validation_dataset.to_numpy())
predicted = predicted_values(w1, validation)
val_MSE1 = MSE(predicted, validation[:,-1])

# print(w1)
# print(trains_MSE1)
print("MSE of validation set")
print(val_MSE1)



w=[1 for _ in range(14)]
w2, trains_MSE2 = linear_regression(20, 0.01, 0.6, w, normalized)

predicted = predicted_values(w2, validation)
val_MSE2 = MSE(predicted, validation[:,-1])

# print(w2)
# print(trains_MSE2)
print("MSE of validation set")
print(val_MSE2)



w=[1 for _ in range(14)]
w3, trains_MSE3 = linear_regression(30, 0.02, 0.7, w, normalized)

predicted = predicted_values(w3, validation)
val_MSE3 = MSE(predicted, validation[:,-1])

# print(w3)
# print(trains_MSE3)
print("MSE of validation set")
print(val_MSE3)


w=[1 for _ in range(14)]
w4, trains_MSE4 = linear_regression(40, 0.03, 0.8, w, normalized)

predicted = predicted_values(w4, validation)
val_MSE4 = MSE(predicted, validation[:,-1])

# print(w4)
# print(trains_MSE4)
print("MSE of validation set")
print(val_MSE4)

w=[1 for _ in range(14)]
w5, trains_MSE5 = linear_regression(50, 0.001, 0.9, w, normalized)

predicted = predicted_values(w5, validation)
val_MSE5 = MSE(predicted, validation[:,-1])

# print(w5)
# print(trains_MSE5)
print("MSE of validation set")
print(val_MSE5)


print("All MSE considering the best hyperparameter")
print("Validation MSE :", val_MSE1)


train = preprocessing.normalize(train_dataset.to_numpy())
predicted = predicted_values(w1, train)
best_trainMSE = MSE(predicted, train[:,-1])

print("Train MSE:", best_trainMSE)

test = preprocessing.normalize(test_dataset.to_numpy())
predicted = predicted_values(w1, test)
best_testMSE = MSE(predicted, test[:,-1])

print("TEST MSE:", best_testMSE)

import matplotlib.pyplot as plt

# print(trains_MSE1)
epoch = [i for i in range(len(trains_MSE1))]
plt.plot(epoch, trains_MSE1)

