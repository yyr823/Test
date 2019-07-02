/**
 * 
 */
package com.java.list.node;

/**
 * @author PE
 * @date 2019年6月26日 下午5:26:24
 * @explain 二叉树排序
 */
public class NodeTest {
	public static void main(String[] args) {
		
	
	 int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
	  //插入数据
     Node<Integer> roots = new Node<>();
     for (int number : randoms) {
         roots.add(number);
     }
     System.out.println(roots.values());
	}
 
}
