import React from "react";
import "animate.css";
import Terminal from "../components/dynamic/Terminal";
import Heading from "../components/dynamic/Heading";
import Myself from "../components/static/Myself";


const Projects = () => {

    return(
        <div className="info" id="Projects">        
            <Heading heading="Projects" />
            <Terminal command="cat Projects.md" filename="Projects.md"
             title={Myself[0][3][1]} 
            item1={Myself[4][0]}
            item2={Myself[4][1]}
            item3={Myself[4][2]}
            />
        </div>
    )
}

export default Projects;