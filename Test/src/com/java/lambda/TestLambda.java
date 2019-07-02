/**
 * 
 */
package com.java.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author PE
 * @date 2019年6月27日 下午1:58:07
 * @explain 
 * 优点:
 * 引入Lambda表达式，会使得代码更加紧凑，而不是各种接口和匿名类到处飞。
 * Lambda的弊端
 * 1. 可读性差，与啰嗦的但是清晰的匿名类代码结构比较起来，Lambda表达式一旦变得比较长，就难以理解
2. 不便于调试，很难在Lambda表达式中增加调试信息，比如日志
3. 版本支持，Lambda表达式在JDK8版本中才开始支持，如果系统使用的是以前的版本，考虑系统的稳定性等原因，而不愿意升级，那么就无法使用。
Lambda比较适合用在简短的业务代码中，并不适合用在复杂的系统中，会加大维护成本。
 */
public class TestLambda {
	public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("普通方法:筛选出 hp>100 && damange<50的英雄");
        filter(heros);
        System.out.println("匿名类的方式:筛选出 hp>100 && damange<50的英雄");
        HeroChecker checker = new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return (h.hp>100 && h.damage<50);
            }
        };
        filter(heros,checker);
        
        System.out.println("使用Lamdba的方式，筛选出 hp>100 && damange<50的英雄");
        filter(heros,h->h.hp>100 && h.damage<50);
        //有匿名类演变Lamdba
        // 把new HeroChcekcer，方法名，方法返回类型信息去掉
        // 只保留方法参数和方法体
        // 参数和方法体之间加上符号 ->
        HeroChecker c2 = (Hero h) -> {
            return h.hp > 100 && h.damage < 50;
        };
 
        // 把return和{}去掉,(只有一个参数的时候，才可以去掉圆括号)
        HeroChecker c3 = (Hero h) -> h.hp > 100 && h.damage < 50;
 
        // 把 参数类型和圆括号去掉
        HeroChecker c4 = h -> h.hp > 100 && h.damage < 50;
 
        // 把c4作为参数传递进去
        filter(heros, c4);
         
        // 直接把表达式传递进去
        filter(heros, h -> h.hp > 100 && h.damage < 50);
        
    }
  

    private static void filter(List<Hero> heros,HeroChecker checker) {
        for (Hero hero : heros) {
            if(checker.test(hero))
                System.out.print(hero);
        }
    }
	//普通方法
    private static void filter(List<Hero> heros) {
        for (Hero hero : heros) {
            if(hero.hp>100 && hero.damage<50)
                System.out.print(hero);
        }
    }
  
}
