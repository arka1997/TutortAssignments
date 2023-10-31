package com.OracleHealth.stream_apis;

import com.OracleHealth.NestedClass.Samsung;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi1 {

    StreamApi1(){}
    int id;
    String size;
    StreamApi1(int id, String size){
        this.id = id;
        this.size = size;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        Map<Integer,String> m = new HashMap<>();
        l.add(25);
        l.add(35);
        l.add(45);
        m.put(1, "MacBook");
        m.put(2, "Dell");
        m.put(3, "HP");
        m.put(4, "Asus");
//        l.stream().collect(Collectors.toSet()).forEach(e -> System.out.println(e));
//        m.keySet().forEach(e -> System.out.println(e.intValue()));
//        List<Integer> collect = m.keySet().stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
//        System.out.println(collect);

        //Generate random infinite supply of streams of number, so used limit, to reduce it to finite size.
//        Stream.generate(() -> (int)(Math.random()*100)) // Supplier<T>, Intermediate State
//                .limit(30) // Intermediate State
//                .filter( e -> e % 2 == 0)// Predicate<T>,  Intermediate State
//                .peek(StreamApi1::discountProducts)// Consumer<T>,  Intermediate State
//                .map(e -> e.byteValue())//Functions<T, R> / UnaryOperator<T>, Intermediate State
//                .max(Integer::compare); // Terminal or Ending state
                /**     OR      */
//              .forEach(e -> System.out.println(e)); // consumer<T>, Terminal or Ending state


        List<Integer> supplyStream = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 18, 19, 20);
        supplyStream.stream()
                .filter(e -> e > 2)// here range 3 to 20
                .peek(name -> System.out.println("peek :" + name))
                .takeWhile(e -> e <= 4)// here range 3 to 4
                .forEach(e -> System.out.println(e));
//        OR
        supplyStream.stream()
                .map(Object::hashCode);//chnaged from Integer to HashCode

        List<Integer> supplyStream2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 18, 19, 20);
        int sum = supplyStream2
                    .stream()
                    .mapToInt(e -> e.intValue())
                    .sum();// converts to primitive "int", but uses lamda format
        int parallelSum = supplyStream2
                            .parallelStream()
                            .mapToInt(Integer::intValue)
                            .sum();// converts to primitive "int", but uses Method Reference <Class>::<InstanceMethod>
        System.out.println("Sum : "+sum);
        System.out.println("parallelSum : "+parallelSum);

        UnaryOperator<Integer> multiply = e -> e * 2;
        UnaryOperator<Integer> add = e -> e + 5;
        int val = multiply.andThen(add).apply(1);
        System.out.println(val);

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grapefruit");
        UnaryOperator<String> u = e -> e.trim();// Here type is not changed.
        Function<String, Integer> testFunc = e -> e.length(); // here type is changed, and the name "testFunc" can be used inside "map", instead of the lamda function
        words.stream()
                .map(e -> e.length()/** testFunc */)
                .collect(Collectors.toList());// Here type is changed from String to int

        StreamApi1 s1 = new StreamApi1();
        StreamApi1 s = new StreamApi1(7, "200 GB");
        StreamApi1 s2 = new StreamApi1(8, "500 GB");
        StreamApi1 s3 = new StreamApi1(9, "800 GB");
        List<StreamApi1> obj = new ArrayList<>();
        obj.add(s);
        obj.add(s2);
        obj.add(s3);

        List<Samsung> nestedLists = Arrays.asList(
                new Samsung(5,"200 GB"),
                new Samsung(6,"500 GB"),
                new Samsung(7,"800 GB")
        );

//        flatMap is basically used to fetch List of Object, or Set of Object like List<Product> l = {[1,"abc"],[2,"cbd"],[3, "jkl"]},
//        and stream Lined to a single object/pipeline
        nestedLists.stream()
                .flatMap(e -> Stream.of(e.getGb(),e.getUnit()))
                .forEach(e -> System.out.println(e));


        nestedLists.stream()
                .map(Samsung::getUnit)//Here changing the type from Stram<Samsung> -> Stream<Integer>
                .flatMapToInt(IntStream::of)//Converting to Stream of Integers
                .forEach(e -> System.out.println("flatMap :" + e));



        List<StreamTestMethods> list = Arrays.asList(
                new StreamTestMethods(1, "100 kg"),
                new StreamTestMethods(3, "300 kg"),
                new StreamTestMethods(6, "600 kg")
        );

        list.stream()
                .map(ss -> ss.getProductDetails())
                .flatMap(Collection::stream)
                .forEach(e -> System.out.println("FlatMap Object Streamline :" + e));


/**     Syntax of reduce() -> T result = stream.reduce(identity, (accumulator, element) -> binaryOperator);
 *      This basically picks data, and accumulates them or reduce to a single value
 *      Returns single data and works best o aggregate functions
 *      Shows 3 usage of reduce methods
 * */

        int total = Stream.of(1,2,3,4,5).reduce(0,(sumTotal, digits) -> sumTotal + digits);
        System.out.println(total);

        String reduce = list.stream()
                .map(StreamTestMethods::reduceTest)
                .reduce("",((value,sizes) -> value.isEmpty()? sizes : value+","+sizes)).toString();
        System.out.println("reduce : " + reduce);

        /** To be Debug & tested */
        String longestWord = words.stream()
                .reduce((word1, word2) -> {
                    if (word1.length() >= word2.length()) {
                        return word1;
                    } else {
                        return word2;
                    }
                })
                .orElse("No words in the list");
        List<Transaction> transactions = Arrays.asList(
                new Transaction( 1000.0, 3,"Electronics"),
                new Transaction(50.0, 5,"Clothing"),
                new Transaction( 750.0, 2,"Electronics"),
                new Transaction(200.0, 4,"Furniture")
        );


        double totalRevenue = transactions.stream()
                .filter(transaction -> "Electronics".equals(transaction.getProducts()))
                .mapToDouble(transaction -> transaction.getPrice() * transaction.getQuantity())
                .reduce(0.0, (x, y) -> x + y);
        System.out.println("Total revenue for " + "Electronics" + ": " + totalRevenue);


        List<String> strings = Arrays.asList("Hello", "World", "This", "Is", "Parallel", "Reduction");

        String result = strings.parallelStream()
                .reduce(
                        "", // Identity
                        (partialResult, str) -> partialResult + str, // Accumulator
                        (combinedResult1, combinedResult2) -> combinedResult1 + combinedResult2 // Combiner
                );

        System.out.println("Concatenated String: " + result);

    }

    private static int discountProducts(Integer price) {
        price += (price * 20)/100;
        return price;
    }
}
