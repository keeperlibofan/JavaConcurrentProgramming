package com.libofan.annoations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE) // 运行时注解
public @interface NotThreadSafe {
    String value() default "";
}
