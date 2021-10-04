/** @format */

import React from "react";
import "animate.css";
import InfoIcon from "@material-ui/icons/Info";
import CodeIcon from "@material-ui/icons/Code";
import WbIncandescentIcon from "@material-ui/icons/WbIncandescent";
import SpellcheckOutlinedIcon from "@material-ui/icons/SpellcheckOutlined";
import AssignmentIcon from "@material-ui/icons/Assignment";
import VerifiedUserIcon from "@material-ui/icons/VerifiedUser";
import StarBorderIcon from "@material-ui/icons/StarBorder";
import { Link } from "react-scroll";

const SidebarSm = () => {
  return (
    <div className="sidebarSm animate__rotateInDownLeft animate__animated">
      <div className="container">
        <div className="container__content">About Me</div>
        <div className="container__arrow" />
        <span>
          <Link to="About Me" activeClass="active" spy={true} smooth={true}>
            <InfoIcon fontSize="large" />
          </Link>
        </span>
      </div>

      <div className="container">
        <div className="container__content">Learning</div>
        <div className="container__arrow" />
        <span>
          <Link
            to="Learning"
            activeClass="active-icon"
            spy={true}
            smooth={true}
          >
            <CodeIcon fontSize="large" />
          </Link>
        </span>
      </div>

      <div className="container">
        <div className="container__content">TechStack</div>
        <div className="container__arrow" />
        <span>
          <Link
            to="TechStack"
            activeClass="active-icon"
            spy={true}
            smooth={true}
          >
            <StarBorderIcon fontSize="large" />
          </Link>
        </span>
      </div>

      <div className="container">
        <div className="container__content">Projects</div>
        <div className="container__arrow" />
        <span>
          <Link
            to="Projects"
            activeClass="active-icon"
            spy={true}
            smooth={true}
          >
            <AssignmentIcon fontSize="large" />
          </Link>
        </span>
      </div>

      <div className="container">
        <div className="container__content">Achievments</div>
        <div className="container__arrow" />
        <span>
          <Link
            to="Achievments"
            activeClass="active-icon"
            spy={true}
            smooth={true}
          >
            <SpellcheckOutlinedIcon fontSize="large" />
          </Link>
        </span>
      </div>

      <div className="container">
        <div className="container__content">Interests</div>
        <div className="container__arrow" />
        <span>
          <Link
            to="Interests"
            activeClass="active-icon"
            spy={true}
            smooth={true}
          >
            <WbIncandescentIcon fontSize="large" />
          </Link>
        </span>
      </div>

      <div className="container">
        <div className="container__content">Certifications</div>
        <div className="container__arrow" />
        <span>
          <Link
            to="Certifications"
            activeClass="active-icon"
            spy={true}
            smooth={true}
          >
            <VerifiedUserIcon fontSize="large" />
          </Link>
        </span>
      </div>

      <div className="container">
        <span style={{ fontSize: "3em", color: "rgb(216, 216, 216)" }}>
          &copy;
        </span>
      </div>
    </div>
  );
};

export default SidebarSm;
