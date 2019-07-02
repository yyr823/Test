/**
 * 
 */
package com.java.list.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author PE
 * @date 2019年6月27日 上午9:55:15
 * @explain 
 */
public class TestCollections {
public static void main(String[] args) {
	 //初始化集合numbers
    List<Integer> numbers = new ArrayList<>();
     
    for (int i = 0; i < 10; i++) {
        numbers.add(i);
    }
    System.out.println("集合中的数据:");
    System.out.println(numbers);
     
    Collections.reverse(numbers);
     
    System.out.println("翻转后集合中的数据:");
    System.out.println(numbers);
    
    Collections.shuffle(numbers);
    System.out.println("混淆后集合中的数据:");
    System.out.println(numbers);

    Collections.sort(numbers);
    System.out.println("排序后集合中的数据:");
    System.out.println(numbers);
    Collections.swap(numbers,0,5);
    System.out.println("交换0和5下标的数据后，集合中的数据:");
    System.out.println(numbers);
    Collections.rotate(numbers,2);
    System.out.println("把集合向右滚动2个单位，标的数据后，集合中的数据:");
    System.out.println(numbers);

    System.out.println("把非线程安全的List转换为线程安全的List");
    List<Integer> synchronizedNumbers = (List<Integer>) Collections.synchronizedList(numbers);
    System.out.println(synchronizedNumbers);
}
}
