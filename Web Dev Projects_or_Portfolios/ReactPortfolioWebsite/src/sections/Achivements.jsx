/** @format */

import React from "react";
import "animate.css";
import Terminal from "../components/dynamic/Terminal";
import Heading from "../components/dynamic/Heading";
import Myself from "../components/static/Myself";

const Achievments = () => {
  return (
    <div className="info" id="Achievments">
      <Heading heading="Achieved" />
      <Terminal
        command="cat Achievments.md"
        filename="Achievments.md"
        title={Myself[0][4][1]}
        item1={Myself[5][0]}
        item2={Myself[5][1]}
        item3={Myself[5][2]}
        item4={Myself[5][3]}
        img="CryptoHack Weekend Rankings"
      />
    </div>
  );
};

export default Achievments;
