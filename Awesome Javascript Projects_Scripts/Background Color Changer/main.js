// Colors that will be visible when Triggered !!

let colors = ["blue", "green", "red", "orange"];

//get Button
let button = document.getElementById("button");

button.addEventListener("click", function () {
  var randomColor = colors[Math.floor(Math.random() * colors.length)];

  let container = document.getElementById("container");

  container.style.background = randomColor;
});
