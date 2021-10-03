// const express = require("express");
// const { request } = require("http");
// const https = require("https");
// const { stringify } = require("querystring");
// const client = require("@mailchimp/mailchimp_marketing");

// const app = express();

// app.use(express.static("public"));
// app.use(express.urlencoded({ extended: true }));

// app.get("/", function (req, res) {
//   res.sendFile(__dirname + "/signUp.html");
// });

// client.setConfig({
//   apiKey: "8c2d0c5023c1e06b704a14118620b0fb-us5",
//   server: "us5",
// });

// app.post("/", function (req, res) {
//   var firstName = req.body.fName;
//   var lastName = req.body.lName;
//   var email = req.body.email;

//   const listId = "719916b5c2";

//   // const run = async () =>{
//     async function run() {
//     try {
//       const response = await mailchimp.lists.addListMember(listId, {
//             members: [{
//               email_address: email,
//               status: "subscribed",
//               merge_fields: {
//                   FNAME: firstName,
//                   LNAME: lastName
//               }
//             }],
//       })
//       console.log(response);
//       res.sendFile(__dirname + "/success.html");

//     } catch (error) {
//       res.sendFile(__dirname + "/failure.html");
//     }
//   };

//   run();
// });


// app.post("/failure",function(req,res){
//     res.redirect("/");
// })

// app.listen(process.env.PORT||3000, function () {
//   console.log("Server is running on Port 3000");
// });

// //API Key
// // 8c2d0c5023c1e06b704a14118620b0fb-us5

// //List Id
// // 719916b5c2


const express = require("express");
const request = require("request");
const mailchimp = require("@mailchimp/mailchimp_marketing");
const md5 = require("md5");
 
const app = express();
app.use(express.static(__dirname + '/public'));
app.use(express.urlencoded({extended: true}));
 
 
 
app.get("/", function(rec,res){
 
  res.sendFile(__dirname + "/signUp.html");
 
});
 
app.post("/", function(rec, res) {
 
  var Fname = rec.body.fName;
  var Lname = rec.body.lName;
  var Email = rec.body.email;
 
  mailchimp.setConfig({
    apiKey: "8c2d0c5023c1e06b704a14118620b0fb-us5",
    server: "us5"
  });
 
  const listId = "719916b5c2";
  const subscribingUser = {
    firstName: Fname,
    lastName: Lname,
    email: Email
  };
 
  async function run() {
 
    const subscriberHash = md5(Email.toLowerCase());
 
    // chicking first if the email is already subscribed if not add it
    try {
      const response = await mailchimp.lists.getListMember(listId, subscriberHash);
 
      console.log(`This user's subscription status is ${response.status}.`);
 
      if (response.status == "subscribed") {
        res.send("The contact is already subscribed ");
      } else if (response.status == "unsubscribed") {
        //
      } else if (response.status == "pending") {
        //
      } else if (response.status == "cleaned") {
        //
      }
 
    } catch (e) {
 
      if (e.status === 404) {
        const response1 = await mailchimp.lists.addListMember(listId, {
          email_address: subscribingUser.email,
          status: "subscribed",
 
          merge_fields: {
            FNAME: subscribingUser.firstName,
            LNAME: subscribingUser.lastName
          }
 
        });
 
        res.sendFile(__dirname + "/success.html");
 
      } else {
        // specify any failure by e.status number
        // or just
        console.error(`CATCH error STATUS`, e.status);
        res.sendFile(__dirname + "/failure.html");
      }
    }
  }
 
  run();
 
});
 
app.post("/failure", function(rec,res){
  res.redirect("/");
});
 
app.listen(3000, function(){
  console.log("server is running on port 3000.");
})