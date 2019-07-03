package com.hutool.disanf;

import org.junit.Before;
import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

public class TestMail extends CommentTool {
	private MailAccount account;

	/*
	 * @Before public void prepareMailAccount() { account = new MailAccount();
	 * account.setHost("smtp.163.com"); account.setPort(25); account.setAuth(true);
	 * account.setFrom("13623760439@163.com"); //假邮箱，请自己申请真实邮箱
	 * account.setUser("13623760439@163.com"); //假邮箱，请自己申请真实邮箱
	 * account.setPass("xxxxx."); //假密码，请自己申请真实邮箱
	 * 
	 * 
	 * }
	 */
	/**
	 * 关于qq邮箱如果要使用，密码要使用授权码。 授权码的获取手段：
	 * https://service.mail.qq.com/cgi-bin/help?subtype=1&&id=28&&no=1001256
	 */
	@Before
	public void prepareMailAccount1() {
		account = new MailAccount();
		account.setHost("smtp.qq.com");
		account.setPort(465);
		account.setAuth(true);
		account.setFrom("2812154848@qq.com"); // 假邮箱，请自己申请真实邮箱
		account.setUser("2812154848@qq.com"); // 假邮箱，请自己申请真实邮箱
		account.setPass("xxxx"); // 假密码，请自己申请真实邮箱
		account.setSslEnable(true); // qq邮箱要加密

	}

	@Test
	@Comment("发送qq信息")
	public void test0() {
		// 因为账号密码不对，所以不能正确发送
		MailUtil.send(account, "2812154848@qq.com", "hutool 测试邮件" + DateUtil.now(), "测试内容", false);
	}

	@Test
	@Comment("发送普通文本")
	public void test1() {
		// 因为账号密码不对，所以不能正确发送
		MailUtil.send(account, "13623760439@163.com", "hutool 测试邮件" + DateUtil.now(), "测试内容", false);
	}

	@Test
	@Comment("发送html邮件")
	public void test2() {
		// 因为账号密码不对，所以不能正确发送

		MailUtil.send(account, "13623760439@163.com", "hutool 测试邮件" + DateUtil.now(), "<p>测试内容</p>", true);
	}

	@Test
	@Comment("发送带附件的邮件")
	public void test3() {
		/**
		 * 发起人 收信人 主题 内容 内容是否是html格式 附件内容
		 */
		// 因为账号密码不对，所以不能正确发送
		MailUtil.send(account, "13623760439@163.com", "hutool 测试邮件" + DateUtil.now(), "<p>测试内容</p>", true,
				FileUtil.file("D:\\Download\\Test\\image\\5.jpg"));
	}

}
