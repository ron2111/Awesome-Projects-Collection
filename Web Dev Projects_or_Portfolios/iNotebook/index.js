const express = require("express");
const cors = require("cors");

const connectToMongo = require("./db.js");
connectToMongo();

const app = express();
const port = process.env.PORT || 5000;

app.use(cors());
app.use(express.json());
app.use("/api/auth", require("./routes/auth"));
app.use("/api/notes", require("./routes/notes"));

if (process.env.NODE_ENV == "production") {
  app.use(express.static("inotebook/build"));
}

app.listen(port, () => {
  console.log(`iNotebook backend listening at http://localhost:${port}`);
});
