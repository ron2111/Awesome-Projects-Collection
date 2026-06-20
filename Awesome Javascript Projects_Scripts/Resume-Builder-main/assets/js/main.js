const resetBtn = document.getElementById("reset");

function addWxp() {
  let newNode = document.createElement("input");
  newNode.classList.add("form-control", "language", "mt-2");
  newNode.setAttribute("placeholder","Language");

  let weOb = document.getElementById("we");
  let weAddBtnOb = document.getElementById("wAddBtn");
  weOb.insertBefore(newNode, weAddBtnOb);
}


resetBtn.addEventListener("click", () => {
  document.getElementById("myForm1").reset();
  document.getElementById("myForm2").reset();
});
//generating CV

function generateCv() {
  //input value
  const nameField = document.getElementById("namefield").value;
  const ageField = document.getElementById("agefield").value;
  const genderField = document.getElementById("genderfield").value;
  const contactField = document.getElementById("contact").value;
  const addressField = document.getElementById("address").value;
  const emailField = document.getElementById("email").value;
  const faceField = document.getElementById("facebook").value;
  const instaField = document.getElementById("insta").value;
  const linkedField = document.getElementById("linkedin").value;
  const jobField = document.getElementById("jobfield").value;
  const objField = document.getElementById("objective").value;
  const skill1 = document.getElementById("skillfield1").value;
  const skill2 = document.getElementById("skillfield2").value;
  const skill3 = document.getElementById("skillfield3").value;
  const skill4 = document.getElementById("skillfield4").value;



  const range1 = document.getElementById("range1").value;
  const range2 = document.getElementById("range2").value;
  const range3 = document.getElementById("range3").value;
  const range4 = document.getElementById("range4").value;

  //assingin value
  document.getElementById("Tname1").innerHTML = nameField;
  // document.getElementById("Tname2").innerHTML = nameField;
  // document.getElementById("Tage").innerHTML = "Age: " + ageField;
  // document.getElementById("Tgender").innerHTML = "Gender: " + genderField;
  document.getElementById("Tcontact").innerHTML = contactField;
  document.getElementById("Taddress").innerHTML = addressField;
  document.getElementById("Temail").innerHTML = emailField;
  document.getElementById("hrefFb").href = faceField;
  document.getElementById("hrefinsta").href = instaField;
  document.getElementById("hrefLin").href = linkedField;
  // document.getElementById("Tfb").innerHTML = faceField;
  // document.getElementById("Tinsta").innerHTML = instaField;
  // document.getElementById("Tlinked").innerHTML = linkedField;
  document.getElementById("Tjob").innerHTML = jobField;
  document.getElementById("Tobjectives").innerHTML = objField;

  document.getElementById("skillname1").innerHTML = skill1;
  document.getElementById("skillname2").innerHTML = skill2;
  document.getElementById("skillname3").innerHTML = skill3;
  document.getElementById("skillname4").innerHTML = skill4;

 // document.getElementById("experience_description").innerHTML = workExp;
  document.getElementById("Progress1").style.width = range1 + "%";
  document.getElementById("Progress2").style.width = range2 + "%";
  document.getElementById("Progress3").style.width = range3 + "%";
  document.getElementById("Progress4").style.width = range4 + "%";
  document.getElementById("progress1").value = range1;
  document.getElementById("progress2").value = range2;
  document.getElementById("progress3").value = range3;
  document.getElementById("progress4").value = range4;



  
// 1
  const courseinput1 = document.getElementById("course1").value;
  document.getElementById("coursename1").innerHTML = courseinput1;
  const universityinput1 = document.getElementById("university1").value;
  document.getElementById("uniName1").innerHTML = universityinput1;
  const yearsinput1 = document.getElementById("years1").value;
  document.getElementById("Eyear1").innerHTML = yearsinput1;
  // 2
  const courseinput2 = document.getElementById("course2").value;
  document.getElementById("coursename2").innerHTML = courseinput2;
  const universityinput2 = document.getElementById("university2").value;
  document.getElementById("uniName2").innerHTML = universityinput2;
  const yearsinput2 = document.getElementById("years2").value;
  document.getElementById("Eyear2").innerHTML = yearsinput2;
  // 3
  const courseinput3 = document.getElementById("course3").value;
  document.getElementById("coursename3").innerHTML = courseinput3;
  const universityinput3 = document.getElementById("university3").value;
  document.getElementById("uniName3").innerHTML = universityinput3;
  const yearsinput3 = document.getElementById("years3").value;
  document.getElementById("Eyear3").innerHTML = yearsinput3;
  

  // exprerince 1
  const jobinput1 = document.getElementById("job1").value;
  document.getElementById("exp_title1").innerHTML = jobinput1;
  const companyinput1 = document.getElementById("company1").value;
  document.getElementById("exp_comp1").innerHTML = companyinput1;
  const yearinput1 = document.getElementById("year1").value;
  document.getElementById("exp_year1").innerHTML = yearinput1;
  const descinput1 = document.getElementById("workExp1").value;
  document.getElementById("exp_desc1").innerHTML = descinput1;

 // exprerince 2
 const jobinput2 = document.getElementById("job2").value;
 document.getElementById("exp_title2").innerHTML = jobinput2;
 const companyinput2 = document.getElementById("company2").value;
 document.getElementById("exp_comp2").innerHTML = companyinput2;
 const yearinput2 = document.getElementById("year2").value;
 document.getElementById("exp_year2").innerHTML = yearinput2;
 const descinput2 = document.getElementById("workExp2").value;
 document.getElementById("exp_desc2").innerHTML = descinput2;
 
 // exprerince 3
 const jobinput3 = document.getElementById("job3").value;
 document.getElementById("exp_title3").innerHTML = jobinput3;
 const companyinput3 = document.getElementById("company3").value;
 document.getElementById("exp_comp3").innerHTML = companyinput3;
 const yearinput3 = document.getElementById("year3").value;
 document.getElementById("exp_year3").innerHTML = yearinput3;
 const descinput3 = document.getElementById("workExp3").value;
 document.getElementById("exp_desc3").innerHTML = descinput3;
 
  //certificate
  const certinput1 = document.getElementById("cert_name1").value;
  document.getElementById("cert_title1").innerHTML = certinput1;
  const certinput2 = document.getElementById("cert_name2").value;
  document.getElementById("cert_title2").innerHTML = certinput2;
  const certinput3 = document.getElementById("cert_from1").value;
  document.getElementById("cert_desc1").innerHTML = "~ " + certinput3;
  const certinput4 = document.getElementById("cert_from2").value;
  document.getElementById("cert_desc2").innerHTML = "~ " + certinput4;

  // language
  const langInput = document.getElementsByClassName("language");
  console.log(langInput);
  let str = "";

  for (let e of langInput) {
    
    str = str + `<li class="languages_name">
    <span class="languages_circle"></span>${e.value}
  </li>`;
  }
  document.getElementById("langItem").innerHTML = str;

  document.getElementById("cv-form").style.display = "none";
  document.getElementById("cv-template").style.display = "block";

  //image setting
  let file = document.getElementById("imgField").files[0];
  let reader = new FileReader();
  reader.readAsDataURL(file);
  reader.onloadend = function () {
    document.getElementById("imgTemplate").src = reader.result;
  };
}

function EditForm() {
  document.getElementById("cv-form").style.display = "block";
  document.getElementById("cv-template").style.display = "none";
}

// sync function call
// setInterval(function () {
//   generateCv();
// }, 100);

function autoFill() {
  document.getElementById("namefield").value = "KYLE RYAN";
  document.getElementById("agefield").value = "35";
  document.getElementById("contact").value = "+91-987654321";
  document.getElementById("address").value = "Street 19 florida USA";
  document.getElementById("email").value = "kyleryan@email.com";
  document.getElementById("facebook").value = "@kyleRyan";
  document.getElementById("insta").value = "@kyleRyan";
  document.getElementById("linkedin").value = "@kyleRyan";
  document.getElementById("jobfield").value = "Web Design";
  document.getElementById("objective").value =
    "Versatile Front-end Developer with 3+ years of experience designing, developing, and managing complex e-commerce sites and internal frameworks. Specializes in AngularJS and responsive design";
  document.getElementById("course1").value =
    "Bachelor of Computer Science";
  document.getElementById("university1").value =
    "Deccan Education Society";
  document.getElementById("years1").value =
    "2015 - 2018";
  document.getElementById("skillfield1").value = "HTML";
  document.getElementById("skillfield2").value = "CSS";
  document.getElementById("skillfield3").value = "JAVASCRIPT";
  document.getElementById("skillfield4").value = "PHP";

  document.getElementById("workExp1").value =
  "Develop new UI functionality for multithreaded user-facing applications running on touchscreen devices, using AngularJS";
  document.getElementById("job1").value =
  "MOBILE APPLICATION DEVELOPER";
  document.getElementById("company1").value =
  "Tech Soft";
  document.getElementById("year1").value =
  "2013-2015";
  document.getElementById("cert_name1").value =
  "Certified for compliance in the work area (2012)";
  document.getElementById("cert_from1").value =
  "FreeCodeCamp.com";
  document.getElementById("cert_name2").value =
  "Certificate of attendance on computer technology";
  document.getElementById("cert_from2").value =
  "Udemy.com";
  document.getElementById("lang").value =
  "Arabic";
  
}

/*==================== REDUCE THE SIZE AND PRINT ON AN A4 SHEET ====================*/
function scaleCv() {
  document.body.classList.add("scale-cv");
}
/*==================== REMOVE THE SIZE WHEN THE CV IS DOWNLOADED ====================*/
function removeScale() {
  document.body.classList.remove("scale-cv");
}
/*==================== GENERATE PDF ====================*/
// PDF generated area
let areaCv = document.getElementById("cv-template");
let resumeButton = document.getElementById("resume-button");

// Html2pdf options
let opt = {
  margin: 0,
  filename: "myResume.pdf",
  image: { type: "jpeg", quality: 0.98 },
  html2canvas: { scale: 2 },
  jsPDF: { format: "a4", orientation: "portrait" },
};
// Function to call areaCv and Html2Pdf options
function generateResume() {

  html2pdf(areaCv, opt);
}
// When the button is clicked, it executes the three functions
resumeButton.addEventListener("click", () => {
  // 1. The class .scale-cv is added to the body, where it reduces the size of the elements
  //scaleCv();

  // 2. The PDF is generated
  generateResume();

  // 3. The .scale-cv class is removed from the body after 5 seconds to return to normal size.
  setTimeout(removeScale, 5000);
});




function form2(){
  var edu_item2 =  document.getElementById("edu-item2")
  
 var checkBox2 = document.getElementById("chck_form2")
 var checkBox3 = document.getElementById("chck_form3")
 var form2 = document.getElementById("edu-form2")
  if (checkBox2.checked == true){
    form2.classList.remove("hide")
    checkBox3.classList.remove("hide")
    edu_item2.classList.remove("hide")
   
  } else {
    form2.classList.add("hide")
    checkBox3.classList.add("hide")
    edu_item2.classList.add("hide")
  }
}
function form3(){

  var checkBox3 = document.getElementById("check_form3")
  var form3 = document.getElementById("edu-form3")
  var edu_item3 = document.getElementById("edu-item3")
   if (checkBox3.checked == true){
     form3.classList.remove("hide")
     edu_item3.classList.remove("hide")
   } else {
     form3.classList.add("hide")
     edu_item3.classList.add("hide")
   }
 }

 function exp2(){
  var edu_item2 =  document.getElementById("exp-item2")
  
 var checkBox2 = document.getElementById("chck_exp2")
 var checkBox3 = document.getElementById("chck_exp3")
 var form2 = document.getElementById("exp-form2")
  if (checkBox2.checked == true){
    form2.classList.remove("hide")
    checkBox3.classList.remove("hide")
    edu_item2.classList.remove("hide")
   
  } else {
    form2.classList.add("hide")
    checkBox3.classList.add("hide")
    edu_item2.classList.add("hide")
  }
}
function exp3(){

  var checkBox3 = document.getElementById("check_exp3")
  var form3 = document.getElementById("exp-form3")
  var edu_item3 = document.getElementById("exp-item3")
   if (checkBox3.checked == true){
     form3.classList.remove("hide")
     edu_item3.classList.remove("hide")
   } else {
     form3.classList.add("hide")
     edu_item3.classList.add("hide")
   }
 }