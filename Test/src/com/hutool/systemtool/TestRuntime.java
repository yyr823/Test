/**
 * 
 */
package com.hutool.systemtool;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.util.RuntimeUtil;

/**
 * @author PE
 * @date 2019年7月2日 下午10:19:04
 * @explain 活动连接
 */
public class TestRuntime extends CommentTool{
	 @Test
	    @Comment("RuntimeUtil使用举例")
	    public void test1() {
	        String s =RuntimeUtil.execForStr("netstat -n");
	        System.out.println(s);
	    }
}
