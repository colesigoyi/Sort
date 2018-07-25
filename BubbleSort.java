package SortMethod;

import org.junit.Test;

import java.awt.*;

/**
 * 冒泡排序复杂度O[n^2]
 一种交换排序方法，基本思想：两两比较相邻记录的关键字，如果反序则交换，知道没有反序的记录为止
 冒泡排序毕竟是一种效率低下的排序方法，在数据规模很小时，可以采用。数据 规模比较大时，最好用其它排序方法。
 */
public class BubbleSort {

    public static final int[] nums = {1,2,5,9,4,12,34,23,45,77,55,44,20,79,72,98,90,30,99};

    /*
        冒泡排序1.0排序算法
        数列长度18，循环次数171
        */
    @Test
    public void test1() {
        System.out.println("数列长度：" + nums.length + '\n');
        System.out.println("第一种冒泡排序算法");
        System.out.print("排序之前：");
        SortUtils.printArray(nums);
        BubbleSort1(nums);
        System.out.print("排序之后：");
        SortUtils.printArray(nums);
        System.out.println();
    }

    /*
    冒泡排序2.0排序算法
    数列长度18，循环次数135
    */
    @Test
    public void test2() {
        System.out.println("数列长度：" + nums.length + '\n');
        System.out.println("第二种冒泡排序算法");
        System.out.print("排序之前：");
        SortUtils.printArray(nums);
        BubbleSort2(nums);
        System.out.print("排序之后：");
        SortUtils.printArray(nums);
        System.out.println();
    }
    /*
    冒泡排序3.0排序算法
    数列长度18，循环次数126
    */
    @Test
    public void test3() {
        System.out.println("数列长度：" + nums.length + '\n');
        System.out.println("第三种冒泡排序算法");
        System.out.print("排序之前：");
        SortUtils.printArray(nums);
        BubbleSort3(nums);
        System.out.print("排序之后：");
        SortUtils.printArray(nums);
        System.out.println();
    }
    /*
    数列长度：19

    第一种冒泡排序算法
    排序之前：[1, 2, 5, 9, 4, 12, 34, 23, 45, 77, 55, 44, 20, 79, 72, 98, 90, 30, 99]
    循环次数：171
    排序之后：[1, 2, 4, 5, 9, 12, 20, 23, 30, 34, 44, 45, 55, 72, 77, 79, 90, 98, 99]

    第二种冒泡排序算法
    排序之前：[1, 2, 5, 9, 4, 12, 34, 23, 45, 77, 55, 44, 20, 79, 72, 98, 90, 30, 99]
    循环次数：135
    排序之后：[1, 2, 4, 5, 9, 12, 20, 23, 30, 34, 44, 45, 55, 72, 77, 79, 90, 98, 99]

    第三种冒泡排序算法
    排序之前：[1, 2, 5, 9, 4, 12, 34, 23, 45, 77, 55, 44, 20, 79, 72, 98, 90, 30, 99]
    循环次数:126
    排序之后：[1, 2, 4, 5, 9, 12, 20, 23, 30, 34, 44, 45, 55, 72, 77, 79, 90, 98, 99]
     */

    /*
    冒泡排序1.0
    设数组长度为N。
    1.比较相邻的前后二个数据，如果前面数据大于后面的数据，就将二个数据交换。
    2.这样对数组的第0个数据到N-1个数据进行一次遍历后，最大的一个数据就
      “沉”到数组第N-1个位置。
    3.N=N-1，如果N不为0就重复前面二步，否则排序完成。
    */
    public static void BubbleSort1(int[] nums) {
        int i,j;
        //循环次数
        int count = 0;
        for(i=0; i<nums.length; i++) {
            //每次循环一遍后，最大的被挪到最后，下次再循环的时候最后一位已经最大，所以不用比较，所以循环比上一次少一位
            for(j=1; j<nums.length-i; j++) {
                count++;
                if(nums[j-1] > nums[j]) {
                    SortUtils.swapNum(nums,j-1,j);
                }
            }
        }
        System.out.println("循环次数：" + count);
    }
    /*
    冒泡排序2.0
    设置一个标志，如果这一趟发生了交换，则为true，否则为 false。明显如果有一趟没有发生交换，说明排序已经完成。
     */
    public static void BubbleSort2(int[] nums) {
        int i,j;
        int count2 = 0;
        boolean flag =false;
        for(i=0; i<nums.length; i++ ) {
            if(flag) {
                //如果排好序，flag为true，跳过这个交换，进行下一位的查看
                break;
            }
            flag = true;
            for(j=1; j<nums.length-i; j++) {
                count2++;
                if(nums[j-1] > nums[j]) {
                    if(flag) {
                        //如果有交换，说明没有排好序，flag为false，循环继续
                        flag = false;
                    }
                    SortUtils.swapNum(nums,j-1,j);
                }
            }
        }
        System.out.println("循环次数：" + count2);
    }
    /*
    冒泡排序3.0
    再做进一步的优化。如果有100个数的数组，仅前面10个无序，后面90个都已排 好序且都大于前面10个数字，
    那么在第一趟遍历后，最后发生交换的位置必定小 于10，且这个位置之后的数据必定已经有序了，记录下这位置，
    第二次只要从数 组头部遍历到这个位置就可以了。
    不行->同理，如果前面的一部分是有序的，且小于后面的，那么下次就可以从前部分的最后一位开始循环；(不通，前面的条件无法判断)
     */
    public static void BubbleSort3(int[] nums) {
        int flagnum = nums.length;
        int count = 0;
        int k,j;
        while (flagnum > 0) {
            k = flagnum;
            flagnum = 0;
            for(j=1; j<k; j++) {
                count ++;
                if(nums[j-1] > nums[j]) {
                    SortUtils.swapNum(nums,j-1,j);
                    //如果从n开始后面都是有序的，则j等于n-1，下次就从1循环到n-1，后面的就不用循环额了
                    flagnum = j;
                }
            }
        }
        System.out.println("循环次数:" + count);

    }
}
