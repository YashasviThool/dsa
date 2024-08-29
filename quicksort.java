import java.util.Arrays;

public class quicksort {
    public static void main(String[] args) {
        int[] arr1 = { 2,5,1,3,6};
        Quicksort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }

    static void Quicksort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }
        int s = low;
        int e = high;
        int mid = s + (e - s) / 2;

        int pivot = arr[mid];

        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }

            if (s <= e) {
                swap(arr, s, e);
                s++;
                e--;
            }
        }

        Quicksort(arr, low, e);
        Quicksort(arr, s, high);
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
