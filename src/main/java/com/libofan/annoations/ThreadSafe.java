package com.libofan.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE) // 源代码注解
public @interface ThreadSafe {
    // 注释当前线程是安全的
    String value() default "";
}
