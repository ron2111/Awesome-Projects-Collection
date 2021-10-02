import React, { useContext } from "react";
import { Col, Container, Row, Button, Form } from "react-bootstrap";
import { Link } from "react-router-dom";
import noteContext from "../context/notes/noteContext";
import "../custom.css";

export default function LandingPage() {
  const context = useContext(noteContext);

  return (
    <div>
      <header className="page-header gradient">
        <Container>
          <Row className="align-items-center">
            <Col md={6} className="text-center">
              <h2
                style={{
                  fontFamily: "'Lobster', cursive",
                }}
              >
                iNotebook - Your notes, everywhere you are!
              </h2>
              <p>
                iNotebook is an open-source note taking app. Capture your
                thoughts and access them from any device.
              </p>
              {localStorage.getItem("token") ? (
                <Button
                  onClick={context.logOut}
                  type="button"
                  variant="outline-warning btn-lg rounded-pill page-header"
                >
                  Log Out
                </Button>
              ) : (
                <div>
                  <Link
                    style={{
                      color: "white",
                    }}
                    type="button"
                    className="my-1 mx-1 btn btn-outline-primary btn-lg rounded-pill page-header"
                    to="/login"
                  >
                    Log in
                  </Link>
                  <Link
                    style={{
                      color: "white",
                    }}
                    type="button"
                    className="my-1 mx-1 btn btn-outline-success btn-lg rounded-pill"
                    to="/signup"
                  >
                    Sign up with iNotebook
                  </Link>
                </div>
              )}
            </Col>
            <Col md={6}>
              <img
                className="img-fluid"
                src="https://joplinapp.org/images/customise-it-img.png"
                alt="HeaderImage"
              />
            </Col>
          </Row>
        </Container>
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320">
          <path
            fill="#fff"
            fillOpacity="1"
            d="M0,96L48,117.3C96,139,192,181,288,197.3C384,213,480,203,576,170.7C672,139,768,85,864,80C960,75,1056,117,1152,128C1248,139,1344,117,1392,106.7L1440,96L1440,320L1392,320C1344,320,1248,320,1152,320C1056,320,960,320,864,320C768,320,672,320,576,320C480,320,384,320,288,320C192,320,96,320,48,320L0,320Z"
          ></path>
        </svg>
      </header>

      <section className="functionality-logo">
        <Container>
          <Row>
            <Col md={3}>
              <img
                className="img-fluid"
                src="https://image.freepik.com/free-vector/copywriting-social-media-post-content-marketing-internet-commercial-cartoon-character-writing-text-advertising-promotional-strategy_335657-356.jpg"
                alt="Create logo"
              />
              <h3 className="text-center">Create</h3>
            </Col>
            <Col md={3}>
              <img
                className="img-fluid"
                src="https://image.freepik.com/free-vector/bibliophile-concept-illustration_114360-1167.jpg"
                alt="Read logo"
              />
              <h3 className="text-center">Read</h3>
            </Col>
            <Col md={3}>
              <img
                className="img-fluid"
                src="https://image.freepik.com/free-vector/web-page-visualization-protocol-procedure-dynamic-software-workflow-full-stack-development-markup-administrate-system-driver-shared-memory-vector-isolated-concept-metaphor-illustration_335657-4299.jpg"
                alt="Update logo"
              />
              <h3 className="text-center">Update</h3>
            </Col>
            <Col md={3}>
              <img
                className="img-fluid"
                src="https://image.freepik.com/free-vector/inbox-cleanup-concept-illustration_114360-1020.jpg"
                alt="Delete logo"
              />
              <h3 className="text-center">Delete</h3>
            </Col>
          </Row>
        </Container>
      </section>

      <section className="feature gradient">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320">
          <path
            fill="#fff"
            fillOpacity="1"
            d="M0,320L48,282.7C96,245,192,171,288,154.7C384,139,480,181,576,170.7C672,160,768,96,864,85.3C960,75,1056,117,1152,154.7C1248,192,1344,224,1392,240L1440,256L1440,0L1392,0C1344,0,1248,0,1152,0C1056,0,960,0,864,0C768,0,672,0,576,0C480,0,384,0,288,0C192,0,96,0,48,0L0,0Z"
          ></path>
        </svg>
        <Container>
          <Row className="align-items-center">
            <Col md={6}>
              <img
                className="img-fluid"
                src="https://www.notion.so/cdn-cgi/image/w=640,q=100/front-static/pages/product/home-page-hero-refreshed.png"
                alt="Something went wrong"
              />
            </Col>
            <Col md={6}>
              <h2 className="text-end">
                <strong>Introducing iNotebook</strong>
              </h2>
              <p className="my-4">
                It is a modern web application based on modern technologies,
                i.e., MongoDB, Express Js, React Js & Node Js. It is crafted
                with the latest design and coded with all modern approach.
              </p>
              <ul>
                <li>
                  <i className="far fa-check-circle me-2"></i>Suer Responsive UI
                </li>
                <li>
                  <i className="far fa-check-circle me-2"></i>User - Friendly
                </li>
                <li>
                  <i className="far fa-check-circle me-2"></i>Based on modern
                  technologies ,i.e., MERN
                </li>
              </ul>
            </Col>
          </Row>
        </Container>
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320">
          <path
            fill="#fff"
            fillOpacity="1"
            d="M0,320L48,282.7C96,245,192,171,288,154.7C384,139,480,181,576,170.7C672,160,768,96,864,85.3C960,75,1056,117,1152,154.7C1248,192,1344,224,1392,240L1440,256L1440,320L1392,320C1344,320,1248,320,1152,320C1056,320,960,320,864,320C768,320,672,320,576,320C480,320,384,320,288,320C192,320,96,320,48,320L0,320Z"
          ></path>
        </svg>
      </section>

      <section>
        <Container>
          <Row className="text-center">
            <Col md={4}>
              <div className="icon gradient mb-4">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="25"
                  height="25"
                  fill="currentColor"
                  className="bi bi-arrow-down-up"
                  viewBox="0 0 16 16"
                >
                  <path
                    fillRule="evenodd"
                    d="M11.5 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L11 2.707V14.5a.5.5 0 0 0 .5.5zm-7-14a.5.5 0 0 1 .5.5v11.793l3.146-3.147a.5.5 0 0 1 .708.708l-4 4a.5.5 0 0 1-.708 0l-4-4a.5.5 0 0 1 .708-.708L4 13.293V1.5a.5.5 0 0 1 .5-.5z"
                  />
                </svg>
              </div>
              <h3>Built to unleash</h3>
              <p>
                Access all the functionality of it without reloading the
                webpage.
              </p>
            </Col>
            <Col md={4}>
              <div className="icon gradient mb-4">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="25"
                  height="25"
                  fill="currentColor"
                  className="bi bi-cloud-arrow-up"
                  viewBox="0 0 16 16"
                >
                  <path
                    fillRule="evenodd"
                    d="M7.646 5.146a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 6.707V10.5a.5.5 0 0 1-1 0V6.707L6.354 7.854a.5.5 0 1 1-.708-.708l2-2z"
                  />
                  <path d="M4.406 3.342A5.53 5.53 0 0 1 8 2c2.69 0 4.923 2 5.166 4.579C14.758 6.804 16 8.137 16 9.773 16 11.569 14.502 13 12.687 13H3.781C1.708 13 0 11.366 0 9.318c0-1.763 1.266-3.223 2.942-3.593.143-.863.698-1.723 1.464-2.383zm.653.757c-.757.653-1.153 1.44-1.153 2.056v.448l-.445.049C2.064 6.805 1 7.952 1 9.318 1 10.785 2.23 12 3.781 12h8.906C13.98 12 15 10.988 15 9.773c0-1.216-1.02-2.228-2.313-2.228h-.5v-.5C12.188 4.825 10.328 3 8 3a4.53 4.53 0 0 0-2.941 1.1z" />
                </svg>
              </div>
              <h3>Access from anywhere</h3>
              <p>
                As it is cloud based application, you can access the notes from
                anywhere.
              </p>
            </Col>
            <Col md={4}>
              <div className="icon gradient mb-4">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="25"
                  height="25"
                  fill="currentColor"
                  className="bi bi-file-earmark-lock"
                  viewBox="0 0 16 16"
                >
                  <path d="M10 7v1.076c.54.166 1 .597 1 1.224v2.4c0 .816-.781 1.3-1.5 1.3h-3c-.719 0-1.5-.484-1.5-1.3V9.3c0-.627.46-1.058 1-1.224V7a2 2 0 1 1 4 0zM7 7v1h2V7a1 1 0 0 0-2 0zM6 9.3v2.4c0 .042.02.107.105.175A.637.637 0 0 0 6.5 12h3a.64.64 0 0 0 .395-.125c.085-.068.105-.133.105-.175V9.3c0-.042-.02-.107-.105-.175A.637.637 0 0 0 9.5 9h-3a.637.637 0 0 0-.395.125C6.02 9.193 6 9.258 6 9.3z" />
                  <path d="M14 14V4.5L9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2zM9.5 3A1.5 1.5 0 0 0 11 4.5h2V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.5v2z" />
                </svg>
              </div>
              <h3>100% secure</h3>
              <p>
                Uses End-To-End Encryption (E2EE) to secure your notes and
                ensure no-one but yourself can access them.
              </p>
            </Col>
          </Row>
        </Container>
      </section>

      <section className="contribute gradient">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320">
          <path
            fill="#fff"
            fillOpacity="1"
            d="M0,96L48,122.7C96,149,192,203,288,202.7C384,203,480,149,576,149.3C672,149,768,203,864,197.3C960,192,1056,128,1152,96C1248,64,1344,64,1392,64L1440,64L1440,0L1392,0C1344,0,1248,0,1152,0C1056,0,960,0,864,0C768,0,672,0,576,0C480,0,384,0,288,0C192,0,96,0,48,0L0,0Z"
          ></path>
        </svg>
        <Container>
          <Row className="align-items-center">
            <Col md={6}>
              <h2>App is still under development to acquire new features.</h2>
            </Col>
            <Col md={6}>
              <img
                className="img-fluid"
                src="https://assets.website-files.com/60ccf137433c7c8fdfadedfe/60db7a669d70fb3549bca0b3_Artificial%20intelligence_Flatline.svg"
                alt="Something went wrong"
              />
            </Col>
          </Row>
        </Container>
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320">
          <path
            fill="#fff"
            fillOpacity="1"
            d="M0,224L48,218.7C96,213,192,203,288,213.3C384,224,480,256,576,229.3C672,203,768,117,864,112C960,107,1056,181,1152,192C1248,203,1344,149,1392,122.7L1440,96L1440,320L1392,320C1344,320,1248,320,1152,320C1056,320,960,320,864,320C768,320,672,320,576,320C480,320,384,320,288,320C192,320,96,320,48,320L0,320Z"
          ></path>
        </svg>
      </section>

      <section className="contact-us">
        <Container>
          <Row className="align-items-center">
            <Col md={6}>
              <img
                className="img-fluid"
                src="https://image.freepik.com/free-vector/contact-us-concept-illustration_114360-2299.jpg"
                alt="Something went wrong"
              />
            </Col>
            <Col md={6}>
              <h1>Contact us</h1>
              <Form>
                <Form.Group
                  className="mb-3"
                  controlId="exampleForm.ControlInput1"
                >
                  <Form.Label>Email address</Form.Label>
                  <Form.Control type="email" placeholder="name@example.com" />
                </Form.Group>
                <Form.Group
                  className="mb-3"
                  controlId="exampleForm.ControlTextarea1"
                >
                  <Form.Label>Example textarea</Form.Label>
                  <Form.Control as="textarea" rows={3} />
                </Form.Group>
              </Form>
              <button
                type="button"
                className="mb-2 btn btn-outline-secondary float-end"
              >
                Submit
              </button>
            </Col>
          </Row>
        </Container>
      </section>

      <footer className="gradient page-footer">
        <Container fluid className="text-center">
          Made by
          <a
            className="page-footer"
            href="https://www.linkedin.com/in/nishant-singh-362a70201/"
          >
            <strong>Nishant Singh</strong>
          </a>
        </Container>
      </footer>
    </div>
  );
}
