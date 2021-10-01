var screen = document.getElementById("screen");
var symbols = ['+', '-', '×', '÷'];

function calculate(mathStr) {
  mathStr = mathStr.replaceAll("×", "*");
  mathStr = mathStr.replaceAll("÷", "/");

  var ans = "Error";
  try {
    ans = new Function('return ' + mathStr)();
  } catch(err) { }
  return ans;
}

function enterText(element) {
  var variable = element.innerText;
  var screenInp = screen.value;

  if (variable === "=") {
    screen.value = calculate(screenInp);
  } else if (variable === "C") {
    screen.value = "";
  } else if (screenInp === "Infinity") {
    screen.value = variable;
  } else {
    if(symbols.includes(variable) && symbols.includes(screenInp.charAt(screenInp.length - 1))) {
      screen.value = screenInp.slice(0, -1) + variable;
    } else
    screen.value = screenInp + variable;
  }
}
