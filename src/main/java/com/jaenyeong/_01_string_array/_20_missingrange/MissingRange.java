package com.jaenyeong._01_string_array._20_missingrange;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {
    /*
    [Question]
    Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper],
    return its missing ranges.

    [Input]
    nums > [0, 1, 3, 50, 75]
    lower > 0
    upper > 99
    [Output]
    > ["2", "4->49", "51-74", "76-99"]

    [Input]
    nums > [2, 3, 5, 50, 75]
    lower > 0
    upper > 99
    [Output]
    > ["0->1", "4", "6->49", "51->74", "76->99"]

     */

    public static void main(String[] args) {
        int[] numbers = {2, 3, 5, 50, 75};
        int lower = 0;
        int upper = 99;
        System.out.println(solve(numbers, lower, upper));
    }

    static List<String> solve(final int[] numbers, final int lower, final int upper) {
        List<String> result = new ArrayList<>();

        if (numbers == null || numbers.length <= 0) {
            return result;
        }

        if (lower >= upper || upper <= 0) {
            return result;
        }

        // 0 ~ 1
        if (lower < numbers[0]) {
            result.add(makeRange(lower, numbers[0] - 1));
        }

        // 4, 6 ~ 49, 51 ~ 74
        final int limit = numbers.length - 1;
        for (int i = 0; i < limit; i++) {
            if ((numbers[i] != numbers[i + 1])
                    && (numbers[i] + 1 < numbers[i + 1])
                    && (numbers[i] >= lower)
                    && (numbers[i] <= upper)) {

                result.add(makeRange(numbers[i] + 1,
                        numbers[i + 1] > upper
                                ? upper
                                : numbers[i + 1] - 1));
            }
        }

        // 76 ~ 99
        if (numbers[numbers.length - 1] < upper) {
            result.add(makeRange(numbers[numbers.length - 1] + 1, upper));
        }

        return result;
    }

    private static String makeRange(final int startRange, final int endRange) {
        return startRange == endRange
                ? String.valueOf(startRange)
                : (startRange + " -> " + endRange);
    }
}
