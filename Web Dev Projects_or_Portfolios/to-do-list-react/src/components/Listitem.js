import React, { useState, useEffect } from "react";
import firebase from "../utils/firebase";
import iconcheck from "../icon-check.svg";
import Todo from "./Todo";
export default function Listitem() {
  const [todoList, setTodoList] = useState();
  useEffect(() => {
    const todoref = firebase.database().ref("to-do-4cd9a-default-rtdb");
    todoref.on("value", (snapshot) => {
      const todos = snapshot.val();
      const todoList = [];
      for (let id in todos)
        todoList.push({
          id,
          ...todos[id],
        });
      setTodoList(todoList);
    });
  }, []);

  return (
    <div>
      {/* {todoList
                    ? todoList.map((todo) => <h1>{todo.title}</h1>): ''} */}

      {todoList
        ? todoList.map((todo, index) => <Todo todo={todo} key={index} />)
        : ""}{/*normal if loop doesnt work so we use ternary */}

      {/* <div class="todo-items-info">
        <div class="items-left">5 items left</div>
        <div class="items-statuses">
          <span class="active">All</span>
          <span>Active</span>
          <span>Completed</span>
        </div>
        <div class="items-clear">
          <span>Clear Completed</span>
        </div>
      </div> */}
    </div>
  );
}
