package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Alex Yu
 * @date 2019/9/12 22:12
 */
public interface CmsConfigRepository extends MongoRepository<CmsConfig, String> {
}
