/**
 * 
 */
package com.hutool.clazzandduixiang;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;
import com.hutool.Hero;

import cn.hutool.core.util.ReflectUtil;

/**
 * @author PE
 * @date 2019年7月2日 下午10:13:01
 * @explain
 */
public class TestReflection extends CommentTool {
	@Test
	@Comment("设置属性")
	public void test1() {

		Hero h = new Hero();
		ReflectUtil.setFieldValue(h, "name", "盖伦");
		p3("对象通过反射设置name属性后的值", h.getName());
	}

	@Test
	@Comment("调用方法")
	public void test2() {
		Hero h = new Hero();
		ReflectUtil.invoke(h, "setName", "盖伦");
		p3("对象通过反射设置调用setName属性后的值", h.getName());
	}

}
