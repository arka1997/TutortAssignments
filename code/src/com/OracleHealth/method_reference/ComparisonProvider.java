package com.OracleHealth.method_reference;// Java Program to Illustrate How One can use
// Static method reference
// To Sort with Custom Comparator
// But using object method reference

// Importing required classes

// Class 2
// Helper class
// Comparator class
class ComparisonProvider {

	public Object fruitList;

	// Method 1
	// To compare with name
	public int compareByName(Person a, Person b)
	{
		return a.getName().compareTo(b.getName());
	}

	// Method 2
	// To compare with age
	public int compareByAge(Person a, Person b)
	{
		return a.getAge().compareTo(b.getAge());
	}
}

