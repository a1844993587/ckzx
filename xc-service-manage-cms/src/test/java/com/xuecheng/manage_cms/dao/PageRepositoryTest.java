package com.xuecheng.manage_cms.dao;

import com.xuecheng.manage_cms.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Alex Yu
 * @date 2019/9/13 0:45
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PageRepositoryTest {

    @Autowired
    PageService pageService;

    @Test
    public void testGetPageHtml() {
        String pageHtml = pageService.getPageHtml("5d774e9d2c030a2270bc4c7e");
        System.out.println(pageHtml);
    }

}
