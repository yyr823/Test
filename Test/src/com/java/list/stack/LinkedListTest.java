package com.java.list.stack;

import java.util.LinkedList;
import java.util.Queue;

import com.java.list.arraylist.Hero;

/**
 * @author PE
 * @date 2019年6月26日 下午5:08:35
 * @explain 
 *  序列分先进先出FIFO,先进后出FILO 
     FIFO在Java中又叫Queue 队列 
     FILO在Java中又叫Stack 栈
     
实现了List接口外，LinkedList还实现了双向链表结构Deque
 */
public class LinkedListTest {
	 public static void main(String[] args) {
         
		 //实现了双向链表结构Deque
		 deque();
		 //实现了Queue接口(队列)。
		 queue();     
	    }
	 
	 public  static void deque() {
		  //LinkedList是一个双向链表结构的list
	        LinkedList<Hero> ll =new LinkedList<Hero>();
	         
	        //所以可以很方便的在头部和尾部插入数据
	        //在最后插入新的英雄
	        ll.addLast(new Hero("hero1"));
	        ll.addLast(new Hero("hero2"));
	        ll.addLast(new Hero("hero3"));
	        System.out.println(ll);
	         
	        //在最前面插入新的英雄
	        ll.addFirst(new Hero("heroX"));
	        System.out.println(ll);
	         
	        //查看最前面的英雄
	        System.out.println(ll.getFirst());
	        //查看最后面的英雄
	        System.out.println(ll.getLast());
	         
	        //查看不会导致英雄被删除
	        System.out.println(ll);
	        //取出最前面的英雄
	        System.out.println(ll.removeFirst());
	         
	        //取出最后面的英雄
	        System.out.println(ll.removeLast());
	         
	        //取出会导致英雄被删除
	        System.out.println(ll);
		 
	 }
	 
	 /**
	  * offer 在最后添加元素
        poll 取出第一个元素
        peek 查看第一个元素
	  */
	 public  static void queue() {
		 
	        //所不同的是LinkedList还实现了Deque，进而又实现了Queue这个接口
	        //Queue代表FIFO 先进先出的队列
	        Queue<Hero> q= new LinkedList<Hero>();
	          
	        //加在队列的最后面
	        System.out.print("初始化队列：\t");
	        q.offer(new Hero("Hero1"));
	        q.offer(new Hero("Hero2"));
	        q.offer(new Hero("Hero3"));
	        q.offer(new Hero("Hero4"));
	          
	        System.out.println(q);
	        System.out.print("把第一个元素取poll()出来:\t");
	        //取出第一个Hero，FIFO 先进先出
	        Hero h = q.poll();
	        System.out.println(h);
	        System.out.print("取出第一个元素之后的队列:\t");
	        System.out.println(q);
	          
	        //把第一个拿出来看一看，但是不取出来
	        h=q.peek();
	        System.out.print("查看peek()第一个元素:\t");
	        System.out.println(h);
	        System.out.print("查看并不会导致第一个元素被取出来:\t");
	        System.out.println(q);
	          
	 }
	 }
