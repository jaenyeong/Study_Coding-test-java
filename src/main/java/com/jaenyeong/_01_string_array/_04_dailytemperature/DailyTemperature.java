package com.jaenyeong._01_string_array._04_dailytemperature;

import java.util.*;

public class DailyTemperature {
    /*
    [Question]
    Given a list of daily temperatures T, return a list such that, for each day in the input,
    tells you how many days you would have to wait until a warmer temperature.
    If there is no future day for which this is possible, put 0 instead.

    [Input]
    > [73, 74, 75, 71, 69, 72, 76, 73]
    [Output]
    > [1, 1, 4, 2, 1, 1, 0, 0]

    [Note]
    The length of temperatures will be in the range [1, 30000].
    Each temperature will be an integer in the range [30, 100].

     */

    public static void main(String[] args) {
        int[] numbers = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] dailyTemperatures = dailyTemperature(numbers);
        System.out.println(Arrays.toString(dailyTemperatures));

        int[] dailyTemperaturesMap = dailyTemperaturesMap(numbers);
        System.out.println("[Map] -----");
        System.out.println(Arrays.toString(dailyTemperaturesMap));

        int[] dailyTemperaturesBack = dailyTemperaturesBack(numbers);
        System.out.println("[Back] -----");
        System.out.println(Arrays.toString(dailyTemperaturesBack));
    }

    static int[] dailyTemperature(final int[] tempers) {
        int tempersLength = tempers.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[tempersLength];

        for (int i = 0; i < tempersLength; i++) {
            while (!stack.isEmpty() && tempers[stack.peek()] < tempers[i]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }

            stack.push(i);
        }

        return result;
    }

    static int[] dailyTemperaturesMap(final int[] tempers) {
        int tempersLength = tempers.length;
        Map<Integer, Integer> next = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tempersLength; i++) {
            while (!stack.empty() && tempers[stack.peek()] < tempers[i]) {
                next.put(stack.peek(), i - stack.pop());
            }

            stack.push(i);
        }

        int[] result = new int[tempersLength];
        for (int i = 0; i < tempersLength; i++) {
            result[i] = next.getOrDefault(i, 0);
        }

        return result;
    }

    static int[] dailyTemperaturesBack(final int[] tempers) {
        int tempersLength = tempers.length;
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] result = new int[tempersLength];

        linkedList.push(tempersLength - 1);

        for (int i = tempersLength - 2; i >= 0; i--) {
            while (!linkedList.isEmpty() && tempers[i] >= tempers[linkedList.peek()]) {
                linkedList.pop();
            }

            if (!linkedList.isEmpty()) {
                result[i] = linkedList.peek() - i;
            }

            linkedList.push(i);
        }

        return result;
    }
}
