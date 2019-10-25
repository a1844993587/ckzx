package com.xuecheng.manage_cms_client.dao;

import com.xuecheng.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Alex Yu
 * @date 2019/9/16 13:13
 */
public interface CmsSiteRepository extends MongoRepository<CmsSite, String> {

}
