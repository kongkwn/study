package com.tw.questionsix;

import lombok.Data;

/**
 * @Author: tanwei
 * @Description:
 * @Date: Create in 17:52 2019/7/5
 */
@Data
public class User implements Comparable<User> {
    private String userName;
    private Integer num;


    public int compareTo(User o) {
        if (this.num.intValue() < o.getNum().intValue())
            return o.getNum().intValue() - this.num.intValue();
        if (this.num.intValue() > o.getNum().intValue())
            return this.num.intValue() - o.getNum().intValue();
        if (this.userName.compareTo(o.getUserName()) > 0)
            return 1;
        if (this.userName.compareTo(o.getUserName()) < 0)
            return -1;
        return 0;
    }
}
