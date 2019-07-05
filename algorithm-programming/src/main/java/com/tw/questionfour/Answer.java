package com.tw.questionfour;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: tanwei
 * @Description:有一个字符串，其中包含中文字符、英文字符和数字字符，请统计和打印出各个字符的个数。并统计着三种类型字符的个数
 * @Date: Create in 17:17 2019/7/4
 * 知识点
 *      集合Map的使用
 *      数字 中文 英文 字符的特征
 */
public class Answer {
    public static void main(String[] args) {
        String str="a阿23达肯ad123德adad基23阿asdad12达";
        char[] chars = str.toCharArray();
        Map<String,Integer> map =new HashMap<String,Integer>();
        int chineseCount=0;
        int englishCount=0;
        int numCount=0;
        for (char c : chars) {
            String key = String.valueOf(c);
            Integer num = map.get(key);
            if(num==null){
                map.put(key,1);
            }else{
                map.put(key,num+1);
            }
            if(c>='0' && c<='9'){
                numCount++;
            }else if((c>='a' && c<='z')||(c>='A' && c<='Z')){
                englishCount++;
            }else {
                chineseCount++;
            }

        }
        map.put("中文",chineseCount);
        map.put("英文",englishCount);
        map.put("数字",numCount);
        for (String s : map.keySet()) {
            System.out.println(s+":"+map.get(s));
        }
    }
}
