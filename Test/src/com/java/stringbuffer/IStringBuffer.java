/**
 * 
 */
package com.java.stringbuffer;

/**
 * @author PE
 * @date 2019年6月25日 上午11:35:36
 * @explain
 */
public interface IStringBuffer {
	public void append(String str) throws Exception; // 追加字符串

	public void append(char c) throws Exception; // 追加字符

	public void insert(int pos, char b) throws Exception; // 指定位置插入字符

	public void insert(int pos, String b) throws Exception; // 指定位置插入字符串

	public void delete(int start) throws Exception; // 从开始位置删除剩下的

	public void delete(int start, int end) throws Exception; // 从开始位置删除结束位置-1

	public void reverse(); // 反转

	public int length(); // 返回长度
}
