# Transfer_Learning_face_det_with_ResNet50

This model is based on the concept called Transfer Learning.

Now What is Transfer Learning?

Transfer learning is a machine learning method where a model developed for a task is reused as the starting point for a model on a second task. 
 
 About The Task:
 
 The task focuses on using a pre-trained model such as MobileNet to create another model by adding more dense layers for detection of a new object.
 
 Solution:
 
 Step 1:
 The first step is to import the pretrained model that you want to use.
 It can be MobieNet, VGG16, VGG19 Inception.
 In this model I used ResNset50 as a pre-trained model.
 
 Step 2:
 The second step is to freeze all the layers in the model, since we don't have to train all the layers therefore we freeze it.
 
 Step 3:
 After freezing the layers of the model our main task is to add more Dense layers so that when we give a new object to the model as input then these layers will be responible for training the model for that new object.
 
 Step 4:
 After adding all the layers, we, then train the model and import all the modules from keras that are needed for trining the model.
 
 Step 5:
 It is possible that we have a limited number of images of the new object, so from keras preprocessing library we can import a module called Image Data Generator.
 This module will increase the number of data by altering the images that are already clicked, it can zoom out, rotate, rescale and even change the color of the images to generate new images of the same object.
 
 Step 6:
 We import the optimizers that we want to use for our model. Here I have used RMSprop as the optimizer.
 
 Step 7:
 Now we fit the data in the model and train it.
 
 Step 8:
 
The last step is to test the model!
 