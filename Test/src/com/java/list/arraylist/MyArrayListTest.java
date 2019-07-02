/**
 * 
 */
package com.java.list.arraylist;

/**
 * @author PE
 * @date 2019年6月26日 下午4:15:56
 * @explain  
 */
public class MyArrayListTest {
public static void main(String[] args) throws Exception {
	MyArrayListBuffer msb = new MyArrayListBuffer("1234abcd");
       System.out.format("字符串\"%s\"长度是： %d，容量是：%d%n",msb,msb.length(),msb.capacity );
       msb.reverse();
       System.out.format("字符串\"%s\"长度是： %d，容量是：%d%n",msb,msb.length(),msb.capacity );
       msb.insert(0, "zzz");
       System.out.format("字符串\"%s\"长度是： %d，容量是：%d%n",msb,msb.length(),msb.capacity );
       msb.append("nnn");
       System.out.format("字符串\"%s\"长度是： %d，容量是：%d%n",msb,msb.length(),msb.capacity );
       msb.append('0');
       System.out.format("字符串\"%s\"长度是： %d，容量是：%d%n",msb,msb.length(),msb.capacity );
       msb.insert(10, 'm');
       System.out.format("字符串\"%s\"长度是： %d，容量是：%d%n",msb,msb.length(),msb.capacity );
       msb.delete(0,3);
       System.out.format("字符串\"%s\"长度是： %d，容量是：%d%n",msb,msb.length(),msb.capacity );
        
}
}
