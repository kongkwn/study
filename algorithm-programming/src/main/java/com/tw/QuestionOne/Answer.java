package com.tw.QuestionOne;

import java.io.File;
import java.io.FileReader;

/**
 * @Author: tanwei
 * @Description:
 * @Date: Create in 14:40 2019/7/3
 */
public class Answer {

    public static void main(String[] args) {
        try {
            File a = new File("a.txt");
            FileReader readerA = new FileReader(a);
            char[] aBuf=new char[(int)a.length()];
            int i = readerA.read(aBuf);
            String result=new String(aBuf,0,i);
            System.out.println(result);
        } catch (Exception e) {
        }
    }
}
