package com.TutortAssignment.TutortAssignmentCodes;

import java.util.Arrays;

public class WorkScheduling {

    public static int[] performWork(int A, int[][] B) {
        int[] schedule = new int[A + 1];

        for (int[] work : B) {
            int startDay = work[0];
            int deadlineDay = work[1];
            int daysToComplete = work[2];

            if (schedule[deadlineDay] == 0) {
                // Set the deadline day to the index of the work type (1-based).
                schedule[deadlineDay] = Arrays.asList(B).indexOf(work) + 1;
            }

            for (int day = deadlineDay - 1; day >= startDay; day--) {
                if (schedule[day] == 0) {
                    // If the day is not already assigned to a work, set it as rest day (0).
                    schedule[day] = -1;
                }
            }

            for (int day = deadlineDay - 1; day >= deadlineDay - daysToComplete; day--) {
                if (schedule[day] == 0) {
                    // Assign days required to complete the work.
                    schedule[day] = Arrays.asList(B).indexOf(work) + 1;
                }
            }
        }

        // Check if all works are completed before their deadlines.
        for (int[] work : B) {
            int deadlineDay = work[1];
            if (schedule[deadlineDay] != Arrays.asList(B).indexOf(work) + 1) {
                // If any work is not completed by the deadline, return [-1].
                return new int[]{-1};
            }
        }

        // Add the deadline day markers to the result array.
        int[] result = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            result[i] = schedule[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int A = 3;
        int[][] B = {{1, 2, 2}};

        int[] output = performWork(A, B);

        System.out.println(Arrays.toString(output)); // Output: [-1, 2, 1]
    }
}