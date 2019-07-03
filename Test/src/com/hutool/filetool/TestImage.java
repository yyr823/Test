/**
 * 
 */
package com.hutool.filetool;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.hutool.Comment;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ImageUtil;

/**
 * @author PE
 * @date 2019年7月3日 下午1:52:37
 * @explain 图片工具
 */
public class TestImage {
	@Test
	@Comment("scale 缩放图片")
	public void test1() {
		ImageUtil.scale(
			    FileUtil.file("D:\\Download\\Test\\image\\4.jpg"), 
			    FileUtil.file("d:/face_result.jpg"), 
			    0.5f//缩放比例
			);
	}
	@Test
	@Comment("cut 剪裁图片")
	public void test2() {
		ImageUtil.cut(
			    FileUtil.file("d:/4.jpg"),FileUtil.file("d:/face_result.jpg"), 
			    new Rectangle(200, 200, 100, 100)//裁剪的矩形区域
			);
	}
	
	@Test
	@Comment("slice 按照行列剪裁切片（将图片分为20行和20列）")
	public void test3() {
		ImageUtil.slice(FileUtil.file("d:/4.jpg"), FileUtil.file("d:/temp/"), 20, 20);

	}
	
	@Test
	@Comment("convert 图片类型转换，支持GIF->JPG、GIF->PNG、PNG->JPG、PNG->GIF(X)、BMP->PNG等")
	public void test4() {
		ImageUtil.convert(FileUtil.file("d:/4.jpg"), FileUtil.file("d:/temp/test2Convert.png"));

	}
	
	@Test
	@Comment("gray 彩色转为黑白")
	public void test5() {
		ImageUtil.gray(FileUtil.file("d:/4.jpg"), FileUtil.file("d:/temp/test2Convert.jpg"));

	}
	
	@Test
	@Comment("pressText 添加文字水印")
	public void test6() {
		ImageUtil.pressText(
			    FileUtil.file("D:\\Download\\Test\\image\\4_1.jpg"), 
			    FileUtil.file("d:/temp/te2.jpg"), 
			    "版权所有", ImageUtil.randomColor(), //文字顏色
			    new Font("黑体", Font.BOLD, 100), //字体
			    0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
			    0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
			    0.8f//透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
			);
	}
	@Test
	@Comment("pressImage 添加图片水印")
	public void test7() {
		ImageUtil.pressImage(
			    FileUtil.file("D:\\Download\\Test\\image\\4_1.jpg"), 
			    FileUtil.file("d:/temp/te.jpg"), 
			    ImageUtil.read(FileUtil.file("d:/temp/test2Conver1.jpg")), //水印图片
			    0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
			    0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
			    0.1f
			);
	}
	@Test
	@Comment("rotate 旋转图片")
	public void test8() {
		// 旋转180度
		BufferedImage image;
		try {
			image = ImageUtil.rotate(ImageIO.read(FileUtil.file("D:\\Download\\Test\\image\\4_1.jpg")), 180);
			ImageUtil.write(image, FileUtil.file("d:/temp/test2Conver1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	@Comment("flip 水平翻转图片")
	public void test9() {
		ImageUtil.flip(FileUtil.file("d:/temp/test2Conver1.jpg"), FileUtil.file("d:/temp/test2Conver2.jpg"));

	}

}

