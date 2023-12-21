package com.myMovie.tool;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class MyTool {
    /**
     *
     * @param multipartFile 前端返回的文件类型
     * @param realPath 真实路径
     * @return
     * true 文件已被存入
     * false 文件未被存入
     * @throws IOException
     */
    public boolean create(MultipartFile multipartFile,String realPath) throws IOException {
        File file = new File(realPath);
        multipartFile.transferTo(file);
        return isImg(realPath);
    }

    /**
     *
     * @param realPath 真实路劲
     * @return
     * true 文件被删除
     * false 文件未删除
     */
    public boolean delete(String realPath){
        boolean results = false;
        File file = new File(realPath);
        if (isImg(realPath)) {
            results = file.delete();
        }
        return results;
    }

    /**
     *
     * @param realPath 真实路径
     * @return
     *  true 文件存在
     *  false 文件不存在
     */
    public boolean isImg(String realPath){
        File file = new File(realPath);
        return file.exists();
    }

    /**
     *
     * @param oldPath 原始路径
     * @param splitStr 需要分割的字符
     * @param place 末尾是否加位
     * @return
     * 切割后的字符
     */
    public String Split(String oldPath,String splitStr,int place){
        int index = oldPath.lastIndexOf(splitStr);
        return oldPath.substring(index+place);
    }
}
