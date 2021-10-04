/** @format */

import React from "react";
import "animate.css";
import { Link } from "react-scroll";
import Myself from "../static/Myself";

const SidebarLg = () => {
  return (
    <div className="sidebarLg animate__rotateInDownLeft animate__animated animate__slow">
      <h1>
        <Link to="image" spy={true} smooth={true}>
          ╰─$ ls Profile
        </Link>
      </h1>
      {Myself[0].map((item, index) => {
        return (
          <div key={index}>
            <Link
              to={item[0]}
              activeClass="active"
              offset={-100}
              spy={true}
              smooth={true}
            >
              {item[0]}
            </Link>
          </div>
        );
      })}
      <center>
        <hr className="white" />
      </center>
      <article
        style={{
          fontSize: "3em",
          textAlign: "center",
          color: "rgb(216, 216, 216)",
          marginTop: "0.7em",
        }}
      >
        &copy;
      </article>
      <p>Coded by Priyansh.</p>
    </div>
  );
};

export default SidebarLg;
