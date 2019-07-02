/**
 * 
 */
package com.junit.test1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author PE
 * @date 2019年7月2日 下午4:23:44
 * @explain 一下执行多个测试类(类似不在方法上进行启动而是在类上进行测试一样)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ TestCase1.class })
public class TestSuite {

}