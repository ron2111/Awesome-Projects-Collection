// import Typed from "typed.js";
$(document).ready(function () {
  var typed = new Typed(".typed", {
    strings: ["UI/UX Designer", "Web Developer", "Learning DSA"],
    smartBackspace: true, // Default value
    typeSpeed: 40,
    backSpeed: 40,
    loop: true,
  });
});

AOS.init();

// You can also pass an optional settings object
// below listed default settings
AOS.init({
  // Global settings:
  offset: 300,
  durattion: 2000,
});
