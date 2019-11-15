package com.ys.alg.sort;

import com.ys.bit.BitUtils;

import java.util.Random;

/**
 * 交换排序:包括快速排序和冒泡排序
 *
 * @author ys 2019/11/7 2:50 下午
 */
public class SwapSort {
    private static int LEAST_NUM = 2;

    /**
     * 冒泡基本版
     */
    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length < LEAST_NUM) {
            return;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    Sort.swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * 冒泡优化版:当某趟没有发生交换，即说明数组已经有序，则中断程序
     */
    public static void betterBubbleSort(int[] nums) {
        if (nums == null || nums.length < LEAST_NUM) {
            return;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    Sort.swap(nums, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] nums, int L, int R) {
        //基线条件
        if (nums == null || nums.length < LEAST_NUM) {
            return;
        }


        //递归条件
        if (L < R) {
            //分区
            int[] p = partition(nums, L, R);
            quickSort(nums, L, p[0] - 1);
            quickSort(nums, p[1] + 1, R);
        }
    }

    /**
     * 根据基准值分区:
     * 分区的过程，整数数组 arr 的[L, R]部分上，使得：
     * 大于 arr[p] 的元素位于[L, R]部分的右边，但这部分数据不一定有序
     * 小于 arr[p] 的元素位于[L, R]部分的左边，但这部分数据不一定有序
     * 等于 arr[p] 的元素位于[L, R]部分的中间
     * 返回等于部分的第一个元素的下标和最后一个下标组成的整数数组
     */
    private static int[] partition(int[] arr, int l, int r) {
        //随机基准值
        int pivot = arr[new Random().nextInt(r - l + 1) + l];
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < pivot) {
                BitUtils.bitSwap(arr, ++less, l++);
                //为何此时l++？l从左开始扫，less=l-1，故每次交换++less后l(原来的less+1值<=l值)都小于pivot
            } else if (arr[l] > pivot) {
                BitUtils.bitSwap(arr, --more, l);
                //此时交换了more后l的值不确定，故不能++
            } else {
                l++;
            }
        }
        return new int[]{less + 1, more - 1};
    }
}
