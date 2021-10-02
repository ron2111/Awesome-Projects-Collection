#!/usr/bin/env python
# coding: utf-8

# In[14]:


import tensorflow


# In[15]:


from keras.applications import ResNet50


# In[16]:


img_rows = 224
img_cols = 224 

#Loads the ResNet50 model 
ResNet50 = ResNet50(weights = 'imagenet', 
                 include_top = True, 
                 input_shape = (img_rows, img_cols, 3))


# In[17]:


# Print Layers
for (i,layer) in enumerate(ResNet50.layers):
    print(str(i) + " "+ layer.__class__.__name__, layer.trainable)


# In[18]:


from keras.applications import ResNet50


img_rows = 224
img_cols = 224 

# Re-loads the ResNet50 model without the FC layers

ResNet50 = ResNet50(weights = 'imagenet', 
                 include_top = False, 
                 input_shape = (img_rows, img_cols, 3))

# Here we freeze the last 4 layers 
# Layers are set to trainable as True by default

for layer in ResNet50.layers:
    layer.trainable = False
    
# Again print the Layers

for (i,layer) in enumerate(ResNet50.layers):
    print(str(i) + " "+ layer.__class__.__name__, layer.trainable)


# In[19]:


# Adding Layers to the pre-trained model

def addTopModel(bottom_model, num_classes):
    """creates the top or head of the model that will be 
    placed ontop of the bottom layers"""

    top_model = bottom_model.output
    top_model = GlobalAveragePooling2D()(top_model)
    top_model = Dense(1024,activation='relu')(top_model)
    top_model = Dense(1024,activation='relu')(top_model)
    top_model = Dense(512,activation='relu')(top_model)
    top_model = Dense(num_classes,activation='softmax')(top_model)
    return top_model


# In[20]:


from keras.models import Sequential
from keras.layers import Dense, Dropout, Activation, Flatten, GlobalAveragePooling2D
from keras.layers import Conv2D, MaxPooling2D, ZeroPadding2D
from keras.layers.normalization import BatchNormalization
from keras.models import Model

num_classes = 3

FC_Head = addTopModel(ResNet50, num_classes)

model = Model(inputs=ResNet50.input, outputs=FC_Head)

print(model.summary())




# In[21]:


# Generating new images for the same object

from keras.preprocessing.image import ImageDataGenerator

train_data_dir = './Data/Train'
validation_data_dir = './Data/Validation'

train_datagen = ImageDataGenerator(
      rescale=1./255,
      rotation_range=20,
      width_shift_range=0.2,
      height_shift_range=0.2,
      horizontal_flip=True,
      fill_mode='nearest')
 
validation_datagen = ImageDataGenerator(rescale=1./255)
 

train_batchsize = 18
val_batchsize = 20
 
train_generator = train_datagen.flow_from_directory(
        train_data_dir,
        target_size=(img_rows, img_cols),
        batch_size=train_batchsize,
        class_mode='categorical')
 
validation_generator = validation_datagen.flow_from_directory(
        validation_data_dir,
        target_size=(img_rows, img_cols),
        batch_size=val_batchsize,
        class_mode='categorical',
        shuffle=False)


# In[22]:


# importing our optimizer

from keras.optimizers import RMSprop
 
model.compile(loss = 'categorical_crossentropy',
              optimizer = RMSprop(lr = 0.001),
              metrics = ['accuracy'])


# In[23]:


# Training the model

nb_train_samples = 140
nb_validation_samples = 140
epochs = 5
batch_size = 16

history = model.fit_generator(
    train_generator,
    steps_per_epoch = nb_train_samples // batch_size,
    epochs = epochs,
    validation_data = validation_generator,
    validation_steps = nb_validation_samples // batch_size)




# In[24]:


# Loading our cassifier

from keras.models import load_model

classifier = load_model('Fam_cam.h5')


# In[26]:


# Final step : Testing our model

import os
import cv2
import numpy as np
from os import listdir
from os.path import isfile, join

Family_dict = {"[0]": "Falguni ", 
                      "[1]": "Mom",
                      "[2]": "Sister"}

Family_dict_n =  {"n0": "Falguni ", 
                         "n1": "Mom",
                         "n2": "Sister"}

def draw_test(name, pred, im):
    members = Family_dict[str(pred)]
    BLACK = [0,0,0]
    expanded_image = cv2.copyMakeBorder(im, 80, 0, 0, 100 ,cv2.BORDER_CONSTANT,value=BLACK)
    cv2.putText(expanded_image, members, (20, 60) , cv2.FONT_HERSHEY_SIMPLEX,1, (0,0,255), 2)
    cv2.imshow(name, expanded_image)

def getRandomImage(path):
    """function loads a random images from a random folder in our test path """
    folders = list(filter(lambda x: os.path.isdir(os.path.join(path, x)), os.listdir(path)))
    random_directory = np.random.randint(0,len(folders))
    path_class = folders[random_directory]
    print("Class - " + Family_dict_n[str(path_class)])
    file_path = path + path_class
    file_names = [f for f in listdir(file_path) if isfile(join(file_path, f))]
    random_file_index = np.random.randint(0,len(file_names))
    image_name = file_names[random_file_index]
    return cv2.imread(file_path+"/"+image_name)    

for i in range(0,3):
    input_im = getRandomImage("Data/Validation/")
    input_original = input_im.copy()
    input_original = cv2.resize(input_original, None, fx=0.5, fy=0.5, interpolation = cv2.INTER_LINEAR)
    
    input_im = cv2.resize(input_im, (224, 224), interpolation = cv2.INTER_LINEAR)
    input_im = input_im / 255.
    input_im = input_im.reshape(1,224,224,3) 
    
    # Show Prediction
    res = np.argmax(classifier.predict(input_im, 1, verbose = 0), axis=1)
    

    # Show images with predicted class
    draw_test("Fam_cam.h5", res, input_original) 
    cv2.waitKey(0)

cv2.destroyAllWindows()






