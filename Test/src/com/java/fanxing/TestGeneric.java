/**
 * 
 */
package com.java.fanxing;

import java.util.ArrayList;

/**
 * @author PE
 * @date 2019年6月27日 下午1:18:21
 * @explain 
 */
public class TestGeneric {
	public static void main(String[] args) {
        //如果希望只取出，不插入，就使用? extends Number
        ArrayList<Float> apHeroList = new ArrayList<Float>();
        apHeroList.add(12.f);
        ArrayList<? extends Number> heroList = apHeroList;
        //? extends Number 表示这是一个Number泛型的子类泛型
        //heroList 的泛型可以是Float
        //heroList 的泛型可以使Integer
        //heroList 的泛型可以使Double
        //可以确凿的是，从heroList取出来的对象，一定是可以转型成Number的
        Number h= heroList.get(0);
        //但是，不能往里面放东西
        //heroList.add(12); //编译错误，因为heroList的泛型 有可能是12.f
          
        
        
        //如果希望只插入，不取出，就使用? super Number

        ArrayList<? super Number> heroList1 = new ArrayList<>();
          
        //? super Hero 表示 heroList的泛型是Hero或者其父类泛型
        //heroList 的泛型可以是Number
        //heroList 的泛型可以是Object
         
        heroList1.add(12);
        heroList1.add(12.5f);
        heroList1.add(1200L);
        /**
         *  但是，不能从里面取数据出来
         *  编译错误，因为其泛型可能是Object,而Object是强转Integer会失败
         */
         // Number h1= heroList1.get(0);
        
        //如果希望，又能插入，又能取出，就不要用通配符？
        
        
        //子类泛型不可以转换为父类泛型
        ArrayList< Number> nums = new ArrayList<>();
        ArrayList< Integer> num = new ArrayList<>();
        /**反证法:
         * 假设成功:此时nums的引用指向了num(Integer)
         * 但nums是可以放Float的,如果加进去，就变成
         * 了Integer泛型的容器里放进了Float，这就矛盾了
         */
       // nums=num;
     
        //父类泛型不可以转换成子类泛型
        /**反证法:
         * 假设成功:此时num(Float)的引用指向了nums(Integer,Float)
         * 此时Float指向的nums里有Integer,这就矛盾了
         */
       // num=nums;
    }
      
}
