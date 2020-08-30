package com.jaenyeong._04_graph._12_courseschedule;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    /*
    [Question]
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
    Some courses may have prerequisites,
    for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
    Given the total number of courses and a list of prerequisite pairs,
    is it possible for you to finish all courses?

    [Input]
    > [[1, 0], [0, 1]]
    [Output]
    > false

    [Input]
    > [[1, 0], [2, 1], [3, 2]]
    [Output]
    > true

     */

    public static void main(String[] args) {
        int courseNumber = 4;
        int[][] courses = {
            {1, 0},
            {2, 1},
            {3, 2}
        };

        // false
//        int[][] numbers = {
//            {1, 0},
//            {0, 1}
//        };

        System.out.println(solve(courseNumber, courses));
    }

    static boolean solve(final int courseNumber, final int[][] courses) {
        if (courseNumber <= 0) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[courseNumber];

        for (int[] course : courses) {
            inDegree[course[1]]++;
        }

        final int inDegreeLength = inDegree.length;
        for (int i = 0; i < inDegreeLength; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            final int firstClassZeroValue = queue.poll();

            for (int[] course : courses) {
                if (firstClassZeroValue == course[0]) {
                    inDegree[course[1]]--;

                    if (inDegree[course[1]] == 0) {
                        queue.offer(course[1]);
                    }
                }
            }
        }

        for (int i : inDegree) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
