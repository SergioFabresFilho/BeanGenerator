package io.github.sergiofabresfilho.beangenerator.service.typegenerator;

import io.github.sergiofabresfilho.beangenerator.annotation.CollectionOf;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public final class ListGenerator {

	private static final int DEFAULT_SIZE = 3;

	private ListGenerator() {
	}

	public static List<?> generate(Field field) throws Exception {
		CollectionOf annotation = field.getAnnotation(CollectionOf.class);

		if (annotation == null) {
			throw new Exception(
					"Field " + field + " must be annotated with " + CollectionOf.class);
		}

		return Arrays.asList((Object[]) ArrayGenerator.generateOfType(annotation.type(), annotation.size()));
	}
}
