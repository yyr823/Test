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
 * @date 2019年7月2日 下午3:47:26
 * @explain 对应 javax.persistence.Entity
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyEntity {

}