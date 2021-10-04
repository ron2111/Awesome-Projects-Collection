/** @format */

import React from "react";
import { Parallax } from "react-parallax";
import pi from "../components/static/pi.jpeg";
import "../App.css";
import "animate.css";
import GitHubIcon from "@material-ui/icons/GitHub";
import LinkedInIcon from "@material-ui/icons/LinkedIn";
import MailOutlineIcon from "@material-ui/icons/MailOutline";

const Imager = () => {
  const url =
    "https://images.pexels.com/photos/1342460/pexels-photo-1342460.jpeg?cs=srgb&dl=pexels-vitaly-vlasov-1342460.jpg&fm=jpg";

  const style = {
    color: "white",
    marginTop: "0.7em",
    marginRight: "1.1em",
    fontSize: "2.2em",
  };
  return (
    <div>
      <Parallax blur={0} bgImage={url} bgImageAlt="the tech" strength={370}>
        <div className="heighter" id="image">
          <img
            className="avatar animate__zoomIn animate__animated animate__slow"
            alt="Priyansh"
            src={pi}
          />
          <h1 className="name">Priyansh Vyas</h1>
        </div>
      </Parallax>
      <div className="navicons">
        <a
          href="https://github.com/priyansh71/profile"
          target="_blank"
          rel="noreferrer"
        >
          <GitHubIcon style={style} />
        </a>
        <a
          href="https://www.linkedin.com/in/priyansh-vyas/"
          target="_blank"
          rel="noreferrer"
        >
          <LinkedInIcon style={style} />
        </a>
        <a
          href="mailto:f20201388@goa.bits-pilani.ac.in"
          target="_blank"
          rel="noreferrer"
        >
          <MailOutlineIcon style={style} />
        </a>
      </div>{" "}
    </div>
  );
};

export default Imager;
