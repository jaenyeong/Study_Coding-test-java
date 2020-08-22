package com.jaenyeong._01_string_array._16_spiralmatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /*
    [Question]
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

    [Input]
    > [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    [Output]
    > [1, 2, 3, 6, 9, 8, 7, 4, 5]

     */

    public static void main(String[] args) {
//        int[][] matrix = {
//            {1, 2, 3},
//            {4, 5, 6},
//            {7, 8, 9}
//        };

//        int[][] matrix = {
//            {0, 1, 2, 3},
//            {4, 5, 6, 7},
//            {8, 9, 10, 11},
//            {12, 13, 14, 15}
//        };

        int[][] matrix = {
            {0, 1, 2, 3, 4},
            {5, 6, 7, 8, 9},
            {10, 11, 12, 13, 14}
        };

        System.out.println(solve(matrix).toString());
    }

    static List<Integer> solve(final int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length <= 0) {
            return result;
        }

        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;

        // 매트릭스 전체 원소가 끝날 때까지
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 우측
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            // 아래
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // 좌측
            // 행이 남아 있는 경우만
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // 위
            // 열이 남아 있는 경우만
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }

        return result;
    }
}
