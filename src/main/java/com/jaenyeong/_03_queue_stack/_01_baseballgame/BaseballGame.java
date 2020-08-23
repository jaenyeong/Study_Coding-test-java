package com.jaenyeong._03_queue_stack._01_baseballgame;

import java.util.Stack;

public class BaseballGame {
    /*
    [Question]
    You're now a baseball game point recorder.
    Given a list of strings, each string can be one of the 4 following types:
      1. Integer (one round's score):
         Directly represents the number of points you get in this round.
      2. "+" (one round's score):
         Represents that the points you get in this round are the sum of the last two valid round's points.
      3. "D" (one round's score):
         Represents that the points you get in this round are the doubled data of the last valid round's points.
      4. "C" (an operation, which isn't a round's score):
         Represents the last valid round's points you get were invalid and should be removed.
    Each round's operation is permanent and could have an impact on the round before and the round after.
    You need to return the sum of the points you could get in all the rounds.

    [Input]
    > ["5","2","C","D","+"]
    [Output]
    > 30

    [Input]
    > ["5","-2","4","C","D","9","+","+"]
    [Output]
    > 27

    [Note]
    The size of the input list will be between 1 and 1000.
    Every integer represented in the list will be between -30000 and 30000.

     */

    public static void main(String[] args) {
        String[] strings = {"5", "-2", "4", "C", "D", "9", "+", "+"};

        System.out.println(solve(strings));
    }

    static int solve(String[] strings) {
        Stack<Integer> stack = compute(strings);

        return sum(stack);
    }

    private static Stack<Integer> compute(String[] strings) {
        Stack<Integer> stack = new Stack<>();

        for (String string : strings) {
            switch (string.toUpperCase()) {
                case "C":
                    stack.pop();
                    break;

                case "D":
                    stack.push(stack.peek() * 2);
                    break;

                case "+":
                    int x = stack.pop();
                    int y = stack.pop();
                    int sum = x + y;

                    stack.push(y);
                    stack.push(x);
                    stack.push(sum);
                    break;

                default:
                    stack.add(Integer.valueOf(string));
            }
        }

        return stack;
    }

    private static int sum(Stack<Integer> stack) {
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
