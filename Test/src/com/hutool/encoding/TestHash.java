/**
 * 
 */
package com.hutool.encoding;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.util.HashUtil;

/**
 * @author PE
 * @date 2019年7月2日 下午4:57:59
 * @explain 各种各样的hash算法
 */
public class TestHash extends CommentTool {
	@Test
	@Comment("各种各样的hash算法")
	public void test2() {
		int[] aaa1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5,
				6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// int[][] aaa3 = { };
		String s = "how";
		int number = 12;
		long hash1 = HashUtil.additiveHash(s, Integer.MAX_VALUE);
		long hash2 = HashUtil.rotatingHash(s, Integer.MAX_VALUE);
		long hash3 = HashUtil.oneByOneHash(s);
		long hash4 = HashUtil.bernstein(s);
		// 底层用len<<3所以aaa数组的长度要很大才能跑起来
		long hash5 = HashUtil.universal(s.toCharArray(), 1, aaa1);
		// long hash6 = HashUtil.zobrist(s.toCharArray(), 1, aaa3);
		long hash7 = HashUtil.fnvHash(s);
		long hash8 = HashUtil.intHash(number);
		long hash9 = HashUtil.rsHash(s);
		long hash10 = HashUtil.jsHash(s);
		long hash11 = HashUtil.pjwHash(s);
		long hash12 = HashUtil.elfHash(s);
		long hash13 = HashUtil.bkdrHash(s);
		long hash14 = HashUtil.sdbmHash(s);
		long hash15 = HashUtil.djbHash(s);
		long hash16 = HashUtil.dekHash(s);
		long hash17 = HashUtil.apHash(s);
		long hash18 = HashUtil.tianlHash(s);
		long hash19 = HashUtil.javaDefaultHash(s);
		long hash20 = HashUtil.mixHash(s);
		p2("原数据", s, "加法算法对应的哈希值", hash1);
		p2("原数据", s, "旋转算法对应的哈希值", hash2);
		p2("原数据", s, "一次一个算法对应的哈希值", hash3);
		p2("原数据", s, "Bernstein's算法对应的哈希值", hash4);
		p2("原数据", s, " Universal 算法对应的哈希值", hash5);
		// p2("原数据", s, " Zobrist 算法对应的哈希值", hash6);
		p2("原数据", s, " 改进的32位FNV 算法对应的哈希值", hash7);
		p2("原数据", s, "Thomas Wang的整数算法对应的哈希值", hash8);
		p2("原数据", s, "RS算法对应的哈希值", hash9);
		p2("原数据", s, "JS算法对应的哈希值", hash10);
		p2("原数据", s, "PJ算法对应的哈希值", hash11);
		p2("原数据", s, "ELF算法对应的哈希值", hash12);
		p2("原数据", s, "BKDR算法对应的哈希值", hash13);
		p2("原数据", s, "SDBM算法对应的哈希值", hash14);
		p2("原数据", s, "DJB算法对应的哈希值", hash15);
		p2("原数据", s, "DEK算法对应的哈希值", hash16);
		p2("原数据", s, "AP算法对应的哈希值", hash17);
		p2("原数据", s, "TianL算法对应的哈希值", hash18);
		p2("原数据", s, "JAVA自己带算法对应的哈希值", hash19);
		p2("原数据", s, "混合算法对应的哈希值", hash20);

	}

}
