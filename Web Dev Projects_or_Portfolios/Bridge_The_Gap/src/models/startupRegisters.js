const mongoose=require("mongoose");
const bcrypt=require("bcryptjs");
const jwt=require("jsonwebtoken");
const express=require("express");

const app=express();

const startupSchema= new mongoose.Schema({
    noOfFounders:{
        type: Number,
            },
    name:{
        type: String,
            },
    email:{
        type: String,
        
        
    },
    password:{
        type: String,
            },
    confirmPassword:{
        type: String,
            },

    phone:{
        type: Number,
            },
    linkedIn:{
        type: String,
            },
    startupName:{
        type: String,
            },
    startupStage:{
        type: String,
            },
    websiteAddress:{
        type: String,
        
    },
    startupDomain:{
        type: String,
            },
    foundedIn:{
        type: String,
            },
    location:{
        type: String,
            },
    startupBusiness:{
        type: String,
            },
    productSummary:{
        type: String,
            },
    twitterPitch:{
        type: String,
            },
    teamSummary:{
        type: String,
            },
    difference:{
        type: String,
            },
    cloud:{
        type: String,
            },
    amount:{
        type: Number,
            },
    
    tokens:[{
        token:{
            type:String,
        }
    }]

})

startupSchema.methods.generateAuthToken=async function(){
    try {
        const token=jwt.sign({_id:this._id.toString()},process.env.SECRET_KEY);
        this.tokens=this.tokens.concat({token:token});
        await this.save();
        console.log("YEAH");
        return token;
        
    } catch (error) {
        
        console.log(error);
    }
}

startupSchema.pre("save",async function(next){
    // const passwordHash=await bcrypt.hash(password,10);

    if(this.isModified("password")){
    this.password=await bcrypt.hash(this.password,10);
    this.confirmPassword=await bcrypt.hash(this.confirmPassword,10);
    }
    next();

})

const startupRegister=new mongoose.model("Startup", startupSchema);
module.exports=startupRegister;