package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by lance on 2017/8/12.
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
