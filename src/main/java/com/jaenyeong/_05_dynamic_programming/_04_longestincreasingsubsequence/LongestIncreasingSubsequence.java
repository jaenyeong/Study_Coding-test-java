package com.jaenyeong._05_dynamic_programming._04_longestincreasingsubsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /*
    [Question]
    We have already discussed Overlapping Subproblems and Optimal Substructure properties.
    Now, let us discuss the Longest Increasing Subsequence (LIS) problem as an example problem
    that can be solved using Dynamic Programming.
    The Longest Increasing Subsequence (LIS) problem is to find
    the length of the longest subsequence of a given sequence
    such that all elements of the subsequence are sorted in increasing order.
    For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6
    and LIS is {10, 22, 33, 50, 60, 80}.

    [Input]
    > [3, 10, 2, 1, 20]
    [Output]
    > 3

    [Input]
    > [50, 3, 10, 7, 40, 80]
    [Output]
    > 4

    [Input]
    > [1, 2, 3, 2, 5, 2, 6, 10, 4, 12]
    [Output]
    > 7

     */

    static final int INIT_VALUE = 1;

    public static void main(String[] args) {
//        int[] numbers = {1, 2, 3, 2, 5, 2, 6, 10, 4, 12}; // 7
        int[] numbers = {50, 3, 10, 7, 40, 80};           // 4

        System.out.println(solve(numbers));
    }

    static int solve(final int[] numbers) {
        if ((numbers == null) || (numbers.length <= 0)) {
            return 0;
        }

        // 초기화
        int[] lis = new int[numbers.length];
        Arrays.fill(lis, INIT_VALUE);
        int result = INIT_VALUE;

        final int numbersLength = numbers.length;
        // 주어진 숫자열 2번째부터 끝까지 반복
        for (int curr = 1; curr < numbersLength; curr++) {

            // 반복하면서 그 전 값들과 비교
            for (int prev = 0; prev < curr; prev++) {
                // 현재 값이 큰 경우만 처리 (작으면 통과)
                if (numbers[curr] <= numbers[prev]) {
                    continue;
                }

                // 이전 값들과 비교 연산
                lis[curr] = Math.max(lis[prev] + 1, lis[curr]);
            }
            result = Math.max(result, lis[curr]);
        }

        return result;
    }
}
