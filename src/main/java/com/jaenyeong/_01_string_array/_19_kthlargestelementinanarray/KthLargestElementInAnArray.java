package com.jaenyeong._01_string_array._19_kthlargestelementinanarray;

import java.util.*;

public class KthLargestElementInAnArray {
    /*
    [Question]
    Find the kth largest element in an unsorted array.
    Note that it is the kth largest element in the sorted order, not the kth distinct element.

    [Input]
    array > [3, 2, 1, 5, 6, 4]
    key > 2
    [Output]
    > 5

    [Input]
    array > [3, 2, 3, 1, 2, 4, 5, 5, 6]
    key > 4
    [Output]
    > 4

    [Note]
    You may assume key is always valid, 1 <= key <= array's length.

     */

    public static void main(String[] args) {
        int[] numbers = {3, 2, 1, 5, 6, 4};
        int key = 2;

        System.out.println(solveArray(numbers, key));
//        System.out.println(solvePriorityQueue(numbers, key));
    }

    static int solveArray(final int[] numbers, final int key) {
        final int length = numbers.length;
        // 오름차순으로 정렬
        Arrays.sort(numbers);

        return numbers[length - key];
    }

    static int solvePriorityQueue(final int[] numbers, final int key) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int number : numbers) {
            queue.offer(number);

            if (queue.size() > key) {
                queue.poll();
            }
        }

        assert queue.size() > 0;
        return queue.peek();
    }
}
