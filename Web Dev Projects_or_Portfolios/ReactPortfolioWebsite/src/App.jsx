import React from "react";
import SidebarLg from "./components/dynamic/SidebarLg";
import SidebarSm from "./components/dynamic/SidebarSm";
import Interests from "./sections/Interests";
import Imager from "./sections/Imager";
import Myself from "./sections/Myself";
import Projects from "./sections/Projects";
import Learning from "./sections/Learning";
import Achievments from "./sections/Achivements";
import Certifications from "./sections/Certifications";
import TechStack from "./sections/Techstack";
const App = () => {
  return (
    <div>
    <Imager />
    <SidebarSm />
    <SidebarLg   />
    <Myself />
    <Learning />
    <TechStack />
    <Projects />
    <Achievments />
    <Interests />
    <Certifications />
    <div style={{padding : "3.3em", backgroundColor : "rgb(245, 245, 245)"}}>
</div> </div>
  );
};

export default App;
