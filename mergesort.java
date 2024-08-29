import java.util.Arrays;



public class mergesort {
    public static void main(String[] args) {
        int[] nums = { 6, 5, 7, 3, 9, 1, 2 };
        Mergesort(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
       
        
        System.out.println(Arrays.toString(nums));
    }

    static void Mergesort(int[] arr, int l, int r) {  
        int mid = l + (r - l) / 2;
        if (r > l) {
            Mergesort(arr, l, mid);
            Mergesort(arr, mid + 1, r);
            merge(arr, l, r, mid);

        }
       
    }

    static void merge(int[] arr, int l, int r, int m) {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        // Merge the temp arrays
 
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }
}
 
