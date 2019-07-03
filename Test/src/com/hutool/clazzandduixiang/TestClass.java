package com.hutool.clazzandduixiang;

import java.lang.reflect.Method;
import java.util.Set;
import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.lang.Filter;
import cn.hutool.core.util.ClassUtil;

public class TestClass extends CommentTool {

	@Test
	@Comment("ClassUtil使用举例")
	public void test1() {

		String packageName = "com.hutool";
		Set<Class<?>> classes = ClassUtil.scanPackage(packageName);
		p2("包名", packageName, "当前包下所有的类", classes);
		/**
		 * 获取方法
		 */
		Set<String> methodNames = ClassUtil.getPublicMethodNames(TestClass.class);
		p2("当前类", packageName + this.getClass().getName(), "当前运行类下的所有方法名称", methodNames);
		Method[] methods = ClassUtil.getPublicMethods(TestClass.class);
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		p2("当前类", packageName + this.getClass().getName(), "当前运行类下的所有方法", methods);

		ClassUtil.getPublicMethods(TestClass.class, new Filter<Method>() {
			@Override
			public boolean accept(Method arg0) {
				if (arg0.getName().equals("test1")) {
					p2("当前类", packageName + this.getClass().getName(), "当前运行类下是否有test1方法", "找到方法");
				}
				return false;
			}
		});
	}

	/**
	 * 获取方法
	 * 
	 * 1.public static Set<String> getPublicMethodNames(Class<?> clazz) 2.public
	 * static Method[] getPublicMethods(Class<?> clazz) 3.public static List<Method>
	 * getPublicMethods(Class<?> clazz, Filter<Method> filter)4.public static
	 * List<Method> getPublicMethods(Class<?> clazz, Method... excludeMethods)
	 * 5.public static List<Method> getPublicMethods(Class<?> clazz, String...
	 * excludeMethodNames) 6.public static Method getPublicMethod(Class<?> clazz,
	 * String methodName, Class<?>... paramTypes) 7.public static Set<String>
	 * getDeclaredMethodNames(Class<?> clazz) 8.public static Method[]
	 * getDeclaredMethods(Class<?> clazz) 9.public static Method
	 * getDeclaredMethodOfObj(Object obj, String methodName, Object... args) 10.
	 * public static Method getDeclaredMethod(Class<?> clazz, String methodName,
	 * Class<?>... parameterTypes)
	 * 
	 * 
	 * 获取字段
	 * 
	 * 1.public static Field getDeclaredField(Class<?> clazz, String fieldName) 2.
	 * public static Field[] getDeclaredFields(Class<?> clazz)
	 * 
	 * 
	 * 调用方法
	 * 
	 * 1.public static <T> T invoke(String classNameDotMethodName, Object[] args)
	 * 2.public static <T> T invoke(String classNameWithMethodName, boolean
	 * isSingleton, Object... args) 3. public static <T> T invoke(String className,
	 * String methodName, Object[] args) 4.public static <T> T invoke(String
	 * className, String methodName, boolean isSingleton, Object[] args)
	 */

}
