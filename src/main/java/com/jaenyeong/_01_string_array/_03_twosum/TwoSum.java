package com.jaenyeong._01_string_array._03_twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
    [Question]
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution,
    and you may not use the same element twice.

    [Input]
    nums > [2, 7, 11, 15]
    target > 9

    [Output]
    > [0, 1]

     */

    public static void main(String[] args) {
        int[] numbers = {2, 11, 8, 21};
        int target = 10;

        System.out.println(Arrays.toString(solve(numbers, target)));
    }

    static int[] solve(final int[] numbers, final int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int matchingValue = map.get(numbers[i]);
                result[0] = matchingValue + 1;
                result[1] = i + 1;
            } else {
                map.put(target - numbers[i], i);
            }
        }

        return result;
    }
}
