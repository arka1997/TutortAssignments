package com.OracleHealth.method_reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Class 3
// Main class
public class MethodRefernceTest {


    private static <T> int compareByAge(T t, T t1) {
         t.equals(t1);
         return 0;
    }

    // Main driver method
    public static void main(String[] args) {
        // Creating an empty ArrayList of user-defined type
        // List of person
        List<Person> personList = new ArrayList<>();

        // Adding elements to above object
        // using add() method
        personList.add(new Person("vicky", 24));
        personList.add(new Person("poonam", 25));
        personList.add(new Person("sachin", 19));

        // A comparator class with multiple
        // comparator methods
        ComparisonProvider comparator
                = new ComparisonProvider();

        /** Now using instance method reference
            * to sort array by name
            * <object>::<instanceMethod>
        */
        Collections.sort(personList,
                comparator::compareByName);
        Collections.sort(personList,
                MethodRefernceTest::compareByAge);// by Method reference
        Collections.sort(personList,
                (t, t1) -> compareByAge(t, t1)); // by Lamda

        List<String> mobileName = new ArrayList<>();
        mobileName.add("Samsung");
        mobileName.add("Lenovo");
        Collections.sort(mobileName,
                String::compareToIgnoreCase);
        // Display message only
        System.out.println("Sort by name :");

        // Using streams
        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);

        // Using instance method reference
        // to sort array by age
        Collections.sort(personList,
                comparator::compareByAge);

        // Display message only
        System.out.println("Sort by age :");

        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);
    }

}
