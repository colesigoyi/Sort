package SortMethod;

import org.junit.Test;

public class RedirectSelectSort {


    public static final int[] nums = {1,2,5,9,4,12,34,23,45,77,55,44,20,79,72,98,90,30,99};

    @Test
    public void test() {
        System.out.println("数列长度：" + nums.length + '\n');
        /*
        简单选择排序算法
        数列长度19，循环次数171
        数列长度：19

        简单选择排序算法
        排序之前：[1, 2, 5, 9, 4, 12, 34, 23, 45, 77, 55, 44, 20, 79, 72, 98, 90, 30, 99]
        循环次数：171
        排序之后：[1, 2, 4, 5, 9, 12, 30, 20, 34, 45, 23, 44, 55, 77, 72, 79, 90, 98, 99]
        */
        System.out.println("简单选择排序算法");
        System.out.print("排序之前：");
        SortUtils.printArray(nums);
        SelectSort(nums);
        System.out.print("排序之后：");
        SortUtils.printArray(nums);
    }
    /*
    简选择排序算法:时间复杂度（n^2），但是总体还是优于冒泡排序
    遍历找到最小值，和第1位交换，然后再从第二位开始遍历，找到最小的和第二位交换，以此类推
    直接选择排序和直接插入排序类似，都将数据分为有序区和无序区，所不同的是 直接插入排序是
    将无序区的第一个元素直接插入到有序区以形成一个更大的有 序区，而直接选择排序是从无序区
    选一个最小的元素直接放到有序区的最后。
    设数组为 a[0...n-1]。
    4. 初始时，数组全为无序区为a[0..n-1]。令i=0
    5. 在无序区a[i...n-1]中选取一个最小的元素，将其与a[i]交换。交换之后a[0...i]
    就形成了一个有序区。
    6. i++并重复第二步直到 i==n-1。排序完成。
     */
    public static void SelectSort(int[] nums) {
        int min,j;
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            min = i;
            for (j = i+1; j < nums.length; j++) {
                count ++;
                if (nums[j] < nums[i]) {
                    min = j;
                }
            }
            SortUtils.swapNum(nums,i,min);
        }
        System.out.println("循环次数：" + count);
    }
}
