package com.hutool.disanf;

import java.io.IOException;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.ftp.Ftp;

public class TestFTP extends CommentTool {

	@Test
	@Comment("上传下载")
	public void test1() {

		String localFile4Upload = "d:/test.jpg";
		String localFile4Download = "d:/test2.jpg";
		String remoteFolder = "/";
		String remoteFile = "test.jpg";
		String ftpServer = "28.212.18.5"; // 这是无效的ip地址，请使用自己有效的ftp服务器ip地址
		String name = "ftpuser";
		String password = "password123";

		Ftp ftp = new Ftp(ftpServer, 21, name, password);
		boolean success = ftp.upload(remoteFolder, remoteFile, FileUtil.file(localFile4Upload));
		p3("上传是否成功", success);

		ftp.download(remoteFolder, remoteFile, FileUtil.file(localFile4Download));

		p3("用于上传的文件大小", FileUtil.file(localFile4Upload).length());
		p3("下载下来之后的文件大小", FileUtil.file(localFile4Download).length());

		try {
			ftp.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
