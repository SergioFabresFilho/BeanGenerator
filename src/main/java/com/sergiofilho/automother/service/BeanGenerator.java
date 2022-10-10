package com.sergiofilho.automother.service;

import com.google.common.collect.ImmutableList;
import com.sergiofilho.automother.annotation.Exclude;
import com.sergiofilho.automother.service.typegenerator.*;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

public final class BeanGenerator {

	private static final Random random = new Random();

	public static <T> T create(Class<T> clazz) {

		try {
			Constructor<T> constructor = clazz.getConstructor();
			T object = constructor.newInstance();

			ImmutableList<Field> fields = ImmutableList.copyOf(clazz.getDeclaredFields());

			for (Field field : fields) {
				populateField(field, object);
			}

			return object;
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return null;
	}

	private static void populateField(@NotNull Field field, @NotNull Object instance) throws Exception {
		if (field.isAnnotationPresent(Exclude.class)) {
			return;
		}

		field.setAccessible(true);
		Class<?> clazz = field.getType();
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
		} else {
			throw new Exception("Unsupported field type: " + clazz);
		}

		field.set(instance, value);
	}
}
