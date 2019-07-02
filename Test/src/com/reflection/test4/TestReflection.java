/**
 * 
 */
package com.reflection.test4;

import java.lang.reflect.Method;

import com.reflection.test3.Hero;

/**
 * @author PE
 * @date 2019年7月2日 下午1:45:06
 * @explain 通过反射机制调用Hero的setName方法
 */
public class TestReflection {
	public static void main(String[] args) {
		Hero h = new Hero();

		try {
			// 获取这个名字叫做setName，参数类型是String的方法
			Method m = h.getClass().getMethod("setName", String.class);
			// 对h对象，调用这个方法
			m.invoke(h, "盖伦");
			// 使用传统的方式，调用getName方法
			System.out.println(h.getName());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
