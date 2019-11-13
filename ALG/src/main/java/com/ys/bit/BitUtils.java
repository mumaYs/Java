package com.ys.bit;

import com.sun.istack.internal.NotNull;

/**
 * 二进制的最高位是符号位，0表示正，1表示负
 * &--与运算:只要有一个为0，就为0|用途:取相同的位、2的幂等判断
 * ^--异或运算:相同的为0，不同的为1|用途:取不同的位、数值交换
 * <<--向左位移:向左移动n位，后面用0补齐|用途:左移n位即乘2的n次方
 * >>--向右位移:转换成二进制后向右移动3位|用途:右移n位即除2的n次方
 * >>>--无符号右移:无符号右移,忽略符号位,空位都以0补齐,与>>唯一的不同是它无论原来的最左边是什么数，统统都用0填充
 *
 * @author ys 2019/11/8 10:39 上午
 */
public class BitUtils {

    /**
     * &
     * 判断一个数是否是2的幂次方
     * 解析:
     * 二进制中n一旦是2的幂次方，必为10，100，1000，10000，100000，…形式;
     * 并且n-1为01,011,0111,0111，01111形式。
     * 所以只要让n,n-1两个数按位与&等于零则为2的幂次方
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * &
     * 求一个数转化为二进制后，包含1的数量
     * 解析:
     * 利用二进制中n一旦是2的幂次方,则n & (n - 1) = 0
     * 如果n不是2的幂次方则每次循环n & (n - 1)结果就会等于n - 1，再赋值给n故n每次循环都会-1
     * 直到n为2的幂等,即n & (n - 1) = 0时，代表此时只有一个1了
     * 示例:
     * 11 & 10 = 10     =>      0000 1011  &  0000 1010  = 0000 1010
     * 10 & 9 = 9       =>      0000 1010  &  0000 1001  = 0000 1001
     * 9 & 8 = 8        =>      0000 1001  &  0000 1000  = 0000 1000
     * 8 & 7 = 0        =>      0000 1000  &  0000 0111  = 0000 0000
     */
    public static int countOne(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * & ^
     * 求平均值
     * 解析:
     * x & y是取相同位与，结果是x和y相同位的和的一半；
     * x ^ y是取x和y的不同位，右移相当于除以2，所以这个函数的功能是取平均值
     * 示例:
     * 11 & 15 = 11   =>  0000 1011  &  0000 1111 = 0000 1011
     * 11 ^ 15 = 4    => 0000 1011 ^ 0000 1111 = 0000 0100
     * 4 >> 1 = 13    => 0000 0100 >> 1 = 0000 0010
     * <p>
     * 8 & 7 = 0      => 0000 1000 & 0000 0111 = 0000 0000
     * 8 ^ 7 = 15     => 0000 1000 ^ 0000 0111 = 0000 1111
     * 15 >> 1 = 7    => 0000 1111 >> 1 = 0000 0111
     */
    public static int avg(int x, int y) {
        return (x & y) + ((x ^ y) >> 1);
    }

    /**
     * ^
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

    /**
     * 获取运算数指定位置的值
     * 例如： 0000 1011 获取其第 0 位的值为 1, 第 2 位 的值为 0
     *
     * @param source 需要运算的数
     * @param pos    指定位置 (0<=pos<=7)
     * @return 指定位置的值(0 or 1)
     */
    public static byte getBitValue(byte source, int pos) {
        return (byte) ((source >> pos) & 1);
    }


    /**
     * 将运算数指定位置的值置为指定值
     * 例: 0000 1011 需要更新为 0000 1111, 即第 2 位的值需要置为 1
     *
     * @param source 需要运算的数
     * @param pos    指定位置 (0<=pos<=7)
     * @param value  只能取值为 0, 或 1, 所有大于0的值作为1处理, 所有小于0的值作为0处理
     * @return 运算后的结果数
     */
    public static byte setBitValue(byte source, int pos, byte value) {

        byte mask = (byte) (1 << pos);
        if (value > 0) {
            source |= mask;
        } else {
            source &= (~mask);
        }

        return source;
    }


    /**
     * 将运算数指定位置取反值
     * 例： 0000 1011 指定第 3 位取反, 结果为 0000 0011; 指定第2位取反, 结果为 0000 1111
     *
     * @param source
     * @param pos    指定位置 (0<=pos<=7)
     * @return 运算后的结果数
     */
    public static byte reverseBitValue(byte source, int pos) {
        byte mask = (byte) (1 << pos);
        return (byte) (source ^ mask);
    }


    /**
     * 检查运算数的指定位置是否为1
     *
     * @param source 00001011
     *               需要运算的数
     * @param pos    指定位置 (0<=pos<=7)
     * @return true 表示指定位置值为1, false 表示指定位置值为 0
     */
    public static boolean checkBitValue(byte source, int pos) {

        source = (byte) (source >>> pos);

        return (source & 1) == 1;
    }

    /**
     * 入口函数做测试
     *
     * @param args
     */
    public static void main(String[] args) {

        // 取十进制 11 (二进制 0000 1011) 为例子
        byte source = 11;

//        // 取第2位值并输出, 结果应为 0000 1011
//        for (byte i = 7; i >= 0; i--) {
//            System.out.printf("%d ", getBitValue(source, i));
//        }
//
//        // 将第6位置为1并输出 , 结果为 75 (0100 1011)
//        System.out.println("\n" + setBitValue(source, 6, (byte) 1));
//
//        // 将第6位取反并输出, 结果应为75(0100 1011)
//        System.out.println(reverseBitValue(source, 6));
//
//        // 检查第6位是否为1，结果应为false
//        System.out.println(checkBitValue(source, 6));
//
//        // 输出为1的位, 结果应为 0 1 3
//        for (byte i = 0; i < 8; i++) {
//            if (checkBitValue(source, i)) {
//                System.out.printf("%d ", i);
//            }
//        }

    }
}
