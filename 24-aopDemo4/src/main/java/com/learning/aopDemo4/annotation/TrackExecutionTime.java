package com.learning.aopDemo4.annotation;

import java.lang.annotation.*;

// Marker annotation

//@Target({ElementType.METHOD})  // Can be used on methods only
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//public @interface TrackExecutionTime {
//}


// Configured annotation

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {
    long warnAfter() default 2000;
    String operation() default "";
}