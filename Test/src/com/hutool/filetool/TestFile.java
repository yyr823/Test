package com.hutool.filetool;

import org.junit.Test;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.ImageUtil;

public class TestFile {
	/**
	 * ClassPathResource 是专门用来读取classpath 里的数据的，很方便。 如代码所所示，读取 hutoool jar 包里的：
	 * META-INF/MANIFEST.MF 文件并打印出来了。。。
	 */
	@Test
	public void test1() {
		//获取文件后缀
		String ext = FileUtil.extName("file.txt");
		
		System.out.println(ext);
		ClassPathResource resource = new ClassPathResource("META-INF/MANIFEST.MF");
		System.out.println(resource.readUtf8Str());
	}
}
