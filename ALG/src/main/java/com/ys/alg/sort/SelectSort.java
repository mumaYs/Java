package com.ys.alg.sort;

/**
 * 选择排序:包括直接选择、堆排序
 *
 * @author ys 2019/11/7 4:10 下午
 */
public class SelectSort {
    /**
     * 直接选择排序
     */
    public static void selectSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    Sort.swap(nums, i, j);
                }
            }
        }
    }

    /**
     * 优化选择排序
     */
    public static void betterSelectSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                minIndex = nums[j] < nums[minIndex] ? j : minIndex;
            }
            if (i != minIndex) {
                Sort.bitSwap(nums, i, minIndex);
            }
        }
    }
}
