package com.jaenyeong._06_back_tracking._03_subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /*
    [Question]
    Given a set of distinct integers, nums, return all possible subsets (the power set).

    [Input]
    > [1, 2, 3]
    [Output]
    > [
          [3],
          [1],
          [2],
          [1, 2, 3],
          [1, 3],
          [2, 3],
          [1, 2],
          []
      ]

    [Note]
    The solution set must not contain duplicate subsets.

     */

    static final int START = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        System.out.println(solve(numbers));
    }

    static List<List<Integer>> solve(final int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();

        if ((numbers == null) || (numbers.length <= 0)) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        dfs(numbers, result, list, START);

        return result;
    }

    static void dfs(final int[] numbers, final List<List<Integer>> result, final List<Integer> current, final int start) {
        // 반환될 결과에 삽입
        result.add(new ArrayList<>(current));

        // 파라미터 값부터 반복 주어진 배열의 끝까지 반복
        final int numbersLength = numbers.length;
        for (int i = start; i < numbersLength; i++) {
            current.add(numbers[i]);
            // 재귀 호출시 현재 인덱스에 1을 더한 값을 매개변수로 담아 호출
            dfs(numbers, result, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
