/** @format */

import React from "react";
import "animate.css";
import Terminal from "../components/dynamic/Terminal";
import Heading from "../components/dynamic/Heading";
import Myself from "../components/static/Myself";

const Education = () => {
  return (
    <div className="info" id="Interests">
      <Heading heading="Interests" />
      <Terminal
        command="cat Interests.md"
        filename="Interests.md"
        title={Myself[0][5][1]}
        item1={Myself[3][0]}
        item2={Myself[3][1]}
        item3={Myself[3][2]}
        item4={Myself[3][3]}
      />
    </div>
  );
};

export default Education;
