package com.sergiofilho.beangenerator.service;

import com.sergiofilho.beangenerator.service.typegenerator.*;

import java.lang.reflect.Field;
import java.util.List;

public final class ValueGenerator {

	private ValueGenerator() {
	}

	public static Object generate(Field field) throws Exception {
		Object value;
		Class<?> clazz = field.getType();

		if (clazz.isAssignableFrom(List.class)) {
			value = ListGenerator.generateOfType(field);
		} else {
			value = generate(clazz);
		}

		return value;
	}

	public static Object generate(Class<?> clazz) throws Exception {
		Object value;

		if (clazz.equals(Integer.TYPE) || clazz.equals(Integer.class)) {
			value = IntegerGenerator.generate();
		} else if (clazz.equals(Long.TYPE) || clazz.equals(Long.class)) {
			value = LongGenerator.generate();
		} else if (clazz.equals(Double.TYPE) || clazz.equals(Double.class)) {
			value = DoubleGenerator.generate();
		} else if (clazz.equals(Character.TYPE) || clazz.equals(Character.class)) {
			value = CharacterGenerator.generate();
		} else if (clazz.equals(Boolean.TYPE) || clazz.equals(Boolean.class)) {
			value = BooleanGenerator.generate();
		} else if (clazz.equals(Short.TYPE) || clazz.equals(Short.class)) {
			value = ShortGenerator.generate();
		} else if (clazz.equals(Byte.TYPE) || clazz.equals(Byte.class)) {
			value = ByteGenerator.generate();
		} else if (clazz.equals(Float.TYPE) || clazz.equals(Float.class)) {
			value = FloatGenerator.generate();
		} else if (clazz.equals(String.class)) {
			value = StringGenerator.generate();
		} else if (clazz.isEnum()) {
			value = EnumGenerator.generate(clazz);
		} else if (clazz.isArray()) {
			value = ArrayGenerator.generateOfType(clazz.getComponentType());
		}  else {
			throw new Exception("Unsupported field type: " + clazz);
		}

		return value;
	}
}
