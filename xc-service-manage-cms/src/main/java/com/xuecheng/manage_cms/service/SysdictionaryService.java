package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.system.SysDictionary;
import com.xuecheng.manage_cms.dao.SysDictionaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alex Yu
 * @date 2019/9/18 14:11
 */
@Service
public class SysdictionaryService {

    @Autowired
    private SysDictionaryDao sysDictionaryDao;

    public SysDictionary findDictionaryByType(String type) {
        return sysDictionaryDao.findBydType(type);
    }

}
