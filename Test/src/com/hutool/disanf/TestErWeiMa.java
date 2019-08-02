package com.hutool.disanf;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;

public class TestErWeiMa extends CommentTool {

	@Test
	@Comment("生成二维码图片和解析二维码图片")
	public void test1() {
		String string = "楊玉榮";
		String path = "d:/qrcode.jpg";
		QrCodeUtil.generate(string, 300, 300, FileUtil.file(path));
		p1("字符串", string, "二维码图片", path);
		

		string = QrCodeUtil.decode(FileUtil.file(path));
		p1("二维码图片", path, "二维码图片", string);

	}

}
