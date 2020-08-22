package com.jaenyeong._01_string_array._17_groupanagrams;

import java.util.*;

public class GroupAnagrams {
    /*
    [Question]
    Given an array of strings, group anagrams together.

    [Input]
    > ["eat", "tea", "tan", "ate", "nat", "bat"]
    [Output]
    > [["ate", "eat", "tea"], ["nat", "tan"], ["bat"]]

    [Note]
    All inputs will be in lowercase.
    The order of your output does not matter.

     */

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(solve(strings));
    }

    static List<List<String>> solve(String[] strings) {
        List<List<String>> result = new ArrayList<>();

        if (strings == null || strings.length <= 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String string : strings) {
            // 정렬 후 정렬한 값을 맵의 키로 활용
            String key = sortingSolve(string);

            // 아스키 코드로 처리
//            String key = asciiSolve(string);

            // 해당 키의 리스트를 생성하여 맵에 바인딩
            if (map.containsKey(key)) {
                map.get(key).add(string);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(string);
                map.put(key, stringList);
            }
        }

        result.addAll(map.values());

        return result;
    }

    private static String sortingSolve(String string) {
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    private static String asciiSolve(String string) {
        char[] charArray = new char[256];

        final int length = string.length();
        for (int i = 0; i < length; i++) {
            charArray[string.charAt(i)]++;
        }

        return String.valueOf(charArray);
    }
}
