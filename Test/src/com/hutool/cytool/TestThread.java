/**
 * 
 */
package com.hutool.cytool;

import java.util.concurrent.ExecutionException;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.ArrayUtil;

/**
 * @author PE
 * @date 2019年7月2日 下午10:07:02
 * @explain
 */
public class TestThread extends CommentTool {
	@Test
	@Comment("多线程工具")
	public void test1() throws InterruptedException, ExecutionException {
		p3("所有线程", ArrayUtil.join(ThreadUtil.getThreads(), "\r\n\t\t\t\t"));
		p3("获取主线程", ThreadUtil.getMainThread());

		p3("不用捕捉异常的sleep", "ThreadUtil.sleep(2000);");
		ThreadUtil.sleep(2000);
		p3("很方便的通过线程池执行任务", "");
		for (int i = 0; i < 10; i++) {
			Runnable r = new Runnable() {
				@Override
				public void run() {
					System.out.println("\t\t当前线程是：" + Thread.currentThread());
				}
			};
			ThreadUtil.execute(r);

		}

	}
}
