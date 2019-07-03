package com.hutool.systemtool;

import java.awt.Image;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.swing.ClipboardUtil;
import cn.hutool.core.util.ImageUtil;

public class TestClipboard extends CommentTool{
	
	@Test
	@Comment("粘贴版")
	public void test1() {	
		String s1 = "how2j.cn- java教程";
		ClipboardUtil.setStr(s1);
		
		String s2 = ClipboardUtil.getStr();
		
		p3("把如下数据通过ClipboardUtil 保存到粘贴板里",s1);
		
		p3("通过ClipboardUtil 从粘贴板里取数据",s2);
		
		//注意此文件是否真的存在
		String imagePath = "D:\\Download\\Test\\image\\1.jpg";
	     Image img =ImageUtil.read(imagePath);
	     ClipboardUtil.setImage(img);
		img = ClipboardUtil.getImage();
		p3("向粘贴板复制图片的用法：","ClipboardUtil.setImage(img)");
		p3("从粘贴板获取图片的用法：","ClipboardUtil.getImage()");
	}
	
}
