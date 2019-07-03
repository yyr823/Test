package com.hutool.encoding;

import java.awt.Color;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.util.HexUtil;

/**
 * @author PE
 * @date 2019年7月2日 下午4:32:03
 * @explain 字符串和进制,颜色对象和颜色字符之间的转换
 */
public class TestHex extends CommentTool {
	@Test
	@Comment("判断是否是十六进制")
	public void test1() {
		String s1 = "12";
		boolean b1 = HexUtil.isHexNumber(s1);
		String s2 = "0x12";
		boolean b2 = HexUtil.isHexNumber(s2);
		p2("字符串", s1, "是否十六机制", b1);
		p2("字符串", s2, "是否十六机制", b2);

	}

	@Test
	@Comment("字符串和十六进制互相转换")
	public void test2() {

		String s1 = "how2j.cn - java教程";
		String s2 = HexUtil.encodeHexStr(s1);
		String s3 = HexUtil.decodeHexStr(s2);

		p2("原数据", s1, "十六机制编码", s2);
		p2("十六进制", s2, "十六机制解码", s3);

	}

	@Test
	@Comment("颜色转换")
	public void test3() {
		Color color1 = Color.red;
		String s1 = HexUtil.encodeColor(color1);
		String s2 = "#112233";
		Color color2 = HexUtil.decodeColor(s2);
		p2("颜色对象1", color1, "字符串", s1);
		p2("字符串", s2, "颜色对象2", color2);

	}

}
