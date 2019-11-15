package com.ys.bit;

import com.ys.alg.sort.SwapSortTest;

/**
 * @author ys 2019/11/7 4:23 下午
 */
public class SortTest {
    public static void main(String[] args) {
        int[] a = new int[]{9, 13, 23, 1, 3, 6, 43, 56, 78};
        SwapSortTest.quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
