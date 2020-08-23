package com.jaenyeong._01_string_array._18_trappingrainwater;

public class TrappingRainWater {
    /*
    [Question]
    Given n non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it is able to trap after raining.
    The above elevation map is represented by array [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1].
    In this case, 6 unit of rain water (blue section) are being trapped.
    Thanks Marcos for contributing this image!

    [Input]
    > [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    [Output]
    > 6

     */

    public static void main(String[] args) {
        int[] numbers = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // 12개

        System.out.println(solve(numbers));
    }

    static int solve(int[] heightArray) {
        if (heightArray == null || heightArray.length <= 2) {
            return 0;
        }

        int[] leftArray = leftArray(heightArray);
        int[] rightArray = rightArray(heightArray);

        return sumWaterHeight(heightArray, leftArray, rightArray);
    }

    private static int[] leftArray(final int[] heightArray) {
        int[] array = new int[heightArray.length];
        int max = array[0] = heightArray[0];

        final int limit = heightArray.length;
        for (int i = 1; i < limit; i++) {
            if (max < heightArray[i - 1]) {
                max = array[i] = heightArray[i - 1];
            } else {
                array[i] = max;
            }
        }

        return array;
    }

    private static int[] rightArray(final int[] heightArray) {
        int[] array = new int[heightArray.length];
        int max = array[array.length - 2] = heightArray[heightArray.length - 1];

        final int limit = array.length - 2;
        for (int i = limit; i >= 0; i--) {
            if (max < heightArray[i + 1]) {
                max = array[i] = heightArray[i + 1];
            } else {
                array[i] = max;
            }
        }

        return array;
    }

    private static int sumWaterHeight(final int[] heightArray, final int[] leftArray, final int[] rightArray) {
        int result = 0;

        // height : {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
        // left   : {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}
        // right  : {3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 0}

        for (int i = 0; i < heightArray.length; i++) {
            final int water = Math.min(leftArray[i], rightArray[i]) - heightArray[i];
            if (water > 0) {
                result += water;
            }
        }
        return result;
    }
}
