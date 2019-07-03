/**
 * 
 */
package com.hutool;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author PE
 * @date 2019年7月2日 下午4:37:49
 * @explain
 */
@Target({ METHOD, TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Comment {
	String value();
}
