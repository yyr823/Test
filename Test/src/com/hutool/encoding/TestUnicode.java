/**
 * 
 */
package com.hutool.encoding;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.text.UnicodeUtil;

/**
 * @author PE
 * @date 2019年7月2日 下午5:25:48
 * @explain unicode转换
 */
public class TestUnicode extends CommentTool {
	@Test
	@Comment("unicode转换")
	public void test1() {
		// String charset = "utf-8";

		String content = "how2j.cn - java教程";

		p3("原字符串", content);

		String unicode = UnicodeUtil.toUnicode(content);
		content = UnicodeUtil.toString(unicode);

		p3("获取unicode", unicode);
		p3("转会原字符串", content);

	}
}
