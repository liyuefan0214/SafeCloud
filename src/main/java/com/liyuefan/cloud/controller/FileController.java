package com.liyuefan.cloud.controller;

import org.springframework.stereotype.Controller;

import java.io.File;

/**
 * @Author liyuefan
 * @Date create in 2020/2/2 21:19
 * @Description
 */
@Controller
public class FileController {
    public static final String storePath = "D:" + File.separator + "SafeCloud"; //存储目录 D:\\SafeCloud
    private static final int normallimit = 1024 * 1024 * 1024; //普通用户上传单个文件的最大体积 1024mb
    private static final int viplimit = 512 * 1024 * 1024; //普通用户上传单个文件的最大体积 512mb
    private static final int factor = 1000000;  //Mb到字节的转换因子
}
