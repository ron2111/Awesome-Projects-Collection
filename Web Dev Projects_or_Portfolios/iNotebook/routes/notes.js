const express = require("express");
const router = express.Router();
const fetchUser = require("../middleware/fetchUser");
const { body, validationResult } = require("express-validator");
const Notes = require("../models/Notes");

// ROUTE 1 : - Get all the notes: GET /api/notes/fetchallnotes .login required
router.get("/fetchallnotes", fetchUser, async (req, res) => {
  try {
    const notes = await Notes.find({ user: req.user.id });
    res.json(notes);
  } catch (error) {
    console.error(error.message);
    res.status(500).send("Something went wrong");
  }
});

// ROUTE 2 : - Add the notes: POST /api/notes/addnotes .login required
router.post(
  "/addnotes",
  fetchUser,
  [
    body("title", "Please provide some title").exists(),
    body("description", "Description must be atLeast 5 characters").isLength({
      min: 5,
    }),
  ],
  async (req, res) => {
    // Finds the validation errors in this request and wraps them in an object with handy functions
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(400).json({ errors: errors.array() });
    }
    try {
      // Add the notes
      const notes = await Notes.create({
        user: req.user.id,
        title: req.body.title,
        description: req.body.description,
        tag: req.body.tag,
      });

      res.json(notes);
    } catch (error) {
      console.error(error.message);
      res.status(500).send("Something went wrong");
    }
  }
);

// ROUTE 3 : - Update the existing notes: PUT /api/notes/updatenotes/:id .login required
router.put(
  "/updatenotes/:id",
  fetchUser,
  [
    body("title", "Please provide some title").exists(),
    body("description", "Description must be atLeast 5 characters").isLength({
      min: 5,
    }),
  ],
  async (req, res) => {
    // Finds the validation errors in this request and wraps them in an object with handy functions
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(400).json({ errors: errors.array() });
    }
    // Destructuring the request body
    const { title, description, tag } = req.body;
    try {
      const newNotes = {};
      if (title) {
        newNotes.title = title;
      }
      if (description) {
        newNotes.description = description;
      }
      if (tag) {
        newNotes.tag = tag;
      }
      // Find the note that is going to be updated
      let notes = await Notes.findById(req.params.id);
      // Check if the notes is available or not
      if (!notes) {
        return res.status(404).send("Not found");
      }
      // Check the particular note belong to the loggedIn user or not
      if (notes.user.toString() !== req.user.id) {
        return res.status(401).send("Unauthorized user");
      }
      // Find the note and update the note
      notes = await Notes.findByIdAndUpdate(
        req.params.id,
        { $set: newNotes },
        { new: true }
      );

      res.json(notes);
    } catch (error) {
      console.error(error.message);
      res.status(500).send("Something went wrong");
    }
  }
);

// ROUTE 4 : - Delete the existing notes: DELETE /deletenotes/:id .login required
router.delete("/deletenotes/:id", fetchUser, async (req, res) => {
  try {
    // Find the note that is going to be updated
    let notes = await Notes.findById(req.params.id);
    // Check if the notes is available or not
    if (!notes) {
      return res.status(404).send("Not found");
    }
    // Check the particular note belong to the loggedIn user or not
    if (notes.user.toString() !== req.user.id) {
      return res.status(401).send("Unauthorized user");
    }

    notes = await Notes.findByIdAndDelete(req.params.id);
    res.json({ success: "Note has been deleted" });
  } catch (error) {
    console.error(error.message);
    res.status(500).send("Something went wrong");
  }
});

module.exports = router;
