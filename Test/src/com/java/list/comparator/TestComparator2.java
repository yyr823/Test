/**
 * 
 */
package com.java.list.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author PE
 * @date 2019年6月27日 上午11:43:13
 * @explain 
 */
public class TestComparator2 {
	 public static void main(String[] args) {
		 Random r =new Random();
	        List<Hero2> heros = new ArrayList<Hero2>();
	          
	        for (int i = 0; i < 10; i++) {
	            //通过随机值实例化hero的hp和damage
	            heros.add(new Hero2("hero "+ i, r.nextInt(100), r.nextInt(100)));
	        }
	          
	        System.out.println("初始化后的集合");
	        System.out.println(heros);
	          
	        //Hero类实现了接口Comparable，即自带比较信息。
	        //Collections直接进行排序，无需额外的Comparator
	        Collections.sort(heros);
	        System.out.println("按照伤害高低排序后的集合");
	        System.out.println(heros);
}

}
