import random

def start_game():
    # Generateing 2-D matrix (list)
    mat = []
    
    for i in range(4):
        mat.append([0]*4)
    
    return mat

def add_new_2(mat):
    # Generating random position for new 2
    r = random.randint(0, 3)
    c = random.randint(0, 3)
    while mat[r][c] != 0:
        r = random.randint(0, 3)
        c = random.randint(0, 3)
    
    mat[r][c] = 2

def get_current_state(mat):
    # WON
    # Anywhere 2048 is present
    for i in range(4):
        for j in range(4):
            if mat[i][j] == 2048:
                return 'WON!'
    
    # Not Over Yet
    # Anywhere 0 is present
    for i in range(4):
        for j in range(4):
            if mat[i][j] == 0:
                return 'GAME NOT OVER!'
    
    # Every row and column except last row and last column
    for i in range(3):
        for j in range(3):
            if mat[i][j] == mat[i+1][j] or mat[i][j] == mat[i][j+1]:
                return 'GAME NOT OVER!'
    
    # Last Row
    for j in range(3):
        if mat[3][j] == mat[3][j+1]:
            return 'GAME NOT OVER!'
        
    # Last Column
    for i in range(3):
        if mat[i][3] == mat[i+1][3]:
            return 'GAME NOT OVER!'
    
    # LOST
    return 'LOST!'

def compress(mat):
    new_mat = []
    changed = False
    for i in range(4):
        new_mat.append([0]*4)
        
    for i in range(4):
        pos = 0
        for j in range(4):
            if mat[i][j] != 0:
                new_mat[i][pos] = mat[i][j]
                if j != pos:
                    changed = True
                pos += 1
    
    return new_mat, changed

def merge(mat):
    changed = False
    for i in range(4):
        for j in range(3):
            if mat[i][j] == mat[i][j+1] and mat[i][j] != 0:
                mat[i][j] *= 2
                mat[i][j+1] = 0
                changed = True
    
    return mat, changed

def reverse(mat):
    new_mat = []
    for i in range(4):
        new_mat.append([])
        for j in range(4):
            new_mat[i].append(mat[i][4-j-1])
            
    return new_mat

def transpose(mat):
    new_mat = []
    for i in range(4):
        new_mat.append([])
        for j in range(4):
            new_mat[i].append(mat[j][i])
    
    return new_mat

def move_up(grid):
    transposed_grid = transpose(grid)
    new_grid, changed1 = compress(transposed_grid)
    new_grid, changed2 = merge(new_grid)
    changed = changed1 or changed2
    new_grid, temp = compress(new_grid)
    final_grid = transpose(new_grid)
    
    return final_grid, changed

def move_down(grid):
    transposed_grid = transpose(grid)
    reverse_grid = reverse(transposed_grid)
    new_grid, changed1 = compress(reverse_grid)
    new_grid, changed2 = merge(new_grid)
    changed = changed1 or changed2
    new_grid, temp = compress(new_grid)
    final_reversed_grid = reverse(new_grid)
    final_grid = transpose(final_reversed_grid)
    
    return final_grid, changed

def move_right(grid):
    reverse_grid = reverse(grid)
    new_grid, changed1 = compress(reverse_grid)
    new_grid, changed2 = merge(new_grid)
    changed = changed1 or changed2
    new_grid, temp = compress(new_grid)
    final_grid = reverse(new_grid)
    
    return final_grid, changed

def move_left(grid):
    new_grid, changed1 = compress(grid)
    new_grid, changed2 = merge(new_grid)
    changed = changed1 or changed2
    new_grid, temp = compress(new_grid)
    
    return new_grid, changed