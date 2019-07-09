package com.tw.questioneight;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * @Author: tanwei
 * @Description:一个整数，大于0，不用循环和本地变量，按照n，2n，4n，8n的顺序递增，当值大于5000时，把值按照指定顺序输出来。
 * @Date: Create in 14:03 2019/7/9
 *  知识点
 *      递归算法
 */
public class Answer {
    public static void main(String[] args) {
        int num=2000;

        /*List<Integer> arrayList= Lists.newArrayList();

        doubleNum(arrayList,num);

        sortList(arrayList);*/

        doubleNum(num);

    }

    public static List<Integer> doubleNum(List<Integer> list,int num){
        if(num>5000){
            list.add(num);
            return list;
        }else{
            list.add(num);
            return doubleNum(list,num*2);
        }
    }

    public static void sortList(List<Integer> arrayList){
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }

        Collections.reverse(arrayList);

        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }

    public static void doubleNum(int n)

    {

        System.out.println(n);

        if(n<=5000)

            doubleNum(n*2);

        System.out.println(n);

    }
}
