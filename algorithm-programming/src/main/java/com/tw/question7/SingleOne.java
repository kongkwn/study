package com.tw.question7;

/**
 * @Author: tanwei
 * @Description: 手写单例
 * @Date: Create in 13:58 2019/7/8
 *      知识点：
 *          饿汉式单例 类创建时就初始化一个静态对象，天生线程安全
 *          懒汉式单例 第一次使用该类时才会创建对象，线程不安全，可优化。
 *          本答案为双重检测懒汉式单例，多线程安全
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
