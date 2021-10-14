'''
Generate Electricity bill using simple gui
'''

from guietta import _, Gui, Quit

# Defining Gui for the program
gui = Gui (
    ["Enter the units of electricity consumed: ", '__units__'],
    [           ['Generate'],                            Quit],
    ["-----------------Bill-------------------",            _],
    ["No. of units consumed: ",              'units_consumed'],
    ["Base unit: ",                               'base_unit'],
    ["Base price: ",                             'base_price'],
    ["No. of units above base unit: ",          'extra_units'],
    ["Price per extra units: ",           'extra_units_price'],
    ["-------------------------------------------------",   _],
    ["Total amount to pay: ",                         'total']
)

# Function for the button generate
def calculate_bill(gui):
    if (int(gui.units) < 150):
        gui.unit_consumed = float(gui.units)
        gui.base_unit = 0.0
        gui.base_price = 3
        gui.extra_units = 0
        gui.extra_units_price = 0
        gui.total = float(gui.units) * float(gui.base_price)
    elif ((float(gui.units) > 151) & (float(gui.units) < 300)):
        gui.units_consumed = float(gui.units)
        gui.base_unit = 150
        gui.base_price = 100
        gui.extra_units = float(gui.units) - float(gui.base_unit)
        gui.extra_units_price = 3.75
        gui.total = (float(gui.base_price) + ((float(gui.extra_units) * 
        float(gui.extra_units_price))))
    elif ((float(gui.units) > 301) & (float(gui.units) < 451)):
        gui.units_consumed = float(gui.units)
        gui.base_unit = 300
        gui.base_price = 250
        gui.extra_units = float(gui.units) - float(gui.base_unit)
        gui.extra_units_price = 4
        gui.total = (float(gui.base_price) + ((float(gui.extra_units) * 
        float(gui.extra_units_price))))
    elif ((float(gui.units) > 450) & (float(gui.units) < 601)):
        gui.units_consumed = float(gui.units)
        gui.base_unit = 450
        gui.base_price = 300
        gui.extra_units = float(gui.units) - float(gui.base_unit)
        gui.extra_units_price = 4.25
        gui.total = (float(gui.base_price) + ((float(gui.extra_units) * 
        float(gui.extra_units_price))))
    else:
        gui.units_consumed = float(gui.units)
        gui.base_unit = 600
        gui.base_price = 400
        gui.extra_units = float(gui.units) - float(gui.base_unit)
        gui.extra_units_price = 5
        gui.total = (float(gui.base_price) + ((float(gui.extra_units) * 
        float(gui.extra_units_price))))

# Assigning function to the button
gui.Generate = calculate_bill

# Running the gui
gui.run()