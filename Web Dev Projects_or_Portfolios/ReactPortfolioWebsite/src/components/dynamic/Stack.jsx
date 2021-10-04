/** @format */

import React from "react";
import "animate.css";
import Myself from "../static/Myself";

const Stack = () => {
  return (
    <div className="stacker">
      {Myself[7].map((item, index) => {

        return (
          <article key={index}>
          <div className="tech">{item[0]}</div>
            <div className="progress">
              <div className="progress-bar" style={{ width: item[1]}}></div>
            </div>
          </article>
        );
      })}
    </div>
  );
};

export default Stack;
