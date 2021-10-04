#include <iostream>
#include <vector>
#include <algorithm>
#include <ctime>
#include <cstdlib>
#include <random>
#include <windows.h>
#define MINE '*';
#define HIDDEN '#';
#define UP 'w';
#define LEFT 'a';
#define DOWN 's';
#define RIGHT 'd';
#define USER_POS '$';
#define FLAG 'F';
using namespace std;

struct colors_t{
    HANDLE hstdout;
    int initial_colors;

    colors_t(){
        hstdout = GetStdHandle(STD_OUTPUT_HANDLE);
        initial_colors = getcolors();
    }

    ~colors_t(){
        setcolors( initial_colors );
    }

    int getcolors() const{
        CONSOLE_SCREEN_BUFFER_INFO csbi;
        GetConsoleScreenBufferInfo( hstdout, &csbi );
        return csbi.wAttributes;
    }

    void setcolors(int color){
        SetConsoleTextAttribute(hstdout, color);
    }

    void setfg(int color){
        int current_colors = getcolors();
        setcolors((current_colors & 0xF0)|(color & 0x0F));
    }

    void setbg( int color ){
        int current_colors = getcolors();
        setcolors(((color & 0x0F) << 4)|(current_colors & 0x0F));
    }

    int getfg() const { 
        return getcolors() & 0x0F; 
    }

    int getbg() const {
        return (getcolors() >> 4) & 0x0F;
    }

};

enum {
  black,
  dark_blue,
  dark_green,
  dark_cyan,
  dark_red,
  dark_magenta,
  dark_yellow,
  light_gray,
  dark_gray,
  light_blue,
  light_green,
  light_cyan,
  light_red,
  light_magenta,
  light_yellow,
  white
};

int rows = 9, cols = 9, mines = 10;
bool gameOver = false;
char board[100][100];
char playBoard[100][100];
bool revealedBoard[100][100];
bool flagBoard[100][100];
int playRow = 0, playCol = 0;

void printBoard(){
    colors_t colors;
    for(int i = 0; i < rows; i++){
        cout << "---------------------------\n";
        for(int j = 0; j < cols; j++){
            if(playBoard[i][j] == '#'){
                cout << "|" << playBoard[i][j] << "|";
            }else if(playBoard[i][j] == '1'){
                colors.setfg(dark_blue);
                cout << "|" << playBoard[i][j] << "|";
                colors.setcolors( colors.initial_colors );
            }else if(playBoard[i][j] == '2'){
                colors.setfg(dark_green);
                cout << "|" << playBoard[i][j] << "|";
                colors.setcolors( colors.initial_colors );
            }else if(playBoard[i][j] == '3'){
                colors.setfg(dark_red);
                cout << "|" << playBoard[i][j] << "|";
                colors.setcolors( colors.initial_colors );
            }else if(playBoard[i][j] == '0'){
                colors.setfg(white);
                cout << "|" << playBoard[i][j] << "|";
                colors.setcolors( colors.initial_colors );
            }else if(playBoard[i][j] == '$'){
                colors.setfg(dark_yellow);
                cout << "|" << playBoard[i][j] << "|";
                colors.setcolors( colors.initial_colors );
            }else if(playBoard[i][j] == 'F'){
                colors.setfg(dark_magenta);
                cout << "|" << playBoard[i][j] << "|";
                colors.setcolors( colors.initial_colors );
            }else{
                cout << "|" << playBoard[i][j] << "|";
            }
        }
        cout << "\n";
    }
}

void initMines(){
    vector< pair< int, int > > positions;
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
            positions.push_back(make_pair(i, j));
        }
    }
    shuffle(positions.begin(), positions.end(), default_random_engine(time(0)));
    for(int i = 0; i < mines; i++){
        board[positions[i].first][positions[i].second] = MINE;
    }
}

bool isValid(int x, int y){
    return ((x >= 0 && x < rows) && (y >= 0 && y < cols));
}

int neighborMines(int x, int y){
    int numMines = 0;
    for(int xOffset = -1; xOffset <= 1; xOffset++){
        for(int yOffset = -1; yOffset <= 1; yOffset++){
            int neighborX = x + xOffset;
            int neighborY = y + yOffset;
            if(isValid(neighborX, neighborY) && (board[neighborX][neighborY] == '*')){
                numMines++;
            }
        }
    }
    return numMines;
}

void initBoard(){
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
            board[i][j] = playBoard[i][j] = HIDDEN;
        }
    }
    initMines();
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
            if(board[i][j] != '*'){
                board[i][j] = neighborMines(i, j) + '0';
            }
        }
    }
}

void triggerPress(int x, int y){
    if(revealedBoard[x][y]){
        return;
    }
    if(board[x][y] == '*'){
        gameOver = true;
        cout << "Game Over! :(\n";
        colors_t colors;
        for(int i = 0; i < rows; i++){
            cout << "---------------------------\n";
            for(int j = 0; j < cols; j++){
                if(board[i][j] == '*'){
                    colors.setfg(light_red);
                    cout << "|*|";
                    colors.setcolors( colors.initial_colors );
                }else{
                    if(playBoard[i][j] == '#'){
                        cout << "|" << playBoard[i][j] << "|";
                    }else if(playBoard[i][j] == '1'){
                        colors.setfg(dark_blue);
                        cout << "|" << playBoard[i][j] << "|";
                        colors.setcolors( colors.initial_colors );
                    }else if(playBoard[i][j] == '2'){
                        colors.setfg(dark_green);
                        cout << "|" << playBoard[i][j] << "|";
                        colors.setcolors( colors.initial_colors );
                    }else if(playBoard[i][j] == '3'){
                        colors.setfg(dark_red);
                        cout << "|" << playBoard[i][j] << "|";
                        colors.setcolors( colors.initial_colors );
                    }else if(playBoard[i][j] == '0'){
                        colors.setfg(white);
                        cout << "|" << playBoard[i][j] << "|";
                        colors.setcolors( colors.initial_colors );
                    }else if(playBoard[i][j] == '$'){
                        colors.setfg(dark_yellow);
                        cout << "|" << playBoard[i][j] << "|";
                        colors.setcolors( colors.initial_colors );
                    }else if(playBoard[i][j] == 'F'){
                        colors.setfg(dark_magenta);
                        cout << "|" << playBoard[i][j] << "|";
                        colors.setcolors( colors.initial_colors );
                    }else{
                        cout << "|" << playBoard[i][j] << "|";
                    }
                }
            }
            cout << endl;
        }
        Sleep(10000);
        return;
    }else{
        revealedBoard[x][y] = true;
        playBoard[x][y] = board[x][y];
        if(playBoard[x][y] == '0'){
            for(int xOffset = -1; xOffset <= 1; xOffset++){
                for(int yOffset = -1; yOffset <= 1; yOffset++){
                    int neighborX = x + xOffset;
                    int neighborY = y + yOffset;
                    if(isValid(neighborX, neighborY)){
                        triggerPress(neighborX, neighborY);
                    }
                }
            }
        }
    }
}

void toggleFlag(int x, int y){
    if(revealedBoard[x][y]){
        return;
    }
    if(!flagBoard[x][y]){
        flagBoard[x][y] = true;
        playBoard[x][y] = FLAG;
    }else{
        flagBoard[x][y] = false;
        playBoard[x][y] = HIDDEN;
    }
}

void processCommand(char command){
    int nextRow = playRow, nextCol = playCol;
    if(command == 'w'){
        nextRow--;
    }else if(command == 'a'){
        nextCol--;
    }else if(command == 's'){
        nextRow++;
    }else if(command == 'd'){
        nextCol++;
    }
    if(!isValid(nextRow, nextCol)){
        return;
    }
    if(!revealedBoard[playRow][playCol]){
        if(flagBoard[playRow][playCol]){
            playBoard[playRow][playCol] = FLAG;
        }else{
            playBoard[playRow][playCol] = HIDDEN;
        }
    }else{
        playBoard[playRow][playCol] = board[playRow][playCol];
    }
    playRow = nextRow;
    playCol = nextCol;
    playBoard[playRow][playCol] = USER_POS;
    if(command == 'p'){
        triggerPress(playRow, playCol);
    }
    if(command == 'f'){
        toggleFlag(playRow, playCol);
    }
}

void startGame(){
    playRow = playCol = 0;
    gameOver = false;
    initBoard();
    playBoard[playRow][playCol] = USER_POS;
}

bool checkGameFinished(){
    if(gameOver){
        return gameOver;
    }
    int coveredMines = 0;
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
           coveredMines += 1 - revealedBoard[i][j];
        }
    }
    if(coveredMines == mines){
        cout << "Congratulations!\nYou won the game!";
        return true;
    }
    return false;
}

int main(){
    cout << "Welcome to Minesweeper! :) - By NAMAN MALHOTRA\n";
    int difficultyLevel;
    cout << "Choose a Difficulty Level! :O\n";
    cout << "Press 1 - For Beginners!\n";
    cout << "Press 2 - For Experienced!\n";
    cout << "Press 3 - For Veterans!\n";
    cin >> difficultyLevel;
    switch(difficultyLevel){
        case 1:
            rows = 9;
            cols = 9;
            mines = 10;
            break;
        case 2:
            rows = 16;
            cols = 16;
            mines = 40;
            break;
        case 3:
            rows = 16;
            cols = 30;
            mines = 99;
            break;    
    }
    startGame();
    while(!gameOver){
        printBoard();
        char command;
        cout << "Input command: ";
        cin >> command;
        processCommand(command);
        gameOver = checkGameFinished();
    }
    return 0;
}