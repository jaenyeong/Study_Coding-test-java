package com.jaenyeong._01_string_array._05_mergeinterval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    /*
    [Question]
    Given a collection of intervals, merge all overlapping intervals.

    [Input]
    > [[1, 3], [2, 6], [8, 10], [15, 18]]
    [Output]
    > [[1, 6], [8, 10], [15, 18]]

     */

    public static void main(String[] args) {
//        Interval interval1 = new Interval(1, 3);
//        Interval interval2 = new Interval(2, 6);
//        Interval interval3 = new Interval(8, 10);
//        Interval interval4 = new Interval(15, 18);

        Interval interval1 = new Interval(15, 18);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(1, 3);
        Interval interval4 = new Interval(8, 10);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);

        List<Interval> resultList = merge(intervals);
        print(resultList, "Result");
    }

    static List<Interval> merge(final List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return intervals;
        }

        print(intervals, "Before sorting");

        List<Interval> result = new ArrayList<>();

        // 정렬
//        Collections.sort(intervals, (a, b) -> a.start - b.start); // 오름차순
//        Collections.sort(intervals, (a, b) -> b.start - a.start); // 내림차순

//        intervals.sort(Comparator.comparingInt(a -> a.start)); // 오름차순
//        intervals.sort((a, b) -> b.start - a.start); // 내림차순
        intervals.sort(comparing);

        print(intervals, "After sorting");

        Interval before = intervals.get(0);
        final int size = intervals.size();

        for (int i = 1; i < size; i++) {
            Interval current = intervals.get(i);

            if (before.end >= current.start) {
                before.end = Math.max(current.end, before.end);
            } else {
                result.add(before);
                before = current;
            }
        }

        // 마지막 원소의 존재유무 확인 후 삽입
        if (!result.contains(before)) {
            result.add(before);
        }

        return result;
    }

    static void print(final List<Interval> intervals, final String message) {
        System.out.println("=========== [ " + message + " ] ===========");
        intervals.forEach(System.out::println);
    }

    static Comparator<Interval> comparing = Comparator.comparingInt(o -> o.start); // 오름차순

//    static Comparator<Interval> comp = (o1, o2) -> Integer.compare(o1.start, o2.start);

//    static Comparator<Interval> comp = new Comparator<Interval>() {
//        @Override
//        public int compare(Interval o1, Interval o2) {
//            return Integer.compare(o1.start, o2.start);
//        }
//    };

//    static Comparator<Interval> comp = new Comparator<Interval>() {
//        @Override
//        public int compare(Interval o1, Interval o2) {
//            if (o1.start > o2.start) {
//                return 1;
//            } else if (o1.start < o2.start) {
//                return -1;
//            } else {
//                return 0;
//            }
//        }
//    };
}
