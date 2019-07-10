package com.tw.question3;

/**
 * @Author: tanwei
 * @Description:编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串，但要保证汉字不被截取半个，如“我ABC”，4，应该截取“我AB”，输入“我ABC汉DEF”，6，应该输出“我ABC”，而不是“我ABC+汉的半个”。
 * @Date: Create in 16:25 2019/7/4
 * 知识点
 *      注意编码特征：
 *          GBK编码中文占用两个字节，且字节大小为负
 *          UTF-8编码中文占3个字符，且字节大小为负
 *          ISO-8859编码中文占1个字符，且中英文字节无明显区别
 *          unicode编码中文占4个字符，但中英文字节值无明显区别。
 *      字符串getBytes substring等api的使用
 */
public class Answer {
    public static void main(String[] args) {
        try {
            String str = "我AVDK哈哈";
            byte[] bytes = str.getBytes("GBK");
            int i = trimGbk(bytes, 3);
            System.out.println(str.substring(0,i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int trimGbk(byte[] buf, int n) {
        int num = 0;
        boolean chineseFirstHalf = false;
        for (int i = 0; i < n; i++) {
            if (buf[i] < 0 && !chineseFirstHalf) {
                chineseFirstHalf = true;
            } else {
                num++;
                chineseFirstHalf = false;
            }
        }
        return num;
    }
}
