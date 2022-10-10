package com.sergiofilho.automother.service.typegenerator;

import java.util.Random;

public final class DoubleGenerator {

	private static final Random random = new Random();

	private DoubleGenerator() {
	}

	public static Double generate() {
		return random.nextDouble();
	}
}
