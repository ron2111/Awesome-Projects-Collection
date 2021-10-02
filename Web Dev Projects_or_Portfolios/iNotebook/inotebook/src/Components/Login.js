import React, { useState, useContext } from "react";
import noteContext from "../context/notes/noteContext";
import { Form, Button, Container, Row, Col } from "react-bootstrap";
import "../custom.css";

export default function Login() {
  const context = useContext(noteContext);
  const [user, setUser] = useState({ email: "", password: "" });

  const handleOnChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleOnSubmit = (e) => {
    context.userLogin(user.email, user.password);
    e.preventDefault();
  };

  return (
    <Container>
      <Row className="align-items-center">
        <Col md={6}>
          <h1 className="mb-5">Login to access your notes...</h1>
          <Form onSubmit={handleOnSubmit}>
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
                required
              />
            </Form.Group>
            <Button variant="primary" type="submit">
              Log In
            </Button>
          </Form>
        </Col>
        <Col md={6}>
          <img
            className="img-fluid"
            src="https://image.freepik.com/free-vector/mobile-login-concept-illustration_114360-135.jpg"
            alt=""
          />
        </Col>
      </Row>
    </Container>
  );
}
