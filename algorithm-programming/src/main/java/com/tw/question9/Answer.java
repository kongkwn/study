package com.tw.question9;

/**
 * @Author: tanwei
 * @Description:第1个人10，第2个比第1个人大2岁，依次递推，请用递归方式计算出第8个人多大？
 * @Date: Create in 14:45 2019/7/9
 *  知识点
 *      递归算法
 */
public class Answer {
    public static void main(String[] args) {
        //getyears(10,1);
        int getyears = getyears(8);
        System.out.println(getyears);
    }

    public static void getyears(int years,int person){
        if(person==8){
            System.out.println(years);
        }else {
            years=years+2;
            getyears(years,person+1);
        }
    }

    public static int getyears(int n){
        if(n==1)
            return 10;
        return getyears(n-1)+2;
    }
}
