package io.github.sergiofabresfilho.beangenerator.service.typegenerator;

import java.util.Random;

public final class StringGenerator {

	private static final Random random = new Random();

	private StringGenerator() {
	}

	public static String generate() {
		return String.valueOf(random.nextInt());
	}
}
