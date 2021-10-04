/** @format */

import React from "react";
import "animate.css";
import Terminal from "../components/dynamic/Terminal";
import Heading from "../components/dynamic/Heading";

const TechStack = () => {
  return (
    <div className="info" id="TechStack">
      <Heading heading="techStack" />
      <Terminal
        command="cat TechStack.md"
        filename="TechStack.md"
        techStack={true}
      />
    </div>
  );
};

export default TechStack;
