/**
 * 
 */
package com.java.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author PE
 * @date 2019年6月27日 下午2:45:08
 * @explain 
 */
public class HeroSortByHp {
	// 供Lambda中引用或直接引用
    public static int compare(Hero h1, Hero h2) {
        return (h1.hp >= h2.hp ? 1 : -1);
    }
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
 
        for (int i = 0; i < 10; i++) {
            // 通过随机值实例化hero的hp和damage
            heros.add(new Hero("hero " + i, r.nextInt(100), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
 
        // 在Lambda表达式中使用静态方法
        System.out.println("在Lambda表达式中使用静态方法");
        Collections.sort(heros, (h1, h2) -> HeroSortByHp.compare(h1, h2));
        System.out.println(heros);
 
        // 直接引用静态方法
        System.out.println("直接引用静态方法");
        Collections.sort(heros, HeroSortByHp::compare);
        System.out.println(heros);
 
        // 引用容器中(Hero)的对象的方法(compareHero)
        System.out.println("引用容器中的对象的方法");
        Collections.sort(heros, (h1, h2) -> h1.compareHero(h1, h2));
        System.out.println(heros);
    }
}
