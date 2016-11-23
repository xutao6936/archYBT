package com.topcheer.ybt.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解 拦截service
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface SystemServiceLog {
	String description() default "";
}