package io.github.sergiofabresfilho.beangenerator.model;

import io.github.sergiofabresfilho.beangenerator.annotation.CollectionOf;
import io.github.sergiofabresfilho.beangenerator.annotation.MapOf;
import io.github.sergiofabresfilho.beangenerator.model.enumeration.ExampleEnum;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExampleBean {

	private Integer[] myArray;
	private Boolean myBoolean;
	private Byte myByte;
	private Character myCharacter;
	private Double myDouble;
	private ExampleEnum myEnum;
	private Float myFloat;
	private Integer myInteger;
	@CollectionOf(type = String.class, size = 50)
	private List<String> myList;
	private Long myLong;
	private Short myShort;
	private String myString;
	@CollectionOf(type = Integer.class, size = 10)
	private Set<Integer> mySet;
	@MapOf(keyType = String.class, elementType = Integer.class, size = 100)
	private Map<String, ComplexExampleBean> myMap;
	private ComplexExampleBean complexExampleBean;

	//TODO: make array generator work with primitive types
	public Integer[] getMyArray() {
		return myArray;
	}

	public Boolean getMyBoolean() {
		return myBoolean;
	}

	public Byte getMyByte() {
		return myByte;
	}

	public Character getMyCharacter() {
		return myCharacter;
	}

	public Double getMyDouble() {
		return myDouble;
	}

	public ExampleEnum getMyEnum() {
		return myEnum;
	}

	public Float getMyFloat() {
		return myFloat;
	}

	public Integer getMyInteger() {
		return myInteger;
	}

	public List<String> getMyList() {
		return myList;
	}

	public Long getMyLong() {
		return myLong;
	}

	public Short getMyShort() {
		return myShort;
	}

	public String getMyString() {
		return myString;
	}

	public Set<Integer> getMySet() {
		return mySet;
	}

	public Map<String, ComplexExampleBean> getMyMap() {
		return myMap;
	}

	public ComplexExampleBean getComplexExampleBean() {
		return complexExampleBean;
	}
}
