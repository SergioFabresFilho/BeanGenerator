package com.sergiofilho.beangenerator.service;

import com.sergiofilho.beangenerator.service.typegenerator.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ValueGenerator {

	private ValueGenerator() {
	}

	public static Object generate(Field field, Set<Class<?>> generatedComplexTypes) throws Exception {
		Class<?> clazz = field.getType();
		Object value;

		if (clazz.isAssignableFrom(List.class)) {
			value = ListGenerator.generate(field);
		} else if (clazz.isAssignableFrom(Set.class)) {
			value = SetGenerator.generate(field);
		} else if (clazz.isAssignableFrom(Map.class)) {
			value = MapGenerator.generate(field);
		} else if (clazz.equals(field.getDeclaringClass())) {
			value = null;
		} else {
			value = generate(clazz, generatedComplexTypes);
		}

		return value;
	}

	public static Object generate(Class<?> clazz, Set<Class<?>> generatedComplexTypes) throws Exception {
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
			try {
				value = BeanGenerator.create(clazz, generatedComplexTypes);
			} catch (Exception exception) {
				throw new Exception("Unsupported field type: " + clazz);
			}
		}

		return value;
	}
}
