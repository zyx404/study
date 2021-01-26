package com.example.api.ftp;

import com.example.api.tools.FtpUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@SpringBootTest
public class PictureFTPTest {
    @Test
    public void testFTPClient() throws IOException {

        String host = "10.103.238.99";
        int port = 21;
        String username = "uftp";
        String passwd = "zyx199503";
        String basePath = "/home/uftp/img";
        String filePath = "/image";
        String fileName = "/Users/zuoyuanxun/Java/front/vueblog-vue/src/assets/plus.png";

        //1、创建一个FtpClient对象
        FTPClient ftpClient = new FTPClient();
        //2.创建Ftp连接
        ftpClient.connect("10.103.238.99", 21);
        //3.登录
        ftpClient.login("uftp", "zyx199503");
        int replyCode = ftpClient.getReplyCode(); //replyCode表示的是返回的状态码。
        boolean res = FTPReply.isPositiveCompletion(replyCode);//判断状态码的状态，如果为true，表示连接成功。
        //4.读取本地文件
        FileInputStream fileInputStream = new FileInputStream(new File("/Users/zuoyuanxun/Java/front/vueblog-vue/src/assets/plus.png"));
        //5.设置上传的路径
        ftpClient.changeWorkingDirectory("/home/uftp/img");

        ftpClient.enterLocalPassiveMode();
        // 6. 修改上传文件的格式为二进制
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //7.服务器存储文件，第一个参数是存储在服务器的文件名，第二个参数是文件流
        boolean res1 = ftpClient.storeFile("3.jpg", fileInputStream);
        //8.关闭连接
        ftpClient.disconnect();
    }

    @Test
    public void testFTPClient1() throws IOException {
//        String host = "10.103.238.99";
        String host = "139.155.35.77";
        int port = 21;
        String username = "uftp";
        String passwd = "zyx199503";
        String basePath = "/home/uftp/img";
        String filePath = "/image";
        String fileName = "shuai2.png";
        FileInputStream fileInputStream = new FileInputStream(new File("/Users/zuoyuanxun/Java/front/vueblog-vue/src/assets/timg.png"));
        FtpUtil.uploadFile(host, port, username, passwd, basePath, filePath, fileName, fileInputStream);

    }
}
