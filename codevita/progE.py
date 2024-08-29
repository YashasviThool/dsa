def check_priest_fate(N, M, snakes, priest_direction):
    matrix = [['' for _ in range(N)] for _ in range(N)]
    
    # Place snakes in the matrix
    for snake in snakes:
        name, start, end = snake
        row_start, col_start = map(int, start.split(','))
        row_end, col_end = map(int, end.split(','))
        
        if row_start == row_end:
            for j in range(min(col_start, col_end), max(col_start, col_end) + 1):
                matrix[row_start - 1][j - 1] = name
        else:
            for i in range(min(row_start, row_end), max(row_start, row_end) + 1):
                matrix[i - 1][col_start - 1] = name
    
    # Function to check if the priest can reach Nirvana
    def can_reach_nirvana(priest_direction):
        row, col = map(int, priest_direction[1:])
        if priest_direction[0] == 'N':
            while row > 1:
                if matrix[row - 2][col - 1]:
                    return f"{matrix[row - 2][col - 1]} {row - 1},{col}"
                row -= 1
        elif priest_direction[0] == 'S':
            while row < N:
                if matrix[row][col - 1]:
                    return f"{matrix[row][col - 1]} {row},{col}"
                row += 1
        elif priest_direction[0] == 'E':
            while col < N:
                if matrix[row - 1][col]:
                    return f"{matrix[row - 1][col]} {row},{col}"
                col += 1
        elif priest_direction[0] == 'W':
            while col > 1:
                if matrix[row - 1][col - 2]:
                    return f"{matrix[row - 1][col - 2]} {row},{col - 1}"
                col -= 1
        return "NIRVANA"
    
    result = can_reach_nirvana(priest_direction)
    return result

# Input
N = int(input())
M = int(input())
snakes = []
for _ in range(M):
    name, start, end = input().split()
    snakes.append((name, start, end))
priest_direction = input()
result = check_priest_fate(N, M, snakes, priest_direction)
print(result)