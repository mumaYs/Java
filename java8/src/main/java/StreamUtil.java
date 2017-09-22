import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Java 8 Stream使用
 */
public class StreamUtil {
    public static void main(String[] args) {



//        //3.1.1 使用Stream静态方法来创建Stream
//        //1. of方法：有两个overload方法，一个接受变长参数，一个接口单一值
//        Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
//        Stream<String> stringStream = Stream.of("taobao");
//
//        //2. generator方法：生成一个无限长度的Stream，其元素的生成是通过给定的Supplier（这个接口可以看成一个对象的工厂，每次调用返回一个给定类型的对象）
//        Stream.generate(new Supplier<Double>() {
//            @Override
//            public Double get() {
//                return Math.random();
//            }
//        });

        Stream.generate(() -> Math.random());
        Stream.generate(Math::random);

        /*
        3. iterate方法：也是生成无限长度的Stream，和generator不同的是，
        其元素的生成是重复对给定的种子值(seed)调用用户指定函数来生成的。
        其中包含的元素可以认为是：seed，f(seed),f(f(seed))无限循环
         */
        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);

    }
}
