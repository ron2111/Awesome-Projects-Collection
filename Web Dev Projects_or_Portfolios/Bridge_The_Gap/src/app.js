require('dotenv').config();
const express=require("express");
const app=express();
const ejs=require('ejs');
app.set('view engine','ejs');
require("./db/conn");
const mongoose= require("mongoose");
const multer = require('multer');
const bodyParser = require("body-parser");

const startupRegister=require("./models/startupRegisters");
const investorRegister=require("./models/investorRegisters");

const bcrypt=require("bcryptjs");
const { start } = require('repl');
const port=process.env.PORT || 3000;
path=require('path')
app.use(express.static(path.join(__dirname,'../')+'public'));
app.use(express.urlencoded({extended:false}))

app.get("/",(req,res)=>{
    res.render("home");
})

app.listen(port,()=>{
    console.log(path.join(__dirname,'../'));
})


app.get("/login",(req,res)=>{
    res.render("login");
})

app.get("/option",(req,res)=>{
    res.render("option");
})
app.get("/startup_form_main",(req,res)=>{
    res.render("startup_form_main");
})
app.get("/investor_form",(req,res)=>{
    res.render("investor_form_main");
})

app.get("/registerStartup",(req,res)=>{
    res.send("HI");
})

app.get("/registerInvestor",(req,res)=>{
    res.send("HI");
})

app.get("/startupFeed", (req,res) =>{
    
    startupRegister.find({},function(err,feed){
        console.log(feed);
        res.render('feed_new',{
            feedList:feed
        })
    })

    // startupRegister.find({amount:2000000},function(err,feed){
    //     res.render('bs4_profile_with_feed_item',{
            
    //     })
    // })

    
})

var storage = multer.diskStorage({
    destination:function(req,file,cb){
        cb(null,'public/uploads')
    },
    filename:function(req,file,cb){
        cb(null,file.fieldname + '-' + Date.now() + path.extname(file.originalname));
    }
})

var upload = multer({
    storage:storage
})



app.post("/registerStartup",upload.single('file'),async(req,res)=>{
    try{

        const file = req.file;

    if(!file){
        const error = new Error('Upload File');
        error.httpStatusCode = 400;
        return next(error);
    }

    else{
        const password=req.body.password;
        const cpassword=req.body.confirmPassword;

        console.log(req.body.sstage);

        if(password===cpassword){
            const regStartup= new startupRegister({
                noOfFounders: req.body.founders,
                name: req.body.name,
                email: req.body.email,
                phone:req.body.phone,
                linkedIn:req.body.lurl,
                startupName:req.body.fname,
                startupStage:req.body.sstage,
                websiteAddress:req.body.website,
                startupDomain:req.body.domain,
                foundedIn:req.body.date,
                location:req.body.location,
                startupBusiness:req.body.btype,
                productSummary:req.body.productSumm,
                twitterPitch:req.body.twitter,
                teamSummary:req.body.team,
                difference:req.body.diff,
                cloud:req.body.cloudPlatform,
                amount:req.body.amountt,
                password:password,
                confirmPassword:cpassword

            }) 
            const token=await regStartup.generateAuthToken();

            const registered= await regStartup.save();
            
            
            res.redirect("/login");
        }else{
            res.send("Passwords do not match");
        }
    }
        
    }
    catch(error){
        res.status(400).send(error);
        console.log(error);
    }
})


app.post("/registerInvestor",async(req,res)=>{
    try{
        const password=req.body.password;
        const cpassword=req.body.confirmPassword;

        if(password===cpassword){
            const regInvestor= new investorRegister({
                
                name: req.body.name,
                email: req.body.email,
                phone:req.body.phone,
                linkedIn:req.body.lurl,
                location:req.body.location,
                budget:req.body.budget,
                password:password,
                confirmPassword:cpassword

            }) 
            const token=await regInvestor.generateAuthToken();

            const registered= await regInvestor.save();
            
            res.redirect("/login");

        }else{
            res.send("Passwords do not match");
        }
    }
    catch(error){
        res.status(400).send(error);
        console.log(error);
    }
})




app.get("/loginBoth",(req,res)=>{
    res.send("Hey");
})




app.get("/startupFeed/startupDetails", (req,res) =>{
    const i=req.query.index;
    startupRegister.find({},function(err,feed){
        console.log(feed);
        res.render('profile_with_data_and_skills',{
            feedList:feed[i]
        })
    })
})

app.post("/loginBoth",async(req,res)=>{
    try {
        const email=req.body.Email;
        const password=req.body.Password;


        userEmail= await startupRegister.findOne({email:email});

        if(userEmail==null){
            userEmail= await investorRegister.findOne({email:email});
            console.log("HEREE");
        }

        const isMatch=await bcrypt.compare(password,userEmail.password);
        const token=await userEmail.generateAuthToken();

        if(isMatch){
            // res.status(201).send("Matched");
            // console.log(startupRegister.find({},{email:1}));
            // res.sendFile(path.join(__dirname,'../')+'bs4_profile_with_feed_item.html');
            // let name="FromDB";
            // res.render('bs4_profile_with_feed_item',{
            //    userEmail:name     
            // });
            res.redirect('/startupFeed');
        }
        else { 

            // const userEmail= await investorRegister.findOne({email:email});

            // const isMatch=await bcrypt.compare(password,userEmail.password);
            // const token=await userEmail.generateAuthToken();

            // if(isMatch){
            //     res.redirect('/startupFeed');
            // }
            // else{
            //     res.send("Email or password not matching");
            // }

            res.send("Email or password not matching");
        }
    } catch (error) {
        res.status(400).send(error);
        console.log(error);
        
    }

})