package com.TutortAssignment.TutortAssignmentCodes.BinarySearch;

class MedianSortedArrays {
    public static double findMedianSortedArrays(int[] arr, int[] brr) {
        // 135
        // 279
        // 1 2 3 5 7 9
        // 1 3 5
        // 2 4
        // 1 2 3 4 5
        // Brute Force: Use 2 pointers, and merger the arrays in sorted order. T.C. O(m + n)
        // Then find median.
        int arrLen = arr.length;
        int brrLen = brr.length;
        int begin1 = 0;
        int end1 = arrLen;

        while (begin1 <= end1) {
            int leftPtr = (begin1 + end1) / 2;
            int rightPtr = (arrLen + brrLen + 1) / 2 - leftPtr;

            int min1 = (leftPtr == arrLen) ? Integer.MAX_VALUE : arr[leftPtr];
            int max1 = (leftPtr == 0) ? Integer.MIN_VALUE : arr[leftPtr - 1];

            int min2 = (rightPtr == brrLen) ? Integer.MAX_VALUE : brr[rightPtr];
            int max2 = (rightPtr == 0) ? Integer.MIN_VALUE : brr[rightPtr - 1];

            if ((max1 <= min2) && (max2 <= min1)) {
                if ((arrLen + brrLen) % 2 == 0) {
                    return ((double) (Math.max(max1, max2) + Math.min(min1, min2)) / 2);
                } else {
                    return ((double) Math.max(max1, max2));
                }
            } else if (max1 > min2) {
                end1 = leftPtr - 1;
            } else {
                begin1 = leftPtr + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3};
        int[] brr = {2};

        double result = findMedianSortedArrays(arr, brr);
        System.out.println("Median: " + result);
    }
}