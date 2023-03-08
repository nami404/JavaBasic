package IOStream.Serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author nami
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        //1.创建对象
        Student stu = new Student("zhangsan", 24);

        //2.创建序列化流的对象/对象操作输出流
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("/Users/nami/IdeaProjects/tempFile/a.txt")));

        //3.写出数据
        oos.writeObject(stu);

        //4.释放资源
        oos.close();
    }
}
