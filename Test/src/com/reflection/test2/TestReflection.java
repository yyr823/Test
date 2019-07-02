/**
 * 
 */
package com.reflection.test2;

import java.lang.reflect.Constructor;

import com.reflection.Hero;

/**
 * @author PE
 * @date 2019年7月2日 下午1:25:33
 * @explain 与传统的通过new 来获取对象的方式不同 反射机制，会先拿到Hero的“类对象”,然后通过类对象获取“构造器对象”
 *          再通过构造器对象创建一个对象
 */
public class TestReflection {
	public static void main(String[] args) {
		// 传统的使用new的方式创建对象
		Hero h1 = new Hero();
		h1.name = "teemo";
		System.out.println(h1);

		try {
			// 使用反射的方式创建对象
			String className = "com.reflection.Hero";
			// 类对象
			Class<?> pClass = Class.forName(className);
			// 构造器
			Constructor<?> c = pClass.getConstructor();
			// 通过构造器实例化
			Hero h2 = (Hero) c.newInstance();
			h2.name = "gareen";
			System.out.println(h2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
