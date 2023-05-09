package com.TutortAssignment.TutortAssignmentCodes.PriorityQueue;

import java.util.PriorityQueue;
import java.util.regex.Pattern;

public class KthLargestInStream {

        int k;
        PriorityQueue<Integer> pq;
        private static final String DOT_REGEX = "\\.";
        private static final String NUMBER_FINDER_REGEX = ".*\\d.*";
        private static final Pattern NUMBER_FINDER_REGEX2 = Pattern.compile(".*\\d.*");
        private static final Pattern NUMBER_PICKER_REGEX = Pattern.compile("[0-9]");

    private static final String NUMBER_PICKER_REGEX2 = "[^0-9]";
        public static void main(String[] args) {
            String s = "djk54.1s-52.3dd-e45f.5fd-34.5";
            String version = s.trim();
            String[] elements = version.replace('-', '.').split(DOT_REGEX);
            System.out.println(elements[3]);
            //check if a string has any decimal digit or not using NumberFinderRegex -> Then remove the charcaters from only leaving the digits behind using NumberPicker
            if (elements.length > 3 && NUMBER_FINDER_REGEX2.matcher("fgh45").matches()) {
                Integer number = Integer.valueOf("edgdf45".replaceAll(NUMBER_PICKER_REGEX2, ""));
                System.out.println(number);
            }
//        KthLargestInStream(3,nums);
        }
        public KthLargestInStream(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for(int ele : nums){

                pq.add(ele);

                if(pq.size() > k) {
                    pq.poll();
                }
            }

        }

        public int add(int val) {
            pq.add(val);

            if(pq.size() > k) {
                pq.poll();
            }


            return pq.peek();


        }
    }
