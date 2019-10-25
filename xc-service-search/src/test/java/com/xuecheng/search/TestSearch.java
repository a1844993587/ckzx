package com.xuecheng.search;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author Alex Yu
 * @date 2019/9/25 16:34
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSearch {

    @Autowired
    RestHighLevelClient client;
    @Autowired
    RestClient restClient;

    @Test
    public void testSearchAll() throws IOException, ParseException {
        // 搜索请求对象
        SearchRequest searchRequest = new SearchRequest("xc_course");
        // 指定类型
        searchRequest.types("doc");
        // 搜索源对象构建
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 设置源自段过滤
        searchSourceBuilder.fetchSource(new String[]{"name", "studymodel", "price", "timestamp"}, new String[]{});
        // 搜索方式 搜索全部
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        // 执行搜索
        SearchResponse searchResponse = client.search(searchRequest);
        // 搜索结果
        SearchHits hits = searchResponse.getHits();
        // 匹配到的总记录数
        long totalHits = hits.getTotalHits();
        SearchHit[] hitsHits = hits.getHits();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (SearchHit hit : hitsHits) {
            // 文档主键
            String id = hit.getId();
            // 源文档内容
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            // 日期
            Date timestamp = dateFormat.parse((String) sourceAsMap.get("timestamp"));
            System.out.println("name:" + name + "--timestamp:" + timestamp);
        }
    }

    @Test
    public void testSearchPage() throws IOException, ParseException {
        // 搜索请求对象
        SearchRequest searchRequest = new SearchRequest("xc_course");
        // 指定类型
        searchRequest.types("doc");
        // 搜索源对象构建
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 设置分页参数
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(1);
        // 设置源自段过滤
        searchSourceBuilder.fetchSource(new String[]{"name", "studymodel", "price", "timestamp"}, new String[]{});
        // 搜索方式 搜索全部
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        // 执行搜索
        SearchResponse searchResponse = client.search(searchRequest);
        // 搜索结果
        SearchHits hits = searchResponse.getHits();
        // 匹配到的总记录数
        long totalHits = hits.getTotalHits();
        SearchHit[] hitsHits = hits.getHits();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (SearchHit hit : hitsHits) {
            // 文档主键
            String id = hit.getId();
            // 源文档内容
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            // 日期
            Date timestamp = dateFormat.parse((String) sourceAsMap.get("timestamp"));
            System.out.println("name:" + name + "--timestamp:" + timestamp);
        }
    }

    @Test
    public void testTermQuery() throws IOException, ParseException {
        // 搜索请求对象
        SearchRequest searchRequest = new SearchRequest("xc_course");
        // 指定类型
        searchRequest.types("doc");
        // 搜索源对象构建
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 设置分页参数
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(1);
        // 设置源自段过滤
        searchSourceBuilder.fetchSource(new String[]{"name", "studymodel", "price", "timestamp"}, new String[]{});
        // 搜索方式 搜索全部
        searchSourceBuilder.query(QueryBuilders.termQuery("name", "spring"));
        searchRequest.source(searchSourceBuilder);
        // 执行搜索
        SearchResponse searchResponse = client.search(searchRequest);
        // 搜索结果
        SearchHits hits = searchResponse.getHits();
        // 匹配到的总记录数
        long totalHits = hits.getTotalHits();
        SearchHit[] hitsHits = hits.getHits();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (SearchHit hit : hitsHits) {
            // 文档主键
            String id = hit.getId();
            // 源文档内容
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            // 日期
            Date timestamp = dateFormat.parse((String) sourceAsMap.get("timestamp"));
            System.out.println("name:" + name + "--timestamp:" + timestamp);
        }
    }

    @Test
    public void testTermQueryByIds() throws IOException, ParseException {
        // 搜索请求对象
        SearchRequest searchRequest = new SearchRequest("xc_course");
        // 指定类型
        searchRequest.types("doc");
        // 搜索源对象构建
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 设置源自段过滤
        searchSourceBuilder.fetchSource(new String[]{"name", "studymodel", "price", "timestamp"}, new String[]{});
        // 搜索方式 搜索全部
        String[] ids = new String[]{"1", "2"};
        searchSourceBuilder.query(QueryBuilders.termsQuery("_id", ids));
        searchRequest.source(searchSourceBuilder);
        // 执行搜索
        SearchResponse searchResponse = client.search(searchRequest);
        // 搜索结果
        SearchHits hits = searchResponse.getHits();
        // 匹配到的总记录数
        long totalHits = hits.getTotalHits();
        SearchHit[] hitsHits = hits.getHits();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (SearchHit hit : hitsHits) {
            // 文档主键
            String id = hit.getId();
            // 源文档内容
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            // 日期
            Date timestamp = dateFormat.parse((String) sourceAsMap.get("timestamp"));
            System.out.println("name:" + name + "--timestamp:" + timestamp);
        }
    }

    @Test
    public void testMatchQuery() throws IOException, ParseException {
        // 搜索请求对象
        SearchRequest searchRequest = new SearchRequest("xc_course");
        // 指定类型
        searchRequest.types("doc");
        // 搜索源对象构建
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 设置源自段过滤
        searchSourceBuilder.fetchSource(new String[]{"name", "studymodel", "price", "timestamp", "description"}, new String[]{});
        // 搜索方式 搜索全部
        searchSourceBuilder.query(QueryBuilders.matchQuery("description", "Spring开发框架").minimumShouldMatch("80%"));
        searchRequest.source(searchSourceBuilder);
        // 执行搜索
        SearchResponse searchResponse = client.search(searchRequest);
        // 搜索结果
        SearchHits hits = searchResponse.getHits();
        // 匹配到的总记录数
        long totalHits = hits.getTotalHits();
        SearchHit[] hitsHits = hits.getHits();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (SearchHit hit : hitsHits) {
            // 文档主键
            String id = hit.getId();
            // 源文档内容
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            // 日期
            Date timestamp = dateFormat.parse((String) sourceAsMap.get("timestamp"));
            System.out.println("name:" + name + "--timestamp:" + timestamp);
        }
    }

    @Test
    public void testMultiMatchQuery() throws IOException, ParseException {
        // 搜索请求对象
        SearchRequest searchRequest = new SearchRequest("xc_course");
        // 指定类型
        searchRequest.types("doc");
        // 搜索源对象构建
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 设置源自段过滤
            searchSourceBuilder.fetchSource(new String[]{"name", "studymodel", "price", "timestamp", "description"}, new String[]{});
        // 搜索方式 搜索全部
        searchSourceBuilder.query(QueryBuilders.multiMatchQuery("spring css", "name", "description").minimumShouldMatch("50%").field("name", 10));
        searchRequest.source(searchSourceBuilder);
        // 执行搜索
        SearchResponse searchResponse = client.search(searchRequest);
        // 搜索结果
        SearchHits hits = searchResponse.getHits();
        // 匹配到的总记录数
        long totalHits = hits.getTotalHits();
        SearchHit[] hitsHits = hits.getHits();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (SearchHit hit : hitsHits) {
            // 文档主键
            String id = hit.getId();
            // 源文档内容
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            // 日期
            Date timestamp = dateFormat.parse((String) sourceAsMap.get("timestamp"));
            System.out.println("name:" + name + "--timestamp:" + timestamp);
        }
    }

}
