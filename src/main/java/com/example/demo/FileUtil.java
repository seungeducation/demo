/*
 * Copyright 2017 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */


package com.example.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.util.Arrays;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

/**
 * 文件工具类
 * 
 * @author songxibo 
 * @date 2017年12月15日 上午9:51:45
 */
public class FileUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
    
    /**
     * 把文件转换成base64格式
     *
     * @param imgFile 文件路径
     * @return
     */
    @SuppressWarnings("restriction")
    public static String getImageStr(String imgFile) {
        
        InputStream inputStream = null;
        byte[] data = null;
        try {
        
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
       
        } catch (IOException e) {

            logger.info("文件转换成base64格式失败");
            
        }

        // 加密
//        BASE64Encoder encoder = new BASE64Encoder();
//        return encoder.encode(data);

        return Base64.getEncoder().encodeToString(data);
    
    }
       
    /**
     * 将base64文件转换成byte[]
     * 
     * @param baseStr base64格式字符串
     * @return
     */
    @SuppressWarnings("restriction")
    public static byte[] getImageByteArray(String baseStr) {
        
//        BASE64Decoder decoder = new BASE64Decoder();
        // Base64解码
        byte[] bytes = null;
        try {
            bytes = Base64.getDecoder().decode(baseStr);
//            byte[] bytes1 = decoder.decodeBuffer(baseStr);
//            System.out.println(Arrays.equals(bytes,bytes1));
        
        } catch (Exception e) {

            logger.info("base64转换byte[]失败{}",e);
                
        }
        
        for (int i = 0; i < bytes.length; ++i) {
            if (bytes[i] < 0) {
                bytes[i] += 256;
            }
        }
        
        return bytes;

    }
    
}
