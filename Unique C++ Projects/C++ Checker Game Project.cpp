#include<iostream>
using namespace std;
#include<ctime>
int v1 = 8, v2 = 8;
int i, j, k;
int op1, op3, piece_row, piece_colum;
char op2;
bool b1 = false; // for player 1
bool b2 = false; // for player 2
int* p1 = new int; // for player 1
int* p2 = new int; // for player 2
int n1, n2;
char play1, play2;
void fill_mape(char**, int, int);
void make_board(char**);
void random_player(char**);
void player_1_turn(char**, int*, int*);
void player_2_turn(char**, int*, int*);
void player2_loss(int*, int*);
void player1_loss(int*, int*);
void game_manue(char**);
int main()
{
char** game_mape = new char* [v1];

for (i = 0; i < v1; i++)

{

    game_mape[i] = new char[v2];

}

fill_mape(game_mape, v1, v2);

game_manue(game_mape);
}
void game_manue(char** g_mape)
{
system("color 03");

system("cls");

cout << "\n\n\n\n\n\n\t\t\t\t\t\tGame Manue\n";

cout << "\n\t\t\t\t\t\  Opetion 1 : Start Game\n";

cout << "\n\t\t\t\t\t\  Opetion 2 : Palyre 1 Setting\n";

cout << "\n\t\t\t\t\t\  Opetion 3 : Palyre 2 Setting\n";

cout << "\n\t\t\t\t\t\  Opetion 4 : Exit \n";

cout << "\n\t\t\t\t\t\  Enter Opetion : ";

cin >> op1;

switch (op1)

{

case 1:

    random_player(g_mape);

    break;

case 2:

    cout << endl;

    system("cls");

    system("color 04");

    cout << "\n\t\t\t\t==========================================================\n";

    cout << "\n\t\t\t\t\t\t\tPalyer 1\n\n";

    cout << "\t\t\t\t---> There are 12 Pieces of Player 1\n\n";

    cout << "\t\t\t\t---> Piece 'A' and Capital 'K' are defined to Player 1\n\n";

    cout << "\t\t\t\t---> If you want to close the game during the game play\n\n";

    cout << "\t\t\t\t---> Then Enter the (Q or q)\n\n";

    cout << "\n\t\t\t\t==========================================================\n";

    cout << "\n\t\t\t\t\tBack to main manue (press B & b) : ";

    cin >> op2;

    if (op2 == 'B' || op2 == 'b')

    {

        main();

    }

    break;

case 3:

    cout << endl;

    system("color 06");

    system("cls");

    cout << "\n\t\t\t\t==========================================================\n";

    cout << "\n\t\t\t\t\t\t\tPalyer 2\n\n";

    cout << "\t\t\t\t---> There are 12 Pieces of Player 2\n\n";

    cout << "\t\t\t\t---> Piece 'B' and Small 'k' are defined to Player 2\n\n";

    cout << "\t\t\t\t---> If you want to close the game during the game play\n\n";

    cout << "\t\t\t\t---> Then Enter the (Q or q)\n\n";

    cout << "\n\t\t\t\t==========================================================\n";

    cout << "\n\t\t\t\t\tBack to main manue (press B & b) : ";

    cin >> op2;

    if (op2 == 'B' || op2 == 'b')

    {

        main();

    }

    break;

case 4:

    exit(-1);

}
}
void fill_mape(char** mape, int a1, int a2)
{
char arr1[8][8] = {

{'.','A','.','A','.','A','.','A'},

{'A','.','A','.','A','.','A','.'},

{'.','A','.','A','.','A','.','A'},

{'.','.','.','.','.','.','.','.'},

{'.','.','.','.','.','.','.','.'},

{'B','.','B','.','B','.','B','.'},

{'.','B','.','B','.','B','.','B'},

{'B','.','B','.','B','.','B','.'},

};

for (i = 0; i < v1; i++)

{

    for (j = 0; j < v2; j++)

    {

        mape[i][j] = arr1[i][j];

    }

}
}
void random_player(char** g_mape)
{
srand(time(0));

op3 = rand() % 2 + 1;

*p1 = 12;

*p2 = 12;

switch (op3)

{

case 1:

    player_1_turn(g_mape, p1, p2);

    break;

case 2:

    player_2_turn(g_mape, p1, p2);

    break;

}
}
void player_1_turn(char** gg_mape, int* num1, int* num2)
{
while (b1 == false)

{

    system("color 02");

    make_board(gg_mape);

    cout << "\t\t------------------PLAYER 1------------------\n";

    cout << "\t\t\tPlayer 1 Pieces remainig : " << *num1 << endl;

    cout << "\t\t\tPlayer 2 Pieces remainig : " << *num2 << endl;

    cout << "Enter the index number of a piece(Like Row and Colum) which you want to move\n";

    cout << "Row : ";

    cin >> piece_row;

    cout << "Colum : ";

    cin >> piece_colum;

    cout << endl;

    if (gg_mape[piece_row][piece_colum] == 'A')

    {

        cout << "Left for (L or l) and Right for (R or r) : ";

        cin >> play1;

        if (play1 == 'Q' || play1 == 'q')

        {

            break;

        }

        cout << endl;

        if (play1 == 'L' || play1 == 'l')  // Left

        {

            if (piece_row + 1 == 7)

            {

                if (gg_mape[piece_row + 1][piece_colum - 1] == '.')

                {

                    gg_mape[piece_row][piece_colum] = '.';

                    gg_mape[piece_row + 1][piece_colum - 1] = 'K';

                    b1 = true;

                }

            }

            else if (gg_mape[piece_row + 1][piece_colum - 1] == '.')

            {

                gg_mape[piece_row + 1][piece_colum - 1] = 'A';

                gg_mape[piece_row][piece_colum] = '.';

                b1 = true;

            }

            else if (gg_mape[piece_row + 1][piece_colum - 1] == 'A')

            {

                player_1_turn(gg_mape, num1, num2);

            }

            else if (gg_mape[piece_row + 1][piece_colum - 1] == 'K')

            {

                player_1_turn(gg_mape, num1, num2);

            }

            else if (gg_mape[piece_row + 1][piece_colum - 1] == 'B')

            {

                if (gg_mape[piece_row + 2][piece_colum - 2] == '.')

                {

                    if (piece_row + 2 == 7)

                    {

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row + 1][piece_colum - 1] = '.';

                        gg_mape[piece_row + 2][piece_colum - 2] = 'K';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                    else

                    {

                        gg_mape[piece_row + 2][piece_colum - 2] = 'A';

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row + 1][piece_colum - 1] = '.';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                }

                else

                {

                    player_1_turn(gg_mape, num1, num2);

                }

            }

            else if (gg_mape[piece_row + 1][piece_colum - 1] == 'k')

            {

                if (gg_mape[piece_row + 2][piece_colum - 2] == '.')

                {

                    if (piece_row + 2 == 7)

                    {

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row + 1][piece_colum - 1] = '.';

                        gg_mape[piece_row + 2][piece_colum - 2] = 'K';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                    else

                    {

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row + 1][piece_colum - 1] = '.';

                        gg_mape[piece_row + 2][piece_colum - 2] = 'A';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                }

                else

                {

                    player_1_turn(gg_mape, num1, num2);

                }

            }

            else if (gg_mape[piece_row + 1][piece_colum - 1] != '.')

            {

                player_1_turn(gg_mape, num1, num2);

            }

        }

        else if (play1 == 'R' || play1 == 'r')      // Right

        {

            if (play1 == 'Q' || play1 == 'q')

            {

                break;

            }

            cout << endl;

            if (piece_row + 1 == 7)

            {

                if (gg_mape[piece_row + 1][piece_colum + 1] == '.')

                {

                    gg_mape[piece_row][piece_colum] = '.';

                    gg_mape[piece_row + 1][piece_colum + 1] = 'K';

                    b1 = true;

                }

            }

            else if (gg_mape[piece_row + 1][piece_colum + 1] == '.')

            {

                gg_mape[piece_row + 1][piece_colum + 1] = 'A';

                gg_mape[piece_row][piece_colum] = '.';

                b1 = true;

            }

            else if (gg_mape[piece_row + 1][piece_colum + 1] == 'A')

            {

                player_1_turn(gg_mape, num1, num2);

            }

            else if (gg_mape[piece_row + 1][piece_colum + 1] == 'K')

            {

                player_1_turn(gg_mape, num1, num2);

            }

            else if (gg_mape[piece_row + 1][piece_colum + 1] == 'B')

            {

                if (gg_mape[piece_row + 2][piece_colum + 2] == '.')

                {

                    if (piece_row + 2 == 7)

                    {

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row + 1][piece_colum + 1] = '.';

                        gg_mape[piece_row + 2][piece_colum + 2] = 'K';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                    else

                    {

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row + 1][piece_colum + 1] = '.';

                        gg_mape[piece_row + 2][piece_colum = 2] = 'A';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                }

                else

                {

                    player_1_turn(gg_mape, num1, num2);

                }

            }

            else if (gg_mape[piece_row + 1][piece_colum + 1] == 'k')

            {

                if (gg_mape[piece_row + 2][piece_colum + 2] == '.')

                {

                    if (piece_row + 2 == 7)

                    {

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row + 1][piece_colum + 1] = '.';

                        gg_mape[piece_row + 2][piece_colum + 2] = 'K';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                    else

                    {

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row + 1][piece_colum + 1] = '.';

                        gg_mape[piece_row + 2][piece_colum + 2] = 'A';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                }

                else

                {

                    player_1_turn(gg_mape, num1, num2);

                }

            }

            else if (gg_mape[piece_row + 1][piece_colum + 1] != '.')

            {

                player_1_turn(gg_mape, num1, num2);

            }

        }

    }

    else if (gg_mape[piece_row][piece_colum] == 'K')

    {

        cout << "Up for (U or u) and Down for (D or d) : ";

        cin >> play2;

        cout << "Left for (L or l) and Right for (R or r) : ";

        cin >> play1;

        if (play1 == 'Q' || play1 == 'q')

        {

            break;

        }

        cout << endl;

        if (play2 == 'D' || play2 == 'd')

        {

            if (play1 == 'L' || play1 == 'l')

            {

                if (gg_mape[piece_row + 1][piece_colum - 1] == '.')

                {

                    gg_mape[piece_row + 1][piece_colum - 1] = 'K';

                    gg_mape[piece_row][piece_colum] = '.';

                    b1 = true;

                }

                else if (gg_mape[piece_row + 1][piece_colum - 1] == 'A')

                {

                    player_1_turn(gg_mape, num1, num2);

                }

                else if (gg_mape[piece_row + 1][piece_colum - 1] == 'K')

                {

                    player_1_turn(gg_mape, num1, num2);

                }

                else if (gg_mape[piece_row + 1][piece_colum - 1] == 'B')

                {

                    if (gg_mape[piece_row + 2][piece_colum - 2] == '.')

                    {

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row + 1][piece_colum - 1] = '.';

                        gg_mape[piece_row + 2][piece_colum - 2] = 'K';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                }

                else if (gg_mape[piece_row + 1][piece_colum - 1] == 'k')

                {

                    if (gg_mape[piece_row + 2][piece_colum - 2] == '.')

                    {

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row + 1][piece_colum - 1] = '.';

                        gg_mape[piece_row + 2][piece_colum - 2] = 'K';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                }

                else if (gg_mape[piece_row + 1][piece_colum - 1] != '.')

                {

                    player_1_turn(gg_mape, num1, num2);

                }

            }

            else if (play1 == 'R' || play1 == 'r')

            {

                if (gg_mape[piece_row + 1][piece_colum + 1] == '.')

                {

                    gg_mape[piece_row + 1][piece_colum + 1] = 'K';

                    gg_mape[piece_row][piece_colum] = '.';

                    b1 = true;

                }

                else if (gg_mape[piece_row + 1][piece_colum + 1] == 'A')

                {

                    player_1_turn(gg_mape, num1, num2);

                }

                else if (gg_mape[piece_row + 1][piece_colum + 1] == 'K')

                {

                    player_1_turn(gg_mape, num1, num2);

                }

                else if (gg_mape[piece_row + 1][piece_colum + 1] == 'B')

                {

                    if (gg_mape[piece_row + 2][piece_colum + 2] == '.')

                    {

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row + 1][piece_colum + 1] = '.';

                        gg_mape[piece_row + 2][piece_colum + 2] = 'K';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                }

                else if (gg_mape[piece_row + 1][piece_colum + 1] == 'k')

                {

                    if (gg_mape[piece_row + 2][piece_colum + 2] == '.')

                    {

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row + 1][piece_colum + 1] = '.';

                        gg_mape[piece_row + 2][piece_colum + 2] = 'K';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                }

                else if (gg_mape[piece_row + 1][piece_colum + 1] != '.')

                {

                    player_1_turn(gg_mape, num1, num2);

                }

            }

        }

        else if (play2 == 'U' || play2 == 'u')

        {

            if (play1 == 'L' || play1 == 'l')

            {

                if (gg_mape[piece_row - 1][piece_colum - 1] == '.')

                {

                    gg_mape[piece_row - 1][piece_colum - 1] = 'K';

                    gg_mape[piece_row][piece_colum] = '.';

                    b1 = true;

                }

                else if (gg_mape[piece_row - 1][piece_colum - 1] == 'A')

                {

                    player_1_turn(gg_mape, num1, num2);

                }

                else if (gg_mape[piece_row - 1][piece_colum - 1] == 'K')

                {

                    player_1_turn(gg_mape, num1, num2);

                }

                else if (gg_mape[piece_row - 1][piece_colum - 1] == 'B')

                {

                    if (gg_mape[piece_row - 2][piece_colum - 2] == '.')

                    {

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row - 1][piece_colum - 1] = '.';

                        gg_mape[piece_row - 2][piece_colum - 2] = 'K';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                }

                else if (gg_mape[piece_row - 1][piece_colum - 1] == 'k')

                {

                    if (gg_mape[piece_row - 2][piece_colum - 2] == '.')

                    {

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row - 1][piece_colum - 1] = '.';

                        gg_mape[piece_row - 2][piece_colum - 2] = 'K';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                }

                else if (gg_mape[piece_row - 1][piece_colum - 1] != '.')

                {

                    player_1_turn(gg_mape, num1, num2);

                }

            }

            else if (play1 == 'R' || play1 == 'r')

            {

                if (gg_mape[piece_row - 1][piece_colum + 1] == '.')

                {

                    gg_mape[piece_row - 1][piece_colum + 1] = 'K';

                    gg_mape[piece_row][piece_colum] = '.';

                    b1 = true;

                }

                else if (gg_mape[piece_row - 1][piece_colum + 1] == 'A')

                {

                    player_1_turn(gg_mape, num1, num2);

                }

                else if (gg_mape[piece_row - 1][piece_colum + 1] == 'K')

                {

                    player_1_turn(gg_mape, num1, num2);

                }

                else if (gg_mape[piece_row - 1][piece_colum + 1] == 'B')

                {

                    if (gg_mape[piece_row - 2][piece_colum + 2] == '.')

                    {

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row - 1][piece_colum + 1] = '.';

                        gg_mape[piece_row - 2][piece_colum + 2] = 'K';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                }

                else if (gg_mape[piece_row - 1][piece_colum + 1] == 'k')

                {

                    if (gg_mape[piece_row - 2][piece_colum + 2] == '.')

                    {

                        gg_mape[piece_row][piece_colum] = '.';

                        gg_mape[piece_row - 1][piece_colum + 1] = '.';

                        gg_mape[piece_row - 2][piece_colum + 2] = 'K';

                        *num2 = *num2 - 1;

                        b1 = true;

                    }

                }

                else if (gg_mape[piece_row - 1][piece_colum + 1] != '.')

                {

                    player_1_turn(gg_mape, num1, num2);

                }

            }

        }

    }

    cout << endl;

    if (*num2 == 0)

    {

        for (k = 0; k < v1; k++)

        {

            delete[]gg_mape[i];

        }

        delete[]gg_mape;

        player2_loss(num1, num2);

    }

    if (b1 = true)

    {

        b2 = false;

        player_2_turn(gg_mape, num1, num2);

    }

    make_board(gg_mape);

}
}
void player_2_turn(char** ggg_mape, int* num3, int* num4)
{
while (b2 == false)

{

    system("color 02");

    make_board(ggg_mape);

    cout << "\t\t------------------PLAYER 2------------------\n";

    cout << "\t\t\tPlayer 1 Pieces remainig : " << *num3 << endl;

    cout << "\t\t\tPlayer 2 Pieces remainig : " << *num4 << endl;

    cout << "Enter the index number of a piece(Like Row and Colum) which you want to move\n";

    cout << "Row : ";

    cin >> piece_row;

    cout << "Colum : ";

    cin >> piece_colum;

    cout << endl;

    if (ggg_mape[piece_row][piece_colum] == 'B')

    {

        cout << "Left for (L or l) and Rigth for (R or r) : ";

        cin >> play1;

        if (play1 == 'Q' || play1 == 'q')

        {

            break;

        }

        cout << endl;

        if (play1 == 'L' || play1 == 'l')

        {

            if (piece_row - 1 == 0)

            {

                if (ggg_mape[piece_row - 1][piece_colum - 1] == '.')

                {

                    ggg_mape[piece_row][piece_colum] = '.';

                    ggg_mape[piece_row - 1][piece_colum - 1] = 'k';

                    b2 = true;

                }

            }

            else if (ggg_mape[piece_row - 1][piece_colum - 1] == '.')

            {

                ggg_mape[piece_row - 1][piece_colum - 1] = 'B';

                ggg_mape[piece_row][piece_colum] = '.';

                b2 = true;

            }

            else if (ggg_mape[piece_row - 1][piece_colum - 1] == 'B')

            {

                player_2_turn(ggg_mape, num3, num4);

            }

            else if (ggg_mape[piece_row - 1][piece_colum - 1] == 'k')

            {

                player_2_turn(ggg_mape, num3, num4);

            }

            else if (ggg_mape[piece_row - 1][piece_colum - 1] == 'A')

            {

                if (ggg_mape[piece_row - 2][piece_colum - 2] == '.')

                {

                    if (piece_row - 2 == 0)

                    {

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row - 1][piece_colum - 1] = '.';

                        ggg_mape[piece_row - 2][piece_colum - 2] = 'k';

                        *num3 = *num3 - 1;

                        b2 = true;

                    }

                    else

                    {

                        ggg_mape[piece_row - 2][piece_colum - 2] = 'B';

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row - 1][piece_colum - 1] = '.';

                        *num3 = *num3 - 1;

                        b2 = true;

                    }

                }

                else

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

            }

            else if (ggg_mape[piece_row - 1][piece_colum - 1] == 'K')

            {

                if (ggg_mape[piece_row - 2][piece_colum - 2] == '.')

                {

                    if (piece_row - 2 == 0)

                    {

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row - 1][piece_colum - 1] = '.';

                        ggg_mape[piece_row - 2][piece_colum - 2] = 'k';

                        *num3 = *num3 - 1;

                        b2 = true;

                    }

                    else

                    {

                        ggg_mape[piece_row - 2][piece_colum - 2] = 'B';

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row - 1][piece_colum - 1] = '.';

                        *num3 = *num3 - 1;

                        b2 = true;

                    }

                }

                else

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

            }

            else if (ggg_mape[piece_row - 1][piece_colum - 1] != 0)

            {

                player_2_turn(ggg_mape, num3, num4);

            }

        }

        else if (play1 == 'R' || play1 == 'r')

        {

            if (piece_row - 1 == 0)

            {

                if (ggg_mape[piece_row - 1][piece_colum + 1] == '.')

                {

                    ggg_mape[piece_row][piece_colum] = '.';

                    ggg_mape[piece_row - 1][piece_colum + 1] = 'k';

                    b2 = true;

                }

            }

            else if (ggg_mape[piece_row - 1][piece_colum + 1] == '.')

            {

                ggg_mape[piece_row - 1][piece_colum + 1] = 'B';

                ggg_mape[piece_row][piece_colum] = '.';

                b2 = true;

            }

            else if (ggg_mape[piece_row - 1][piece_colum + 1] == 'B')

            {

                player_2_turn(ggg_mape, num3, num4);

            }

            else if (ggg_mape[piece_row - 1][piece_colum + 1] == 'k')

            {

                player_2_turn(ggg_mape, num3, num4);

            }

            else if (ggg_mape[piece_row - 1][piece_colum + 1] == 'A')

            {

                if (ggg_mape[piece_row - 2][piece_colum + 2] == '.')

                {

                    if (piece_row - 2 == 0)

                    {

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row - 1][piece_colum + 1] = '.';

                        ggg_mape[piece_row - 2][piece_colum + 2] = 'k';

                        *num3 = *num3 - 1;

                        b2 = true;

                    }

                    else

                    {

                        ggg_mape[piece_row - 2][piece_colum + 2] = 'B';

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row - 1][piece_colum + 1] = '.';

                        *num3 = *num3 - 1;

                        b2 = true;

                    }

                }

                else

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

            }

            else if (ggg_mape[piece_row - 1][piece_colum + 1] == 'K')

            {

                if (ggg_mape[piece_row - 2][piece_colum + 2] == '.')

                {

                    if (piece_row - 2 == 0)

                    {

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row - 1][piece_colum + 1] = '.';

                        ggg_mape[piece_row - 2][piece_colum + 2] = 'k';

                        *num3 = *num3 - 1;

                        b2 = true;

                    }

                    else

                    {

                        ggg_mape[piece_row - 2][piece_colum + 2] = 'B';

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row - 1][piece_colum + 1] = '.';

                        *num3 = *num3 - 1;

                        b2 = true;

                    }

                }

                else

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

            }

            else if (ggg_mape[piece_row - 1][piece_colum - 1] != 0)

            {

                player_2_turn(ggg_mape, num3, num4);

            }

        }

    }

    else if (ggg_mape[piece_row][piece_colum] == 'k')

    {

        cout << "Up for (U or u) and Down for (D or d) : ";

        cin >> play2;

        cout << "Left for (L or l) and Right for (R or r) : ";

        cin >> play1;

        if (play1 == 'Q' || play1 == 'q')

        {

            break;

        }

        cout << endl;

        if (play2 == 'U' || play2 == 'u')

        {

            if (play1 == 'L' || play2 == 'l')

            {

                if (ggg_mape[piece_row - 1][piece_colum - 1] == '.')

                {

                    ggg_mape[piece_row - 1][piece_colum - 1] = 'k';

                    ggg_mape[piece_row][piece_colum] = '.';

                    b2 = true;

                }

                else if (ggg_mape[piece_row - 1][piece_colum - 1] == 'B')

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

                else if (ggg_mape[piece_row - 1][piece_colum - 1] == 'k')

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

                else if (ggg_mape[piece_row - 1][piece_colum - 1] == 'A')

                {

                    if (ggg_mape[piece_row - 2][piece_colum - 2] == '.')

                    {

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row - 1][piece_colum - 1] = '.';

                        ggg_mape[piece_row - 2][piece_colum - 2] = 'k';

                        *num3 = *num3 - 1;

                        b2 = true;

                    }

                }

                else if (ggg_mape[piece_row - 1][piece_colum - 1] == 'K')

                {

                    if (ggg_mape[piece_row - 2][piece_colum - 2] == '.')

                    {

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row - 1][piece_colum - 1] = '.';

                        ggg_mape[piece_row - 2][piece_colum - 2] = 'k';

                        *num3 = *num4 - 1;

                        b2 = true;

                    }

                }

                else if (ggg_mape[piece_row - 1][piece_colum - 1] != '.')

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

            }

            else if (play1 == 'R' || play1 == 'r')

            {

                if (ggg_mape[piece_row - 1][piece_colum + 1] == '.')

                {

                    ggg_mape[piece_row - 1][piece_colum + 1] = 'k';

                    ggg_mape[piece_row][piece_colum] = '.';

                    b2 = true;

                }

                else if (ggg_mape[piece_row - 1][piece_colum + 1] == 'B')

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

                else if (ggg_mape[piece_row - 1][piece_colum + 1] == 'k')

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

                else if (ggg_mape[piece_row - 1][piece_colum + 1] == 'A')

                {

                    if (ggg_mape[piece_row - 2][piece_colum + 2] == '.')

                    {

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row - 1][piece_colum + 1] = '.';

                        ggg_mape[piece_row - 2][piece_colum + 2] = 'k';

                        *num3 = *num3 - 1;

                        b2 = true;

                    }

                }

                else if (ggg_mape[piece_row - 1][piece_colum + 1] == 'K')

                {

                    if (ggg_mape[piece_row - 2][piece_colum + 2] == '.')

                    {

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row - 1][piece_colum + 1] = '.';

                        ggg_mape[piece_row - 2][piece_colum + 2] = 'k';

                        *num3 = *num3 - 1;

                        b2 = true;

                    }

                }

                else if (ggg_mape[piece_row - 1][piece_colum + 1] != '.')

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

            }

        }

        else if (play2 == 'D' || play2 == 'd')

        {

            if (play1 == 'L' || play2 == 'l')

            {

                if (ggg_mape[piece_row + 1][piece_colum - 1] == '.')

                {

                    ggg_mape[piece_row + 1][piece_colum - 1] = 'k';

                    ggg_mape[piece_row][piece_colum] = '.';

                    b2 = true;

                }

                else if (ggg_mape[piece_row + 1][piece_colum - 1] == 'B')

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

                else if (ggg_mape[piece_row + 1][piece_colum - 1] == 'k')

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

                else if (ggg_mape[piece_row + 1][piece_colum - 1] == 'A')

                {

                    if (ggg_mape[piece_row + 2][piece_colum - 2] == '.')

                    {

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row + 1][piece_colum - 1] = '.';

                        ggg_mape[piece_row + 2][piece_colum - 2] = 'k';

                        *num3 = *num3 - 1;

                        b2 = true;

                    }

                }

                else if (ggg_mape[piece_row + 1][piece_colum - 1] == 'K')

                {

                    if (ggg_mape[piece_row + 2][piece_colum - 2] == '.')

                    {

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row + 1][piece_colum - 1] = '.';

                        ggg_mape[piece_row + 2][piece_colum - 2] = 'k';

                        *num3 = *num3 - 1;

                        b2 = true;

                    }

                }

                else if (ggg_mape[piece_row + 1][piece_colum - 1] != '.')

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

            }

            else if (play1 == 'R' || play1 == 'r')

            {

                if (ggg_mape[piece_row + 1][piece_colum + 1] == '.')

                {

                    ggg_mape[piece_row + 1][piece_colum + 1] = 'k';

                    ggg_mape[piece_row][piece_colum] = '.';

                    b2 = true;

                }

                else if (ggg_mape[piece_row + 1][piece_colum + 1] == 'B')

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

                else if (ggg_mape[piece_row + 1][piece_colum + 1] == 'k')

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

                else if (ggg_mape[piece_row + 1][piece_colum + 1] == 'A')

                {

                    if (ggg_mape[piece_row + 2][piece_colum + 2] == '.')

                    {

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row + 1][piece_colum + 1] = '.';

                        ggg_mape[piece_row + 2][piece_colum + 2] = 'k';

                        *num3 = *num3 - 1;

                        b2 = true;

                    }

                }

                else if (ggg_mape[piece_row + 1][piece_colum + 1] == 'K')

                {

                    if (ggg_mape[piece_row + 2][piece_colum + 2] == '.')

                    {

                        ggg_mape[piece_row][piece_colum] = '.';

                        ggg_mape[piece_row + 1][piece_colum + 1] = '.';

                        ggg_mape[piece_row + 2][piece_colum + 2] = 'k';

                        *num3 = *num3 - 1;

                        b2 = true;

                    }

                }

                else if (ggg_mape[piece_row + 1][piece_colum + 1] != '.')

                {

                    player_2_turn(ggg_mape, num3, num4);

                }

            }

        }

    }

    if (*num3 == 0)

    {

        for (k = 0; k < v1; k++)

        {

            delete[]ggg_mape[i];

        }

        delete[]ggg_mape;

        player1_loss(num3, num4);

    }

    if (b2 = true)

    {

        b1 = false;

        player_1_turn(ggg_mape, num3, num4);

    }

    make_board(ggg_mape);

}
}
void player2_loss(int* num5, int* num6)
{
system("color 05");

system("cls");

cout << "\n\t\t\t\t============================================================\n";

cout << "\n\t\t\t\t\t\tPlayer 2 Piece : " << *num6;

cout << "\n\n\t\t\t\t\t   So Player 2 is loss the game\n";

cout << "\n\t\t\t\t\tPlayer 1 win the game with " << *num5 << " Pieces\n";

cout << "\n\t\t\t\t============================================================\n";

delete num5;

delete num6;

exit(-1);
}
void player1_loss(int* num7, int* num8)
{
system("color 09");

system("cls");

cout << "\n\t\t\t\t============================================================\n";

cout << "\n\t\t\t\t\t\tPlayer 1 Piece : " << *num7;

cout << "\n\n\t\t\t\t\t   So Player 1 is loss the game\n";

cout << "\n\t\t\t\t\tPlayer 2 win the game with " << *num8 << " Pieces\n";

cout << "\n\t\t\t\t============================================================\n";

delete num7;

delete num8;

exit(-1);
}
void make_board(char** arr2)
{
system("cls");

cout << "       0         1         2         3         4         5         6         7     \n";

cout << "  _________________________________________________________________________________\n";

cout << "  |         |         |         |         |         |         |         |         |\n";

cout << "0 |    " << arr2[0][0] << "    |    " << arr2[0][1] << "    |    " << arr2[0][2] << "    |    "

    << arr2[0][3] << "    |    " << arr2[0][4] << "    |    " << arr2[0][5] << "    |  "

    << arr2[0][6] << "      |    " << arr2[0][7] << "    |\n";

cout << "  |_________|_________|_________|_________|_________|_________|_________|_________|\n";

cout << "  |         |         |         |         |         |         |         |         |\n";

cout << "1 |    " << arr2[1][0] << "    |    " << arr2[1][1] << "    |    " << arr2[1][2] << "    |    "

    << arr2[1][3] << "    |    " << arr2[1][4] << "    |    " << arr2[1][5] << "    |  "

    << arr2[1][6] << "      |    " << arr2[1][7] << "    |\n";

cout << "  |_________|_________|_________|_________|_________|_________|_________|_________|\n";

cout << "  |         |         |         |         |         |         |         |         |\n";

cout << "2 |    " << arr2[2][0] << "    |    " << arr2[2][1] << "    |    " << arr2[2][2] << "    |    "

    << arr2[2][3] << "    |    " << arr2[2][4] << "    |    " << arr2[2][5] << "    |  "

    << arr2[2][6] << "      |    " << arr2[2][7] << "    |\n";

cout << "  |_________|_________|_________|_________|_________|_________|_________|_________|\n";

cout << "  |         |         |         |         |         |         |         |         |\n";

cout << "3 |    " << arr2[3][0] << "    |    " << arr2[3][1] << "    |    " << arr2[3][2] << "    |    "

    << arr2[3][3] << "    |    " << arr2[3][4] << "    |    " << arr2[3][5] << "    |    "

    << arr2[3][6] << "    |    " << arr2[3][7] << "    |\n";

cout << "  |_________|_________|_________|_________|_________|_________|_________|_________|\n";

cout << "  |         |         |         |         |         |         |         |         |\n";

cout << "4 |    " << arr2[4][0] << "    |    " << arr2[4][1] << "    |    " << arr2[4][2] << "    |    "

    << arr2[4][3] << "    |    " << arr2[4][4] << "    |    " << arr2[4][5] << "    |    "

    << arr2[4][6] << "    |    " << arr2[4][7] << "    |\n";

cout << "  |_________|_________|_________|_________|_________|_________|_________|_________|\n";

cout << "  |         |         |         |         |         |         |         |         |\n";

cout << "5 |    " << arr2[5][0] << "    |    " << arr2[5][1] << "    |    " << arr2[5][2] << "    |    "

    << arr2[5][3] << "    |    " << arr2[5][4] << "    |    " << arr2[5][5] << "    |  "

    << arr2[5][6] << "      |    " << arr2[5][7] << "    |\n";

cout << "  |_________|_________|_________|_________|_________|_________|_________|_________|\n";

cout << "  |         |         |         |         |         |         |         |         |\n";

cout << "6 |    " << arr2[6][0] << "    |    " << arr2[6][1] << "    |    " << arr2[6][2] << "    |    "

    << arr2[6][3] << "    |    " << arr2[6][4] << "    |    " << arr2[6][5] << "    |  "

    << arr2[6][6] << "      |    " << arr2[6][7] << "    |\n";

cout << "  |_________|_________|_________|_________|_________|_________|_________|_________|\n";

cout << "  |         |         |         |         |         |         |         |         |\n";

cout << "7 |    " << arr2[7][0] << "    |    " << arr2[7][1] << "    |    " << arr2[7][2] << "    |    "

    << arr2[7][3] << "    |    " << arr2[7][4] << "    |    " << arr2[7][5] << "    |  "

    << arr2[7][6] << "      |    " << arr2[7][7] << "    |\n";

cout << "  |_________|_________|_________|_________|_________|_________|_________|_________|\n";
}
