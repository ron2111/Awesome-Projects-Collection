import React, { useState } from 'react';
import SingleColor from "./SingleColor";
import Values from "values.js"; // imported a file (npm install values.js --save)  github repo - https://github.com/noeldelgado/values.js
import colorlogo from "./colorlogo.png"

function App() {

  const [color, setColor] = useState('');
  const [error, setError] = useState(false);
  const [list, setList] = useState(new Values('purple').all(10));

  const handleSubmit = (event) => {
    event.preventDefault();
    try {
      let colors = new Values(color).all(10)
      setList(colors)
      setError(false)
      console.log(colors);
    } catch (error) {
      setError(true);
      alert("Enter a valid primary colour or HEX value.")
      console.log("error");
    }
  }

  return (

    <>
      <section className="container">
        <img src={colorlogo} alt="logo" style={{height: '3rem' , width: '3rem'}}></img>
        <h3>Color Generator</h3>
        <form onSubmit={handleSubmit}>
          <input type="text" value={color} placeholder="eg. #f15025" className={error ? "error" : null} onChange={(event) => setColor(event.target.value)}></input>
          <button className="btn" type="submit">Submit</button>
        </form>
      </section>

      <section className="colors">
         {
           list.map((color,index) => {
             console.log(color);
             return(
               <SingleColor key={index} {...color} index={index}/>
             )
           })
         }
      </section>
    </>

  );
}

export default App;
