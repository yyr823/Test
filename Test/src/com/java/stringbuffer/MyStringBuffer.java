/**
 * 
 */
package com.java.stringbuffer;

/**
 * @author PE
 * @date 2019年6月25日 上午11:36:26
 * @explain arraycopy // src: 源数组 // srcPos: 从源数组复制数据的起始位置 // dest: 目标数组 //
 *          destPos: 复制到目标数组的启始位置 // length: 复制的长度
 */
public class MyStringBuffer implements IStringBuffer {
	// 容量
	int capacity = 16;
	// 长度
	int length;
	// 数组
	char[] value;

	// 无参构造方法
	public MyStringBuffer() {
		// new一个数组
		value = new char[capacity];
	}

	// 有参构造方法
	public MyStringBuffer(String str) {
		this();// 调用无参构造方法
		// 如果容量小于str长度,str是你当前输入的字符串
		if (capacity < str.length()) {
			capacity = str.length() * 2;// 2倍扩容
			value = new char[capacity];// value指向新的数组长度16->32
		}
		length = str.length();// 记录长度
		// 当前输入str转换为字符数组，从0开始，copy给value,copy 长度为length
		System.arraycopy(str.toCharArray(), 0, value, 0, length);
	}

	// 实现接口的方法
	// 先实现insert的方法》》》》》》
	// 末尾添加字符串
	@Override
	public void append(String str) throws Exception {
		// TODO Auto-generated method stub
		insert(length, str);
	}

	@Override
	public void append(char c) throws Exception {
		// TODO Auto-generated method stub
		// 末尾添加字符
		insert(length, String.valueOf(c));
	}

	@Override
	// 单字符变字符串，用字符串来
	public void insert(int pos, char c) throws Exception {
		// TODO Auto-generated method stub
		insert(pos, String.valueOf(c));
	}

	@Override
	// 在pos位置插入字符串
	public void insert(int pos, String str) throws Exception {
		// 边界条件判断
		// 边界条件判断
		if (pos < 0)
			throw new IndexIsNagetiveException("插入位置下标为负异常");
		if (pos > length)
			throw new IndexIsOutofRangeException("插入位置下标超出范围异常");
		if (null == str)
			throw new NullPointerException();

		// 扩容
		while (length + str.length() > capacity) {
			capacity = (int) ((length + str.length()) * 1.5f);
			char[] newValue = new char[capacity];
			System.arraycopy(value, 0, newValue, 0, length);

			value = newValue;
		}

		char[] cs = str.toCharArray();

		// 先把已经存在的数据往后移
		// 比如newValue开始是1234567，在2位置插入XYZ,变成12345+34567就是12【345】34567
		System.arraycopy(value, pos, value, pos + cs.length, length - pos);
		/*
		 * for (char c : value) { System.out.print(c+"*"); }
		 */

		// 把要插入的数据插入到指定位置
		// 插入str(XYZ),上面的是12【345】34567变12【XYZ】34567
		System.arraycopy(cs, 0, value, pos, cs.length);
		/*
		 * for (char c : value) { System.out.print(c+"*"); }
		 */
		length = length + cs.length;
	}

	@Override
	// 从pos位置开始，delete 所有，因为end=length
	public void delete(int pos) throws Exception {
		// TODO Auto-generated method stub
		delete(pos, length);
	}

	@Override
	// 判断start

	public void delete(int start, int end) throws Exception {
		// TODO Auto-generated method stub
		// 边界条件判断
		if (start < 0)
			throw new IndexIsNagetiveException("下标为负异常");
		if (start > length)
			throw new IndexIsOutofRangeException("下标超出范围异常");
		if (end < 0)
			throw new IndexIsNagetiveException("下标为负异常");
		if (end > length)
			throw new IndexIsOutofRangeException("下标超出范围异常");
		if (start >= end)
			throw new IndexIsOutofRangeException("下标超出范围异常");
		System.arraycopy(value, end, value, start, length - end);
		length -= end - start;
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		for (int i = 0; i < length / 2; i++) {
			char temp = value[i];
			value[i] = value[length - i - 1];
			value[length - i - 1] = temp;
		}
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return length;
	}

	public String toString() {
		char[] realValue = new char[length];

		System.arraycopy(value, 0, realValue, 0, length);

		return new String(realValue);
	}
}
