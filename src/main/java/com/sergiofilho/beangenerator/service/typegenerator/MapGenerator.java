package com.sergiofilho.beangenerator.service.typegenerator;

import com.sergiofilho.beangenerator.annotation.MapOf;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class MapGenerator {

	private MapGenerator() {
	}

	public static Map<?, ?> generate(Field field) throws Exception {
		MapOf annotation = field.getAnnotation(MapOf.class);

		List<?> keys = Arrays.asList(ArrayGenerator.generateOfType(annotation.keyType()));
		List<?> elements = Arrays.asList(ArrayGenerator.generateOfType(annotation.elementType()));

		return IntStream.range(0, keys.size()).boxed().collect(Collectors.toMap(keys::get, elements::get));
	}
}
