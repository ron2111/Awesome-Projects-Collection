const mongoose=require("mongoose");
const bcrypt=require("bcryptjs");
const jwt=require("jsonwebtoken");
const express=require("express");

const app=express();

const investorSchema= new mongoose.Schema({
    
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
    
    location:{
        type: String,
            },
    budget:{
        type:String,
    },
    
    tokens:[{
        token:{
            type:String,
        }
    }]

})

investorSchema.methods.generateAuthToken=async function(){
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

investorSchema.pre("save",async function(next){
    // const passwordHash=await bcrypt.hash(password,10);

    if(this.isModified("password")){
    this.password=await bcrypt.hash(this.password,10);
    this.confirmPassword=await bcrypt.hash(this.confirmPassword,10);
    }
    next();

})

const investorRegister=new mongoose.model("Investor", investorSchema);
module.exports=investorRegister;