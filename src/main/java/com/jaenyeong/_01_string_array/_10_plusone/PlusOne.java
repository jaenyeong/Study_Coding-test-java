package com.jaenyeong._01_string_array._10_plusone;

import java.util.Arrays;

public class PlusOne {
    /*
    [Question]
    Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
    The digits are stored such that the most significant digit is at the head of the list,
    and each element in the array contain a single digit.
    You may assume the integer does not contain any leading zero, except the number 0 itself.

    [Input]
    > [1, 2, 3]
    [Output]
    > [1, 2, 4]

    [Input]
    > [9, 9, 9]
    [Output]
    > [1, 0, 0, 0]

     */

    public static void main(String[] args) {
//        int[] digits = {1, 2, 3};
        int[] digits = {9, 9, 9};

        System.out.println(Arrays.toString(plusOne(digits)));
    }

    static int[] plusOne(final int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }

        if (digits[0] == 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        return digits;
    }
}
