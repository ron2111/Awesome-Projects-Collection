import React from 'react';
import '../Styles/Footer.css';
import github from '../Icons/github.svg';
import linkedin from '../Icons/linkedin.svg';
import instagram from '../Icons/instagram.svg';

const Footer = () => {
    return (
        <div className="footer">
            <a href="https://github.com/anomic30"><img src={github} alt="GitHub" height="32px" /></a>
            <a href="https://www.linkedin.com/in/anomic/"><img src={linkedin} alt="LinkedIn" height="22px" /></a>
            <a href="https://www.instagram.com/codermav/"><img src={instagram} alt="Instagram" height="32px" /></a>
        </div>
    )
}

export default Footer
