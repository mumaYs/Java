package sort;

import com.sun.istack.internal.NotNull;

/**
 * @author ys 2019/11/13 5:18 下午
 */
public class Sort {
    public static void swap(@NotNull int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
