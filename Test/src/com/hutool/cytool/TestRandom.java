/**
 * 
 */
package com.hutool.cytool;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;

/**
 * @author PE
 * @date 2019年7月2日 下午10:04:14
 * @explain
 */
public class TestRandom extends CommentTool {
	@Test
	@Comment("各种各样的随机数")
	public void test1() {
		List<Integer> ls = new ArrayList<>();
		ls.add(1);
		ls.add(2);
		ls.add(3);
		p3("随机获取一个字符串", RandomUtil.randomString(10));
		p3("随机获取一个整数", RandomUtil.randomInt(1, 1000));
		p3("随机获取一个字节数组", Convert.toStr(RandomUtil.randomBytes(3)));

		p3("随机获取一个集合里的某个元素", RandomUtil.randomEle(ls));
		p3("随机获取一个大写字符串", RandomUtil.randomStringUpper(10));
		p3("随机获取一个数字字符串", RandomUtil.randomNumbers(10));
		p3("随机获取一个UUID", RandomUtil.randomUUID());
		p3("随机获取一个简化的UUID", RandomUtil.simpleUUID());
		p3("随机获取一个UUID",IdUtil.randomUUID());
		p3("随机获取一个简化的UUID", IdUtil.simpleUUID());
	}

}
