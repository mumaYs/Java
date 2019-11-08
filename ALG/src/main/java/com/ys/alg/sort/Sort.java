package com.ys.alg.sort;

import com.sun.istack.internal.NotNull;
import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Random;

/**
 * @author ys 2019/11/7 4:23 下午
 */
public class Sort {
    public static void swap(@NotNull int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 异或交换
     * 仅当没有相同值交换时使用,否则会返回0
     */
    public static void bitSwap(@NotNull int[] nums, int i, int j) {
        if (nums[i] == nums[j]) {
            return;
        }
        nums[i] = nums[j] ^ nums[i];
        nums[j] = nums[j] ^ nums[i];
        nums[i] = nums[j] ^ nums[i];
    }

    public static void main(String[] args) {
        int[] a = new int[]{9, 13, 23, 1, 3, 6, 43, 56, 78};
        SwapSort.quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
