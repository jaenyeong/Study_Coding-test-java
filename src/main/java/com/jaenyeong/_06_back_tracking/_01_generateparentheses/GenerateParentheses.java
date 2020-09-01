package com.jaenyeong._06_back_tracking._01_generateparentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /*
    [Question]
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    [Input]
    > 3
    [Output]
    > [
          "((()))",
          "(()())",
          "(())()",
          "()(())",
          "()()()"
      ]

     */

    static final String EMPTY_VALUE = "";

    public static void main(String[] args) {
        int pairsCount = 3;

        System.out.println(solve(pairsCount));
    }

    static List<String> solve(int pairsCount) {
        List<String> parentheses = new ArrayList<>();

        dfs(parentheses, pairsCount, pairsCount, EMPTY_VALUE);
        return parentheses;
    }

    private static void dfs(final List<String> parentheses,
                            final int left, final int right,
                            final String currStr) {

        // 열수 있는 괄호가 없는 경우, 괄호가 열리지 않았는데 닫히는 경우
        if ((0 > left) || (left > right)) {
            return;
        }

        // 괄호를 모두 사용한 경우
        if ((left == 0) && (right == 0)) {
            parentheses.add(currStr);
        }

        // open parenthesis "("
        dfs(parentheses, left - 1, right, currStr + "(");
        // close parenthesis ")"
        dfs(parentheses, left, right - 1, currStr + ")");
    }
}
