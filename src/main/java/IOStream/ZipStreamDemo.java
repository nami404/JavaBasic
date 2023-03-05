package IOStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author nami
 */
public class ZipStreamDemo {
    public static void main(String[] args) throws IOException {
        // 创建一个File表示要压缩的文件夹
        File src = new File("/Users/nami/IdeaProjects/tempFile/aaa");
        File destParent = src.getParentFile();
        // 创建一个File表示压缩的目的地
        File dest = new File(destParent, src.getName() + ".zip");
        //创建压缩流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));
        //获取src里面的每一个文件，变成zipEntry对象，放入到压缩包中

        toZip(src, zos, src.getName());
        //释放资源
        zos.close();
    }

    /**
     * 获取src里面的每一个文件，变成zipEntry对象，放入到压缩包中
     *
     * @param src 数据源
     * @param zos 压缩流
     * @param name 压缩包内部的路径
     * @throws FileNotFoundException
     */
    private static void toZip(File src, ZipOutputStream zos,String name) throws IOException {
        //1.进入src文件夹
        File[] files = src.listFiles();
        //2.遍历数组
        for (File file : files) {
            if (file.isFile()) {
                //判断--文件，变成zipEntry对象，放入到压缩包中
                ZipEntry entry = new ZipEntry(name + File.separator + file.getName());
                zos.putNextEntry(entry);
                //读取文件中的数据，写到压缩包
                FileInputStream fis = new FileInputStream(file);
                int b;
                while ((b = fis.read()) != -1) {
                    zos.write(b);
                }
                fis.close();
                zos.closeEntry();
            } else {
                //判断--文件夹，递归
                toZip(file, zos, name + File.separator + file.getName());
            }
        }

    }
}
