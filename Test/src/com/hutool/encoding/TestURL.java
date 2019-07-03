/**
 * 
 */
package com.hutool.encoding;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.util.URLUtil;

/**
 * @author PE
 * @date 2019年7月2日 下午5:21:58
 * @explain URLUtil
 */
public class TestURL extends CommentTool {
	@Test
	@Comment("URLUtil使用举例")
	public void test1() {
		String url1 = "how2j.cn";
		String url2 = "http://how2j.cn/k/tmall_springboot/tmall_springboot-1799/1799.html";
		String urla = URLUtil.formatUrl(url1);
		String urlb = URLUtil.encode(url2);
		String urlc = URLUtil.decode(urlb);
		String urld = URLUtil.getPath(url2);

		p1("原数据", url1, "格式化之后", urla);
		p1("原数据", url2, "编码数据", urlb);
		p1("编码数据", urlb, "解码数据", urlc);
		p1("原数据", url2, "对应路径路径", urld);

	}
}
