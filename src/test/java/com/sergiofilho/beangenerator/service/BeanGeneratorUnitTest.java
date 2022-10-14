package com.sergiofilho.beangenerator.service;

import com.sergiofilho.beangenerator.model.ExampleBean;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BeanGeneratorUnitTest {

	@Test
	void testAllFields() {
		ExampleBean exampleBean = BeanGenerator.create(ExampleBean.class);

		// Assert that simple fields are populated correctly1
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
		assertThat(exampleBean.getMyList().size()).isEqualTo(50);
		assertThat(exampleBean.getMyLong()).isNotNull();
		assertThat(exampleBean.getMyShort()).isNotNull();
		assertThat(exampleBean.getMyString()).isNotNull();
		assertThat(exampleBean.getMySet()).isNotNull();
		assertThat(exampleBean.getMySet().size()).isEqualTo(10);
		assertThat(exampleBean.getMyMap()).isNotNull();
		assertThat(exampleBean.getComplexExampleBean()).isNotNull();

		// Assert that complex objects are populated correctly
		assertThat(exampleBean.getComplexExampleBean().getMyInt()).isNotNull();
		assertThat(exampleBean.getComplexExampleBean().getMyString()).isNotNull();
		assertThat(exampleBean.getComplexExampleBean().getMyIntArray()).isNotNull();

		// Assert that recursive relations do not incur an infinite loop
		assertThat(exampleBean.getComplexExampleBean().getComplexExampleBean()).isNull();
		assertThat(exampleBean.getComplexExampleBean().getRecursiveRelationship()).isNull();
	}
}
