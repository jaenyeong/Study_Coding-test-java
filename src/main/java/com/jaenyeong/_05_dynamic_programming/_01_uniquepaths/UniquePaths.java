package com.jaenyeong._05_dynamic_programming._01_uniquepaths;

public class UniquePaths {
    /*
    [Question]
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
    The robot can only move either down or right at any point in time.
    The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
    How many possible unique paths are there? (7 * 3)

    [Input]
    m > 7
    n > 3
    [Output]
    > 28

    [Input]
    m > 3
    n > 2
    [Output]
    > 3

    [Note]
    m and n will be at most 100.

     */

    public static void main(String[] args) {
        int rowLength = 7;
        int colLength = 3;

        System.out.println(solve(rowLength, colLength));
    }

    static int solve(final int rowLength, final int colLength) {
        Integer[][] grid = new Integer[rowLength][colLength];

        // 모든 행의 첫번째 열을 갈 수 있는 유일한 경로가 하나
        // {{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}}
        for (int row = 0; row < rowLength; row++) {
            grid[row][0] = 1;
        }

        // 첫번째 행의 모든 열에 갈 수 있는 유일한 경로가 1개
        // {{0, 0}, {0, 1}, {0, 2}}
        for (int col = 0; col < colLength; col++) {
            grid[0][col] = 1;
        }

        // 나머지는 각 포인트의 top-left를 더한 값이 해당 포인트까지 갈 수 있는 유일한 경로 개수
        for (int row = 1; row < rowLength; row++) {
            for (int col = 1; col < colLength; col++) {
                grid[row][col] = grid[row][col - 1] + grid[row - 1][col];
            }
        }

        return grid[rowLength - 1][colLength - 1];
    }
}
