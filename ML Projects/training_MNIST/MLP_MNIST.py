# 3 layered model
import numpy as np
import torch as T
import torch.nn as nn
#import torch.nn.functional as F
from torchvision import datasets, transforms
from tqdm.notebook import tqdm

class mnist_model(nn.Module):
    def __init__(self):
        super().__init__()
        self.hidden = nn.Linear(784, 500)
        self.hidden1 = nn.Linear(500,250)
        self.output = nn.Linear(250,10)

    def forward(self, x):
        x = self.hidden(x)
        x = F.relu(x)
        x = self.hidden1(x)
        x = F.relu(x)
        x = self.output(x)
        return x#F.softmax(x, dim=1)

# Load the data
mnist_train = datasets.MNIST(root="./datasets", train=True, transform=transforms.ToTensor(), download=True)
mnist_test = datasets.MNIST(root="./datasets", train=False, transform=transforms.ToTensor(), download=True)
train_loader = T.utils.data.DataLoader(mnist_train, batch_size=100, shuffle=True)
test_loader = T.utils.data.DataLoader(mnist_test, batch_size=100, shuffle=False)

## Training
# Instantiate model
model = mnist_model()

# Loss and Optimizer
criterion = nn.CrossEntropyLoss()
optimizer = T.optim.SGD(model.parameters(), lr=0.1)

# Iterate through train set minibatchs 
for images, labels in tqdm(train_loader):
    # Zero out the gradients
    optimizer.zero_grad()
    
    # Forward pass
    x = images.view(-1, 28*28)
    y = model.forward(x)
    loss = criterion(y, labels)
    # Backward pass
    loss.backward()
    optimizer.step()

## Testing
correct = 0
total = len(mnist_test)

with T.no_grad():
    # Iterate through test set minibatchs 
    for images, labels in tqdm(test_loader):
        # Forward pass
        x = images.view(-1, 28*28)
        y = model.forward(x)
        
        predictions = torch.argmax(y, dim=1)
        correct += torch.sum((predictions == labels).float())
    
print('Test accuracy: {}'.format(correct/total))
print(correct)