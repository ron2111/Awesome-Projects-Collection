import React from 'react';
import jS from "../static/jS.pdf"
import webD from "../static/webD.pdf"
import cybersec from "../static/cybersec.pdf"


const Renderer = (props) => {
  return(
    <ul>
      <li><a href={webD} rel="noreferrer" target = "_blank">{props.name1}</a></li>
      <li><a href={jS} rel="noreferrer" target = "_blank">{props.name2}</a></li>
      <li><a href={cybersec} rel="noreferrer" target = "_blank">{props.name3}</a></li>
    </ul>
    );
  }

export default Renderer;