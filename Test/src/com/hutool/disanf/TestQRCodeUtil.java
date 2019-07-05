/**
 * 
 */
package com.hutool.disanf;

import java.io.File;

/**
 * @author PE
 * @date 2019年7月5日 下午3:38:36
 * @explain 二维码测试
 */
public class TestQRCodeUtil {
	public static void main(String[] args) throws Exception {
		/**
		 * 不带log
		 */

		String text = "http://www.cnblogs.com/qianxiaoruofeng/";
		QRCodeUtil.encode(text, "", "d:/barcode", true);

		String txt = QRCodeUtil.decode(new File("D:\\barcode\\94759099.jpg"));
		String txt1 = QRCodeUtil.decode(new File("D:\\barcode\\48444888.jpg"));
		System.out.println(txt);
		System.out.println(txt1);
		/**
		 * 带log
		 */

		String text1 = "http://www.cnblogs.com/qianxiaoruofeng/";

		QRCodeUtil.encode(text1, "D:\\Download\\Test\\image\\4_1.jpg", "d:/barcode", true);

	}
}
