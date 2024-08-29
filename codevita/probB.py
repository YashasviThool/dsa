row, col = map(int, input().split())
arr = [['0'] * col for _ in range(row)]

for i in range(row):
    s = input()
    for j in range(col):
        arr[i][j] = s[j]

ans = 0
for i in range(col):
    temp = row
    for j in range(row):
        if arr[j][i] == 'C':
            temp = row - j - 1
            break
        elif arr[j][i] == 'H':
            if temp != 0:
                continue
            else:
                temp = row - j
        elif arr[j][i] == '0':
            temp = 0
    ans += temp
coin_count = 0
for i in range(row):
    for j in range(col):
        if arr[i][j] == 'C':
            coin_count += 1
print(coin_count, ans * 2, end="")