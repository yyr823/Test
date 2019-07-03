/**
 * 
 */
package com.hutool.encoding;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.codec.Base32;
import cn.hutool.core.codec.Base64;

/**
 * @author PE
 * @date 2019年7月2日 下午5:23:51
 * @explain base-32-64转换
 */
public class TestIdBase32_64 extends CommentTool {
	@Test
	@Comment("base-32-64转换")
	public void test1() {
		String charset = "utf-8";

		String content = "how2j.cn - java教程";

		p3("原字符串", content);

		String code32 = Base32.encode(content, charset);
		content = Base32.decodeStr(code32, charset);

		p3("32位编码后", code32);
		p3("32位解码", content);

		String code64 = Base64.encode(content, charset);
		content = Base64.decodeStr(code64, charset);
		p3("64位编码后", code64);
		p3("64位解码", content);

	}
}
