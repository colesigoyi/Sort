package SortMethod;

import org.junit.Test;

public class MergeSort {

    public static final int[] nums = {1,2,5,9,4,12,34,23,45,77,55,44,20,79,72,98,90,30,99};


    @Test
    public void test() {
        int[] temp = new int[nums.length];
        MergeSort(nums, 0, nums.length-1, temp);
        SortUtils.printArray(nums);
    }

    public static void MergeSort(int[] nums, int first, int last, int[] temp) {
        if(first < last) {
            int mid = (first + last)/2;
            MergeSort(nums, first, mid, temp);
            MergeSort(nums, mid+1, last, temp);
            mergeArray(nums, first, mid, last, temp);
        }
    }


    public static void mergeArray(int[] a, int first, int mid, int last, int[] temp) {

        int i = first, j = mid+1;
        int m = mid, n = last;
        int k = 0;

        while (i<=m && j<=n) {
            if(a[i] < a[j]) {
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }
        while (i<=m) {
            temp[k++] = a[i++];
        }
        while (j<=n) {
            temp[k++] = a[j++];
        }
        for(i=0; i<k; i++) {
            a[first + i] = temp[i];
        }
    }
}
