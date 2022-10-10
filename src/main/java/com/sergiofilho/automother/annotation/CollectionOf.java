package com.sergiofilho.automother.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CollectionOf {
	Class<?> type();
}
