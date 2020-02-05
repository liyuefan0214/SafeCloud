package com.liyuefan.cloud.utils.file;

import java.io.File;

/**
 * @Author liyuefan
 * @Date create in 2020/2/5 18:44
 * @Description
 */
public class FileUtils {
    public static void makeDir(String folderName) {
        File file = new File(folderName);
        file.mkdirs();
    }
}
