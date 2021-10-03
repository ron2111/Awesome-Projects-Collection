MidpointCircle.java is the java applet for drawing circles using midpoint algorithm. Zoom in&out is done using mouse wheel. 

*** Important thing to remeber - Applets are depricated after java 8, so to run applets you need to install java 8

** How to run the program - 
        1. Go to the folder where you put this program
        2. open cmd there (OR you can open cmd and navigate to the above mentioned folder)
        3. run this 2 lines -   a. "javac MidpointCircle.java"
                                b. "appletviewer MidpointCircle.java"

** How to add new circle - 
        In the 'public void paint' function set the color of the circle(optional) e.g. - "g.setColor(Color.black);", then call function 'midpointCircle' with 4 params e.g/ - "midpointCircle(g, centerX, centerY, radius)"