package com.jaenyeong._03_queue_stack._02_validparentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    /*
    [Question]
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.
    An input string is valid if:
      1. Open brackets must be closed by the same type of brackets.
      2. Open brackets must be closed in the correct order.

    [Input]
    > "{[]}"
    [Output]
    > true

    [Input]
    > "()[]{}"
    [Output]
    > true

    [Input]
    > "([)]"
    [Output]
    > false

    [Input]
    > "(]"
    [Output]
    > false

    [Constraints]
    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.

     */

    public static void main(String[] args) {
        String expression = "{[]}";
//        String expression = "([)]";

        System.out.println(solveStack(expression));
//        System.out.println(solveMap(expression));
    }

    static boolean solveStack(String expression) {
        if (expression == null || expression.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        final int length = expression.length();
        for (int i = 0; i < length; i++) {
            final char parentheses = expression.charAt(i);

            switch (parentheses) {
                case ')':
                    if ((!stack.isEmpty()) && (stack.peek() == '(')) {
                        stack.pop();
                    }

                    break;

                case '}':
                    if ((!stack.isEmpty()) && (stack.peek() == '{')) {
                        stack.pop();
                    }

                    break;

                case ']':
                    if ((!stack.isEmpty()) && (stack.peek() == '[')) {
                        stack.pop();
                    }

                    break;
                default:
                    stack.push(parentheses);
            }
        }

        return stack.isEmpty();
    }

    static boolean solveMap(String expression) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        final int length = expression.length();
        for (int i = 0; i < length; i++) {
            final char parentheses = expression.charAt(i);

            if (map.containsKey(parentheses)) {
                stack.push(parentheses);
            } else if (map.containsValue(parentheses)) {
                if (!stack.isEmpty() && map.get(stack.peek()) == parentheses) {
                    stack.pop();
                    continue;
                }
                return false;
            }
        }

        return stack.isEmpty();
    }
}
