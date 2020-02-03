package sort;


/**
 * @author ys 2019/11/13 5:18 下午
 */
public class Sort {
    public static void swap(int[] nums, int i, int j) {
        if (nums == null) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
