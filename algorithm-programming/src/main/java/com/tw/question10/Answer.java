package com.tw.question10;

import java.util.Date;
import java.util.Random;

/**
 * @Author: tanwei
 * @Description: 冒泡 选择 快速排序算法
 * @Date: Create in 9:42 2019/7/10
 *      知识点
 *          冒泡 双层循环遍历 内层循环两两比较进行排序，内层遍历一次，相当于生成一个新数组，效率低
 *          选择 双层循环遍历 定义数组最小/大值每次内层循环可确定该值在数组的最终位置，效率较高。
 *          快速 使用递归，定义枢轴，根据枢轴值将数组大于该值和小于该值的划分到数组两边(替换)并重新定义枢轴，
 *          将新划分的数组看成两个新的数组继续递归划分，效率高。
 */
public class Answer {
    public static void main(String[] args) {
        int size=100000;
        Random random = new Random();
        int[] arr = new int[size];

        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(1000);
        }

        //冒泡排序
        bubbleSort(arr);
        //printArr(arr);
        //选择排序
        selectSort(arr);
        //printArr(arr);
        //快速排序
        long start = System.currentTimeMillis();
        fastSort(arr,0,arr.length-1);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        //printArr(arr);
    }

    public static void bubbleSort(int[] arr){
        long start = System.currentTimeMillis();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp =arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void printArr(int[] arr){
        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    public static void selectSort(int[] arr){
        long start = System.currentTimeMillis();
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length-i;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void fastSort(int[] arr,int start,int end){
        if(start<end){
            int part=partition(arr,start,end);

            fastSort(arr,start,part-1);
            fastSort(arr,part+1,end);
        }
    }

    public static int partition(int[] arr,int start,int end){

        //使用数组始元素作为枢轴
        int part=arr[start];
        while (start<end){

            while (start<end && arr[start]<=part){start++;}
            //比基数大移到数组右
            arr[end]=arr[start];
            //比基数小移到数组左
            while (start<end && arr[end]>=part){end--;}
            arr[start]=arr[end];
        }

        arr[start]=part;

        return start;
    }
}
