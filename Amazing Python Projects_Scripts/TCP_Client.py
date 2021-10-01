import socket
target_host = "0.0.0.0"
target_port = 8888
# 1. Create a Socket Object
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# 2. Connect the Client
client.connect((target_host,target_port))
# 3. NOw it's time to send some data
client.send("GET / HTTP/1.1\r\nHost: google.com\r\n\r\n")
# 4. Time to recieve the data
response = client.recv(4096)
print response


###########  OUTPUT ###########
#HTTP/1.1 301 Moved Permanently
#Location: http://www.google.com/
#Content-Type: text/html; charset=UTF-8
#Date: Mon, 11 Jan 2021 11:09:14 GMT
#Expires: Wed, 10 Feb 2021 11:09:14 GMT
#Cache-Control: public, max-age=2592000
#Server: gws
#Content-Length: 219
#X-XSS-Protection: 0
#X-Frame-Options: SAMEORIGIN

##<HTML><HEAD><meta http-equiv="content-type" content="text/html;charset=utf-8">
#<TITLE>301 Moved</TITLE></HEAD><BODY>
#<H1>301 Moved</H1>
#The document has moved
#<A HREF="http://www.google.com/">here</A>.
#</BODY></HTML>