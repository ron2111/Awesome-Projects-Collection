function ID(id) {
  return document.getElementById(id);
}

function clss(id) {
  return document.getElementsByClassName(id);
}

function inner(id, thingy) {
  ID(id).innerHTML = thingy;
}

function style(id, thingy, state) {
  ID(id).style[thingy] = state;
}

let chess = {
  states: {
    // states that have to be kept track of during game
    player: "white",
    stateOfBoard: "waitingForPlayer", // 1) waiting for player 2) player clicked square 3) gameover
    isWhiteChecked: false,
    didWhiteKingMoved: false,
    didWhiteRookAMoved: false,
    didWhiteRookBMoved: false,
    isBlackChecked: false,
    didBlackKingMoved: false,
    didBlackRookAMoved: false,
    didBlackRookBMoved: false,
    savedMoves: [],
    oldIndexOfPiece: null,
    highlightedIndexes: [],
    state: [],
  },

  action: {
    // methods needed for gameplay (data modification and logic, not html)
    clickPiece: function (index) {
      let row = Math.floor(9 - (64 - index) / 8);
      let col = 1 + (index % 8);
      // console.log(`index: ${index}, row: ${row}, column: ${col}`);
      //1. check if index contains piece
      // ALL OF THIS WILL FIRE IF chess.states.stateOfBoard == waiting for player;
      // in ither casese handling will be different
      if (chess.states.stateOfBoard == "waitingForPlayer") {
        if (chess.states.state[index].piece == null) {
          return;
        }

        //2. check all the possible moves with this.possibleMoves()
        if (this.possibleMoves(index)) {
          this.highlightPossibleMoves(index, this.possibleMoves(index));
          chess.states.oldIndexOfPiece = index;
          chess.states.stateOfBoard = "playerClickedSquare";
        } else if (true) {
          //no moves AND king is not checked -> draw
        } else {
          //no moves AND king is checked -> lose game
        }
        //3. if player owns the piece (color!), let player move on to this.movePiece() via...
        //4. ...via highlighting possible moves on board using this.highlightPossibleMoves()
        //4. --> this.highlightPossibleMoves()
        //5. chess.states.stateOfBoard = player cliked square
      } else if (chess.states.stateOfBoard == "playerClickedSquare") {
        // player already clicked valid piece
        if (chess.states.highlightedIndexes.includes(index)) {
          this.movePiece(index);
        } else if (chess.states.oldIndexOfPiece == index) {
          chess.states.stateOfBoard = "waitingForPlayer";
          for (let i = 0; i < 64; i++) {
            clss("square")[i].style.backgroundColor =
              parseInt(i / 8 + i) % 2 == 0 ? "#fff" : "rgb(180, 180, 180)";
            clss("square")[i].style.webkitBoxShadow = null;
          }
          chess.states.highlightedIndexes = [];
        } else {
          for (let i = 0; i < 64; i++) {
            clss("square")[i].style.backgroundColor =
              parseInt(i / 8 + i) % 2 == 0 ? "#fff" : "rgb(180, 180, 180)";
            clss("square")[i].style.webkitBoxShadow = null;
          }
          chess.states.highlightedIndexes = [];
          this.highlightPossibleMoves(index, this.possibleMoves(index));
          chess.states.oldIndexOfPiece = index;
        }
      }
    },
    possibleMoves: function (index) {
      //1. using index checks chess.states.state to get piece and color
      let piece = chess.states.state[index].piece;
      let color = chess.states.state[index].color;
      //2. checks all possible moves for piece
      //2.1 return all results of functions for piece movement that are within <0,63>
      let possibleMovesArray = this.pieceMovement(piece, color, index);
      let tempArray = [];

      // remove all the moves from the possibleMovesArray, that would highlight player's own pieces
      for (let i = 0; i < possibleMovesArray.length; i++) {
        if (
          chess.states.state[possibleMovesArray[i]].color != chess.states.player
        ) {
          tempArray.push(possibleMovesArray[i]);
        }
      }
      possibleMovesArray = tempArray;

      //2.2 checks if player is checked - if yes, then return movements...
      // ...that result in resolving check; if there is none, its game over
      //3. returns ARRAY with possible moves for the PIECE in the SQUARE
      if (color == chess.states.player) {
        // return possible moves for the piece if the piece is owned by current player
        return possibleMovesArray;
      }
    },
    highlightPossibleMoves: function (index, moves) {
      if (moves.length > 0) {
        console.log(
          `possible moves for ${chess.states.player} on square ${index} are ${moves}`
        );
      }
      if (!moves) {
        return;
      }
      for (let i = 0; i < moves.length; i++) {
        clss("square")[moves[i]].style.webkitBoxShadow = "inset 0 0 65px green";
        clss("square")[moves[i]].style.backgroundColor = "white";
        chess.states.highlightedIndexes.push(moves[i]);
      }
      clss("square")[index].style.webkitBoxShadow = "inset 0 0 7px 2px black";
      clss("square")[index].style.backgroundColor = "lightgreen";
      //1. adds current index to chess.states.highlightedIndexes for future saving
      //2. highlights possible moves on board and waits for player to move/cancel
      //3a. if player cancels, turns off highlight of possible moves and gets back to state before clickPiece()
      //3b. if player clicks on possible square, it moves piece to that square using this.movePiece()
      //4. --> this.movePiece()
    },
    movePiece: function (index) {
      //1. moves piece from one square to another in chess.states.state
      chess.states.state[index] =
        chess.states.state[chess.states.oldIndexOfPiece];
      chess.states.state[chess.states.oldIndexOfPiece] = {
        piece: null,
        color: null,
      };
      //2. chess.render.update() to render current (after move) board
      chess.render.update();
      //3. saves move from chess.states.highlightedIndexes in chess.states.savedMoves
      //4. chess.states.highlightedIndexes = []
      chess.states.highlightedIndexes = [];
      chess.states.stateOfBoard = "waitingForPlayer";
      chess.states.player = chess.states.player == "white" ? "black" : "white";
      for (let i = 0; i < 64; i++) {
        clss("square")[i].style.backgroundColor =
          parseInt(i / 8 + i) % 2 == 0 ? "#fff" : "rgb(180, 180, 180)";
        clss("square")[i].style.webkitBoxShadow = null;
      }
      console.log(`player ${chess.states.player} moved to ${index}`);
    },
    undoMove: function () {
      //?. chess.states.savedMoves is an array in form [[index, index, oldPiece], [index, index, oldPiece], ...]
      //?. every inner array in ...savedMoves is [oldIndexOfPiece, newIndexOfPiece, oldPiece]
      //1. if there were no moves, return
      //2. move value in chess.states.state [old, new, oldPiece] -> value from NEW to OLD;
      //2b. value of NEW = oldPiece
      //3. chess.states.savedMoves.pop()
      //3. chess.render.update()
    },
    pieceMovement: function (piece, color, index) {
      let resultArray = [];
      let moves = [];

      if (piece == "pawn") {
        let whitePawnsFirstRow = [48, 49, 50, 51, 52, 53, 54, 55];
        let blackPawnsFirstRow = [8, 9, 10, 11, 12, 13, 14, 15];
        if (color == "white") {
          whitePawnsFirstRow.includes(index) ? moves.push(-16) : null;
          moves.push(-8);
        } else {
          blackPawnsFirstRow.includes(index) ? moves.push(16) : null;
          moves.push(8);
        }
      } else if (piece == "knight") {
        let firstVectorRows = [-2, 2];
        let firstVectorCols = [-16, 16];
        let row = Math.floor(9 - (64 - index) / 8);
        let col = 1 + (index % 8);
        for (let i = 0; i < 2; i++) {
          if (Math.floor(9 - (64 - (index + firstVectorRows[i])) / 8) == row) {
            moves.push(firstVectorRows[i] + 8);
            moves.push(firstVectorRows[i] - 8);
          }
          if (1 + ((index + firstVectorCols[i]) % 8) == col) {
            moves.push(firstVectorCols[i] + 1);
            moves.push(firstVectorCols[i] - 1);
          }
        }
      } else if (piece == "king") {
        let kingMoves = [-9, -8, -7, -1, 1, 7, 8, 9];
        for (let i = 0; i < kingMoves.length; i++) {
          moves.push(kingMoves[i]);
        }
      } else if (piece == "queen") {
        let quinnMoves = [-9, -8, -7, -1, 1, 7, 8, 9];
        for (let i = 0; i < quinnMoves.length; i++) {
          moves.push(quinnMoves[i]);
        }
      } else if (piece == "rook") {
        let rookMoves = [-8, -1, 1, 8];
        for (let i = 0; i < rookMoves.length; i++) {
          moves.push(rookMoves[i]);
        }
      } else if (piece == "bishop") {
        let bishopMoves = [-9, -7, 7, 9];
        for (let i = 0; i < bishopMoves.length; i++) {
          moves.push(bishopMoves[i]);
        }
      }

      // no -kings -knights -pawn are getting loop for more than one move in direction, or special move(knight)

      for (let i = 0; i < moves.length; i++) {
        if (piece == "king" || piece == "knight" || piece == "pawn") {
          resultArray.push(index + moves[i]);
        }
        if (piece == "queen" || piece == "rook" || piece == "bishop") {
          // make it so queens, rooks and bishops move more than 1 v
          resultArray.push(index + moves[i]);
          //1 run standard king-like possible moves
          //2 every possible square from step one needs to simulate itself again, but from step 1 result squares
        }
      }

      //cut the ones that are duplicated

      //cut the ones that are not on board
      for (let i = 0; i < resultArray.length; i++) {
        if (resultArray[i] > 63 || resultArray[i] < 0) {
          resultArray.splice(i, 1);
          i -= 1;
        }
      }

      return resultArray;
    },
  },

  render: {
    // methods used to display data in html
    initializeHTML: function () {
      // .initialize() prepares starting board

      // 1. html menu schemat
      let data =
        '<div class="container">' +
        '<div class="menu-button" onclick="chess.render.menu()">&#9776;</div>' +
        '<div class="menu">' +
        '<div class="menu-cover"></div>' +
        '<div class="menu-elements">' +
        '<button onclick="chess.action.undoMove()">undo</button><br>' +
        '<button onclick="chess.render.initializeData()">new game</button><br>' +
        '<button onclick="chess.render.menu()">close menu</button><br>' +
        '</div></div></div><div class="board">';
      for (let i = 0; i < 64; i++) {
        data += '<div class="square"><div class="square-inside"></div></div>';
      }
      data += "</div></div>";

      // 2. line below sets entire html structure ready
      document.body.innerHTML = "";
      document.body.innerHTML = data;

      // 3. style for board squares
      for (let i = 0; i < 64; i++) {
        clss("square")[i].style.backgroundColor =
          parseInt(i / 8 + i) % 2 == 0 ? "#fff" : "rgb(180, 180, 180)";
      }
    },

    initializeData: function () {
      // 4. clear and create new chess.states.state array to keep track of pieces positions
      chess.states.state = [];
      for (let i = 0; i < 64; i++) {
        chess.states.state.push({
          piece: null,
          color: null,
        });
      }

      // 5. fill chess.states.state with pieces in starting position:
      let namesOfPieces = ["king", "queen", "rook", "bishop", "knight", "pawn"];
      let whitePositions = [
        [60], //king
        [59], //queen
        [56, 63], //rooks
        [58, 61], //bishops
        [57, 62], //knights
        [48, 49, 50, 51, 52, 53, 54, 55], //pawns
      ];
      let blackPositions = [
        [4], //king
        [3], //queen
        [0, 7], //rooks
        [2, 5], //bishops
        [1, 6], //knights
        [8, 9, 10, 11, 12, 13, 14, 15], //pawns
      ];

      for (let i = 0; i < 6; i++) {
        // whitePositions[i].length is the same as blackPositions[i].length
        for (let j = 0; j < whitePositions[i].length; j++) {
          chess.states.state[whitePositions[i][j]] = {
            piece: namesOfPieces[i],
            color: "white",
          };
          chess.states.state[blackPositions[i][j]] = {
            piece: namesOfPieces[i],
            color: "black",
          };
        }
      }
      for (let i = 0; i < 64; i++) {
        clss("square")[i].style.backgroundColor =
          parseInt(i / 8 + i) % 2 == 0 ? "#fff" : "rgb(180, 180, 180)";
        clss("square")[i].style.webkitBoxShadow = null;
      }
      chess.render.update();
      chess.states.player = "white";
      clss("menu")[0].style.display = "none";
      clss("menu-button")[0].style.display = "block";
    },

    update: function () {
      // updates HTML chess board with the values of pieces from chess.states.state
      for (let i = 0; i < 64; i++) {
        let piece;
        let square = chess.states.state[i];
        if (square.piece == null) {
          piece = "";
        } else if (square.piece == "king") {
          piece = square.color == "white" ? "&#9812;" : "&#9818;";
        } else if (square.piece == "queen") {
          piece = square.color == "white" ? "&#9813;" : "&#9819;";
        } else if (square.piece == "rook") {
          piece = square.color == "white" ? "&#9814;" : "&#9820;";
        } else if (square.piece == "bishop") {
          piece = square.color == "white" ? "&#9815;" : "&#9821;";
        } else if (square.piece == "knight") {
          piece = square.color == "white" ? "&#9816;" : "&#9822;";
        } else if (square.piece == "pawn") {
          piece = square.color == "white" ? "&#9817;" : "&#9823;";
        }
        clss("square-inside")[i].innerHTML = piece;
      }
    },

    menu: function () {
      let menu = clss("menu")[0].style;
      let menuButton = clss("menu-button")[0].style;
      menu.display == "none"
        ? ((menu.display = "block"), (menuButton.display = "none"))
        : ((menu.display = "none"), (menuButton.display = "block"));
    },
  },
};

chess.render.initializeHTML();
chess.render.initializeData();

// every square onmousedown event handler
for (let i = 0; i < clss("square").length; i++) {
  clss("square")[i].onmousedown = function () {
    chess.action.clickPiece(i);
  };
}
chess.render.update();
