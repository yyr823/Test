/**
 * 
 */
package com.hutool.systemtool;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.util.StrUtil;
import cn.hutool.system.SystemUtil;

/**
 * @author PE
 * @date 2019年7月2日 下午10:20:09
 * @explain 
 */
public class TestSystem extends 	CommentTool{
	 @Test
	    @Comment("系统属性工具")
	    public void test1(){
	        p5("java虚拟机规范",StrUtil.trim(SystemUtil.getJvmSpecInfo().toString()));
	        p5("当前虚拟机信息",StrUtil.trim(SystemUtil.getJvmInfo().toString()));
	        p5("java规范",StrUtil.trim(SystemUtil.getJavaSpecInfo().toString()));
	        p5("当前java信息",StrUtil.trim(SystemUtil.getJavaInfo().toString()));
	        p5("java运行时信息",StrUtil.trim(SystemUtil.getJavaRuntimeInfo().toString()));
	        p5("操作系统信息",StrUtil.trim(SystemUtil.getOsInfo().toString()));
	        p5("用户信息",StrUtil.trim(SystemUtil.getUserInfo().toString()));
	        p5("主机信息",StrUtil.trim(SystemUtil.getHostInfo().toString()));
	        p5("内存信息",StrUtil.trim(SystemUtil.getRuntimeInfo().toString()));
	    }
	     
}
