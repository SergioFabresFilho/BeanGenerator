package com.sergiofilho.beangenerator.service.typegenerator;

import java.util.Random;

public final class EnumGenerator {

	private static final Random random = new Random();

	private EnumGenerator() {
	}

	public static Object generate(Class<?> clazz) {
		Object[] constants = clazz.getEnumConstants();
		int index = random.nextInt(constants.length);

		return constants[index];
	}
}
