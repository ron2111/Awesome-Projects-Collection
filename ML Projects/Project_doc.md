## Add your Machine Learning projects here.

<h3><b>Score Checker 📝</b></h3><hr>
I made this project for improving my accuracy while has been using random forest regressor
by passing different parameters .<br><br>
code is
easy to read and even you add more parameters and techniques in it by just having basic knowledge of python.
<br><br>
<h3>how to use score checker</h3>
<ol>
 <li>save "score checker" in your local directory (where you create your machine learning project)</li>
 <Li> import "score checker.py" as local library</li>
 <li>call function "score_model" form library</li>
 <li> pass 5 arguments i.e
  <ul>
   <li>model</li><li>x_train</li><li>x_test</li><li>y_train</li><li>y_test</li></ul>
 <li> And you get standard Mean Absolute Error as score</li>
  </ol>

<h3> Drowsiness Detection System</h3><hr>

In Recent days most of the accidents were recorded due to drunk driving and sleepiness while driving at night and no safety ascepts were there.
By means of this project if any driver falls asleep or he / She eyes closes or gets drowsy he will be immediately alerted by an buzzer/Alarm System Using Face and Eye tracking
Hope this project see light .

<h3> LSTM Prediction Model</h3><hr>

Artificial Intelligence is shaping the future of stock trading; while humans remain a big part of the trading equation, AI plays a critical role.
Made a Deep learning model, which could predict NASDAQ stock prices (National Association of Securities Dealers Automated Quotations).
The model was built using Tensorflow Sequential API :
A stacked LSTM was made with three LSTM layers, two Dropouts layers, and one final output layer.
Since our task was stock price prediction, mean squared error loss was used with ‘adam’ optimizer for gradient descent.
LearningRateScheduler was used as a callback. With the help of callback, we can customize our model; I was able to decrease the learning rate by 2% after every two epochs using LearningRateScheduler.


