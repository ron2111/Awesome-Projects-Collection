import matplotlib.pyplot as plt
import matplotlib.animation as animation
import matplotlib.patches as mpatches
from mpl_toolkits.mplot3d import axes3d
from matplotlib import style
import numpy as np
import math
import time

#plt.style.use('dark_background')
class ParticleInABox():
    class OneDimensional():

        def __init__(self, length_x, quantum_number):
            self.length_x = int(length_x)
            self.quantum_number = int(quantum_number)

        def wavefunction(self):
            x = []
            for i in range((self.length_x)*100):
                u = i/100
                x.append(u)
            y = []
            for i in x:
                output = math.sqrt((2)/(self.length_x))*math.sin((math.pi*self.quantum_number*i)/(self.length_x))
                y.append(output)

            figure = plt.figure()
            axis = figure.add_subplot(111)
            axis.plot(x, y, color = "blue")
            plt.title(r'$n_x =' + str(self.quantum_number) + '$')
            axis.set_xlabel(r'$x$')
            axis.set_ylabel(r'$\psi(x)$')
            plt.show()

        def PDF(self):

            x = []
            for i in range((self.length_x)*100):
                u = i/100
                x.append(u)

            y = []

            for i in x:
                output = (2/self.length_x)*pow(math.sin((math.pi*self.quantum_number*i)/(self.length_x)), 2)
                y.append(output)

            figure = plt.figure()
            axis = figure.add_subplot(111)
            axis.plot(x, y, color = "blue")
            plt.title(r'$n_x =' + str(self.quantum_number) + '$')
            axis.set_xlabel(r'$x$')
            axis.set_ylabel(r'$|\psi(x)|^2$')
            plt.show()

    class TwoDimensional():

        def __init__(self, length_x, length_y, quantum_number_x, quantum_number_y):

            self.length_x = length_x
            self.length_y = length_y
            self.quantum_number_x = quantum_number_x
            self.quantum_number_y = quantum_number_y

        def close(self):
            pass

        def wavefunction(self):

            """Generating x-coordinates."""
            x = np.linspace(0, self.length_x, 100)

            """Generating y-coordinates."""
            y = np.linspace(0, self.length_y, 100)

            """Generating all possible xy-coordinates."""
            X,Y = np.meshgrid(x,y)

            """Generating z-coordinates from xy-coordinates."""
            Z = np.sqrt((2)/(self.length_x*self.length_y))*np.sin((math.pi*self.quantum_number_x*X)/(self.length_x))*np.sin((math.pi*self.quantum_number_y*Y)/(self.length_y))

            """Generating plot."""
            figure = plt.figure()
            axis = figure.gca(projection='3d')
            contour = axis.plot_surface(X,Y,Z,cmap='hot')
            figure.colorbar(contour, shrink = 0.75)
            axis.set_xlabel(r'$x$')
            axis.set_ylabel(r'$y$')
            axis.set_zlabel(r'$\psi(x, y)$')
            plt.title(r'$n_x =' + str(self.quantum_number_x) + ' ,n_y =' + str(self.quantum_number_y) + '$')
            axis.view_init(elev = 20, azim = -135)
            plt.show()

        def PDF(self):

            """Generating x-coordinates."""
            x = np.linspace(0, self.length_x, 1000)

            """Generating y-coordinates."""
            y = np.linspace(0, self.length_y, 1000)

            """Generating all possible xy-coordinates."""
            X,Y = np.meshgrid(x,y)

            """Generating z-coordinates from xy-coordinates."""
            Z = (2/self.length_x*self.length_y)*pow(np.sin((math.pi*self.quantum_number_x*X)/(self.length_x))*np.sin((math.pi*self.quantum_number_y*Y)/(self.length_y)),2)

            """Generating plot."""
            figure = plt.figure()
            axis = figure.gca(projection='3d')
            contour = axis.plot_surface(X,Y,Z,cmap='hot')
            figure.colorbar(contour, shrink = 0.75)
            axis.set_xlabel(r'$x$')
            axis.set_ylabel(r'$y$')
            axis.set_zlabel(r'$|\psi(x, y)|^2$')
            plt.title(r'$n_x =' + str(self.quantum_number_x) + ' ,n_y =' + str(self.quantum_number_y) + '$')
            axis.view_init(elev = 20, azim = -135)
            plt.show()

    class ThreeDimensional():

        def __init__(self, length_x, length_y, length_z, quantum_number_x, quantum_number_y, quantum_number_z, scatter_density):

            self.length_x = length_x
            self.length_y = length_y
            self.length_z = length_z
            self.quantum_number_x = quantum_number_x
            self.quantum_number_y = quantum_number_y
            self.quantum_number_z = quantum_number_z
            self.scatter_density = scatter_density

        def wavefunction(self):

            """Generating x-coordinates."""
            x = []
            for i in range((self.length_x)*self.scatter_density):
                u = i/self.scatter_density
                x.append(u)

            """Generating y-coordinates."""
            y = []
            for i in range((self.length_y)*self.scatter_density):
                u = i/self.scatter_density
                y.append(u)

            """Generating z-coordinates."""
            z = []
            for i in range((self.length_z)*self.scatter_density):
                u = i/self.scatter_density
                z.append(u)

            """Generating all possible xyz-coordinates."""
            space_coordinates = []
            counter = 0
            for i in x:
                for j in y:
                    for k in z:
                        coordinate = []
                        coordinate.append(i)
                        coordinate.append(j)
                        coordinate.append(k)
                        space_coordinates.append(coordinate)
                        counter = counter + 1

            """Generating colour-coordinates from xyz-coordinates."""
            for coordinate in space_coordinates:
                output = math.sqrt((2)/(self.length_x*self.length_y*self.length_z))*math.sin((math.pi*self.quantum_number_x*coordinate[0])/(self.length_x))*math.sin((math.pi*self.quantum_number_y*coordinate[1])/(self.length_y))*math.sin((math.pi*self.quantum_number_z*coordinate[2])/(self.length_z))
                coordinate.append(output)

            """Formatting colour-xyz-coordinates."""
            x_plot = []
            y_plot = []
            z_plot = []
            colour_plot = []
            for coordinate in space_coordinates:
                x_plot.append(coordinate[0])
                y_plot.append(coordinate[1])
                z_plot.append(coordinate[2])
                colour_plot.append(coordinate[3])

            """Generating plot"""
            figure = plt.figure()
            plt.title(r'$n_x =' + str(self.quantum_number_x) + ' ,n_y =' + str(self.quantum_number_y) +' ,n_z =' + str(self.quantum_number_z)+ '$')
            axis = figure.add_subplot(111, projection='3d')
            img = axis.scatter(x_plot, y_plot, z_plot, c=colour_plot, cmap=plt.get_cmap('jet'))
            figure.colorbar(img)
            axis.set_xlabel(r'$x$')
            axis.set_ylabel(r'$y$')
            axis.set_zlabel(r'$|\psi(x, y)|^2$')
            axis.view_init(elev = 30, azim = -135)
            plt.show()
 
        def PDF(self):

            """Generating x-coordinates."""
            x = []
            for i in range((self.length_x)*self.scatter_density):
                u = i/self.scatter_density
                x.append(u)

            """Generating y-coordinates."""
            y = []
            for i in range((self.length_y)*self.scatter_density):
                u = i/self.scatter_density
                y.append(u)

            """Generating z-coordinates."""
            z = []
            for i in range((self.length_z)*self.scatter_density):
                u = i/self.scatter_density
                z.append(u)

            """Generating all possible xyz-coordinates."""
            space_coordinates = []
            counter = 0
            for i in x:
                for j in y:
                    for k in z:
                        coordinate = []
                        coordinate.append(i)
                        coordinate.append(j)
                        coordinate.append(k)
                        space_coordinates.append(coordinate)
                        counter = counter + 1

            """Generating colour-coordinates from xyz-coordinates."""
            for coordinate in space_coordinates:
                output = (2/(self.length_x*self.length_y*self.length_z))*pow(math.sin((math.pi*self.quantum_number_x*coordinate[0])/(self.length_x))*math.sin((math.pi*self.quantum_number_y*coordinate[1])/(self.length_y))*math.sin((math.pi*self.quantum_number_z*coordinate[2])/(self.length_z)),2)
                coordinate.append(output)

            """Formatting colour-xyz-coordinates."""
            x_plot = []
            y_plot = []
            z_plot = []
            colour_plot = []
            for coordinate in space_coordinates:
                x_plot.append(coordinate[0])
                y_plot.append(coordinate[1])
                z_plot.append(coordinate[2])
                colour_plot.append(coordinate[3])

            """Generating plot"""
            figure = plt.figure()
            axis = figure.add_subplot(111, projection='3d')
            img = axis.scatter(x_plot, y_plot, z_plot, c=colour_plot, cmap=plt.get_cmap('jet'))
            figure.colorbar(img)
            axis.set_xlabel(r'$x$')
            axis.set_ylabel(r'$y$')
            axis.set_zlabel(r'$z$')
            plt.title(r'$|\psi(x, y, z)|^{2} ( n_x =' + str(self.quantum_number_x) + ' ,n_y =' + str(self.quantum_number_y)+ ' ,n_z =' + str(self.quantum_number_z) +') $')
            axis.view_init(elev = 30, azim = -135)
            plt.show()
   
quantum_number_x_list = [1, 2, 3]
quantum_number_y_list = [1, 2, 3]
quantum_number_z_list = [1, 2, 3]

print("Enter the dimensions for the simulation: ")
dim=int(input())

#.............PROB. DENSITY FUNC. ....................
if dim == 1:
    for n in quantum_number_x_list:
        BOX=ParticleInABox().OneDimensional(length_x=1, quantum_number=n).PDF()
elif dim==2 :
    for nx in quantum_number_x_list:
        for ny in quantum_number_y_list:
            BOX=ParticleInABox().TwoDimensional(length_x=1, length_y=1, quantum_number_x=nx, quantum_number_y=ny).PDF()    
elif dim==3:
    for nx in quantum_number_x_list:
        for ny in quantum_number_y_list:
            for nz in quantum_number_z_list:
                BOX=ParticleInABox().ThreeDimensional(length_x=1, length_y=1, length_z=1, quantum_number_x=nx, quantum_number_y=ny, quantum_number_z=nz, scatter_density=10).PDF()    
   
   
 # ..............WAVEFUNCTION...................
if dim == 1:
    for n in quantum_number_x_list:
        BOX=ParticleInABox().OneDimensional(length_x=1, quantum_number=n).wavefunction()
elif dim==2 :
    for nx in quantum_number_x_list:
        for ny in quantum_number_y_list:
            BOX=ParticleInABox().TwoDimensional(length_x=1, length_y=1, quantum_number_x=nx, quantum_number_y=ny).wavefunction()    
elif dim==3:
    for nx in quantum_number_x_list:
        for ny in quantum_number_y_list:
            for nz in quantum_number_z_list:
                BOX=ParticleInABox().ThreeDimensional(length_x=1, length_y=1, length_z=1, quantum_number_x=nx, quantum_number_y=ny, quantum_number_z=nz, scatter_density=10).wavefunction()    
    