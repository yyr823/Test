/**
 * 
 */
package com.annotation.test3;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.RetentionPolicy;

/**
 * @author PE
 * @date 2019年7月2日 下午2:52:51
 * @explain 定义注解@JDBCConfig 元注解 用于注解 自定义注解 的注解。
 * @Target({METHOD,TYPE}) 表示这个注解可以用用在类/接口上，还可以用在方法上
 * @Retention(RetentionPolicy.RUNTIME) 表示这是一个运行时注解，即运行起来之后，才获取注解中的相关信息，而不像基本注解如@Override
 *                                     那种不用运行，在编译时eclipse就可以进行相关工作的编译时注解。
 * @Inherited 表示这个注解可以被子类继承
 * @Documented 表示当执行javadoc的时候，本注解会生成相关文档
 */
@Target({ METHOD, TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface JDBCConfig {
	/*
	 * 注解的属性也叫做成员变量。注解只有成员变量，没有方法。 注解的成员变量在注解的定义中以“无形参的方法”形式来声明， 其方法名定义了该成员变量的名字，
	 * 其返回值定义了该成员变量的类型
	 */
	String ip();

	int port() default 3306;

	String database();

	String encoding();

	String loginName();

	String password();
}
