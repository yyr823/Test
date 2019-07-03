package com.hutool.qita;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.lang.Validator;

public class TestValidator extends CommentTool {

	@Test
	@Comment("校验器")
	public void test1() {
		String email = "123@qq.com";
		boolean valid = Validator.isEmail(email);
		p2("邮件地址", email, " 是否合法 ", valid);
		boolean valid1 = Validator.isChinese("aa");
		p2("中文验证", email, " 是否是中文 ", valid1);

	}
	/**
	 * Validator 把一些常用的校验工具准备好了，提供给大家直接使用
	 * 
	 * 1.为空判断 isNull isEmpty 字母，数字和下划线 
	 * 2.isGeneral 至少多长的 isGeneral(String value, int min) 
	 * 3.给定范围的 isGeneral(String value, int min, int max)
	 * 4. 数字 isNumber 
	 * 5.给定范围的数字isBetween(Number value, Number min, Number max) 
	 * 6.纯字母 isLetter 
	 * 7.大小写 isUpperCase  isLowerCase 
	 * 8. 金额 isMoney 
	 * 9.邮件 isEmail 
	 * 10.手机号码 isMobile 
	 * 11.18位身份证 isCitizenId
	 * 12.邮编 isZipCode 
	 * 13.出生年月日 isBirthday 
	 * 14.URL isUrl 
	 * 15.汉字 isChinese 
	 * 16.汉字，字母，数字和下划线 isGeneralWithChinese 
	 * 17.mac地址 isMac 
	 * 18.中国车牌 isPlateNumber 
	 * 19 uuid isUUID
	 * 20.ip isIpv4
	 */

}
