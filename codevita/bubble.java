import java.util.Scanner;

public class bubble {
    public static int help = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        BubbleSort(arr.clone());
        int ans = help;
        help = 0;
        BubbleSort_des(arr);

        System.out.println((ans < help) ? ans : help);

    }

    static void BubbleSort(int[] arr) {

        boolean is_swap = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    swap(arr, j, j + 1);
                    help++;
                    is_swap = true;
                }
            }
            if (!is_swap) {
                break;
            }
            is_swap=false;
        }

    }

    static void BubbleSort_des(int[] arr) {

        boolean is_swap = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] < arr[j + 1]) {

                    swap(arr, j, j + 1);
                    help++;
                    is_swap = true;

                }
            }
            if (!is_swap) {
                break;
            }
            is_swap=false;
        }

    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}