const button = document.querySelector('.btn');
const input = document.querySelector('.input');
const msg = document.querySelector('.msg');
var random;
const arr = [
    "hph","pcp","vaja","ytnhop","iwfts","ritpjvsaac","seypctprit","droidan",
    "utterfl","chefcode"
];
const ans = {
    hph:"php",
    pcp:"cpp",
    vaja:"java",
    ytnhop:"python",
    iwfts:"swift",
    ritpjvsaac:"javascript",
    seypctprit:"typescript",
    droidan:"android",
    utterfl:"flutter",
    chefcode:"codechef"
}
button.addEventListener("click",function(){ 
    //generating a random number 
    if(input.classList[1]=="hidden"||button.innerHTML=="SKIP"){
        if(input.value!=""){
            if(ans[arr[random]]==input_text){
                input.classList.add('hidden');//removing the hidden class from input
                msg.innerHTML ="Correct ! boss"; 
                button.innerHTML="Continue";
                input.value = "";
            }else{
                input.classList.add('hidden');//removing the hidden class from input
                msg.innerHTML ="Wrong ! boss"; 
                button.innerHTML="Continue";
                input.value = "";
            }
        }else{
            random = Math.floor((Math.random()*arr.length));
            input.classList.remove('hidden');//removing the hidden class from input
            msg.innerHTML ="Guess the word : "+arr[random]; 
            button.innerHTML="Guess"
            input.value="";
        }
    }else{
        const input_text = input.value.trim();
        console.log(input_text);//java
        console.log(ans[arr[random]]);//typescrit
        if(input_text==""&&button.innerHTML!="continue"){
            msg.innerHTML ="Wanna try once more or SKIP : "+arr[random]; 
            button.innerHTML="SKIP";
        }else if(input_text!=""){
            if(ans[arr[random]]==input_text){
                input.classList.add('hidden');//removing the hidden class from input
                msg.innerHTML ="Correct ! boss"; 
                button.innerHTML="Continue";
                input.value = "";
            }else{
                input.classList.add('hidden');//removing the hidden class from input
                msg.innerHTML ="Wrong ! boss"; 
                button.innerHTML="Continue";
                input.value = "";
            }
        }
    }
});