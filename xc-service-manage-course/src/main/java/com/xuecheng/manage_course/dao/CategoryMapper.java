package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Alex Yu
 * @date 2019/9/18 13:51
 */
@Mapper
public interface CategoryMapper {

    CategoryNode selectList();

}
