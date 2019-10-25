package com.xuecheng.api.course;

import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.CoursePic;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.domain.course.ext.CourseView;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.domain.course.response.AddCourseResult;
import com.xuecheng.framework.domain.course.response.CoursePublishResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Alex Yu
 * @date 2019/9/16 15:12
 */
@Api(value = "课程管理接口", description = "课程管理接口，提供课程的管理、查询接口")
public interface CourseControllerApi {

    @ApiOperation("课程计划查询")
    TeachplanNode findTeachPlanList(String courseId);

    @ApiOperation("添加课程计划")
    ResponseResult addTeachplan(Teachplan teachplan);

    @ApiOperation("添加课程基础信息")
    AddCourseResult addCourseBase(CourseBase courseBase);

    @ApiOperation("查询课程")
    QueryResponseResult findCourseList(int page, int size, CourseListRequest courseListRequest);

    @ApiOperation("根据Id查询课程详情")
    CourseBase getCoursebaseById(String id);

    @ApiOperation("添加课程图片")
    ResponseResult addCoursePic(String courseId, String pic);

    @ApiOperation("查询课程图片")
    CoursePic findCoursePic(String courseId);

    @ApiOperation("删除课程图片")
    ResponseResult deleteCoursePic(String courseId);

    @ApiOperation("课程视图查询")
    CourseView courseView(String id);

    @ApiOperation("课程预览")
    CoursePublishResult preview(String id);

    @ApiOperation("课程发布")
    CoursePublishResult publish(String id);
}
