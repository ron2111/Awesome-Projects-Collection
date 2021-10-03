const boxes = document.querySelectorAll(".box");

window.addEventListener("scroll", scrollShow);

function scrollShow(){
    const endpoint = (4*window.innerHeight)/5 ;

    boxes.forEach(box => {
        const boxEndpoint = box.getBoundingClientRect().top;

        if (boxEndpoint < endpoint){
            box.classList.add("active");
        }
        else{
            box.classList.remove("active")
        }
    })
    
    
}

console.log("This is ", this.scrollX)