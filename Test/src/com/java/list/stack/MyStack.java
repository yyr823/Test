/**
 * 
 */
package com.java.list.stack;

import java.util.LinkedList;

import com.java.list.arraylist.Hero;

/**
 * @author PE
 * @date 2019年6月26日 下午5:18:56
 * @explain 
 */
public class MyStack implements Stack{
	/**
	 * 解释一下栈: 栈的结构，就像给弹夹添加子弹一样，先添加的子弹，
	就放在了最下面，打手枪的时候，只能从最上面取子弹。
	 */
public static void main(String[] args) {
	MyStack ms=new MyStack();
    for(int i=0;i<5;i++){
        Hero h=new Hero("hero "+i);
        ms.push(h);
        System.out.println("push进栈："+h);
    }
     
    System.out.println("查看最后一个英雄："+ms.peek());
     
    for(int j=0;j<5;j++){
        Hero h=ms.pull();
        System.out.println("pull出栈："+h);
    }       
}


   LinkedList<Hero> link=new LinkedList<>();
/*
 * 借助Collections辅助类 将不安全的list转换为安全的list
 * LinkedList<Hero> link;

public MyStack() {
	link = (LinkedList<Hero>) Collections.synchronizedList(new LinkedList<Hero>());
}*/
	@Override
	public synchronized void push(Hero h) {
		link.addLast(h);//把英雄推入最后的位置
		
	}
	@Override
	public  Hero pull() {
		  synchronized (this) {
			  Hero h=link.removeLast();//把最后一个英雄取出来
		        return h;
	        }
		
	}

//线程安全的方法
	@Override
	public synchronized Hero peek() {
		 Hero h=link.getLast();//查看最后一个英雄
	        return h;
	}

}
