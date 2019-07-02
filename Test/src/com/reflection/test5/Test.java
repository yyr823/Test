/**
 * 
 */
package com.reflection.test5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author PE
 * @date 2019年7月2日 下午2:19:18
 * @explain
 */
public class Test {

	public static void main(String[] args) {
		/**
		 * 当需要从第一个业务方法切换到第二个业务方法的时候，使用非反射方式， 必须修改代码，并且重新编译运行，才可以达到效果
		 */
		// new Service1().doService1();
		// new Service2().doService2();

		/**
		 * 使用反射方式，首先准备一个配置文件，就叫做spring.txt吧。 里面存放的是类的名称，和要调用的方法名。
		 * 在测试类Test中，首先取出类名称和方法名，然后通过反射去调用这个方法。 当需要从调用第一个业务方法，切换到调用第二个业务方法的时候，
		 * 不需要修改一行代码，也不需要重新编译，只需要修改配置文件spring.txt， 再运行即可。
		 * 这也是Spring框架的最基本的原理，只是它做的更丰富，安全，健壮。
		 */
		// 从spring.txt中获取类名称和方法名称
		File springConfigFile = new File("D:\\Download\\Test\\src\\com\\reflection\\test5\\spring.txt");
		Properties springConfig = new Properties();
		try {
			springConfig.load(new FileInputStream(springConfigFile));
			String className = (String) springConfig.get("class");
			String methodName = (String) springConfig.get("method");
			// 根据类名称获取类对象
			Class<?> clazz = Class.forName(className);
			// 获取构造器
			Constructor c = clazz.getConstructor();
			// 根据构造器，实例化出对象
			Object service = c.newInstance();
			// 根据方法名称，获取方法对象
			Method m = clazz.getMethod(methodName);
			// 调用对象的指定方法
			m.invoke(service);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
