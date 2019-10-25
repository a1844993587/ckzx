package com.xuecheng.search;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

/**
 * @author Alex Yu
 * @date 2019/9/25 16:34
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestIndex {

    @Autowired
    RestHighLevelClient client;
    @Autowired
    RestClient restClient;
//    @Autowired
//    CoursePubRepository coursePubRepository;

    @Test
    public void testCreateIndex() throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("xc_course");
        createIndexRequest.settings(Settings.builder().put("number_of_shards", "1").put("number_of_replicas", "0"));
        createIndexRequest.mapping("doc", "{\n" +
                "\t\"properties\": {\n" +
                "\t\t\"name\": {\n" +
                "\t\t\t\"type\": \"text\",\n" +
                "\t\t\t\"analyzer\":\"ik_max_word\",\n" +
                "\t\t\t\"search_analyzer\":\"ik_smart\"\n" +
                "\t\t},\n" +
                "\t\t\"description\": {\n" +
                "\t\t\t\"type\": \"text\",\n" +
                "\t\t\t\"analyzer\":\"ik_max_word\",\n" +
                "\t\t\t\"search_analyzer\":\"ik_smart\"\n" +
                "\t\t},\n" +
                "\t\t\"pic\":{\n" +
                "\t\t\t\"type\":\"text\",\n" +
                "\t\t\t\"index\":false\n" +
                "\t\t},\n" +
                "\t\t\t\"studymodel\":{\n" +
                "\t\t\t\"type\":\"text\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}", XContentType.JSON);
        IndicesClient indices = client.indices();
        // 创建索引库
        CreateIndexResponse createIndexResponse = indices.create(createIndexRequest);
        // 得到响应
        System.out.println(createIndexResponse.isAcknowledged());
    }

    @Test
    public void testDeleteIndex() throws IOException {
        // 创建删除索引对象
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("xc_course");
        // 操作索引客户端
        IndicesClient indices = client.indices();
        // 执行删除
        DeleteIndexResponse delete = indices.delete(deleteIndexRequest);
        // 得到响应
        System.out.println(delete.isAcknowledged());
    }

    // 添加文档
    @Test
    public void testAdd() throws IOException {
//        List<CoursePub> all = coursePubRepository.findAll();
//        for (CoursePub coursePub : all) {
//            Map<String, Object> jsonMap = new HashMap<>();
//            jsonMap.put("charge", coursePub.getCharge());
//            jsonMap.put("description", coursePub.getDescription());
//            jsonMap.put("expires", coursePub.getExpires());
//            jsonMap.put("grade", coursePub.getGrade());
//            jsonMap.put("id", coursePub.getId());
//            jsonMap.put("mt", coursePub.getMt());
//            jsonMap.put("name", coursePub.getName());
//            jsonMap.put("pic", coursePub.getPic());
//            jsonMap.put("price", coursePub.getPrice());
//            jsonMap.put("price_old", coursePub.getPrice_old());
//            jsonMap.put("pub_time", coursePub.getPubTime());
//            jsonMap.put("qq", coursePub.getQq());
//            jsonMap.put("st", coursePub.getSt());
//            jsonMap.put("studymodel", coursePub.getStudymodel());
//            jsonMap.put("teachmode", coursePub.getTeachmode());
//            jsonMap.put("teachplan", coursePub.getTeachplan());
//            jsonMap.put("users", coursePub.getUsers());
//            jsonMap.put("valid", coursePub.getValid());
//            IndexRequest indexRequest = new IndexRequest("xc_course", "doc");
//            indexRequest.source(jsonMap);
//            IndexResponse index = client.index(indexRequest);
//
//        }
        //准备json数据
        System.out.println("-----------------end----------------------");
    }

    @Test
    public void testGet() throws IOException {
        GetRequest getRequest = new GetRequest("xc_course", "doc", "V_qgZ20Bi6O3OarLrF2K");
        GetResponse getResponse = client.get(getRequest);
        Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
        System.out.println(sourceAsMap);
    }

}
