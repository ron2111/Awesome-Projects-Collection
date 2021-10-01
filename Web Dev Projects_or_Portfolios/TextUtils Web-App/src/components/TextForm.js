import React, { useState } from "react";

export default function TextForm(props) {
  const [text, setText] = useState("");
  const handleOnChange = (event) => {
    setText(event.target.value);
  };
  const handleUpClick = () => {
    let upText = text.toUpperCase();
    setText(upText);
    props.showAlert("Converted to uppercase.", "primary");
  };
  const handleLowClick = () => {
    let lowText = text.toLowerCase();
    setText(lowText);
    props.showAlert("Converted to lowercase.", "primary");
  };
  const handleExtraSpaces = () => {
    let newText = text.split(/[ ]+/);
    setText(newText.join(" "));
    props.showAlert("extra spaces removed.", "primary");
  };
  const handleCopy = () => {
    let text = document.getElementById("textbox");
    text.select();
    navigator.clipboard.writeText(text.value);
    props.showAlert("copied to clipboard.", "primary");
  };
  const handleClearClick = () => {
    let newText = "";
    setText(newText);
    props.showAlert("cleared.", "primary");
  };

  return (
    <>
      <div
        className='container'
        style={{
          color: props.mode === "dark" ? "white" : "black",
        }}
      >
        <h2>{props.heading}</h2>
        <div className='mb-3'>
          <label htmlFor='exampleFormControlTextarea1' className='form-label'>
            Text Box
          </label>
          <textarea
            className='form-control'
            style={{
              backgroundColor: props.mode === "dark" ? "#2c3035" : "white",
              color: props.mode === "dark" ? "white" : "black",
            }}
            value={text}
            onChange={handleOnChange}
            id='textbox'
            rows='8'
            placeholder='Type here...'
          ></textarea>
        </div>
        <div>
          <button className='btn btn-primary mx-1' onClick={handleUpClick}>
            UPPERCASE CONVERTER
          </button>
          <button className='btn btn-primary mx-1' onClick={handleLowClick}>
            lowercase converter
          </button>
          <button className='btn btn-primary mx-1' onClick={handleExtraSpaces}>
            Extra Spaces Remover
          </button>
          <button className='btn btn-primary mx-1' onClick={handleCopy}>
            Copy Text
          </button>
          <button className='btn btn-primary mx-1' onClick={handleClearClick}>
            Clear Selection
          </button>
        </div>
      </div>

      <div
        className='container my-4'
        style={{
          color: props.mode === "dark" ? "white" : "black",
        }}
      >
        <h3>Text Analysis</h3>
        <p>
          {text.split(" ").length} words and {text.length} characters
        </p>
        <h3>Time Taken</h3>
        <p>{0.008 * text.split(" ").length} minutes to read</p>
        <h3>Preview</h3>
        <p>{text.length > 0 ? text : "Enter your text for previewing"}</p>
      </div>
    </>
  );
}
