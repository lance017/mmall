package com.mmall.service.Impl;

import com.mmall.service.IFileService;
import com.mmall.util.qiniu.QiniuStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by lance on 2017/8/12.
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public String upload(MultipartFile file, String path) {

        String key = null;
        try {
            if (null != file && file.getBytes().length > 0) {
                key = QiniuStorage.uploadImage(file.getBytes());//七牛上传图片
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = QiniuStorage.getUrl(key);

        return url + "----" + key;

    }


}
