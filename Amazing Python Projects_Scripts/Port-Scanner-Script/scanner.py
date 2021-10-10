#!/bin/python

import sys #Allow us to enter command line arguments, amoung other things
import socket
from datetime import datetime

#Define Our Target
if len(sys.argv) == 2:
	target = socket.gethostbyname(sys.argv[1])  #Translate host name to IPV4
else:
	print("Invalid amount of arguments.")
	print("Syntax:python3 scanner.py <ip>")
	sys.exit()
	
#Add pretty banner
print("-" * 50)
print("Scanning Target "+target)
print("Time Started: "+str(datetime.now()))
print("-" *50)

try:
	for port in range(50,85):
		#Setup connection vaiables
		s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  #AF_INET is IPV4 and SOCK_STREAM is port
		socket.setdefaulttimeout(1)  # This is Float
		result = s.connect_ex((target,port))  #returns error indicators
		print("Checking port {}".format(port))
		if result == 0:
			print("Port {} is open".format(port))
		s.close()
			
except KeyboardInterrupt:
	print("\nExiting program.")
	sys.exit()
	
except socket.gaierror:  #If We cannot connect to the hostname
	print("Hostname could nor resolved.")
	sys.exit()
	
except socket.error:    #If server is down or anything is worng
	print("Could'nt connect to the server.")
	sys.exit()
	


