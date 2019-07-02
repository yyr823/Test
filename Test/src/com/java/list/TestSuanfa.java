/**
 * 
 */
package com.java.list;

import com.java.list.node.Node;

/**
 * 最快二叉树、其次选择排序，最慢冒泡排序
 * @author Pan 测试二叉树、选择排序，冒泡排序排序效率
 *
 */
public class TestSuanfa {

	    public static int a[] = null;
	    public static void main(String[] args) {
	        int n = 40000;
	        a = new int[n];
	        //每次必须重新排序数组
	        for(int i = 0; i < n; i++){
	            a[i] = (int) (Math.random()*1000);
	        }
	        System.out.println(" ");
	        select();
	         
	        for(int i = 0; i < n; i++){
	            a[i] = (int) (Math.random()*1000);
	        }
	        buble();
	         
	        for(int i = 0; i < n; i++){
	            a[i] = (int) (Math.random()*1000);
	        }
	        long startTime = System.currentTimeMillis();
	        Node roots = new Node();
	        for (int number : a) {
	            roots.add(number);
	        }
	        roots.values();
	        long endTime = System.currentTimeMillis();
	        System.out.printf("二叉树排序耗时:%d毫秒%n", endTime - startTime);
	    }
	    //选择排序
	    public static void select(){
	 
	        long startTime = System.currentTimeMillis();
	         
	        for(int i = 0; i < a.length - 1; i++){
	            for(int j = i+1; j < a.length; j++){
	                if(a[i] > a[j]){
	                    int tmp = a[i];
	                    a[i] = a[j];
	                    a[j] = tmp;
	                }
	            }
	        }
	        long endTime = System.currentTimeMillis();
	        System.out.printf("选择排序法耗时:%d毫秒%n", endTime - startTime);
	    }
	    //冒泡排序
	    public static void buble(){
	        long startTime = System.currentTimeMillis();
	        for(int i = 0; i < a.length; i++){
	            for(int j = 0; j < a.length-i-1; j++){
	                if(a[j] > a[j+1]){
	                    int tmp = a[j];
	                    a[j] = a[j+1];
	                    a[j+1] = tmp;
	                }
	            }
	        }
	        long endTime = System.currentTimeMillis();
	        System.out.printf("冒泡排序法耗时:%d毫秒%n", endTime - startTime);
	    }
	
}
