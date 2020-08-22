package com.jaenyeong._01_string_array._15_findallanagrams;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    /*
    [Question]
    Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
    Strings consists of lowercase English letters only
    and the length of both strings s and p will not be larger than 20,100.
    The order of output does not matter.

    [Input]
    s > "cbaebabacd"
    p > "abc"

    [Output]
    > [0, 6]

    [Explanation]
    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".

     */

    public static void main(String[] args) {
//        String text = "cbaebabacd";
//        String pattern = "abc";

        String text = "BACDGABCDA";
        String pattern = "ABCD";

        System.out.println(solve(text, pattern));
    }

    static List<Integer> solve(final String text, final String pattern) {
        // 결과로 나온 인덱스들을 담을 객체 선언
        List<Integer> result = new ArrayList<>();

        if (text == null || text.length() <= 0
            || pattern == null || pattern.length() <= 0
            || text.length() < pattern.length()) {
            return result;
        }

        int[] patternArray = new int[256];

        final int textLength = text.length();
        final int patternLength = pattern.length();

        // 비교할 패턴(아스키코드) 배열 초기화
        for (int i = 0; i < patternLength; i++) {
            // [0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0] 형태와 같이 변경
            patternArray[pattern.charAt(i)]++;
        }

        // 주어진 text 문자열 비교시
        // pattern 문자열의 문자수 보다 text 문자열의 문자 수가 많이 남았을 때까지만 비교
        final int loopLimit = textLength - patternLength + 1;
        for (int i = 0; i < loopLimit; i++) {
            int[] textArray = new int[256];

            // text 문자열에서 pattern 문자열의 문자 수 만큼 비교할 textArray 배열 생성
            for (int j = 0; j < patternLength; j++) {
                textArray[text.charAt(i + j)]++;
            }

            // 위에서 생성한 textArray, patternArray 비교
            if (check(textArray, patternArray)) {
                // 조건을 만족했을 때 시작 인덱스 삽입
                result.add(i);
            }
        }

        return result;
    }

    private static boolean check(final int[] textArray, final int[] patternArray) {
        final int patternArrayLength = patternArray.length;

        for (int i = 0; i < patternArrayLength; i++) {
            if (patternArray[i] != textArray[i]) {
                return false;
            }
        }

        return true;
    }
}
