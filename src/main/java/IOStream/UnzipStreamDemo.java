package IOStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author nami
 */
public class UnzipStreamDemo {
    public static void main(String[] args) throws IOException {
        // 创建一个File表示要解压的压缩包
        File src = new File("/Users/nami/IdeaProjects/tempFile/aaa.zip");
        // 创建一个File表示解压的目的地
        File dest = new File("/Users/nami/IdeaProjects/tempFile");

        unZip(src, dest);
    }

    private static void unZip(File src, File dest) throws IOException {
        // 解压的本质：把压缩包里面的每一个文件或文件夹读取出来，按照层级拷贝到目的地中

        //创建一个解压缩流用来读取压缩包中的数据
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src));
        //先获取压缩包里面的每一个zipEntry对象
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            if (entry.isDirectory()) {
                //是文件夹，就创建对应文件夹
                File file = new File(dest, entry.getName());
                file.mkdirs();
            } else {
                //是文件，创建对应文件
                FileOutputStream fos = new FileOutputStream(new File(dest, entry.getName()));
                int b;
                while ((b = zis.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                //表示在压缩包中的一个文件处理完毕了
                zis.closeEntry();
            }
        }
        zis.close();
    }
}
