#include <iostream>
#include <algorithm>
#include <vector>
#include <array>
using namespace std;
#define grid_full make_pair(9, 9)

void print(int grid[9][9])
{
    for (int row = 0; row < 9; row++)
    {
        for (int col = 0; col < 9; col++)
        {
            cout << grid[row][col] << " ";
        }
        cout << endl;
    }
}
bool in_row(int grid[9][9], int row, int num);



bool in_col(int grid[9][9], int col, int num)
{
    for (int row = 0; row < 9; row++)
    {
        if (grid[row][col] == num)
            return true;
    }
    return false;
}

bool in_box(int grid[9][9], int box_start_row, int box_start_col, int num)
{
	for (int row = 0; row < 3; row++)
		for (int col = 0; col < 2; col++)
			if (grid[row + box_start_row][col + box_start_col] == num) 
			{
				return true;
			}
	return false;
}

// void getinput(int grid[9][9]){
//     for(int row=0;row<9;row++){
//         for(int col=0;col<9;col++){
//             cin>>grid[row][col];
//         }
//     }
// }
bool is_Safe(int grid[9][9], int row, int col, int num)
{   bool y=!in_row(grid, row, num) && !in_col(grid, col, num) && !in_box(grid, row - row % 3, col - col % 3, num);
    return y;
}

pair<int, int> get_Unassigned_Entry(int grid[9][9])
{
    for (int row = 0; row < 9; row++)
        for (int col = 0; col < 9; col++)
            if (grid[row][col] == 0){
                return make_pair(row, col);
            }
    return grid_full;
}

bool solve_Sudoku(int grid[9][9])
{

    if (grid_full == get_Unassigned_Entry(grid))
    {
        return true;
    }

    pair<int, int> row_col = get_Unassigned_Entry(grid);
    int row = row_col.first;
    int col = row_col.second;

    for (int num = 1; num <= 9; num++)
    {

        if (is_Safe(grid, row, col, num))
        {

            grid[row][col] = num;

            if (solve_Sudoku(grid))
            {
                return true;
            }

            grid[row][col] = 0;
        }
    }
    return false;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int grid[9][9] = { { 0, 4, 9, 0, 0, 7, 0, 0, 1 },
						   { 0, 0, 0, 2, 0, 0, 0, 0, 0 },
						   { 0, 6, 0, 0, 0, 0, 0, 3, 2 },
						   { 0, 0, 3, 0, 0, 5, 6, 0, 0 },
						   { 0, 0, 0, 0, 0, 0, 0, 0, 3 },
						   { 9, 0, 0, 8, 0, 0, 0, 4, 0 },
						   { 0, 1, 8, 0, 0, 3, 0, 0, 0 },
						   { 0, 0, 0, 0, 0, 2, 4, 0, 0 },
						   { 0, 0, 0, 4, 7, 0, 3, 8, 0 } };
    
    // getinput(grid);
    cout<<"unsolved-Sudoku-\n";
    print(grid);
    cout<<"\n\n";
    if (true == solve_Sudoku(grid)){
        print(grid);
    }
    else{
        cout << "No solution exists";
        }
    return 0;
}

bool in_row(int grid[9][9], int row, int num)
{
    for (int col = 0; col < 9; col++)
    {
        if (grid[row][col] == num)
            return true;
    }
    return false;
}

// 4 4 6 2 2 7 1 1 1
// 4 4 4 2 2 2 1 1 1
// 4 6 4 2 2 2 1 3 2
// 3 3 3 5 5 5 6 3 3
// 3 3 3 5 5 5 3 3 3
// 9 3 3 8 5 5 3 4 3
// 1 1 8 2 2 3 3 3 3
// 1 1 1 2 2 2 4 3 3
// 1 1 1 4 7 2 3 8 3

// 2 4 9 3 5 7 8 6 1
// 1 3 5 2 6 8 9 7 4
// 8 6 7 9 1 4 5 3 2
// 7 2 3 1 4 5 6 9 8
// 6 8 4 7 2 9 1 5 3
// 9 5 1 8 3 6 2 4 7
// 4 1 8 6 9 3 7 2 5
// 3 7 6 5 8 2 4 1 9
// 5 9 2 4 7 1 3 8 6