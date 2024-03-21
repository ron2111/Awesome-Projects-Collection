# Image Classification using Python and Machine Learning

This repo contains the code to perform a simple image classification task using Python and Machine Learning. We will apply global feature descriptors such as Color Histograms, Haralick Textures and Hu Moments to extract features from FLOWER17 dataset and use machine learning models to learn and predict.

[UPDATE]
Now, you can simply run `organize_flowers17.py` script to download and organize training data for this project. Also, I have updated the code to support only Python 3+ as Python 2+ faces end of life.

## Summary of the project
* Global Feature Descriptors such as Color Histograms, Haralick Textures and Hu Moments are used on University of Oxford's FLOWER17 dataset.
* Classifiers used are Logistic Regression, Linear Discriminant Analysis, K-Nearest Neighbors, Decision Trees, Random Forests, Gaussian Naive Bayes and Support Vector Machine.

## Usage 

* `python organize_flowers17.py` - Downloads Flowers17 Dataset and organizes training set in disk.
* `python global.py` - Extracts global features from training set and stores it in disk.
* `python train_test.py` - Predicts the image class using the trained model.
