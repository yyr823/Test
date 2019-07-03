/**
 * 
 */
package com.hutool.cytool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;
import com.hutool.Hero;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.comparator.PinyinComparator;
import cn.hutool.core.comparator.PropertyComparator;
import cn.hutool.core.util.RandomUtil;

/**
 * @author PE
 * @date 2019年7月2日 下午10:05:13
 * @explain
 */
public class TestComparator extends CommentTool {
	@Test
	@Comment("属性比较器")
	public void test1() {
		List<Hero> heros = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero " + i, RandomUtil.randomInt(100)));
		}
		System.out.println("未排序的集合:");
		System.out.println(CollectionUtil.join(heros, "\r\n"));

		Collections.sort(heros, new PropertyComparator<>("hp"));
		System.out.println("根据属性 hp 排序之后：");
		System.out.println(CollectionUtil.join(heros, "\r\n"));
	}

	@Test
	@Comment("拼音比较器")
	public void test2() {
		List<String> names = new ArrayList<>();
		names.add("令狐冲");
		names.add("陈家洛");
		names.add("石破天");
		names.add("胡一刀");

		p3("未排序的集合", CollectionUtil.join(names, " , "));

		Collections.sort(names, new PinyinComparator());
		p3("根据拼音排序的集合", CollectionUtil.join(names, " , "));
	}
}
