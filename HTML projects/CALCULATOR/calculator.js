let chk = document.getElementById('chk');

chk.addEventListener('change', () => {
    document.body.classList.toggle('dark');
});

let inp = document.getElementById('input');
let out = document.getElementById('output');

function calculate(data){
    
    switch (data){
        case 'AC' :
            inp.innerHTML = "";
            out.innerHTML = 0;
            break;
        case 'C' :
            inp.innerHTML = inp.innerHTML.substr(0,inp.innerHTML.length-1);
            out.innerHTML = math.evaluate(inp.innerHTML) === undefined ? 0 :  math.evaluate(inp.innerHTML);
            break;
        case '=': 
            out.innerHTML = math.evaluate(inp.innerHTML);
            break;
        default:
            inp.innerHTML += data;
    }

}