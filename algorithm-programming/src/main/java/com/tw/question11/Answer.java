package com.tw.question11;

import java.util.Arrays;

/**
 * @Author: tanwei
 * @Description:有数组a[n]，用java代码将数组元素顺序颠倒
 * @Date: Create in 16:48 2019/7/10
 *      知识点：
 *          略
 */
public class Answer {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        for(int i=0;i<arr.length/2;i++){
            int tem=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=tem;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
