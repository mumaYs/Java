import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * java 8 文件工具类
 */
public class FileUtil8 {

    /**
     * 非常方便的对文件进行移动操作
     * 将tt.txt从pathFrom文件夹位置移动到pathTo文件夹下
     * <h1>此方法可以和copy这个方法相比较，用法相同，其他增删改查操作请参考api即可</h1>
     *
     * @throws IOException
     */
    public static void moveFile() {
        Path pathFrom = Paths.get("e:/logs", "tt.txt");
        //其中e:/logs/errorLog/tt.txt的tt.txt文件可以不存在，如果存在会被替换掉
        Path pathTo = pathFrom.getParent().resolve("errorLog/dd.txt");
        try {
            //文件的大小bytes
            System.out.println(Files.size(pathFrom));
            //调用文件移动方法
            Files.move(pathFrom, pathTo, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("移动文件错误" + e.getMessage());
        }
    }

    /**
     * 测试文件的属性信息
     * 包括文件的修改时间、是否是文件夹、创建时间等
     */
    @SuppressWarnings("deprecation")
    public static void fileAttributes() {
        Path path = Paths.get("e:/logs");
        //1
        System.out.println(Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS));
        //2
        try {
            //获得文件的基础属性
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println(attributes.isDirectory());
            System.out.println(new Date(attributes.lastModifiedTime().toMillis()).toLocaleString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建文件夹
     * 遍历文件夹下的文件
     */
    public static void createDir() {
        Path path = Paths.get("e:/test/tte");
        try {
            //创建文件夹
            if (Files.notExists(path)) {
                Files.createDirectories(path);
                System.out.println("create dir");
            } else {
                System.out.println("dir exists");
            }
            //在创建的文件夹下建几个txt文件,例如
            //2.txt
            //ff  文件夹
            //java.bat
            //_java.txt
            //遍历文件夹下面的文件
            DirectoryStream<Path> paths = Files.newDirectoryStream(path);
            for (Path p : paths) {
                System.out.println(p.getFileName());
            }
            System.out.println();
            //创建一个带有过滤器,过滤文件名以java txt bat结尾的文件
            DirectoryStream<Path> pathsFilter = Files.newDirectoryStream(path, "*.{java,txt,bat}");
            for (Path p : pathsFilter) {
                System.out.println(p.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按行读取文件
     *
     * @param fileName 全路径文件名
     */
    public static List<String> readFileByStream(String fileName) throws IOException {
        List<String> contentLines = Files.lines(Paths.get(fileName))
                .collect(java.util.stream.Collectors.toList());
        return contentLines;
    }

    /**
     * 按字节读取文件
     *
     * @param fileName 全路径文件名
     * @return 字节数组
     * @throws IOException
     */
    public static byte[] readFileByBytes(String fileName) throws IOException {
        byte[] contentBytes = Files.readAllBytes(Paths.get(fileName));
        return contentBytes;
    }

    public static void main(String[] args) {
        List<Integer> primes = Arrays.asList(new Integer[]{2, 3, 5, 7});
        int factor = 2;
        primes.forEach(element -> System.out.println(factor * element));

//        try {
//            // 按行读取文件添加到bulkProcessor
////            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\muma123\\Desktop\\ccfsoft\\TMP\\tmp2.txt"), StandardCharsets.UTF_8);
////            for(String line : lines)
////            {
////                System.out.println(line);
////            }
//            // Java8用流的方式读文件，更加高效
//            Files.lines(Paths.get("C:\\Users\\muma123\\Desktop\\ccfsoft\\TMP\\tmp2.txt"),
//                    StandardCharsets.UTF_8)
//                    .forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
