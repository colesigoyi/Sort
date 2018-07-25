package SortMethod;

import org.junit.Test;

/**
 * @author taoxuefeng
 * @create 2018-07-06 下午4:26
 * @desc 快速排序
 **/

public class QuickSort {
    private static final int[] nums = {1, 2, 5, 9, 4, 12, 34, 23, 45, 77, 55, 44, 20, 79, 72, 98, 90, 30, 99};

    @Test
    public void test1() {
        System.out.println("数列长度：" + nums.length + '\n');
        /*
        直接插入排序算法1.0
        数列长度19，循环次数43
        */
        System.out.println("快速排序算法1.0");
        System.out.print("排序之前：");
        SortUtils.printArray(nums);
        quickSort(nums, 0, nums.length - 1);
        System.out.print("排序之后：");
        SortUtils.printArray(nums);
    }

    public static int adjust(int[] nums, int f, int l) {
            int i = f, j = l;
            int X = nums[f];
            while (i < j) {
                while (i < j && nums[j] > X) {
                    j--;
                }
                if (i<j) {
                    nums[i] = nums[j];
                    i++;
                }
                while (i < j && nums[i] < X) {
                    i++;
                }
                if (i<j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = X;
            return i;
    }
    public static void quickSort ( int[] s, int l, int r){
        if (l < r) {
            int i = adjust(nums, l, r);
            quickSort(s, l, i - 1);
            quickSort(s, i + 1, r);
        }
    }
}
