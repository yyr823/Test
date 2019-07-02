/**
 * 
 */
package com.java.thread.waitandnotify;

/**
 * @author PE
 * @date 2019年6月28日 上午10:24:58
 * @explain 
1. 使用栈来存放数据
2. 把栈改造为支持线程安全
3. 把栈的边界操作进行处理，当栈里的数据是0的时候，访问pull的线程就会等待。 
   当栈里的数据是200的时候，访问push的线程就会等待
4. 提供一个生产者（Producer）线程类，生产随机大写字符压入到堆栈
5. 提供一个消费者（Consumer）线程类，从堆栈中弹出字符并打印到控制台
6.使两个生产者和三个消费者线程同时运行
 */
public class Test {
	public static void main(String[] args) {
        MyStack ms = new MyStack();
        for (int i = 1; i < 3; i++)
            new Producer(ms, "Producer" + i).start();
 
        for (int i = 1; i < 4; i++)
            new Consumer(ms, "Consumer" + i).start();
    }
}
