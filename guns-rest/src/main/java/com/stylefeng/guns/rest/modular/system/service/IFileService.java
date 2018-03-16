package com.stylefeng.guns.rest.modular.system.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by geely
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
