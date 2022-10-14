package io.github.sergiofabresfilho.beangenerator.model;

public class ComplexExampleBean {
	private String myString;
	private int myInt;
	private int[] myIntArray;
	private ComplexExampleBean complexExampleBean;
	private ExampleBean recursiveRelationship;

	public String getMyString() {
		return myString;
	}

	public int getMyInt() {
		return myInt;
	}

	public int[] getMyIntArray() {
		return myIntArray;
	}

	public ComplexExampleBean getComplexExampleBean() {
		return complexExampleBean;
	}

	public ExampleBean getRecursiveRelationship() {
		return recursiveRelationship;
	}
}
