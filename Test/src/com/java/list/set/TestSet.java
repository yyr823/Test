/**
 * 
 */
package com.java.list.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author PE
 * @date 2019年6月27日 上午9:33:55
 * @explain Set中的元素，不能重复:
HashSet自身并没有独立的实现，而是在里面封装了一个Map.
HashSet是作为Map的key而存在的
而value是一个命名为PRESENT的static的Object对象，
因为是一个类属性，所以只会有一个。
 */
public class TestSet {
public static void main(String[] args) {
	//遍历
	setBianLi();
	/**
创建一个长度是100的字符串数组
使用长度是2的随机字符填充该字符串数组
统计这个字符串数组里重复的字符串有多少种
	 */
	similar();
}


public static void similar() {
	
	 // TODO 自动生成的方法存根
    String[]arrayString=new String[100];
    System.out.println("生成的字符串数组如下：");
    for(int i=0;i<arrayString.length;i++) {
        arrayString[i]=generateString(2);
        System.out.print(arrayString[i]+" ");
        if((i+1)%20==0) {
            System.out.println();
        }
    }
    int count=0;
    HashSet<String>s=new HashSet<>();
    HashSet<String>s1=new HashSet<>();
    for(String h:arrayString) {
        if(s.add(h)==false) {
            s1.add(h);
            count++;
        }
    }
    System.out.println("重复的元素个数有:"+count);
    System.out.println("重复的元素有：");
    for(String h:s1) {
        System.out.print(h+" ");
    }
     
}
//随机生成两位的字符串方法
public static String generateString(int num) {
    String pool=null;
    for(int i='a';i<'z';i++) {
        pool+=String.valueOf((char)i);
    }
    for(int i='A';i<'Z';i++) {
        pool+=String.valueOf((char)i);
    }
    for(int i='0';i<'9';i++) {
        pool+=String.valueOf((char)i);
    }
    char[] generateChar=new char[num];
    for(int i=0;i<generateChar.length;i++) {
        generateChar[i]=pool.charAt((int)(Math.random()*pool.length()));
    }
    return String.valueOf(generateChar);
}



	
public static void setBianLi() 


{  HashSet<Integer> numbers = new HashSet<Integer>();

for (int i = 0; i < 20; i++) {
    numbers.add(i);
}
//遍历Set可以采用迭代器iterator
for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
    Integer i = (Integer) iterator.next();
    System.out.print(i+"\t");
}
 System.out.println();
//或者采用增强型for循环
for (Integer i : numbers) {
    System.out.print(i+"\t");
}
}

}