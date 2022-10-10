package com.sergiofilho.automother.service.typegenerator;

import java.util.Random;

public final class ShortGenerator {

	private static final Random random = new Random();

	private ShortGenerator() {
	}

	public static Short generate() {
		return (short) random.nextInt(Short.MAX_VALUE);
	}
}
