package com.tw.question12;

/**
 * @Author: tanwei
 * @Description:金额转换，阿拉伯数字的金额转换成中国传统的形式如：（￥1011）－>（一千零一拾一元整）输出。
 * @Date: Create in 17:14 2019/7/10
 *      知识点：
 *          略
 */
public class Answer {
    private static final char[] DATA={'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
    private static final char[] UNIT={'元','拾','佰','仟','万','拾','佰','仟','亿'};

    public static void main(String[] args) {
        int num=999;
        getRmb(num);
    }

    public static void getRmb(int num){
        StringBuilder builder =new StringBuilder();
        int index=0;
        while (num!=0){

            builder.insert(0,UNIT[index++]);
            int number=num%10;
            builder.insert(0,DATA[number]);
            num=num/10;
        }
        System.out.println(builder.toString());
    }
}
