import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Java 8 Lambda 使用学习
 */
public class Lambda {
    public static void main(String[] args) {
//        // 创建线程
//        Thread a = new Thread(() -> System.out.println("Hello, Lambda!"));
//        a.start();

        // 排序
        List<String> l = Arrays.asList(new String[]{"c", "a", "b"});
        Collections.sort(l, (str1, str2) -> str1.compareTo(str2));
        l.forEach(System.out::println);
    }
}
