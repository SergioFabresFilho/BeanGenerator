package io.github.sergiofabresfilho.beangenerator.service.typegenerator;

import java.util.Random;

public final class CharacterGenerator {

	private static final Random random = new Random();

	private CharacterGenerator() {
	}

	public static Character generate() {
		return (char) random.nextInt(256);
	}
}
