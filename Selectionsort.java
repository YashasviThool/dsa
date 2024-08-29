import java.util.Arrays;

public class Selectionsort {

    // this is incomplete.
    static int[] SectionSort(int[] arr) {
        // int max;

        for (int i = 0; i < arr.length; i++) {
            // max = 0;
            for (int j = 0; j < arr.length - i; j++) {

            }
        }
        return arr;

    }

    static void selectionsort(int[] arr, int r, int c, int max)  {   //this is giveing me XXXXXX (wrong) ans.

        if (r < 0) {
            return ;
        }
        if (r > c) {
            if (arr[c] > arr[max]) {
                 selectionsort(arr, r, c + 1, c);
            }
            else{

                selectionsort(arr, r, c + 1, max);
            }
        }
        else{
            swap(arr, r, max);

            selectionsort(arr, r - 1, 0, r-1);
        }


    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {  7, 4, 9, 6, 2, 3 ,1,1};
        selectionsort(arr1, arr1.length -1, 0, 0);
        System.out.println(Arrays.toString(arr1));
    }
}
