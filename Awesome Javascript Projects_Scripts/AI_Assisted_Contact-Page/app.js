const command = new Array();
command[0] = "Here are few commands which you use";
command[1] = "1. 'Dark mode': To change into dark mode";
command[2] = "2. 'Light mode': To change into normal mode";
command[3] = "3. 'Pause video': To pause video";
command[4] = "4. 'Play video': To play video";
command[5] = "5. 'Ex: `Write username Shubham Jain`': To fill name feild";
command[6] = "6. 'Ex: `Write email test@gmail.com`': To fill email feild";
command[7] = "7. 'Ex: `Write mobile number 23456789`': To fill number feild";
command[8] = "8. 'Ex: `Write message hello world`': To fill message feild";
command[9] = "9. 'Clear form': To clear your all details";
command[10] = "10. 'Submit form': To submit your all details to us";
command[11] = "Must say write username,email,etc. with 5,6,7,8 commands";

alert(command.join("\n"));

if (annyang) {
  var commands = {
    "play video": function () {
      document.getElementById("myVideo").play();
    },
    "pause video": function () {
      document.getElementById("myVideo").pause();
    },
    "dark mode": function () {
      const root = document.documentElement;
      root.style.setProperty("--white", "#000");
      root.style.setProperty("--black", "#fff");
      root.style.setProperty("--input-color", "#fff");
    },
    "light mode": function () {
      const root = document.documentElement;
      root.style.setProperty("--white", "#fff");
      root.style.setProperty("--black", "#000");
      root.style.setProperty("--input-color", "rgba(230, 230, 230, 0.692)");
    },
    "write username *tag": function (variable) {
      var username = document.getElementById("username");
      username.value = variable;
    },
    "write email *tag": function (variable) {
      var email = document.getElementById("emailadd");
      email.value = variable.split(" ").join("");
    },
    "write mobile number *tag": function (variable) {
      var phone = document.getElementById("telnum");
      phone.value = variable;
    },
    "write message *tag": function (variable) {
      var msg = document.getElementById("mymessage");
      msg.value = variable;
    },
    "clear form": function () {
      document.getElementById("myform").reset();
    },
    "submit form": function (e) {
      let myform = document.getElementById("myform");
      let formareainner = document.querySelector(".form-area-inner");
      let formareaouter = document.querySelector(".form-area-outer");
      let formheading = document.querySelector(".form-area-inner h2");
      myform.remove();
      formheading.innerHTML = "Your Form is successfully submitted";
      let html = "";
      html += `<p>Thanks for submitting your query. We will shortly contact you.</p>
                             <button type="submit" id="btn"><a href="/">Go Back</a></button>`;
      formareainner.innerHTML += html;
      formareaouter.style.width = "33%";
      formareaouter.style.height = "23%";
      formareaouter.style.top = "340px";
    },
  };

  annyang.addCommands(commands);

  annyang.start();
}
