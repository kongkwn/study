package com.tw.manual.example;

/**
 * @Author: tanwei
 * @Description:
 * @Date: Create in 10:49 2019/8/5
 */
public class OtherTest {

    public static void main(String[] args) {
        int i=0;
        for(foo('A');foo('B') && i<2 ; foo('C')){
            foo('D');
            i++;
        }
    }

    private static boolean foo(char c){
        System.out.println(c);
        return true;
    }
}
