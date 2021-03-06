/**
 * 
 */
package com.annotation.test5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author PE
 * @date 2019年7月2日 下午3:48:56
 * @explain 对应 javax.persistence.GeneratedValue
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyGeneratedValue {
	String strategy();
}