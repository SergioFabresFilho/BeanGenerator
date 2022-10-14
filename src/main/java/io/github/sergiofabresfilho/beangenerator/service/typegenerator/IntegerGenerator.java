package io.github.sergiofabresfilho.beangenerator.service.typegenerator;

import java.util.Random;

public final class IntegerGenerator {

	private static final Random random = new Random();

	private IntegerGenerator() {
	}

	public static Integer generate() {
		return random.nextInt();
	}
}
