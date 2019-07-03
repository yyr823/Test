package com.hutool.cytool;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;
import com.hutool.Hero;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class TestJSON extends CommentTool {
	@Test
	@Comment("java bean 和 json 互相转换")
	public void test0() {
		Hero hero = new Hero("garren", 345);
		String str = JSONUtil.toJsonPrettyStr(hero);
		System.out.println(str);
		JSONObject o = JSONUtil.parseObj(str);
		System.out.println(o.getClass());
		Hero hero2 = JSONUtil.toBean(o, Hero.class);
		System.out.println(hero2);
	}

}
