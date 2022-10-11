package com.sergiofilho.beangenerator.service.typegenerator;

import com.sergiofilho.beangenerator.annotation.CollectionOf;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class SetGenerator {

	private static final int DEFAULT_SIZE = 3;

	private SetGenerator() {
	}

	public static Set<?> generate(Field field) throws Exception {
		CollectionOf annotation = field.getAnnotation(CollectionOf.class);

		if (annotation == null) {
			throw new Exception(
					"Field " + field + " must be annotated with com.sergiofilho.automother.annotation.CollectionOf");
		}

		return new HashSet<>(Arrays.asList(ArrayGenerator.generateOfType(annotation.type())));
	}
}
