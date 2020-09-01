package com.jaenyeong._06_back_tracking._04_lettercombinationofaphonenumber;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    /*
    [Question]
    Given a string containing digits from 2-9 inclusive,
    return all possible letter combinations that the number could represent.
    A mapping of digit to letters (just like on the telephone buttons) is given below.
    (1 - ***)  (2 - abc)  (3 - def)
    (4 - ghi)  (5 - jkl)  (6 - mno)
    (7 - pqrs) (8 - tuv)  (9 - wxyz)

    [Input]
    > 23
    [Output]
    > ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

    [Note]
    1 does not map to any letters.

     */

    static final String[] DIGIT_LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String digits = "23";

        System.out.println(solve(digits));
    }

    static List<String> solve(final String digits) {
        List<String> result = new ArrayList<>();
        if ((digits == null) || (digits.length() <= 0)) {
            return result;
        }

        result.add("");
        // 주어진 digit 길이 동안 반복
        final int digitLength = digits.length();
        for (int i = 0; i < digitLength; i++) {
            // 주어진 digit 숫자에 맞는 문자열을 매개변수로 넘김
            result = combine(result, DIGIT_LETTERS[digits.charAt(i) - '0']);
        }

        return result;
    }

    private static List<String> combine(final List<String> prevLetters, final String currLetters) {
        List<String> returnList = new ArrayList<>();

        // 반복문을 돌면서 현재 digit에 매핑되는 문자열을 이전에 문자열과 각각 매핑 후 삽입
        final int digitLength = currLetters.length();
        for (int i = 0; i < digitLength; i++) {
            for (String first : prevLetters) {
                returnList.add(first + currLetters.charAt(i));
            }
        }

        return returnList;
    }
}
