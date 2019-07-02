/**
 * 
 */
package com.java.list.set;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

/**
 * @author PE
 * @date 2019年6月27日 上午11:50:52
 * @explain 
 */
public class TreeSetComparator {
public static void main(String[] args) {
	Comparator<Integer> c=new Comparator<Integer>() {                           
      /**
       * A>B，renturn 1，true表示执行交换，
       * 所以序列变成 B A， 因为B小于A，所以升序
          A>B，return -1，
          false表示  不执行交换，
          所以 序列不变 A B，因为A大于B，所以降序
       */
		@Override
		public int compare(Integer o1, Integer o2) {
			  if(o1<o2) {
		            return 1;
		        }
		        else {
		            return -1;
		        }
		       
		}
	};
	TreeSet<Integer> ts1=new TreeSet<>();
	TreeSet<Integer> ts=new TreeSet<>(c);
    Random random=new Random();
    while(true) {
        ts.add(random.nextInt(99));
        ts1.add(random.nextInt(99));
        if(ts.size()>=20) {
            break;
        }
        if(ts1.size()>=20) {
            break;
        }
    }
    System.out.println("正常TreeSet的结果为(升序)：");
    System.out.println(ts1);
    System.out.println("对TreeSet倒序排序的结果为()：");
    System.out.println(ts);
	
}
}
