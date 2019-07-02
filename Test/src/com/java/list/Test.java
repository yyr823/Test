/**
 * 
 */
package com.java.list;

import java.util.Scanner;

/**
 * @author PE
 * @date 2019年6月27日 上午10:52:23
 * @explain 练习
 */
public class Test {
	public static void main(String[] args) {
		  // TODO 自动生成的方法存根
        System.out.println("请输入字符串：");
        Scanner s=new Scanner(System.in);
        String a=s.nextLine();      
        System.out.println("得到的hashcode为：");
        System.out.println(hashcode(a));
	}
	/**
	 * 如果字符串长度是0，则返回0。
否则： 获取每一位字符，转换成数字后，相加，最后乘以23,
如果值超过了1999，则取2000的余数，保证落在0-1999之间。
如果是负数，则取绝对值。
	 * @param str
	 * @return
	 */
//随机生成长度是2-10的不等的100个字符串，打印用本hashcode获取的值分别是多少
	 public static int hashcode(String str) {
	        if(str.length()==0) {
	            return 0;
	        }
	        char[]c=str.toCharArray();
	        int sum=0;
	        for(int i=0;i<c.length;i++) {
	            sum+=(char)c[i];
	        }
	        int hashcode=sum*23;
	        if(hashcode>1999) {
	            hashcode=hashcode%2000;
	        }
	        return hashcode;
	    }
}
