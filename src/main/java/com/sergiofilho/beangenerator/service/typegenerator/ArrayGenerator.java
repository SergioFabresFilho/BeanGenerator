package com.sergiofilho.beangenerator.service.typegenerator;

import com.sergiofilho.beangenerator.service.ValueGenerator;

import java.lang.reflect.Array;

public final class ArrayGenerator {

	private static final int DEFAULT_ARRAY_SIZE = 3;

	private ArrayGenerator() {
	}

	public static <T> Object generateOfType(Class<?> clazz) throws Exception {
		return generateOfType(clazz, DEFAULT_ARRAY_SIZE);
	}

	public static <T> Object generateOfType(Class<?> clazz, int size) throws Exception {

		Object array = Array.newInstance(clazz, size);

		for (int i = 0; i < size; i++) {
			Array.set(array, i, ValueGenerator.generate(clazz, null));
		}

		return array;
	}
}
