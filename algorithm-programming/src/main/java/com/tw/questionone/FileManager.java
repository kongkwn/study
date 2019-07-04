package com.tw.questionone;

import java.io.File;
import java.io.FileReader;

/**
 * @Author: tanwei
 * @Description:
 * @Date: Create in 9:54 2019/7/4
 */
public class FileManager {
    private String[] words;
    private int pos=0;

    public FileManager(String filePath, String separator) {
        try {
            File file = new File(filePath);
            //使用FileReader将文件读入内存
            FileReader fileReader = new FileReader(file);
            //file.length 返回文件字节大小
            char[] buf =new char[(int)file.length()];
            //将文件字节读入buf并返回长度
            int length = fileReader.read(buf);
            //new String(buf,offset,length)
            // bytes：要解码为字符的 byte
            // offset： 要解码的第一个 byte 的索引
            // length： 要解码的 byte 数 的长度
            String fileStrings =new String(buf,0,length);
            words=fileStrings.split(separator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] getWords() {
        return words;
    }

    public String getNextWord(){
        if(pos==words.length){
            return null;
        }
        //i++ 先使用该值，后+1
        //++i 先+1，后使用该值
        return words[pos++];
    }
}
