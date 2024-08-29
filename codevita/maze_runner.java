import java.util.*;

class Point {
    int x, y, dis;

    Point(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

public class maze_runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] maze = new int[row][col];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                maze[i][j] = sc.nextInt();
            }
        }

        int start_X = sc.nextInt();
        int start_Y = sc.nextInt();
        int target_X = sc.nextInt();
        int target_Y = sc.nextInt();

        boolean[][][] visited = new boolean[row][col][3];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start_X, start_Y, 0));
        visited[start_X][start_Y][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Point head = queue.poll();

            if (head.x == target_X && head.y == target_Y) {
                System.out.println(head.dis);
                return;
            }

            for (int i = 0; i < 4; ++i) {
                int new_x = head.x + dx[i];
                int new_y = head.y + dy[i];

                if (new_x >= 0 && new_x < row && new_y >= 0 && new_y < col) {
                    if (!visited[new_x][new_y][head.dis % 3]) {
                        if (maze[new_x][new_y] == 1) {
                            continue;
                        }

                        if (maze[new_x][new_y] == 3 && head.dis % 3 == 0) {
                            continue;
                        }

                        visited[new_x][new_y][head.dis % 3] = true;
                        queue.add(new Point(new_x, new_y, head.dis + 1));
                    }
                }
            }
        }

        System.out.println("STUCK");
    }
}