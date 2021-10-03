import React from 'react'
import "./success.css"
import { Link } from "react-router-dom";
import hackathon from "../../src/assets/images/hackathon.png";

export default function Submissions() {
    return (
        
            <div className="container center">
                <div className="col s8 m4">
                    <div className="card">
                        <div className="card-image">
                            <img src={hackathon} />
                        </div>
                        <div className="card-content">
                            <h4 style={{fontWeight:"500"}}>Assignment Successfully Submitted...</h4>
                            <p style={{fontSize: "20px"}}>Thank for submitting the form , we got your response and declare the results soon.
                                Have a great day!!
                            </p>
                        </div>
                        <div className="card-action">
                            <a href="/submissions" style={{fontWeight: 'bold' , fontSize:"20px" , color: "#26a69a"}}>View all submissions</a>
                        </div>
                    </div>
                </div>
            </div>
    )
}