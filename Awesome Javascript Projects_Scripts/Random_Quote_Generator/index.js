//modules
const fs = require('fs');
const http = require('http');
//--------------------------------
const html = fs.readFileSync("index.html","utf-8");
const server = http.createServer((req,res)=>{
    res.end(html);
});
server.listen(8000,"127.0.0.1",()=>{
    console.log("Working fine");
});
