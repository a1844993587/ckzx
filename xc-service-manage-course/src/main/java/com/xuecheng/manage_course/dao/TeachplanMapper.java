package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Alex Yu
 * @date 2019/9/16 15:25
 */
@Mapper
public interface TeachplanMapper {

    TeachplanNode selectList(String courseId);

}
