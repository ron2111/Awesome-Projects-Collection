import React, { useContext } from "react";
import noteContext from "../context/notes/noteContext";

export default function NoteItem(props) {
  const context = useContext(noteContext);
  const { note, updateNote } = props;

  return (
    <div
      className={`card text-white bg-${
        note.tag === `Important`
          ? `dark`
          : note.tag === `Personal`
          ? `primary`
          : note.tag === `Shopping`
          ? `success`
          : note.tag === `Other`
          ? `secondary`
          : `info`
      } mb-3`}
    >
      <div className="card-header">{note.tag}</div>
      <div className="card-body">
        <h5 className="card-title">{note.title}</h5>
        <p className="card-text">{note.description}</p>
        <button
          onClick={() => {
            updateNote(note);
          }}
          type="button"
          className="me-3 btn btn-outline-warning"
        >
          <i className="me-2 far fa-edit"></i>Edit
        </button>
        <button
          onClick={() => {
            context.deleteNotes(note._id);
          }}
          type="button"
          className="btn btn-outline-danger"
        >
          <i className="me-2 far fa-trash-alt"></i>Delete
        </button>
      </div>
    </div>
  );
}
