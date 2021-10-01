# Live-Group-Chat
This is a group chat application which uses web-socket. made with nodejs and socket.io.

## Installation

Install my-project with npm
requires nodejs, npm, socket.io

```bash
  git clone https://github.com/nishith-p-shetty/Live-Group-Chat.git
  cd Live-Group-Chat
  npm install
```
* Then edit the links present in [index.html, static/js/client.js, server/index.js] from localhost to your required domain
* It runs on port 80, and websocket connection runs on port 8000
* if u want to change the port please update it in the [index.html, static/js/client.js, server/index.js] 3 files or elese it will show CORS error

## Deployment

To deploy this project run
* put the cloned folder into your webserver root folder and host it.

```bash
  cd Live-Group-Chat/server
  npm index.js
```
## Note
* To change the websocket port, change the port in index.html on line 13, line 1 on static/js/client.js, line 2 on server/index.js from 8000 to your port
* To change HTTP port, add your port in server/index.js on line 4
  