/**
 * 
 */
package com.java.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author PE
 * @date 2019年6月27日 下午2:27:15
 * @explain 
 */
public class TestLambda1 {
public static void main(String[] args) {
	   Random r =new Random();
       List<Hero> heros = new ArrayList<Hero>();
           
       for (int i = 0; i < 10; i++) {
           //通过随机值实例化hero的hp和damage
           heros.add(new Hero("hero "+ i, r.nextInt(100), r.nextInt(100)));
       }
   
	//Lambda表达式：
	filter(heros,h->h.hp>100 && h.damage<50);
    /**
     * 调用静态方法
     */
	//在Lambda表达式中调用这个静态方法
	filter(heros, h -> TestLambda1.testHero(h) );
	//调用静态方法还可以改写为：
	filter(heros, TestLambda1::testHero);
	/**
	 * 引用对象方法
	 */
	TestLambda1 temp=new TestLambda1();
	filter(heros, h -> temp.testHero1(h) );
    filter(heros, temp::testHero1);
    /**
     * 引用容器中的对象的方法
     */
    System.out.println("引用容器中对象的方法 之过滤结果：");       
    filter(heros,h-> h.matched() );
    System.out.println("matched恰好就是容器中的对象Hero的方法:");
    filter(heros, Hero::matched);
    /**
     * 引用构造器
     */
    //匿名类
    Supplier<List> s = new Supplier<List>() {
        public List get() {
            return new ArrayList();
        }
    };
    //Lambda表达式
    List<?> list2 = getList(()->new ArrayList<Object>());
     
    //引用构造器
    List<?> list3 = getList(ArrayList::new);
    
}
public static List<?> getList(Supplier<List> s){
    return s.get();
}
public static boolean testHero(Hero h) {
	   return h.hp>100 && h.damage<50;
	}
public boolean testHero1(Hero h) {
    return h.hp>100 && h.damage<50;
}
private static void filter(List<Hero> heros,HeroChecker checker) {
    for (Hero hero : heros) {
        if(checker.test(hero))
            System.out.print(hero);
    }
}
}
