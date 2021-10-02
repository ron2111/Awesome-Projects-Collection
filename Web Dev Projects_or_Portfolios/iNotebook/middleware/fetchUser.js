var jwt = require("jsonwebtoken");

const JWT_SECRET = "niks_bornmagnanimous";

const fetchUsers = (req, res, next) => {
  // Get the user from the JWT token and the add the userId to the req object
  const token = req.header("auth-token");
  if (!token) {
    return res
      .status(401)
      .send({ error: "Please authenticate using a valid token" });
  }
  try {
    const data = jwt.verify(token, JWT_SECRET);
    req.user = data.user;
  } catch (error) {
    res.status(401).send({ error: "Please authenticate using a valid token" });
  }
  next();
};

module.exports = fetchUsers;
