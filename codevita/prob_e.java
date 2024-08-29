import java.util.Scanner;
public class prob_e {
    public static int findOverlap(int M , int N, int[] pos1, int[] dir1, int[] pos2, int[] dir2) {
        int step = 0;

        while (true) {
            int[] n1 = {pos1[0] + dir1[0], pos1[1] + dir1[1]};

            if (n1[0] < 0 || n1[0] >= M || n1[1] < 0 || n1[1] >= N) {
                dir1[0] = -dir1[0];
                dir1[1] = -dir1[1];
            }

            pos1 = n1;

            int[] n2 = {pos2[0] + dir2[0], pos2[1] + dir2[1]};

            if (n2[0] < 0 || n2[0] >= M || n2[1] < 0 || n2[1] >= N) {
                dir2[0] = -dir2[0];
                dir2[1] = -dir2[1];
            }

            pos2 = n2;

            if (pos1[0] == pos2[0] && pos1[1] == pos2[1]) {
                return step;
            }

            step++;

            if (step > 1000000) {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] pos1 = {sc.nextInt(), sc.nextInt()};
        int[] dir1 = {sc.nextInt(), sc.nextInt()};
        int[] pos2 = {sc.nextInt(), sc.nextInt()};
        int[] dir2 = {sc.nextInt(), sc.nextInt()};

        int steps = findOverlap(M, N, pos1, dir1, pos2, dir2);

        if (steps == -1) {
            System.out.println("Never");
        } else {
            System.out.println(steps + 1);
        }
    }
}