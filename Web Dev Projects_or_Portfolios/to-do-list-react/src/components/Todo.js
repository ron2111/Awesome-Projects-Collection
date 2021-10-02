import React from "react";
import iconcheck from "../icon-check.svg";
import firebase from "../utils/firebase";

export default function Todo({ todo }) {

    const deleteTodo = ()=>{
        const todoRef = firebase.database().ref('to-do-4cd9a-default-rtdb').child(todo.id);
        todoRef.remove();
    }

    const completed = ()=>{
      if(document.getElementById("check-icon").style.visibility==="hidden"){
        document.getElementById("check-icon").style.visibility="visible"
      }else{
        document.getElementById("check-icon").style.visibility="hidden"
      }
    }

  return (
    <div>
      <div  class="todo-items-wrapper">
        <div class="todo-items">
          <div class="todo-item">
            <div class="check">
              <div onClick={completed}   class="checkmark" >
                <img id="check-icon" src={iconcheck}  alt="" />
              </div>
            </div>
            <div class="todo-text">{todo.title}</div>
          </div>
          <button onClick={deleteTodo} className="remove"><i class="fas fa-trash"></i></button>
        </div>
      </div>
    </div>
  );
}
