package com.ys.bit;

import com.sun.istack.internal.NotNull;
import com.sun.org.apache.bcel.internal.generic.SWAP;
import com.ys.alg.sort.SwapSort;

import java.util.Random;

/**
 * @author ys 2019/11/7 4:23 下午
 */
public class SortTest {
    public static void main(String[] args) {
        int[] a = new int[]{9, 13, 23, 1, 3, 6, 43, 56, 78};
        SwapSort.quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
