var translateButton = document.querySelector("#translate-button");
var translateInput = document.querySelector("#translate-input");
var translateOutput = document.querySelector("#translate-output");
translateButton.addEventListener("click", buttonClickHandler)

var serverurl = "https://api.funtranslations.com/translate/minion.json"

function getTranslationURL(input){
    return serverurl+"?"+"text="+input
}

function errorHandler(error){
    console.log("Error Occured!");
    alert("Something Went Wrong! Please Try Again after sometime.")
}

function buttonClickHandler(){
    var inputText = translateInput.value;
    fetch(getTranslationURL(inputText))
    .then(Response => Response.json())
    .then(json =>{
        var translatedText = json.contents.translated;
        translateOutput.innerText = translatedText;
    })
    .catch(errorHandler)
};