# Video Views Prediction using Machine Learning

## Instructions:
1. Download Jupyter Notebook(or use Google Colab)
2. Download the zip files and extract in directory
3. Open the provided jupyter notebook
4. Add the location of the training and testing data set provided with the code
5. Run to get the predictions
6. Data visualisation has also been done in the code. Refer comments for that

## Data pre-processing:
The metadata was used as it is given. For using image pixel data, discription data and title data, I used the average
of the values provided to make it easy for analysis. With visulation, the results from this approach looked satisfactory.

## Features used:
I didn't use 'views' and 'comp_id' for obvious reasons with the training dataset.
The list of features used are:
1. embed
2. ratio
3. duration
4. language
5. partner
6. n_likes
7. n_tags
8. n_formats
9. hour
10. Average(average of pixel data of images)
11. average_d(average of description data)

## Outlier removal
I removed a few extreme values to avoid outliers. The deleted values and the method to delete has been given in the code with comments to explain it as well.

## Model Used
### Linear Regression

**Note:** Got best results with Linear Regression. I tried XGBoost, Random Forest and SVM regression but results with Linear Regression were the most
suitable.

**Note:** As the image dataset is too big to upload here, I have provided this link to download it.

[Image Data set](https://drive.google.com/file/d/1KP91f34_cMBmRmsg9uk-w9LMygX5mDwq/view?usp=sharing)



