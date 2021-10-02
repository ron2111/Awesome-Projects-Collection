document.addEventListener('DOMContentLoaded', () => {

    const grid = document.querySelector(".grid");
    const width = 8;
    let score = 0;

    const candies = [];

    const candyImages = [
        'url(assets/images/blue-candy.png)',
        'url(assets/images/green-candy.png)',
        'url(assets/images/orange-candy.png)',
        'url(assets/images/purple-candy.png)',
        'url(assets/images/red-candy.png)',
        'url(assets/images/yellow-candy.png)'
    ];

    function createBoard() {

        for (let i = 0; i < width * width; i++) {
            let candy = document.createElement("div");

            candy.setAttribute('draggable', true);
            candy.setAttribute('id', i);

            let randomColorIndex = Math.floor(Math.random() * candyImages.length);
            candy.style.backgroundImage = candyImages[randomColorIndex];
            grid.appendChild(candy);
            candies.push(candy);
        }
    }
    createBoard();

    let imageBeingDragged;
    let candyBeingDragged;

    let imageBeingReplaced;
    let candyBeingReplaced;

    candies.forEach(candy => candy.addEventListener("dragstart", dragStart));
    candies.forEach(candy => candy.addEventListener("dragend", dragEnd));
    candies.forEach(candy => candy.addEventListener("dragleave", dragLeave));
    candies.forEach(candy => candy.addEventListener("drop", dragDrop));
    candies.forEach(candy => candy.addEventListener("dragenter", function (e) {
        e.preventDefault();
    }));
    candies.forEach(candy => candy.addEventListener("dragover", function (e) {
        e.preventDefault();
    }));

    document.getElementById("save_button").addEventListener('click', saveGame);

    function saveGame() {

        let candiesInfo = [];

        candies.forEach(candy => candiesInfo[candy.id] = candy.style.backgroundImage);
        localStorage.setItem("board", JSON.stringify(candiesInfo));
    }

    function loadGame() {

        let oldBoard = JSON.parse(localStorage.getItem("Board"));
    }


    function dragStart() {
        imageBeingDragged = this.style.backgroundImage;
        candyBeingDragged = parseInt(this.id);
    }


    function dragLeave() {
        //console.log(this.id, "DragLeave");
    }


    function dragDrop() {
        imageBeingReplaced = this.style.backgroundImage;
        candyBeingReplaced = parseInt(this.id);
        //console.log(imageBeingReplaced, candyBeingReplaced);

        this.style.backgroundImage = imageBeingDragged;

        candies[candyBeingDragged].style.backgroundImage = imageBeingReplaced;
    }

    function dragEnd() {

        let validMoves = [
            candyBeingDragged + 1,
            candyBeingDragged - 1,
            candyBeingDragged + width,
            candyBeingDragged - width
        ];

        //console.log(candyBeingReplaced, "In Drag End");

        const isValidMove = validMoves.includes(candyBeingReplaced);

        if (candyBeingReplaced && isValidMove) {
            candyBeingReplaced = null;
            candyBeingDragged = null;
            imageBeingReplaced = null;
            imageBeingDragged = null;
        }
        else if (candyBeingReplaced && !isValidMove) {
            candies[candyBeingDragged].style.backgroundImage = imageBeingDragged;
            candies[candyBeingReplaced].style.backgroundImage = imageBeingReplaced;
        }
    }

    function generateRandomCandies() {
        for (let i = 0; i <= width * (width - 1) - 1; i++) {
            if (candies[i + width].style.backgroundImage === "") {
                candies[i + width].style.backgroundImage = candies[i].style.backgroundImage;
                candies[i].style.backgroundImage = "";
            }

            if (i < width && candies[i].style.backgroundImage === '') {
                candies[i].style.backgroundImage = candyImages[Math.floor(Math.random() * candyImages.length)];
            }
        }

    }

    generateRandomCandies();

    function checkRowForThree() {

        let invalidIndex = [];

        for (let i = width - 2; i < width * width - 3; i += width) {
            invalidIndex.push(i, i + 1);
        }

        for (let i = 0; i <= width * width - 3; i++) {
            let threeCandies = [i, i + 1, i + 2];
            let desiredImage = candies[i].style.backgroundImage;

            if (invalidIndex.includes(i)) continue;

            let match = threeCandies.every(index => desiredImage != "" && candies[index].style.backgroundImage == desiredImage);
            if (match) {
                score += 3;
                console.log(score);
                threeCandies.forEach(index => candies[index].style.backgroundImage = "");
            }

        }
    }
    checkRowForThree();


    function checkColumnForThree() {

        let len = width * (width - 2) - 1;

        for (let i = 0; i <= len; i++) {
            let threeCandies = [i, i + width, i + width * 2];
            let desiredImage = candies[i].style.backgroundImage;

            let match = threeCandies.every(index => desiredImage != "" && candies[index].style.backgroundImage == desiredImage);
            if (match) {
                score += 3;
                console.log(score);
                threeCandies.forEach(index => candies[index].style.backgroundImage = "");
            }

        }
    }
    checkColumnForThree();

    function checkRowForFour() {

        let invalidIndex = [];

        for (let i = width - 3; i < width * width - 4; i += width) {
            invalidIndex.push(i, i + 1, i + 2);
        }

        for (let i = 0; i <= width * width - 4; i++) {
            let fourCandies = [i, i + 1, i + 2, i + 3];
            let desiredImage = candies[i].style.backgroundImage;

            if (invalidIndex.includes(i)) continue;

            let match = fourCandies.every(index => desiredImage != "" && candies[index].style.backgroundImage == desiredImage);
            if (match) {
                score += 4;
                console.log(score);
                fourCandies.forEach(index => candies[index].style.backgroundImage = "");
            }

        }
    }
    checkRowForFour();


    function checkColumnForFour() {

        let len = width * (width - 3) - 1;

        for (let i = 0; i <= len; i++) {
            let fourCandies = [i, i + width, i + width * 2, i + width * 3];
            let desiredImage = candies[i].style.backgroundImage;

            let match = fourCandies.every(index => desiredImage != "" && candies[index].style.backgroundImage == desiredImage);
            if (match) {
                score += 4;
                console.log(score);
                fourCandies.forEach(index => candies[index].style.backgroundImage = "");
            }

        }
    }
    checkColumnForFour();


    function checkRowForFive() {

        let invalidIndex = [];

        for (let i = width - 4; i < width * width - 5; i += width) {
            invalidIndex.push(i, i + 1, i + 2, i + 3);
        }

        for (let i = 0; i <= width * width - 5; i++) {
            let fiveCandies = [i, i + 1, i + 2, i + 3, i + 4];
            let desiredImage = candies[i].style.backgroundImage;

            if (invalidIndex.includes(i)) continue;

            let match = fiveCandies.every(index => desiredImage != "" && candies[index].style.backgroundImage == desiredImage);
            if (match) {
                score += 5;
                console.log(score);
                fiveCandies.forEach(index => candies[index].style.backgroundImage = "");
            }

        }
    }
    checkRowForFive();



    function checkColumnForFive() {

        let len = width * (width - 4) - 1;

        for (let i = 0; i <= len; i++) {
            let fiveCandies = [i, i + width, i + width * 2, i + width * 3, i + width * 4];
            let desiredImage = candies[i].style.backgroundImage;

            let match = fiveCandies.every(index => desiredImage != "" && candies[index].style.backgroundImage == desiredImage);
            if (match) {
                score += 5;
                console.log(score);
                fiveCandies.forEach(index => candies[index].style.backgroundImage = "");
            }

        }
    }
    checkColumnForFive();

    function init() {
        checkColumnForFive();
        checkColumnForFour();
        checkColumnForThree();
        checkRowForFive();
        checkRowForFour();
        checkRowForThree();
        generateRandomCandies();

    }

    window.setInterval(function () {
        init();
    }, 500);

});