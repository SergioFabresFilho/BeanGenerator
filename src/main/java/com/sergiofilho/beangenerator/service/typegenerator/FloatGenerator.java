package com.sergiofilho.beangenerator.service.typegenerator;

import java.util.Random;

public final class FloatGenerator {

	private static final Random random = new Random();

	private FloatGenerator() {
	}

	public static Float generate() {
		return random.nextFloat();
	}
}
