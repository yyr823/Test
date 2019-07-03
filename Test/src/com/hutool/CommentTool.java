/**
 * 
 */
package com.hutool;

import java.lang.reflect.Method;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author PE
 * @date 2019年7月2日 下午4:48:53
 * @explain
 */
public class CommentTool {
	String preComment = null;

	public void p2(String type1, Object value1, String type2, Object value2) {
		p(type1, value1, type2, value2, "format2");
	}

	public void p1(String type1, Object value1, String type2, Object value2) {
		p(type1, value1, type2, value2, "format1");
	}

	public void p3(String type1, Object value1) {
		p(type1, value1, "", "", "format3");
	}

	public void p4(Object value) {
		p(null, value, "", "", "format4");
	}

	public void p5(String type1, Object value1) {
		p(type1, value1, "", "", "format5");
	}

	public void c(String msg) {
		System.out.printf("\t备注：%s%n", msg);
	}

	public void p(String type1, Object value1, String type2, Object value2, String format) {
		try {
			throw new Exception();
		} catch (Exception e) {
			String methodName = getTestMethodName(e.getStackTrace());
			Method m = ReflectUtil.getMethod(this.getClass(), methodName);
			Comment annotation = m.getAnnotation(Comment.class);
			if (null != annotation) {
				String comment = annotation.value();
				if (!comment.equals(preComment)) {
					System.out.printf("%n%s 例子： %n%n", comment);
					preComment = comment;
				}

			}
		}
		int padLength = 12;
		type1 = StrUtil.padEnd(type1, padLength, Convert.toSBC(" ").charAt(0));
		type2 = StrUtil.padEnd(type2, padLength, Convert.toSBC(" ").charAt(0));
		if ("format1".equals(format)) {
			System.out.printf("\t%s的:\t\"%s\" %n\t被转换为----->%n\t%s的 :\t\"%s\" %n%n", type1, value1, type2, value2);
		}
		if ("format2".equals(format)) {
			System.out.printf("\t基于 %s:\t\"%s\" %n\t获取 %s:\t\"%s\"%n%n", type1, value1, type2, value2);
		}
		if ("format3".equals(format)) {
			System.out.printf("\t%s:\t\"%s\" %n\t%n", type1, value1);

		}
		if ("format4".equals(format)) {
			System.out.printf("\t%s%n%n", value1);

		}
		if ("format5".equals(format)) {
			System.out.printf("---------%s-------:%n%s %n%n", type1, value1);
		}
	}

	private String getTestMethodName(StackTraceElement[] stackTrace) {
		for (StackTraceElement se : stackTrace) {
			String methodName = se.getMethodName();
			if (methodName.startsWith("test"))
				return methodName;
		}
		return null;
	}

}
