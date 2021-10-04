import React from "react";
import "animate.css";
import Terminal from "../components/dynamic/Terminal";
import Heading from "../components/dynamic/Heading";
import Myself from "../components/static/Myself";


const Info = () => {

    return(
        <div className="info" id="About Me">        
            <Heading heading="About me" />
            <Terminal
             command="cat Myself.md"
            filename="Myself.md" 
            title={Myself[0][0][1]} 
            item1={Myself[1][0]}
            item2={Myself[1][1]}
            item3={Myself[1][2]}
            />
        </div>
    )
}

export default Info;