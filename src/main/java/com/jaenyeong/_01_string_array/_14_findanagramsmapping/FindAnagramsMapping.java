package com.jaenyeong._01_string_array._14_findanagramsmapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAnagramsMapping {
    /*
    [Question]
    Given two lists A and B, and B is an anagram of A.
    B is an anagram of A means B is made by randomizing the order of the elements in A.
    We want to find an index mapping P, from A to B.
    A mapping P[i] = j means the ith element in A appears in B at index j.
    These lists A and B may contain duplicates. If there are multiple answers, output any of them.

    [Input]
    A > [12, 28, 46, 32, 50]
    B > [50, 12, 32, 46, 28]

    [Output]
    > [1, 4, 3, 2, 0]

    [Explanation]
    as P[0] = 1
    because the 0th element of A appears at B[1].
    p[1] = 4
    because the 1st element of A appears at B[4], and so on.

    [Note]
    A, B have equal lengths in range [1, 100].
    A[i], B[i] are integers in range [0, 10^5].

     */

    public static void main(String[] args) {
        int[] aArray = {11, 27, 45, 31, 50};
        int[] bArray = {50, 11, 31, 45, 27};

        System.out.println(Arrays.toString(solve(aArray, bArray)));
    }

    static int[] solve(final int[] aArray, final int[] bArray) {
        int[] result = new int[aArray.length];

        Map<Integer, Integer> map = new HashMap<>();

        final int bLength = bArray.length;
        for (int i = 0; i < bLength; i++) {
            map.put(bArray[i], i);
        }

        final int aLength = aArray.length;
        for (int i = 0; i < aLength; i++) {
            result[i] = map.get(aArray[i]);
        }

        return result;
    }
}
