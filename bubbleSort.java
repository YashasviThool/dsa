
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bubbleSort {
    public static void main(String[] args) {
        int arr[] = { 99, 54, 36, 11, 25, 14, 32, 1 };
        int arr2[] = { 6, 5, 7, 3, 2, 1, 4 };
        int arr3[] = { 4, 3, 2, 7, 7, 2, 3, 1 };
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(cycleSort2(arr3)));
        // System.out.println(Arrays.toString(arr));
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(45);
        ans.add(85);
        System.out.println(ans);

        // System.out.println(Arrays.toString(bubbleSort(arr3, arr3.length-1, 0)));  //it is recursive buuble sort 

    }

    static int[] BubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // temp = arr[j + 1];
                    // arr[j + 1] = arr[j];
                    // arr[j] = temp;
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    static int[] bubbleSort(int[] arr, int i, int j) {
        if (i == 0) {
            return arr;
        }
        if (i > j) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
            return bubbleSort(arr, i, j + 1);
        }
        return bubbleSort(arr, i - 1, 0);

    }

    

    static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j <= 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int[] cycleSort2(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == i + 1) {
                i++;

            } else if (nums[nums[i] - 1] == nums[i]) {
                i++;
            } else {
                swap(nums, nums[i] - 1, i);
            }
        }
        return nums;
    }

    static int[] cycleSort(int[] arr) {
        int n = arr.length - 1, i = 1;

        while (i < n) {
            if (arr[i] == i + 1) {
                i++;
            } else {
                swap(arr, arr[i] - 1, i);
            }
        }
        return arr;
    }

}
