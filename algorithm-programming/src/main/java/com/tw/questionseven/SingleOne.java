package com.tw.questionseven;

/**
 * @Author: tanwei
 * @Description:
 * @Date: Create in 13:58 2019/7/8
 */
public class SingleOne {
    private static SingleOne singleOne=null;

    private SingleOne() {
    }

    //只有第一次调用该方法时对象才会为null之后都直接返回对象
    //而在方法上加synchronized同步导致每次调用该方法是都会去获取锁
    //获取锁和释放锁的开销非常影响性能（100倍左右）
    //所以在方法内加同步代码块最好
    //方法内只做非空判断，好处便是只有在第一次调用该方法才走synchronized同步代码块
    public static SingleOne getSingleOne(){
        if(singleOne==null){
            synchronized (SingleOne.class){
                if(singleOne==null){
                    singleOne=new SingleOne();
                }
            }
        }
        return singleOne;
    }
}
