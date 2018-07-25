package SortMethod;

public class SortUtils {
    public static void swapNum(int nums[], int before, int after) {
        int moddle = nums[before];
        nums[before] = nums[after];
        nums[after] = moddle;
    }
    /**
     * @Description: 打印数组
     * @param nums 数组
     * @return: void
     */
    public static void printArray(int nums[]) {

        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i != nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}
