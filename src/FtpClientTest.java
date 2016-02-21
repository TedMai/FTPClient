import org.junit.Test;

import java.io.*;

/**
 * Created by 常大爷  on 2016/2/20.
 * 描述：
 */
public class FtpClientTest {

    @Test
    public void testUpLoadFromDisk() {
        long start = System.currentTimeMillis();
        try {
            String rootPath = "D:/ceshi/";
            String filiName = "eclipse-4.4.1.zip";
            FileInputStream in = new FileInputStream(new File(rootPath + filiName));
            boolean b = Main.uploadFile("192.168.225.128", 2121, "admin", "admin", "/root/apache-ftpserver-1.0.5/res/home", new String(filiName.getBytes(), "iso-8859-1"), in);
            if (b) {
                System.out.println("文件上传成功 ----原文件路径：" + rootPath + filiName + "上传到文件的路径为：" + "./res/home" + filiName);
            } else {
                System.out.println("文件上传失败 ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件上传时间为：" + (System.currentTimeMillis() - start) + "毫秒");
    }

    @Test
    public void testDownFile() throws UnsupportedEncodingException {
        long start = System.currentTimeMillis();
        boolean b = Main.downFile("192.168.225.128", 2121, "admin", "admin", "/root/apache-ftpserver-1.0.5/res/home", new String("eclipse-4.4.1.zip".getBytes(), "iso-8859-1"), "D:/download/");
        if (b) {
            System.out.println("文件下载完成 ！！！");
        } else {
            System.out.println("文件下载失败 ！！！");
        }
        System.out.println("文件下载时间为：" + (System.currentTimeMillis() - start) + "毫秒");
    }

}
