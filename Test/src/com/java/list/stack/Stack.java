/**
 * 
 */
package com.java.list.stack;

import com.java.list.arraylist.Hero;

/**
 * @author PE
 * @date 2019年6月26日 下午5:19:10
 * @explain 
 */
public interface Stack {
	//把英雄推入到最后位置
    public void push(Hero h);
    //把最后一个英雄取出来
    public Hero pull();
    //查看最后一个英雄
    public Hero peek();
}
