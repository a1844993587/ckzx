package com.xuecheng.test.fastdfs;

import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author Alex Yu
 * @date 2019/9/20 17:24
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestFastDFS {

    // 上传测试
    @Test
    public void testUpload() {
        try {
            //加载fastdfs-client.properties配置文件
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            //定义TrackerClient，用于请求TrackerServer
            TrackerClient trackerClient = new TrackerClient();
            //连接tracker
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取Stroage
            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);
            //创建stroageClient
            StorageClient1 storageClient1 = new StorageClient1(trackerServer, storeStorage);
            //向stroage服务器上传文件
            //本地文件的路径
            String filePath = "C:\\Users\\AlexYu\\Pictures\\Camera Roll\\one.jpg";
            //上传成功后拿到文件Id
            String fileId = storageClient1.upload_file1(filePath, "jpg", null);
            System.out.println(fileId);
            //group1/M00/00/00/wKhLgF2EtVyAbaTsAA5nGodq5_o059.jpg

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 下载测试
    @Test
    public void testDownLoad() throws Exception {
        //加载fastdfs-client.properties配置文件
        ClientGlobal.initByProperties("config/fastdfs-client.properties");
        //定义TrackerClient，用于请求TrackerServer
        TrackerClient trackerClient = new TrackerClient();
        //连接tracker
        TrackerServer trackerServer = trackerClient.getConnection();
        //获取Stroage
        StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);
        //创建stroageClient
        StorageClient1 storageClient1 = new StorageClient1(trackerServer, storeStorage);
        String fileId = "group1/M00/00/00/wKhLgF2EtVyAbaTsAA5nGodq5_o059.jpg";
        byte[] bytes = storageClient1.download_file1(fileId);
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\saveFiles\\1.jpg"));
        fileOutputStream.write(bytes);
    }

}
