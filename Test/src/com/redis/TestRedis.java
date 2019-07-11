/**
 * 
 */
package com.redis;

import redis.clients.jedis.Jedis;

/**
 * @author PE
 * @date 2019年7月10日 下午4:34:36
 * @explain 
 */
public class TestRedis {
public static void main(String[] args) {
	Jedis jedis=new Jedis("localhost");
	jedis.set("foo","bar");
	String value=jedis.get("foo");
	System.out.println(value);
}
}
