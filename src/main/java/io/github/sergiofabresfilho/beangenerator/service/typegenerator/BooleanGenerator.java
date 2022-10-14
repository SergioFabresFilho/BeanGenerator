package io.github.sergiofabresfilho.beangenerator.service.typegenerator;

import java.util.Random;

public final class BooleanGenerator {

	private final static Random random = new Random();

	private BooleanGenerator() {
	}

	public static Boolean generate() {
		return random.nextInt() % 2 == 0;
	}
}
