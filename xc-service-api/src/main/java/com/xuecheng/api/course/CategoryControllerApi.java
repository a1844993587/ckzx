package com.xuecheng.api.course;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Alex Yu
 * @date 2019/9/18 13:50
 */
@Api(value = "查询课程分类", description = "查询课程分类管理接口")
public interface CategoryControllerApi {

    @ApiOperation("查询分类")
    CategoryNode findList();

}
