from __future__ import print_function		
import sys
import numpy as np
import random
import math
import matplotlib.pyplot as plt

fo=open("Class1.txt","r")
data=[]
for line in fo:
	a,b=line.split()
	data.append([1, float(a),float(b)])
fo.close()
fo=open("Class2.txt","r")
for line in fo:
	a,b=line.split()
	data.append([1, float(a),float(b)])
fo.close()
fo=open("Class3.txt","r")
for line in fo:
	a,b=line.split()
	data.append([1, float(a),float(b)])
fo.close()
print(np.shape(data))

Y=[]
for i in range(500):
	Y.append(1)
for i in range(500):
	Y.append(-1)
for i in range(1000):
	Y.append(-1)

w1=[0, 0, 0]
flag=1
it=0
while flag==1:
	it=it+1
	flag=0
	for i in range(2000):
		x=data[i]
		wdash=w1
		decision=x[0]*w1[0]+x[1]*w1[1]+x[2]*w1[2]
		if (decision>=0 and Y[i]==-1):
			flag=1
			for j in range(1,3):
				w1[j]=wdash[j]-x[j]
			w1[0]=wdash[0]-1
		elif (decision<0 and Y[i]==1):
			flag=1
			for j in range(1, 3):
				w1[j]=wdash[j]+x[j]
			w1[0]=wdash[0]+1
	if it==1000:
		flag=0
print(it)

fo=open("Class2.txt","r")
data=[]
for line in fo:
	a,b=line.split()
	data.append([1, float(a),float(b)])
fo.close()
fo=open("Class1.txt","r")
for line in fo:
	a,b=line.split()
	data.append([1, float(a),float(b)])
fo.close()
fo=open("Class3.txt","r")
for line in fo:
	a,b=line.split()
	data.append([1, float(a),float(b)])
fo.close()
print(np.shape(data))

Y=[]
for i in range(500):
	Y.append(1)
for i in range(500):
	Y.append(-1)
for i in range(1000):
	Y.append(-1)

w2=[0, 0, 1]
flag=1
it=0
while flag==1:
	it=it+1
	flag=0
	for i in range(2000):
		x=data[i]
		wdash=w2
		decision=x[0]*w2[0]+x[1]*w2[1]+x[2]*w2[2]
		if (decision>=0 and Y[i]==-1):
			flag=1
			for j in range(2):
				w2[j+1]=wdash[j+1]-x[j+1]
			w2[0]=wdash[0]-1
		elif (decision<0 and Y[i]==1):
			flag=1
			for j in range(2):
				w2[j+1]=wdash[j+1]+x[j+1]
			w2[0]=wdash[0]+1
	if it==1000:
		flag=0
print(it)

fo=open("Class3.txt","r")
data=[]
for line in fo:
	a,b=line.split()
	data.append([1, float(a),float(b)])
fo.close()
fo=open("Class1.txt","r")
for line in fo:
	a,b=line.split()
	data.append([1, float(a),float(b)])
fo.close()
fo=open("Class2.txt","r")
for line in fo:
	a,b=line.split()
	data.append([1, float(a),float(b)])
fo.close()
print(np.shape(data))
Y=[]
for i in range(1000):
	Y.append(1)
for i in range(500):
	Y.append(-1)
for i in range(500):
	Y.append(-1)

w3=[0, 0, 1]
flag=1
it=0
while flag==1:
	it=it+1
	flag=0
	for i in range(2000):
		x=data[i]
		wdash=w3
		decision=x[0]*w3[0]+x[1]*w3[1]+x[2]*w3[2]
		if (decision>=0 and Y[i]==-1):
			flag=1
			for j in range(1, 3):
				w3[j]=wdash[j]-x[j]
			w3[0]=wdash[0]-1
		elif (decision<0 and Y[i]==1):
			flag=1
			for j in range(1, 3):
				w3[j]=wdash[j]+x[j]
			w3[0]=wdash[0]+1
	if it==1000:
		flag=0
print(it)

print(w1)
print(w2)
print(w3)
class1=[]
class2=[]
class3=[]
final=[]
for i in range(2000):
	x=data[i]
	arg1=x[0]*w1[0]+x[1]*w1[1]+x[2]*w1[2]
	arg2=x[0]*w2[0]+x[1]*w2[1]+x[2]*w2[2]
	arg3=x[0]*w3[0]+x[1]*w3[1]+x[2]*w3[2]
	if arg1>arg2 and arg1>arg3:
		class1.append(x)
		final.append(1)
	elif arg3>arg1 and arg3>arg2:
		class3.append(x)
		final.append(3)
	else:
		class2.append(x)
		final.append(2)
print(np.shape(class1))
print(np.shape(class2))
print(np.shape(class3))



temp1=[]
temp2=[]
temp3=[]
for x in np.arange(-8, 8, 0.1):
	for y in np.arange(-8, 8, 0.1):
		arg1=1*w1[0]+x*w1[1]+y*w1[2]
		arg2=1*w2[0]+x*w2[1]+y*w2[2]
		arg3=1*w3[0]+x*w3[1]+y*w3[2]
		if arg1>arg2 and arg1>arg3:
			temp1.append([1, x, y])
		elif arg3>arg1 and arg3>arg2:
			temp3.append([1, x, y])
		else:
			temp2.append([1, x, y])

print(np.shape(temp1))
print(np.shape(temp2))
print(np.shape(temp3))
A=[]
B=[]
for i in temp1:
	A.append(i[1])
	B.append(i[2])
plt.scatter(A, B, c='red', alpha=0.5)
A=[]
B=[]
for i in temp2:
	A.append(i[1])
	B.append(i[2])
plt.scatter(A, B, c='green', alpha=0.5)
A=[]
B=[]
for i in temp3:
	A.append(i[1])
	B.append(i[2])
plt.scatter(A, B, c='yellow', alpha=0.5)

A=[]
B=[]
for i in class1:
	A.append(i[1])
	B.append(i[2])
plt.plot(A, B, 'o', color='blue', markersize=3);
A=[]
B=[]
for i in class2:
	A.append(i[1])
	B.append(i[2])
plt.plot(A, B, 'o', color='black', markersize=3);
A=[]
B=[]
for i in class3:
	A.append(i[1])
	B.append(i[2])
plt.plot(A, B, 'o', color='cyan', markersize=3);
# plt.legend(loc='upper left')
plt.show()
