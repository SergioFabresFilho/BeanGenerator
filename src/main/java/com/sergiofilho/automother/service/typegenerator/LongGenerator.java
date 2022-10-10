package com.sergiofilho.automother.service.typegenerator;

import java.util.Random;

public final class LongGenerator {

	private static final Random ranom = new Random();

	private LongGenerator() {
	}

	public static Long generate() {
		return ranom.nextLong();
	}
}
