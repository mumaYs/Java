package bit;

import bit.BitUtils.*;

import static bit.BitUtils.*;

/**
 * @author ys 2019/11/13 5:14 下午
 */
public class BitUtilTest {
    /**
     * 入口函数做测试
     *
     * @param args
     */
    public static void main(String[] args) {

        // 取十进制 11 (二进制 0000 1011) 为例子
        byte source = 11;

        // 取第2位值并输出, 结果应为 0000 1011
        for (byte i = 7; i >= 0; i--) {
            System.out.printf("%d ", getBitValue(source, i));
        }

        // 将第6位置为1并输出 , 结果为 75 (0100 1011)
        System.out.println("\n" + setBitValue(source, 6, (byte) 1));

        // 将第6位取反并输出, 结果应为75(0100 1011)
        System.out.println(reverseBitValue(source, 6));

        // 检查第6位是否为1，结果应为false
        System.out.println(checkBitValue(source, 6));

        // 输出为1的位, 结果应为 0 1 3
        for (byte i = 0; i < 8; i++) {
            if (checkBitValue(source, i)) {
                System.out.printf("%d ", i);
            }
        }

    }
}
