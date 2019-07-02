/**
 * 
 */
package com.java.list.node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author PE
 * @date 2019年6月26日 下午5:34:56
 * @explain 二叉树
 * 随机生成10个Hero对象，每个Hero对象都有不同的血量值，
 * 插入这个HeroNode后，把排序结果打印出来
 */
public class HeroNodeTest {
	 public static void main(String[] args){
	        List<Hero> heroList = new ArrayList<>();
	        int heroSize = 10;
	        Random r = new Random();
	        for(int i=0;i<heroSize;i++){
	            heroList.add(new Hero("hero "+i,r.nextInt(1000)));
	        }
	        for(Hero h : heroList){
	            System.out.println(h);
	        }
	        System.out.println("--------");
	        HeroNode hn = new HeroNode();
	        for(Hero h : heroList)
	            hn.insert(h);
	        hn.inSearch(hn);
	    }
}
