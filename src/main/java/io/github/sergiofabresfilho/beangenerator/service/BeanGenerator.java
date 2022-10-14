package io.github.sergiofabresfilho.beangenerator.service;

import com.google.common.collect.ImmutableList;
import io.github.sergiofabresfilho.beangenerator.annotation.Exclude;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public final class BeanGenerator {

	public static <T> T create(Class<T> clazz) {
		Set<Class<?>> generatedComplexTypes = new HashSet<>();
		return create(clazz, generatedComplexTypes);
	}

	static <T> T create(Class<T> clazz, Set<Class<?>> generatedComplexTypes) {
		if (!generatedComplexTypes.add(clazz)) {
			return null;
		}

		try {
			Constructor<T> constructor = clazz.getConstructor();
			T object = constructor.newInstance();

			ImmutableList<Field> fields = ImmutableList.copyOf(clazz.getDeclaredFields());

			for (Field field : fields) {
				populateField(field, object, generatedComplexTypes);
			}

			return object;
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return null;
	}

	private static void populateField(@NotNull Field field, @NotNull Object instance, Set<Class<?>> generatedComplexTypes)
			throws Exception {
		if (field.isAnnotationPresent(Exclude.class)) {
			return;
		}

		field.setAccessible(true);
		Object value = ValueGenerator.generate(field, generatedComplexTypes);

		field.set(instance, value);
	}
}
