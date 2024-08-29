package backtrack;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        helper(3, 3);
    }

    static void helper(int r, int c) {
        boolean[][] maze = {
                { true, false, true },
                { true, true, true },
                { true, true, true },

        };

        moves("", maze, new int[3][3], 0, 0, 1);
    }

    static void moves(String p, boolean[][] board, int[][] path, int r, int c, int count) {
        if (r == 2 && c == 2) {
            // System.out.println("(" + r + "," + c + ")");
            path[r][c] = count;
            System.out.println(p);
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            return;
        }
        // if
        if (!board[r][c]) {
            return;
        }
        board[r][c] = false;
        path[r][c] = count;
        if (c < 2) {
            moves(p + "R", board, path, r, c + 1, count + 1);
        }
        if (r < 2) {
            moves(p + "D", board, path, r + 1, c, count + 1);
        }
        board[r][c] = true;
        path[r][c] = 0;


    }
}
