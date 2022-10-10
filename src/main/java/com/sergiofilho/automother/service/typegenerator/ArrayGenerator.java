package com.sergiofilho.automother.service.typegenerator;

import com.sergiofilho.automother.service.ValueGenerator;

import java.lang.reflect.Array;

public final class ArrayGenerator {

	private static final int DEFAULT_ARRAY_SIZE = 3;

	private ArrayGenerator() {
	}

	public static <T> T[] generateOfType(Class<T> clazz) throws Exception {
		T[] array = (T[]) Array.newInstance(clazz, DEFAULT_ARRAY_SIZE);

		for (int i = 0; i < DEFAULT_ARRAY_SIZE; i++) {
			Array.set(array, i, ValueGenerator.generate(clazz));
		}

		return array;
	}
}
