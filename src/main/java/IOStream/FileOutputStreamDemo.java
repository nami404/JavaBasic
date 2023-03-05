package IOStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author nami
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("/Users/nami/IdeaProjects/JavaBasic/src/main/java/IOStream/tempFile/a.txt");
        String str = "i love you!";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        fos.write(bytes);
        fos.close();
    }
}
