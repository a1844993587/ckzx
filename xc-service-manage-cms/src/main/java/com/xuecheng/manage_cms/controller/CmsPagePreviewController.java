package com.xuecheng.manage_cms.controller;

import com.xuecheng.framework.web.BaseController;
import com.xuecheng.manage_cms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.ServletOutputStream;
import java.io.IOException;

/**
 * @author Alex Yu
 * @date 2019/9/13 0:59
 */
@Controller
public class  CmsPagePreviewController extends BaseController {

    @Autowired
    private PageService pageService;

    // 页面预览
    @GetMapping("/cms/preview/{pageId}")
    public void preview(@PathVariable("pageId")String pageId) throws IOException {
        // 执行静态化
        String pageHtml = pageService.getPageHtml(pageId);
        ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader("Content-type", "text/html;charset=utf-8");
        outputStream.write(pageHtml.getBytes("utf-8"));
    }

}
