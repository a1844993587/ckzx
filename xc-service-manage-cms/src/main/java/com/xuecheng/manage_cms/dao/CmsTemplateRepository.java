package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Alex Yu
 * @date 2019/9/8 21:17
 */
public interface CmsTemplateRepository extends MongoRepository<CmsTemplate, String> {


}
