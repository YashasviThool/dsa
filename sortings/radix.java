package sortings;

import java.util.Arrays;

public class radix {
    public void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();

        for (int ex = 1; max / ex > 0; ex *= 10) {
            countSort(arr, ex);
        }
    }

    private void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for(int i=1;i<10;i++){
            count[i]=count[i]+count[i-1];
        }
        for (int i = n - 1; i >=0; i--) {
            output[count[(arr[i] / exp) % 10]-1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        radix rad = new radix();
        int[] arr = { 29, 83, 471, 36, 91, 8 };
        rad.radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
