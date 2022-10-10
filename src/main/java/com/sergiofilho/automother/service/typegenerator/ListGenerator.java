package com.sergiofilho.automother.service.typegenerator;

import com.sergiofilho.automother.annotation.CollectionOf;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public final class ListGenerator {

	private static final int DEFAULT_SIZE = 3;

	private ListGenerator() {
	}

	public static List<?> generateOfType(Field field) throws Exception {
		CollectionOf annotation = field.getAnnotation(CollectionOf.class);

		if (annotation == null) {
			throw new Exception(
					"Field " + field + " must be annotated with com.sergiofilho.automother.annotation.CollectionOf");
		}

		return Arrays.asList(ArrayGenerator.generateOfType(annotation.type()));
	}
}
