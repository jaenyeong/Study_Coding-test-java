package com.jaenyeong._01_string_array._01_meetingroom;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {
    /*
    [Question]
    Given an array of meeting time intervals consisting of start and end times [[s1, e1], [s2, e2], ...]
    (si < ei), determine if a person could attend all meetings.

    [Input]
    > [[0, 30], [5, 10], [15, 20]]
    [Output]
    > false

    [Input]
    > [[7, 10], [2, 4]]
    [Output]
    > true

     */

    public static void main(String[] args) {
        MeetingRoom room1 = new MeetingRoom();

        Interval interval1 = new Interval(15, 20);
        Interval interval2 = new Interval(5, 10);
        Interval interval3 = new Interval(0, 30);

        Interval[] intervals1 = {interval1, interval2, interval3};
        System.out.println(">>>>>>>>>> [Solve 1] : " + room1.solve(intervals1));

        Interval interval4 = new Interval(7, 10);
        Interval interval5 = new Interval(2, 4);

        Interval[] intervals2 = {interval4, interval5};
        System.out.println(">>>>>>>>>> [Solve 2] : " + room1.solve(intervals2));
    }

    boolean solve(final Interval[] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return false;
        }

        // [1] 데이터 정렬
        sortIntervals(intervals);

        // [2] before.end > current.start
        return compareBeforeAndCurrent(intervals);
    }

    private void sortIntervals(final Interval[] intervals) {
        System.out.println("===== [Before sorting] =====");
        print(intervals);

        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

        System.out.println("===== [After sorting] =====");
        print(intervals);
    }

    void print(final Interval[] intervals) {
        for (Interval in : intervals) {
            System.out.println(in.start + " " + in.end);
        }
    }

    private boolean compareBeforeAndCurrent(final Interval[] intervals) {
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
    }
}
