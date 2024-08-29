package sortings;

import java.util.Arrays;

public class quickSort {
    public int[] QuickSort(int []arr){
        Quicksort(arr, 0, arr.length-1);
        return arr;
    }
    private void Quicksort(int [] arr,int start,int end){
        int s=start;
        int e=end;
        int mid=s+(e-s)/2;
        int pivot =arr[mid];

        while(s<=e){
            while(arr[s]<pivot){
                s++;
            }
            while (arr[e]>pivot) {
                e--;
            }
            if( s<=e){
                swap(arr,s,e);
                e--;
                s++;
            }
        }
        if (start < e) {
            Quicksort(arr, start, e);
        }
        if (s < end) {
            Quicksort(arr, s, end);
        }
    }
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        quickSort abc=new quickSort();
        int[] arr = abc.QuickSort(new int[]{2,5,1,3,6});
        System.out.println(Arrays.toString(arr));
    }
}
