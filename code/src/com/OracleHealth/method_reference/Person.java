package com.OracleHealth.method_reference;

// Class 1
// Helper class
// Object need to be sorted
class Person {

    // Attributes of a person
    private String name;
    private Integer age;

    // Constructor
    public Person(String name, int age) {
        // This keyword refers to current object itself
        this.name = name;
        this.age = age;
    }

    // Getter-setter methods
    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
