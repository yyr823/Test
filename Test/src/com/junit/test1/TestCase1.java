/**
 * 
 */
package com.junit.test1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author PE
 * @date 2019年7月2日 下午4:11:59
 * @explain 优点: 1. 新增加的测试，对原来的测试没有影响 2. 如果测试失败了，会立即得到通知
 */
public class TestCase1 {
	@Test
	public void testSum1() {
		int result = sum1(1, 2);
		/**
		 * Assert.assertEquals(result, 3); 表示对 result 数值的期待是 3 如果是其他数值，就无法通过测试
		 */
		Assert.assertEquals(result, 3);
	}

	@Test
	public void testSum2() {
		int result = sum2(1, 2, 3);
		System.out.println(result);
		// 预期 result 的值为5
		Assert.assertEquals(result, 10);
	}

	@Before
	public void before() {
		System.out.println("测试前的准备工作，比如链接数据库等等");
	}

	@After
	public void after() {
		System.out.println("测试结束后的工作，比如关闭链接等等");
	}

	public static int sum1(int i, int j) {
		return i + j;
	}

	public static int sum2(int i, int j, int k) {
		return i + j + k;
	}
}
