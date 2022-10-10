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
		Object value = ValueGenerator.generate(clazz);

		field.set(instance, value);
	}
}
