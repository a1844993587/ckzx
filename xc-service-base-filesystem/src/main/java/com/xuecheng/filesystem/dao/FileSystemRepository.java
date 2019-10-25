package com.xuecheng.filesystem.dao;

import com.xuecheng.framework.domain.filesystem.FileSystem;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Alex Yu
 * @date 2019/9/22 11:36
 */
public interface FileSystemRepository extends MongoRepository<FileSystem, String> {
}
