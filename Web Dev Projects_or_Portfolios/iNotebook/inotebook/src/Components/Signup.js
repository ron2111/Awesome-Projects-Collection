import React, { useState, useContext } from "react";
import noteContext from "../context/notes/noteContext";
import { Form, Button, Container, Row, Col } from "react-bootstrap";

export default function Signup() {
  const context = useContext(noteContext);

  const [newUser, setNewUser] = useState({
    userName: "",
    email: "",
    password: "",
  });

  const handleOnChange = (e) => {
    setNewUser({ ...newUser, [e.target.name]: e.target.value });
  };
  const handleOnSubmit = (e) => {
    context.userSignup(newUser.userName, newUser.email, newUser.password);
    e.preventDefault();
  };

  return (
    <Container>
      <Row className="align-items-center">
        <Col md={6}>
          <h1 className="mb-5">SignUp to Create your notes...</h1>
          <Form onSubmit={handleOnSubmit}>
            <Form.Group className="mb-3" controlId="name">
              <Form.Label>Name</Form.Label>
              <Form.Control
                onChange={handleOnChange}
                type="text"
                placeholder="Name"
                name="userName"
                minLength={3}
                required
              />
            </Form.Group>
            <Form.Group className="mb-3" controlId="email">
              <Form.Label>Email address</Form.Label>
              <Form.Control
                onChange={handleOnChange}
                type="email"
                placeholder="Enter email"
                name="email"
                required
              />
              <Form.Text className="text-muted">
                We'll never share your email with anyone else.
              </Form.Text>
            </Form.Group>

            <Form.Group className="mb-3" controlId="password">
              <Form.Label>Password</Form.Label>
              <Form.Control
                onChange={handleOnChange}
                type="password"
                placeholder="Password"
                name="password"
                minLength={5}
                required
              />
            </Form.Group>
            <Button variant="success" type="submit">
              Sign Up
            </Button>
          </Form>
        </Col>
        <Col md={6}>
          <img
            className="img-fluid"
            src="https://image.freepik.com/free-vector/mobile-login-concept-illustration_114360-83.jpg"
            alt="Something went wrong"
          />
        </Col>
      </Row>
    </Container>
  );
}
