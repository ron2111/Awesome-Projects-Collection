
import './App.css';
import React,{useState,useEffect} from 'react'
import bgdesktopdark from './bg-desktop-dark.jpg';
import iconcheck from './icon-check.svg';
import iconcross from './icon-cross.svg';
import iconmoon from './icon-moon.svg';
import iconsun from './icon-sun.svg';
import firebase from './utils/firebase';
import Listitem from './components/Listitem';
import Footer from './components/Footer'
function App() {
  const [title,setTitle] = useState("");
  const handleTitle = (event)=>{
    setTitle(event.target.value); 
 
   };
 

  const createTodo = ()=>{
    const todoRef = firebase.database().ref("to-do-4cd9a-default-rtdb");
    const todo = {
      title,
    };

    todoRef.push(todo);
    setTitle("");

  }

  return (
    <> <div class="background-img">
    <img src={bgdesktopdark} alt="a" />
</div>
<div class="container">
    <div class="header">
        <div class="title">
            TODO
        </div>
        <div class="theme">
            <img on className="sun" src={iconsun} alt="" />
            <img className="moon" src={iconmoon} alt="" />
        </div>
    </div>
    <div class="new-todo">
        <div class="check">
            <div class="checkmark add-up">
            <button id="add" disabled={!title}  onClick={createTodo} className="button"> <i className="fas fa-plus fa-2x"></i></button>
            </div>
        </div>
        <div class="new-todo-input">
            <form onsubmit="addItem(event)">
                <input id="todo-input" onChange={handleTitle} value={title}  type="text" placeholder="Create a new todo..." />
            </form>
        </div>
    </div>
    <Listitem />
    <Footer />
</div>
</>
  );
}

export default App;
