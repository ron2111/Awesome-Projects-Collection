var quotes=["\"God lives in the house where elders are respected.\"","\"All's well that ends well.\"","\"A life enjoyed is a life lived.\"","\"Nothing changes if nothing changes.\""];
window.onload=function MyFunction(){
    var x=Math.floor(Math.random()*4);
    var quote=quotes[x];
    var para=document.querySelector('p');
    para.textContent=quote;
}
