package com.TutortClassroomPractice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fizzBuzz {
    public static void main(String[] args) {
        List<String> strings = fizzBuzz(10);
        System.out.println(strings);
    }
    public static List<String> fizzBuzz(int n) {
//         create an arrayList which will be String Array, now all the numbers als convert them to String type to store in that arrayList.
//         then start from i = 1 To i=n, and check which numbers are divisible by 3 or 5 or n, and each has different requiremnts.
        List<String> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%3==0&&i%5==0){
                list.add("FizzBuzz");
            }
            else if(i%3==0){
                list.add("Fizz");
            }
            else if(i%5==0){
                list.add("Buzz");
            }else{
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
