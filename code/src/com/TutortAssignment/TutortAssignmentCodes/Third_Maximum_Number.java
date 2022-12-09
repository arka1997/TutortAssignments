package com.TutortAssignment.TutortAssignmentCodes;

class Third_Maximum_Number {
    public static void main(String[] args) {
        int[] num = {3,2};
        System.out.println(thirdMax(num));

    }
    public static int thirdMax(int[] num) {
        // Here it works like a greedy algo. The 1st elder pointer grabs the 1st elemnt in the array. Now, for the rest of the Array elemnts, 1st elder pointer has 2  options -> a) If the next number is bigger then current number, then he becomes greedy, and now stores the new Bigger number, and gives the previous number to the 2nd elder pointer b)If the number next array elemnt is samll then current number, then it will pass it to the next 2ndMax pointer.
        //     And this greedy algo continues.
        long max = Long.MIN_VALUE;
        long scndMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        // Here it works like a greedy algo. The 1st elder pointer grabs the 1st elemnt in the array. Now, for the rest of the Array elemnts, 1st elder pointer has 2  options -> a) If the next number is bigger then current number, then he becomes greedy, and now stores the new Bigger number, and gives the previous number to the 2nd elder pointer b)If the number next array elemnt is samll then current number, then it will pass it to the next 2ndMax pointer.
        // And this greedy algo continues. Now we need to ignore the duplicates also. So for that whenever our 3 pointers traverse the array then it will contai some elements. Now suppsoe while traversing any of the max pointers get any duplicates, then we will skip that part of the loop.
        for(int nums : num){
            if(max==nums||scndMax==nums||thirdMax==nums){
                continue;
            }
            if(nums>max){
                thirdMax = scndMax;
                scndMax = max;
                max = nums;
            }else if(nums>scndMax){
                thirdMax = scndMax;
                scndMax = nums;
            }else if(nums>thirdMax){
                thirdMax  = nums;
            }
        }
        if(thirdMax==Long.MIN_VALUE){
            return (int)max;
        }
        return (int)thirdMax;// 2 4 6 7 8 2
    }
}