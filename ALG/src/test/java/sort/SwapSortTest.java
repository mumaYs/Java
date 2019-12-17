package sort;

import java.util.Random;

/**
 * @author ys 2019/11/8 10:46 上午
 */
public class SwapSortTest {
    public static void quickSort(int[] arr, int L, int R) {
        if (arr == null || arr.length < 2) {
            return;
        }

        if (L < R) {
            int[] p = partitions(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    private static int[] partitions(int[] arr, int L, int R) {
        int pivot = arr[new Random().nextInt(R - L + 1) + L];
        int less = L - 1;
        int more = R + 1;

        while (L < more) {
            if (arr[L] < pivot) {
                swap(arr, ++less, L++);
            } else if (arr[L] > pivot) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    private static void swap(int arr[], int i, int j) {
        if (arr[i] == arr[j]) {
            return;
        }
        arr[i] = arr[j] ^ arr[i];
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[j] ^ arr[i];
    }
}
