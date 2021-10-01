import socket
import threading

bind_ip = "0.0.0.0"
bind_port = 8888

server=socket.socket(socket.AF_INET,socket.SOCK_STREAM)

server.bind((bind_ip,bind_port))
server.listen(5)
print "[*] Listening on %s:%d" %(bind_ip,bind_port)

#This is our Client-Handling Thread
def handle_client(client_socket):
    #print out the Data Sent by Client
    request = client_socket.recv(1024)
    print "[*] Received: %s" %request

    #Send Back a Data
    client_socket.send("ACK!")
    client_socket.close()

while True:
    client,addr = server.accept()
    print"[*] Connection Accepted From: %s:%d" %(addr[0],addr[1])
    #Spin up our Client Thread to Handle the incomeing Data
    client_handler = threading.Thread(target=handle_client,args=(client,))
    client_handler.start()