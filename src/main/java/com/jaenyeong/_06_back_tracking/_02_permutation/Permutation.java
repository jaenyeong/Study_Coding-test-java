package com.jaenyeong._06_back_tracking._02_permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    /*
    [Question]
    Given a collection of distinct integers, return all possible permutations.

    [Input]
    > [1, 2, 3]
    [Output]
    > [
          [1, 2, 3],
          [1, 3, 2],
          [2, 1, 3],
          [2, 3, 1],
          [3, 1, 2],
          [3, 2, 1]
      ]

     */

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
        dfs(numbers, result, list);

        return result;
    }

    private static void dfs(final int[] numbers, final List<List<Integer>> result, final List<Integer> current) {
        // 주어진 배열의 원소 개수만큼 current 객체에 모두 삽입한 경우 결과 객체에 삽입
        final int numbersLength = numbers.length;
        if (current.size() == numbersLength) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 주어진 배열만큼 반복
        for (int number : numbers) {

            // 반복시 이미 삽입된 숫자일 때 건너뜀
            if (current.contains(number)) {
                continue;
            }

            // 숫자 삽입
            current.add(number);
            // 재귀 호출하여 그 외 다른 숫자들을 또 삽입
            dfs(numbers, result, current);
            // 한 로테이션 처리 후 마지막 원소 삭제
            current.remove(current.size() - 1);
        }
    }
}
