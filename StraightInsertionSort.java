package SortMethod;

import org.junit.Test;

/*
    直接插入排序(Insertion Sort)的基本思想是:每次将一个待排序的记录，按其关键字大小插入到前面已经排好序的子
    序列中的适当位置，直到全部记录插入完成为止。
    设数组为 a[0...n-1]。
    1. 初始时，a[0]自成1个有序区，无序区为a[1..n-1]。令i=1
    2. 将a[i]并入当前的有序区a[0...i-1]中形成a[0...i]的有序区间。 3. i++并重复第二步直到 i==n-1。排序完成。

     */
public class StraightInsertionSort {
    public static final int[] nums = {1,2,5,9,4,12,34,23,45,77,55,44,20,79,72,98,90,30,99};

    @Test
    public void test1() {
        System.out.println("数列长度：" + nums.length + '\n');
        /*
        直接插入排序算法1.0
        数列长度19，循环次数43
        */
        System.out.println("直接插入排序算法1.0");
        System.out.print("排序之前：");
        SortUtils.printArray(nums);
        insertionSort_1(nums);
        System.out.print("排序之后：");
        SortUtils.printArray(nums);
    }
    @Test
    public void test2() {
        System.out.println("数列长度：" + nums.length + '\n');
        /*
        直接插入排序算法2.0
        数列长度19，循环次数35
        */
        System.out.println("直接插入排序算法1.0");
        System.out.print("排序之前：");
        SortUtils.printArray(nums);
        insertionSort_2(nums);
        System.out.print("排序之后：");
        SortUtils.printArray(nums);
    }
    @Test
    public void test3() {
        System.out.println("数列长度：" + nums.length + '\n');
        /*
        直接插入排序算法3.0
        数列长度19，循环次数25
        */
        System.out.println("直接插入排序算法1.0");
        System.out.print("排序之前：");
        SortUtils.printArray(nums);
        insertionSort_3(nums);
        System.out.print("排序之后：");
        SortUtils.printArray(nums);
    }
    /*
    数列长度：19

    直接插入排序算法1.0
    排序之前：[1, 2, 5, 9, 4, 12, 34, 23, 45, 77, 55, 44, 20, 79, 72, 98, 90, 30, 99]
    循环次数：43
    排序之后：[1, 2, 4, 5, 9, 12, 20, 23, 30, 34, 44, 45, 55, 72, 77, 79, 90, 98, 99]

    直接插入排序算法2.0
    排序之前：[1, 2, 5, 9, 4, 12, 34, 23, 45, 77, 55, 44, 20, 79, 72, 98, 90, 30, 99]
    循环次数：35
    排序之后：[1, 2, 4, 5, 9, 12, 20, 23, 30, 34, 44, 45, 55, 72, 77, 79, 90, 98, 99]

    直接插入排序算法3.0
    排序之前：[1, 2, 5, 9, 4, 12, 34, 23, 45, 77, 55, 44, 20, 79, 72, 98, 90, 30, 99]
    循环次数：25
    排序之后：[1, 2, 4, 5, 9, 12, 20, 23, 30, 34, 44, 45, 55, 72, 77, 79, 90, 98, 99]
     */
    /*
    直接插入排序1.0
     */
    public static void insertionSort_1(int[] nums) {
        int i, j, count=0;
        for(i=1; i<nums.length; i++) {
            for(j=i-1; j>=0; j--) {
                count ++;
                if(nums[j+1] < nums[j]) {
                    SortUtils.swapNum(nums,j+1,j);
                }else {
                    break;
                }
            }
        }
        System.out.println("循环次数：" + count);
    }
    /*
    直接插入排序2.0
     */
    public static void insertionSort_2(int[] nums) {
        int i, j, count=0;
        for(i=1; i<nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                int temp = nums[i];
                //将较小的值存到一个中间变量当中，然后让较小值的前面几位依次和中间值比较，知道满足大小关系后把中间值放到合适位置
                //然后其他不满足的往后挪一位
                for(j=i-1; j>=0 && nums[j] > temp; j--) {
                    count ++;
                    nums[j+1] = nums[j];
                }
                nums[j+1] = temp;
            }else {
                count++;
            }
        }
        System.out.println("循环次数：" + count);
    }
    /*
    直接插入排序3.0
     */
    public static void insertionSort_3(int[] nums) {
        int i, j, count=0;
        for(i=1; i<nums.length; i++) {
            int temp = nums[i];
            for(j=i; j>0 && nums[j-1] > temp; j--) {
                count ++;
                SortUtils.swapNum(nums, j-1,j);
            }
        }
        System.out.println("循环次数：" + count);
    }
}
