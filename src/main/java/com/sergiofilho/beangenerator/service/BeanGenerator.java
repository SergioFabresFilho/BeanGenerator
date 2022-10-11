package com.sergiofilho.beangenerator.service;

import com.google.common.collect.ImmutableList;
import com.sergiofilho.beangenerator.annotation.Exclude;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Random;

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
		Object value = ValueGenerator.generate(field);

		field.set(instance, value);
	}
}
