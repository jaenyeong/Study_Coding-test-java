package com.jaenyeong._01_string_array._12_longestsubmosttwodist;

import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoDist {
    /*
    [Question]
    Given a string s, find the length of the longest substring t that contains at most 2 distinct characters.

    [Input]
    > "eceba"
    [Output]
    > 3

    [Input]
    > "ccaabbb"
    [Output]
    > 5

     */

    public static void main(String[] args) {
//        String string = "eceba";
        String string = "ccaabbb";

        System.out.println(solve(string));
    }

    static int solve(final String string) {
        // 변수 초기화
        int start = 0, end = 0, length = 0, counter = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (end < string.length()) {
            // 문자별 길이 값 삽입
            final char endChar = string.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);

            // 카운터 플래그를 사용하여 문자 구분
            if (map.get(endChar) == 1) {
                counter++;
            }
            end++;

            // 구분된 문자가 3개 이상일 때 첫번째 문자의 길이 값부터 차감
            while (counter > 2) {
                final char startChar = string.charAt(start);
                map.put(startChar, map.get(startChar) - 1);

                // 해당 문자의 길이를 다 차감한 경우
                // 문자 구분시 사용하는 카운터 플래그 값 차감
                if (map.get(startChar) == 0) {
                    counter--;
                }
                start++;
            }

            // 길이 값 갱신
            length = Math.max(length, end - start);
        }

        return length;
    }
}
