package com.OracleHealth.method_reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MethodReference {
    public static boolean filter(String s){
        return s.equals("Apple");
    }
    public int sortText(String s){
        return s.compareTo("kaushal");
    }
    public static void main(String[] args) {

        MethodReference m = new MethodReference();

        List<String> fruitList = new ArrayList<>();
        fruitList.add("Apple");
        fruitList.add("Guava");
        fruitList.add("Mango");
        System.out.println(fruitList);

        Collections.sort(fruitList, String::compareToIgnoreCase);
//        fruitList.removeIf(s -> MethodReference.filter("Apple"));
//        fruitList.removeIf(MethodReference::filter);


        fruitList.stream()
                .filter(MethodReference::filter)// using method reference
                .filter( e -> MethodReference.filter(e)) // using lamda expression
                .map(e -> e.toLowerCase(Locale.ROOT))
                .forEach(e -> System.out.println(e));

        fruitList.stream()
                .map(m::sortText)//<Object>::<InstanceMethod
                .collect(Collectors.toList());// Here we cannot call a method using method reference inside "filter()". As there filtering things are done, we don't chnage the type of Object. So in ".map()", we use method reference, to call methods.


        List<Person> personList = new ArrayList<>();

        // Adding elements to above object
        // using add() method
        personList.add(new Person("vicky", 24));
        personList.add(new Person("poonam", 25));
        personList.add(new Person("sachin", 19));

        Predicate<Person> per = p -> p instanceof Person;
        personList.removeIf(per.negate().or(per));//whatever will be return from per, it will be made the opposite
//        personList.removeIf(Predicate.isEqual(new Person("vicky", 24)));

        personList.removeIf(person -> !person.getName().equals("vicky") || person.getAge() != 24);

        personList.forEach(Person::getName);
        personList.forEach(Person::getAge);
        personList.forEach(e -> System.out.println(e.getName()));


    }
}
