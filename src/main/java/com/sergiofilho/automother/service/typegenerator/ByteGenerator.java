package com.sergiofilho.automother.service.typegenerator;

import java.util.Random;

public final class ByteGenerator {

	private static final Random random = new Random();

	private ByteGenerator() {}

	public static Byte generate() {
		byte[] bytes = new byte[1];
		random.nextBytes(bytes);

		return bytes[0];
	}
}
