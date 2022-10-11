package com.sergiofilho.beangenerator.service;

import com.sergiofilho.beangenerator.model.ExampleBean;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BeanGeneratorUnitTest {

	@Test
	void testAllFields() {
		ExampleBean exampleBean = BeanGenerator.create(ExampleBean.class);

		assertThat(exampleBean).isNotNull();

		assertThat(exampleBean.getMyArray()).isNotNull();
		assertThat(exampleBean.getMyBoolean()).isNotNull();
		assertThat(exampleBean.getMyByte()).isNotNull();
		assertThat(exampleBean.getMyCharacter()).isNotNull();
		assertThat(exampleBean.getMyDouble()).isNotNull();
		assertThat(exampleBean.getMyEnum()).isNotNull();
		assertThat(exampleBean.getMyFloat()).isNotNull();
		assertThat(exampleBean.getMyInteger()).isNotNull();
		assertThat(exampleBean.getMyList()).isNotNull();
		assertThat(exampleBean.getMyLong()).isNotNull();
		assertThat(exampleBean.getMyShort()).isNotNull();
		assertThat(exampleBean.getMyString()).isNotNull();
		assertThat(exampleBean.getMySet()).isNotNull();
		assertThat(exampleBean.getMyMap()).isNotNull();
	}
}