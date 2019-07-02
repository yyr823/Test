/**
 * 
 */
package com.java.list.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author PE
 * @date 2019年6月27日 上午10:00:51
 * @explain 
首先初始化一个List,长度是10，值是0-9。
然后不断的shuffle，直到前3位出现3 1 4
shuffle 1000,000 次，统计出现的概率
 */
public class TestCollections2 {
public static void main(String[] args) {
	 //首先初始化一个List,长度是10,值是0-9
    List<Integer> nums=new ArrayList<>();
    for(int i=0;i<10;i++)
        nums.add(i);
    System.out.println("初始化列表为：\n"+nums);
    //shuffle 1000000 次,直到前3位出现3 1 4
    int num=0;
    for(int i=0;i<1000000;i++){
        if(nums.get(0)==3&&nums.get(1)==1&&nums.get(2)==4)
            num++;
        Collections.shuffle(nums);
        
    }
    //统计出现的概率
    double time=(double)num/1000000;
    System.out.println("shuffle 1000000次后:\n首三位以3 1 4开头共有"+num+"次,出现的概率为:"+time+"%");
    
}
}
