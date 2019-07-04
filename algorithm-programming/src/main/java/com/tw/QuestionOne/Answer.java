package com.tw.QuestionOne;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

/**
 * @Author: tanwei
 * @Description:编写一个程序，将a.txt文件中的单词与b.txt文件中的单词交替合并到c.txt文件中，a.txt文件中的单词用回车符分隔，b.txt文件中用回车或空格进行分隔。
 * @Date: Create in 14:40 2019/7/3
 */
public class Answer {

    public static void main(String[] args) {
        try {

            FileManager aFileManager =new FileManager("E:\\workspace\\study\\algorithm-programming\\src\\main\\java\\com\\tw\\QuestionOne\\a.txt","\r\n");
            FileManager bFileManager =new FileManager("E:\\workspace\\study\\algorithm-programming\\src\\main\\java\\com\\tw\\QuestionOne\\b.txt"," ");
            String[] aFileManagerWords = aFileManager.getWords();
            String[] bFileManagerWords = bFileManager.getWords();
            //自己的逻辑，使用builder重组数组
            StringBuilder stringBuilder =null;
            /*if(aFileManagerWords.length<=bFileManagerWords.length){
                stringBuilder=getNewArray(aFileManagerWords,bFileManagerWords);
            }else{
                stringBuilder=getNewArray(bFileManagerWords,aFileManagerWords);
            }*/
            File cFile=new File("E:\\workspace\\study\\algorithm-programming\\src\\main\\java\\com\\tw\\QuestionOne\\c.txt");
            if (cFile.exists()){
                cFile.delete();
            }
            FileWriter fileWriter =new FileWriter(cFile);
            String aStr=null;
            String bStr=null;
            while ((aStr=aFileManager.getNextWord())!=null){
                fileWriter.write(aStr);
                if((bStr=bFileManager.getNextWord())!=null){
                    fileWriter.write(bStr);
                }
            }
            while((bStr=bFileManager.getNextWord())!=null){
                fileWriter.write(bStr);
            }
            //fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder getNewArray(String[] minArray,String[] bigArray){
        StringBuilder stringBuilder =new StringBuilder();
        for(int i=0;i<minArray.length;i++){
            stringBuilder.append(minArray[i]);
            stringBuilder.append(bigArray[i]);
        }
        String[] moreArray =new String[bigArray.length-minArray.length];
        System.arraycopy(bigArray,minArray.length,moreArray,0,bigArray.length-minArray.length);
        for (String s : moreArray) {
            stringBuilder.append(s);
        }
        return stringBuilder;
    }
}
