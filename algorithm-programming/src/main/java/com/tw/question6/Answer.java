package com.tw.question6;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * @Author: tanwei
 * @Description:从类似如下的文本文件中读取出所有的姓名，并打印出重复的姓名和重复的次数，并按重复次数排序：
 * @Date: Create in 17:33 2019/7/5
 * 知识点
 *      io缓冲流的使用
 *      comparator的使用
 */
public class Answer {
    public static void main(String[] args) {
        try {
            File file = new File("E:\\workspace\\study\\algorithm-programming\\src\\main\\java\\com\\tw\\question6\\a.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<User> userList = Lists.newArrayList();
            Map map = new HashMap();
            String readStr = "";
            while (StringUtils.isNotBlank(readStr = bufferedReader.readLine())) {
                String[] data = readStr.split(",");
                if (data.length >= 3) {
                    Object o = map.get(data[1]);
                    if (o == null) {
                        map.put(data[1], new Integer(1));
                    } else {
                        map.put(data[1], (Integer) o + 1);
                    }
                }
            }
            for (Object o : map.keySet()) {
                User user = new User();
                user.setUserName((String) o);
                user.setNum((Integer) map.get(o));
                userList.add(user);
            }
            Comparator<User> comparator = new Comparator<User>() {
                public int compare(User s1, User s2) {
                    // 先排年龄
                    if (s1.getNum().intValue() != s2.getNum().intValue()) {
                        return s1.getNum().intValue() - s2.getNum().intValue();
                    } else {
                        // 年龄相同则按姓名排序
                        return s1.getUserName().compareTo(s2.getUserName());
                    }
                }
            };
            System.out.println("排序前");
            for (User user : userList) {
                System.out.println(user);
            }
            System.out.println("排序后");
            Collections.sort(userList,comparator);
            Collections.reverse(userList);
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
