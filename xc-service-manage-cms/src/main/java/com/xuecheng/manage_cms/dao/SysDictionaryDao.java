package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.system.SysDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Alex Yu
 * @date 2019/9/18 14:10
 */
public interface SysDictionaryDao extends MongoRepository<SysDictionary, String> {

    SysDictionary findBydType(String dType);
}
