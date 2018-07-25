package SortMethod;

import org.junit.Test;

/*
该方法的基本思想是:先将整个待排元素序列分割成若干个子序列(由相隔某个 “增量”的元素组成的)分别进行直接插入排序，
然后依次缩减增量再进行排序， 待整个序列中的元素基本有序(增量足够小)时，再对全体元素进行一次直接插入排序。
因为直接插入排序在元素基本有序的情况下(接近最好情况)，效率是 很高的，因此希尔排序在时间效率上比前两种方法有较大􏰀高。
 */
public class ShellSort {
    public static final int[] nums = {1,2,5,9,4,12,34,23,45,77,55,44,20,79,72,98,90,30,99};

    @Test
    public void test1() {
        System.out.println("数列长度：" + nums.length + '\n');
        /*
        希尔排序1.0
        数列长度19，循环次数11
        */
        System.out.println("希尔排序1.0");
        System.out.print("排序之前：");
        SortUtils.printArray(nums);
        shellSort1(nums);
        System.out.print("排序之后：");
        SortUtils.printArray(nums);
        System.out.println();
    }
    @Test
    public void test2() {
        System.out.println("数列长度：" + nums.length + '\n');
        /*
        希尔排序2.0
        数列长度19，循环次数11
        */
        System.out.println("希尔排序2.0");
        System.out.print("排序之前：");
        SortUtils.printArray(nums);
        shellSort2(nums);
        System.out.print("排序之后：");
        SortUtils.printArray(nums);
        System.out.println();
    }
    @Test
    public void test3() {
        System.out.println("数列长度：" + nums.length + '\n');
        /*
        希尔排序3.0
        数列长度19，循环次数11
        */
        System.out.println("希尔排序3.0");
        System.out.print("排序之前：");
        SortUtils.printArray(nums);
        shellSort3(nums);
        System.out.print("排序之后：");
        SortUtils.printArray(nums);
        System.out.println();
    }
    /*
    数列长度：19

    希尔排序1.0
    排序之前：[1, 2, 5, 9, 4, 12, 34, 23, 45, 77, 55, 44, 20, 79, 72, 98, 90, 30, 99]
    循环次数：11
    排序之后：[1, 2, 4, 5, 9, 12, 20, 23, 30, 34, 44, 45, 55, 72, 77, 79, 90, 98, 99]

    希尔排序2.0
    排序之前：[1, 2, 5, 9, 4, 12, 34, 23, 45, 77, 55, 44, 20, 79, 72, 98, 90, 30, 99]
    循环次数：11
    排序之后：[1, 2, 4, 5, 9, 12, 20, 23, 30, 34, 44, 45, 55, 72, 77, 79, 90, 98, 99]

    希尔排序3.0
    排序之前：[1, 2, 5, 9, 4, 12, 34, 23, 45, 77, 55, 44, 20, 79, 72, 98, 90, 30, 99]
    循环次数：11
    排序之后：[1, 2, 4, 5, 9, 12, 20, 23, 30, 34, 44, 45, 55, 72, 77, 79, 90, 98, 99]
     */
    /*
        希尔排序1.0
     */
    public static int[] shellSort1(int[] nums) {
        int i, j, median;
        int count=0;
        int increment = nums.length;

        while (increment > 1) {
            increment = increment/3 + 1;
            for(i=increment; i<nums.length; i++) {
                if(nums[i] < nums[i-increment]) {
                    median = nums[i];
                    j=i-increment;
                    while (j>=0 && median < nums[j]) {
                        count++;
                        nums[j+increment] = nums[j];
                        j -= increment;
                    }
                    nums[j+increment] = median;
                }
            }
        }
        System.out.println("循环次数：" + count);
        return nums;
    }
    /*
        希尔排序2.0
     */
    public static int[] shellSort2(int[] nums) {
        int i, j, median;
        int count=0;
        int increment = nums.length;

        while (increment > 1) {
            increment = increment/3 + 1;
            for(i=increment; i<nums.length; i++) {
                if(nums[i] < nums[i-increment]) {
                    median = nums[i];
                    for(j=i-increment; j>=0 && median < nums[j]; j -= increment) {
                        count ++;
                        nums[j+increment] = nums[j];
                    }
                    nums[j+increment] = median;
                }
            }
        }
        System.out.println("循环次数：" + count);
        return nums;
    }
    /*
        希尔排序3.0
     */
    public static int[] shellSort3(int[] nums) {
        int i, j, median;
        int count=0;
        for(int increment = nums.length/3 +1; increment>=1; increment = increment/3+1) {
            for(i=increment; i<nums.length; i++) {
                for (j = i - increment; j >= 0 && nums[j + increment] < nums[j]; j -= increment) {
                    count++;
                    SortUtils.swapNum(nums, j, j + increment);
                }
            }
            if(increment == 1) {
                break;
            }
        }
        System.out.println("循环次数：" + count);
        return nums;
    }
}
