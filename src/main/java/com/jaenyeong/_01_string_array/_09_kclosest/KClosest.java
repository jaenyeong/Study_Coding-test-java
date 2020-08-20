package com.jaenyeong._01_string_array._09_kclosest;

import java.util.*;

public class KClosest {
    /*
    [Question]
    We have a list of points on the plane. Find the K closest points to the origin (0, 0).
    (Here, the distance between two points on a plane is the Euclidean distance.)
    You may return the answer in any order. The answer is guaranteed to be unique
    (except for the order that it is in.)

    [Input]
    points > [[1, 3], [-2, 2]]
    k > 1
    [Output]
    > [[-2, 2]]

    [Explanation]
    The distance between (1, 3) and the origin is sqrt(10).
    The distance between (-2, 2) and the origin is sqrt(8).
    Since sqrt(8) < sqrt(-2, 2) is closer to the origin.
    We only want the closest K = 1 points from the origin, so the answer is just [[-2, 2]].

     */

    public static void main(String[] args) {
        // 배열로 처리
        int[][] points = {{1, 3}, {-2, 2}};
        int arrayKey = 1;

//        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
//        int arrayKey = 2;

        print(solve(points, arrayKey));

        // 리스트로 처리
        List<List<Integer>> pointList = new ArrayList<>();
        int listKey = 2;

        List<Integer> intList1 = new ArrayList<>();
        intList1.add(3);
        intList1.add(3);

        List<Integer> intList2 = new ArrayList<>();
        intList2.add(5);
        intList2.add(-1);

        List<Integer> intList3 = new ArrayList<>();
        intList3.add(-2);
        intList3.add(-4);

        pointList.add(intList1);
        pointList.add(intList2);
        pointList.add(intList3);

        print(solveList(pointList, listKey));
    }

    static int[][] solve(final int[][] points, final int key) {
        Queue<int[]> queue = new PriorityQueue<>(points.length, comparator);
        int[][] result = new int[key][2];

        // 큐 객체에 바인딩
//        for (int[] point : points) {
//            queue.offer(point);
//        }

        queue.addAll(Arrays.asList(points));

        int idx = 0;
        while (idx < key) {
            result[idx] = queue.poll();
            idx++;
        }

        return result;
    }

    // 람다
    static Comparator<int[]> comparator = Comparator.comparingInt(o -> ((o[0] * o[0]) + (o[1] * o[1])));

//    static Comparator<int[]> comparator = new Comparator<int[]>() {
//        @Override
//        public int compare(int[] o1, int[] o2) {
//            return ((o1[0] * o1[0]) + (o1[1] * o1[1]))
//                - ((o2[0] * o2[0]) + (o2[1] * (o2[1])));
//        }
//    };

    static int[][] solveList(final List<List<Integer>> points, final int key) {
        // 2차원 배열로 변환
        final int[][] convertPoints = convert2DimensionalArray(points);

        // 포인트 별 거리 계산
        final int pointsLength = convertPoints.length;
        final int[] distances = new int[pointsLength];
        for (int i = 0; i < pointsLength; ++i) {
            distances[i] = getDistance(convertPoints[i]);
        }

        // 배열 정렬
        Arrays.sort(distances);

        final int distKey = distances[key - 1];
        final int[][] results = new int[key][2];
        int idx = 0;
        for (int[] convertPoint : convertPoints) {
            if (getDistance(convertPoint) <= distKey) {
                results[idx++] = convertPoint;
            }
        }

        return results;
    }

    private static int[][] convert2DimensionalArray(List<List<Integer>> pointList) {
        // 2차원 배열 초기화
        int[][] points = new int[pointList.size()][];

        // 2차원 배열 내 각 원소 배열 초기화
        final int length = points.length;
        for (int i = 0; i < length; i++) {
            points[i] = new int[pointList.get(i).size()];
        }

        // 각 원소 바인딩
        final int size = pointList.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < pointList.get(i).size(); j++) {
                points[i][j] = pointList.get(i).get(j);
            }
        }

        return points;
    }

    private static int getDistance(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }

    static void print(int[][] results) {
        System.out.println("====== print ======");
        for (int[] result : results) {
            System.out.println(Arrays.toString(result));
        }
    }
}
