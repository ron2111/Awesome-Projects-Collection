/** @format */

import React from "react";
import "animate.css";


const Heading = (props) => {

  return (
      <header className="heading">
        # {props.heading}
      </header>
  );
};

export default Heading;