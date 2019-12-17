package bit;

import sort.SwapSortTest;

/**
 * @author ys 2019/11/15 1:50 下午
 */
public class BitMapTest {
    //由于使用byte为8个bit故mask为7用来取余运算
    private static int MASK = 0x07;
    //由于使用byte,每个byte能存8位bit即8个数，则只需要除8的数组长度
    private static int SHIFT = 3;

    private static void set(byte[] bits, int num) {
        bits[num >> SHIFT] |= 1 << (num & MASK);
    }

    private static void clr(byte[] bits, int num) {
        bits[num >> SHIFT] &= ~(1 << (num & MASK));
    }

    public static void main(String[] args) {
        int n = 10000000;
        byte[] bits = new byte[(n >> 3) + 1];
        //比较位图运算和快速排序的排序速度
        int i;
        for(i=0;i<n;i++){
            clr(bits,i);
        }
        while (i>0){
            set(bits,--i);
        }


    }

}
