package com.sergiofilho.beangenerator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapOf {
	Class<?> keyType();
	Class<?> elementType();
	int size() default 3;
}
