let day,d,m,y;
day=new Date();
d=day.getDate();
m=day.getMonth()+1;
y=day.getFullYear();
day=`${d}-${m}-${y}`;
let response=[]; 
async function getslots(pincode) {

    try {
      let result = await fetch(`https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=${pincode}&date=${day}`);
      let data = await result.json();
      if(data.error=="Invalid Pincode"){
          alert("No Data Found. Enter Valid Pincode.");
      }
    
      if(data.sessions !== []){
        data.sessions.map((e, i) => {
          let centerInfo = [
            e.block_name,
            e.address,
            e.vaccine,
            e.date,
            e.min_age_limit,    
            e.available_capacity,
            e.available_capacity_dose1,
            e.available_capacity_dose2,
            e.slots,
          ];
          response.push(centerInfo);
          let code = `
      <div class="container">
      <h3>
      <span>Block Name : </span>
      ${response[i][0]}
    </h3>
    <div>
    <h3>
    <span>Center Address : </span>
    ${response[i][1]}
  </h3>
  <h3>
    <span>Vaccine Name : </span>
    ${response[i][2]}
  </h3>
  <h3>
    <span>Date : </span>
    ${response[i][3]}
  </h3>
  <h3>
    <span>Minimum Age Limit :</span>
    ${response[i][4]}
  </h3>
  
  <h3>
    <span>Total Available Capacity :</span>
    ${response[i][5]}
  </h3>
  <h3>
    <span>Available Capacity 1st Dose :</span>
    ${response[i][6]}
  </h3>
  <h3>
    <span>Available Capacity 2nd Dose:</span>
    ${response[i][7]}
  </h3>
  
  <h3>
    <span>Slots Available : </span>
     ${response[i][8].join(" | ")}
  </h3>
    </div>
`;
          response_.innerHTML += code;
        });
        if(data.sessions.length === 0){
          alert("No Vaccinations Available")
        }
        response = []
      } 


     else{
        alert("Some error occured")
    }

    }
     
      

 catch(err) {
      alert("No Data Found");
    }
}  

  const input=document.getElementById("pincode");
  input.addEventListener("keypress", (res) => {
    if (res.which === 13) {
        let pincode = input.value;

        response_.innerHTML="";
        if (pincode === "") {
            alert("Enter pincode in the search box")
        } else if (pincode !== "") {
            getslots(pincode);
        }
     }});


    btn.addEventListener("click",function(){
    let pincode=input.value;

    response_.innerHTML="";

    if (pincode === "") {
        alert("Enter pincode in the search box")
    } else if (pincode !== "") {
        getslots(pincode)
    }
   }); 
  