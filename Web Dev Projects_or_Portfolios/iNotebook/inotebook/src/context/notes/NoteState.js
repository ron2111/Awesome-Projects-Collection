import NoteContext from "./noteContext";
import { useState } from "react";
import { useHistory } from "react-router-dom";

const NoteState = (props) => {
  const history = useHistory();
  const host = "http://localhost:5000" || process.env.PORT;
  const [notes, setNotes] = useState([]);

  // Create a user - Sign up
  const userSignup = async (name, email, password) => {
    // APi call
    const response = await fetch(`${host}/api/auth/createuser`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ name, email, password }),
    });

    const json = await response.json();
    console.log(json);
    if (json.success) {
      // Save the auth-token and redirect
      localStorage.setItem("token", json.authToken);
      history.push("/home");
    } else {
      alert("Access denied");
    }
  };

  // Authenticate a user - Login
  const userLogin = async (email, password) => {
    // APi call
    const response = await fetch(`${host}/api/auth/login`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ email, password }),
    });

    const json = await response.json();
    // console.log(json);
    if (json.success) {
      // Save the auth-token and redirect
      localStorage.setItem("token", json.authToken);
      history.push("/home");
    } else {
      alert("Invalid Credentials");
    }
  };

  // Fetch all the notes
  const getAllNotes = async () => {
    // APi call
    const response = await fetch(`${host}/api/notes/fetchallnotes`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        "auth-token": localStorage.getItem("token"),
      },
    });

    const json = await response.json();
    // console.log(json);
    setNotes(json);
  };

  // Add a note
  const addNote = async (title, description, tag) => {
    // API call
    const response = await fetch(`${host}/api/notes/addnotes`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "auth-token": localStorage.getItem("token"),
      },
      body: JSON.stringify({ title, description, tag }),
    });
    const json = await response.json();
    // Logic to add note in client side
    setNotes(notes.concat(json));
  };

  // Edit a note
  const editNote = async (id, title, description, tag) => {
    // APi call
    const response = await fetch(`${host}/api/notes/updatenotes/${id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        "auth-token": localStorage.getItem("token"),
      },
      body: JSON.stringify({ title, description, tag }),
    });

    const json = await response.json();

    let newNotes = JSON.parse(JSON.stringify(notes)); //It will create deep copy
    // Logic to edit note in client side
    for (let index = 0; index < newNotes.length; index++) {
      if (newNotes[index]._id === id) {
        newNotes[index].title = json.title;
        newNotes[index].description = json.description;
        newNotes[index].tag = json.tag;
        break;
      }
    }
    setNotes(newNotes);
  };

  // Delete a note
  const deleteNotes = async (id) => {
    // API call
    await fetch(`${host}/api/notes/deletenotes/${id}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
        "auth-token": localStorage.getItem("token"),
      },
    });

    // Logic to edit note in client side
    const newNotes = notes.filter((note) => {
      return note._id !== id;
    });
    setNotes(newNotes);
  };

  const logOut = () => {
    localStorage.removeItem("token");
    history.push("/");
    window.location.reload();
  };
  return (
    <NoteContext.Provider
      value={{
        notes,
        addNote,
        editNote,
        deleteNotes,
        getAllNotes,
        userLogin,
        userSignup,
        logOut,
      }}
    >
      {props.children}
    </NoteContext.Provider>
  );
};

export default NoteState;
