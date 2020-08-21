package com.jaenyeong._01_string_array._13_maxsubarray;

public class MaxSubArray {
    /*
    [Question]
    Given an integer array nums, find the contiguous subarray (containing at least one number)
    which has the largest sum and return its sum.

    [Input]
    > [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    [Output]
    > 6

    [Explanation]
    [4, -1, 2, 1] has the largest sum = 6

     */

    public static void main(String[] args) {
        int[] numbers = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

//        System.out.println(solve(numbers));
        System.out.println(solveDP(numbers));
    }

    static int solve(final int[] numbers) {
        int newSum = numbers[0];
        int max = newSum;

        final int length = numbers.length;
        for (int i = 1; i < length; i++) {
            newSum = Math.max(numbers[i], newSum + numbers[i]);
            max = Math.max(max, newSum);
        }

        return max;
    }

    static int solveDP(final int[] numbers) {
        final int length = numbers.length;
        int[] dp = new int[length];

        dp[0] = numbers[0];
        int max = dp[0];

        for (int i = 1; i < length; i++) {
            dp[i] = numbers[i] + (Math.max(dp[i - 1], 0));
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
