/* const arr[]= {} this is invalid in javascript*/
const arr = [
    "Lorem ipsum dolor sit amet consectetur adipisicing elit. Autem, exercitationem commodi facere eligendi voluptate deleniti voluptatum ipsam! Sapiente, officiis impedit?"
    ,"asdf jkl; asdf jkl; fkdl a;ls dkls skld qwer poiu mjkl sjld kmdj iwpo jmco lmhj skod mcks",
    "ankush jaison manav krishna kareena kashish kuber himanshoo jaini shubham raj saurabh riya"
    ];

const msg = document.querySelector("#msg");
const words = document.querySelector("#words");
const btn = document.querySelector("#btn");
let random_number;
let start,end;
const counter = (str)=>{
    let r =  str.split(" ").length;
    return r;
}
const playGame = () =>{
    let RandomNumber = Math.floor(Math.random()*arr.length);
    random_number = RandomNumber;
    msg.innerText = arr[RandomNumber];
    let date = new Date();
    start = date.getTime();
    btn.innerText = "EndGame";
}
const endGame = () =>{
    let date = new Date();
    end = date.getTime();
    let total = ((end-start)/1000)/60;
    let words_counter = counter(msg.innerText);
    console.log(words_counter);
    let speed =Math.round(words_counter/total);
    /* total error done during typing */
    /*get value of textarea as a string and convert that string in array,
    we will iterate over the array and will check that how many array elements 
    are present in arr[random_number] also convert arr[random_number] in an array so
    that we can get the number of words in a particular string
    correct = counter
    wrong = total_words-counter
    */
    let correct = 0;
    let string = words.value;//text area string 
    let correct_string = arr[random_number]; //existing real string
    let correct_string_arr = correct_string.split(" ");
    let user_array_of_strings = string.split(" "); //text area string to array
    for(let i =0;i<user_array_of_strings.length;i++){
        if(correct_string.includes(user_array_of_strings[i])){
            correct++;
        }
    }

    let stopped;
    if(user_array_of_strings.length === correct_string_arr.length){
        stopped = "You have Completed the task!";
    }else{
        stopped = "You have stopped in between!";
    }
    let final = "Your speed is "+speed+" wpm | You have done "+(user_array_of_strings.length-correct)+" errors. | "+stopped;
    msg.innerText = final;
    btn.innerText="Start";
}
btn.addEventListener("click",function(){
    if(this.innerText=="Start"){
        words.value="";
        words.disabled = false;
        words.setAttribute("placeholder","Start typing...");
        playGame();
    }else{
        endGame();
    }
});