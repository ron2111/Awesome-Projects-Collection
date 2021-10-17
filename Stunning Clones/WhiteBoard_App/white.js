const canvas = document.getElementById("canvas");
canvas.width = window.innerWidth - 330;
canvas.height = 640;

var toolSelect = document.getElementById('dtool');

var brush = {};
brush.shape = 'round';
brush.size = 3;

function setBrush(type) {
  switch (type) {
    case 'pencil':
      brush.shape = 'round';
      brush.size = 1;
      break;
    case 'square':
      brush.shape = 'square';
      brush.size = 8;
      break;

    case 'flat':
      brush.shape = 'flat';
      brush.size = 14;
      break;
  }
}


let context = canvas.getContext("2d");
context.fillStyle = "white";
context.fillRect(0, 0, canvas.width, canvas.height);

let draw_color = "white";
let is_drawing = false;

let restore_array = [];
let index = -1;

function change_color(element) {
  draw_color = element.style.background;
}


canvas.addEventListener("touchstart" , start, false);
canvas.addEventListener("touchmove" , draw, false);
canvas.addEventListener("mousedown" , start, false);
canvas.addEventListener("mousemove" , draw, false);


canvas.addEventListener("touchend" , stop, false);
canvas.addEventListener("mouseup" , stop, false);
canvas.addEventListener("mouseout" , stop, false);

function start(event) {
    is_drawing = true;
    context.beginPath();
    context.moveTo(event.clientX - canvas.offsetLeft,
                   event.clientY - canvas.offsetTop);
    event.preventDefault();
  }
  
function draw(event) {
    if (is_drawing) {
      context.lineTo(event.clientX - canvas.offsetLeft,
                     event.clientY - canvas.offsetTop);
      context.strokeStyle = draw_color;
      context.lineWidth = brush.size;
      context.lineCap = brush.shape;
      context.lineJoin = brush.shape;
      context.stroke();
    }
    event.preventDefault();
  }

  function stop(event) {
    if(is_drawing){
      context.stroke();
      context.closePath();
      is_drawing = false;
    }
    event.preventDefault();

    if ( event.type != 'mouseout'){
         restore_array.push(context.getImageData(0, 0, canvas.width, canvas.height));
         index += 1;
    }

  }

  function clear_canvas() {
    context.fillStyle = "white";
    context.clearRect(0, 0, canvas.width, canvas.height);
    context.fillRect(0, 0, canvas.width, canvas.height);

    restore_array=[];
    index=-1;
  }
  
  function undo_last() {
    if (index <= 0) {
      clear_canvas();
    } else {
        index -= 1;
        restore_array.pop();
        context.putImageData(restore_array[index], 0, 0);
    }
  }


  function rangeSlide(value) {
    document.getElementById('rangeValue').innerHTML = value;
}

