package com.tw.questiontwo;

import java.io.*;

/**
 * @Author: tanwei
 * @Description:编写一个程序，将amkdir目录下的所有.java文件复制到bmkdir目录下，并将原来文件的扩展名从.java改为.jad。
 * @Date: Create in 14:33 2019/7/4
 */
public class Answer {
    public static void main(String[] args) {
        try {
            File amkdir =new File("E:\\workspace\\study\\algorithm-programming\\src\\main\\java\\com\\tw\\questiontwo\\amkdir");
            if(!(amkdir.exists() && amkdir.isDirectory())){
                throw new Exception("不是目录");
            }
            final File[] files = amkdir.listFiles(new FileFilter(){

                public boolean accept(File pathname) {
                    return pathname.getName().endsWith(".java");
                }
            });
            //自己的逻辑循环判断
            for (File file : files) {
                if(file.getName().endsWith(".java")){
                    FileInputStream fileInputStream=new FileInputStream(file);
                    File bmkdir=new File("E:\\workspace\\study\\algorithm-programming\\src\\main\\java\\com\\tw\\questiontwo\\bmkdir");
                    if(!bmkdir.exists()){
                        bmkdir.mkdirs();
                    }
                    String fileName=file.getName().replaceAll("\\.java$",".jad");
                    FileOutputStream fileOutputStream =new FileOutputStream(new File(bmkdir,fileName));
                    copy(fileInputStream,fileOutputStream);
                    fileInputStream.close();
                    fileOutputStream.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void copy(FileInputStream fileInputStream,FileOutputStream outputStream)throws Exception{
        int len=0;
        byte[] bytes =new byte[1024];
        while((len=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
    }
}
