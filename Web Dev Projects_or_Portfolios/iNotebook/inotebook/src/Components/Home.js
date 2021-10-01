import React from "react";
import { useContext, useState, useEffect, useRef } from "react";
import noteContext from "../context/notes/noteContext";
import NoteItem from "./NoteItem";
import { Form, Button, Container } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import "../custom.css";

export default function Home() {
  const history = useHistory();
  const context = useContext(noteContext);
  const [addNote, setAddNote] = useState({
    id: "",
    title: "",
    description: "",
    tag: "",
  });

  useEffect(() => {
    if (localStorage.getItem("token")) {
      context.getAllNotes();
    } else {
      history.push("/");
    }
    // eslint-disable-next-line
  }, []);

  const handleOnChange = (e) => {
    setAddNote({ ...addNote, [e.target.name]: e.target.value });
  };

  const handleOnSubmit = (e) => {
    context.addNote(addNote.title, addNote.description, addNote.tag);
    setAddNote({ title: "", description: "", tag: "" });
    e.preventDefault();
  };

  const refOpen = useRef(null);
  const refClose = useRef(null);

  const updateNote = (currentNote) => {
    refOpen.current.click();
    setAddNote({
      id: currentNote._id,
      title: currentNote.title,
      description: currentNote.description,
      tag: currentNote.tag,
    });
  };

  const handleUpdateOnClick = (e) => {
    context.editNote(
      addNote.id,
      addNote.title,
      addNote.description,
      addNote.tag
    );
    setAddNote({ id: "", title: "", description: "", tag: "" });
    refClose.current.click();
  };

  return (
    <Container>
      <h1 className="my-5">Take a note...</h1>
      <Form onSubmit={handleOnSubmit}>
        <Form.Group className="mb-3" controlId="title">
          <Form.Label>Title*</Form.Label>
          <Form.Control
            onChange={handleOnChange}
            type="text"
            placeholder="title should be greater than 3 characters"
            name="title"
            value={addNote.title}
            minLength={3}
            required
          />
        </Form.Group>
        <Form.Group className="mb-3" controlId="description">
          <Form.Label>Description*</Form.Label>
          <Form.Control
            onChange={handleOnChange}
            type="description"
            placeholder="description should be greater than 5 characters"
            name="description"
            value={addNote.description}
            minLength={5}
            required
          />
        </Form.Group>

        <div className="my-3">
          <Form.Check
            onClick={handleOnChange}
            inline
            label="Important"
            name="tag"
            value="Important"
            type="radio"
            id={`tag`}
          />
          <Form.Check
            onClick={handleOnChange}
            inline
            label="Personal"
            name="tag"
            value="Personal"
            type="radio"
            id={`tag`}
          />
          <Form.Check
            onClick={handleOnChange}
            inline
            label="Shopping"
            name="tag"
            value="Shopping"
            type="radio"
            id={`tag`}
          />
          <Form.Check
            onClick={handleOnChange}
            inline
            label="Other"
            name="tag"
            value="Other"
            type="radio"
            id={`tag`}
          />
        </div>
        <Button className="mt-3" variant="outline-primary" type="submit">
          Add Note
        </Button>
      </Form>

      {/*  <!-- Update Modal --> */}

      {/* <!-- Button trigger modal --> */}
      <button
        ref={refOpen}
        type="button"
        className="btn btn-primary d-none"
        data-bs-toggle="modal"
        data-bs-target="#myModal"
      >
        Launch demo modal
      </button>

      {/* <!-- Modal --> */}
      <div
        className="modal fade"
        id="myModal"
        tabIndex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      >
        <div className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title" id="exampleModalLabel">
                Edit Note
              </h5>
              <button
                type="button"
                className="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>
            <div className="modal-body">
              <form>
                <div className="mb-3">
                  <label htmlFor="title" className="col-sm-2 col-form-label">
                    Title
                  </label>
                  <div className="col-sm-12">
                    <input
                      placeholder="Title should be greater than 3 characters"
                      onChange={handleOnChange}
                      type="text"
                      className="form-control"
                      id="title"
                      name="title"
                      value={addNote.title}
                    />
                  </div>
                </div>
                <div className="mb-3">
                  <label
                    htmlFor="description"
                    className="col-sm-2 col-form-label"
                  >
                    Description
                  </label>
                  <div className="col-sm-12">
                    <input
                      placeholder="Description should be greater than 3 characters"
                      onChange={handleOnChange}
                      type="description"
                      className="form-control"
                      id="description"
                      name="description"
                      value={addNote.description}
                    />
                  </div>
                </div>
                <div className="mb-3">
                  <label htmlFor="tag" className="col-sm-2 col-form-label">
                    Tag
                  </label>
                  <div className="col-sm-12">
                    <input
                      onChange={handleOnChange}
                      type="text"
                      className="form-control"
                      id="tag"
                      name="tag"
                      value={addNote.tag}
                    />
                  </div>
                </div>
              </form>
            </div>
            <div className="modal-footer">
              <button
                ref={refClose}
                type="button"
                className="btn btn-secondary"
                data-bs-dismiss="modal"
              >
                Close
              </button>
              <button
                disabled={
                  addNote.title.length <= 3 || addNote.description.length <= 5
                }
                onClick={handleUpdateOnClick}
                type="button"
                className="btn btn-primary"
              >
                Save changes
              </button>
            </div>
          </div>
        </div>
      </div>

      <div>
        <h1 className="my-5">Your Notes</h1>
        {context.notes.length === 0 && `No notes available`}
        <div className="row">
          {context.notes.map((note) => {
            return (
              <div key={note._id} className="col-md-6">
                <NoteItem updateNote={updateNote} note={note} />
              </div>
            );
          })}
        </div>
      </div>
    </Container>
  );
}
