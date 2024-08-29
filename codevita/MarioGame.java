import java.util.Scanner;

public class MarioGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        char[][] screen = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < cols; j++) {
                screen[i][j] = row.charAt(j);
            }
        }

        int calories = 0;
        int coinsCollected = 0;

        for (int j = 0; j < cols; j++) {
            int highestCoinRow = -1;
            int holeHeight = 0;

            for (int i = rows - 1; i >= 0; i--) {
                char cell = screen[i][j];

                if (cell == 'C') {
                    // Mario collects a coin
                    coinsCollected++;
                    screen[i][j] = '0';
                } else if (cell == 'H' || cell == '0') {
                    // Mario encounters a hurdle or a hole
                    if (cell == '0') {
                        holeHeight++;
                    }

                    // Calculate calories expended to cross the hurdle or hole
                    if (holeHeight > 0) {
                        calories += 2 * holeHeight;
                        holeHeight = 0; // Reset hole height after crossing
                    } else {
                        calories += 2;
                    }
                }

                if (cell == 'C' || cell == 'H') {
                    highestCoinRow = i;
                }
            }
        }

        System.out.println("Coins Collected: " + coinsCollected);
        System.out.println("Calories Expended: " + calories);
    }
}
