package com.jaenyeong._04_graph._09_removeinvalidparentheses;

import java.util.*;

public class RemoveInvalidParentheses {
    /*
    [Question]
    Remove the minimum number of invalid parentheses in order to make the input string valid.
    Return all possible results.

    [Input]
    > "()())()"
    [Output]
    > ["()()()", "(())()"]

    [Input]
    > "(a)())()"
    [Output]
    > ["(a)()()", "(a())()"]

    [Input]
    > ")("
    [Output]
    > [""]

    [Note]
    The input string may contain letters other than the parentheses.

     */

    public static void main(String[] args) {
        String inputStr = "(a)())()";

        System.out.println(solve(inputStr));
    }

    static List<String> solve(final String inputStr) {
        List<String> returnParentheses = new ArrayList<>();

        if ((inputStr == null) || (inputStr.length() <= 0)) {
            return returnParentheses;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(inputStr);

        Set<String> visited = new HashSet<>();
        visited.add(inputStr);

        boolean valid = false;

        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                String parentheses = queue.poll();
                assert parentheses != null;

                if (isValid(parentheses)) {
                    returnParentheses.add(parentheses);
                    valid = true;
                }

                if (valid) {
                    continue;
                }

                substringAndAdd(queue, visited, parentheses);
            }
        }

        return returnParentheses;
    }

    private static boolean isValid(final String parentheses) {
        int validCnt = 0;

        for (char character : parentheses.toCharArray()) {
            if (character == '(') {
                validCnt++;
            } else if (character == ')') {
                validCnt--;

                if (validCnt < 0) {
                    return false;
                }
            }
        }

        return validCnt == 0;
    }

    private static void substringAndAdd(final Queue<String> queue, final Set<String> visited, final String parentheses) {
        final int length = parentheses.length();

        for (int j = 0; j < length; j++) {
            final char character = parentheses.charAt(j);

            if ((character != '(') && (character != ')')) {
                continue;
            }

            final String frontStr = parentheses.substring(0, j);
            final String backStr = parentheses.substring(j + 1);

            final String parenthesesSubstr = frontStr + backStr;

            if (!visited.contains(parenthesesSubstr)) {
                queue.offer(parenthesesSubstr);
                visited.add(parenthesesSubstr);
            }
        }
    }
}
