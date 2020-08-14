package com.jaenyeong._01_string_array._02_movezero;

import java.util.Arrays;

public class MoveZero {
    /*
    [Question]
    Given an array nums, write a function to move all 0's to the end of
    it while maintaining the relative order of the non-zero elements.

    [Input]
    > [0, 1, 0, 3, 12]

    [Output]
    > [1, 3, 12, 0, 0]

    [Note]
    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.

     */

    public static void main(String[] args) {
        // 문제 값 입력
        int[] numbers = {0, 3, 2, 0, 8, 5};

        System.out.println("Result : " + Arrays.toString(solve(numbers)));
    }

    static int[] solve(final int[] numbers) {
        // 0이 아닌 값을 배열 내 위치 이동
        int idx = 0;
        for (int num : numbers) {
            if (num != 0) {
                numbers[idx] = num;
                idx++;
            }
        }

        // 배열 빈 공간에 0 채워넣기
        while (idx < numbers.length) {
            numbers[idx] = 0;
            idx++;
        }

        return numbers;
    }
}
