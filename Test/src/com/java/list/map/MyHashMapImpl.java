/**
 * 
 */
package com.java.list.map;

import java.util.LinkedList;

/**
 * @author PE
 * @date 2019年6月27日 上午11:31:51
 * @explain
 */
public class MyHashMapImpl implements IHashMap {

	Object o[] = new Object[2000];

	/**
	 * 首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,然后把这个hashcode作为下标，定位到数组的指定位置。
	 * 如果该位置没有数据，则把字符串和对象组合成键值对Entry，再创建一个LinkedList，把键值对，放进LinkedList中，最后把LinkedList
	 * 保存在这个位置。 如果该位置有数据，一定是一个LinkedList,则把字符串和对象组合成键值对Entry，插入到LinkedList后面。
	 * 
	 */
	public void put(String key, Object object) {
		// TODO 自动生成的方法存根
		int num = hashcode(key);
		if (o[num] == null) {// 为null就只管把它entry进去,再将list放到数组对应的下标中
			LinkedList<Entry> link = new LinkedList<>();
			Entry entry = new Entry(key, object);
			link.add(entry);
			o[num] = link;
		} else {
			// 不为空就直接添加到对应下标位置的数组中去
			Entry entry = new Entry(key, object);
			LinkedList<Entry> link = (LinkedList<Entry>) o[num];
			link.addLast(entry);
		}
	}

	/**
	 * 首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,然后把这个hashcode作为下标，定位到数组的指定位置。
	 * 如果这个位置没有数据，则返回空
	 * 如果这个位置有数据，则挨个比较其中键值对的键-字符串，是否equals，找到匹配的，把键值对的值，返回出去。找不到匹配的，就返回空
	 */
	@Override
	public Object get(String key) {
		// TODO 自动生成的方法存根
		// 先找到hashcode(key)对应的数据是否存在，然后再进行equal比较
		if (o[hashcode(key)] != null) {
			LinkedList<Entry> link = (LinkedList<Entry>) o[hashcode(key)];
			for (Entry entry : link) {
				// 千万不要在循环里面return null,我是贼难受的
				if (key.equals(entry.key)) {
					return entry.value;
				}
			}
		}
		return null;
	}

	public static int hashcode(String s) {
		/**
		 * 如果字符串长度是0，则返回0。 否则： 获取每一位字符，转换成数字后，相加，最后乘以23,
		 * 如果值超过了1999，则取2000的余数，保证落在0-1999之间。 如果是负数，则取绝对值。
		 */
		// hashcode方法
		int num = 0;
		if (s.length() > 0) {
			char c[] = s.toCharArray();
			for (char ch : c) {
				num = num + ch;
			}
			num = num * 23;
			if (num < 0) {
				num = Math.abs(num);
			}
		}
		return num > 1999 ? num % 2000 : num;
	}
}
