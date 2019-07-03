/**
 * 
 */
package com.hutool.encoding;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.util.EscapeUtil;

/**
 * @author PE
 * @date 2019年7月2日 下午4:47:22
 * @explain 转义与反转义
 */
public class TestEscape extends CommentTool {
	@Test
	@Comment("转义与反转义")
	public void test2() {
		String s1 = "<script>location.href='http://how2j.cn';</script>";
		String s2 = EscapeUtil.escapeHtml4(s1);
		String s3 = EscapeUtil.unescapeHtml4(s2);

		p2("原数据", s1, "转义后", s2);
		p2("转义后", s2, "原数据", s3);

	}

}
