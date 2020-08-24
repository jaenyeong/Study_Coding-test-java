package com.jaenyeong._04_graph._01_numberofisland;

import java.util.Arrays;

public class NumberOfIsland {
    /*
    [Question]
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.

    [Input]
    > [
          ['1', '1', '1', '1', '0'],
          ['1', '1', '0', '1', '0'],
          ['1', '1', '0', '0', '0'],
          ['0', '0', '0', '0', '0']
      ]
    [Output]
    > 1

    [Input]
    > [
          ['1', '1', '0', '0', '0'],
          ['1', '1', '0', '0', '0'],
          ['0', '0', '1', '0', '0'],
          ['0', '0', '0', '1', '1']
      ]
    [Output]
    > 3

    [Input]
    > [
          ['1', '1', '1', '0', '1'],
          ['1', '1', '0', '0', '0'],
          ['1', '1', '0', '0', '1'],
          ['0', '0', '0', '0', '1']
      ]
    [Output]
    > 3

     */

    static int gridRowLength = 0;
    static int gridColLength = 0;

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '0', '1'}
        };

        gridRowLength = grid.length;
        gridColLength = grid[0].length;

        System.out.println(solve(grid));
    }

    static int solve(final char[][] grid) {
        if (grid == null || gridRowLength <= 0 || gridColLength <= 0) {
            return 0;
        }

        print(grid);

        int islandCnt = 0;
        for (int row = 0; row < gridRowLength; row++) {
            for (int col = 0; col < gridColLength; col++) {
                if (grid[row][col] == '1') {
                    System.out.println("grid[" + row + "][" + col + "]");

                    islandCnt++;

                    dfs(grid, row, col);

                    print(grid);
                }
            }
        }

        return islandCnt;
    }

    static void print(final char[][] grid) {
        Arrays.stream(grid).forEach(array -> System.out.println(Arrays.toString(array)));
    }

    // DFS (Depth First Search) 깊이 우선 탐색
    // 일반적으로 DFS는 Stack 사용
    private static void dfs(final char[][] grid, final int row, final int col) {
        if ((0 > row) || (row >= gridRowLength)
                || (0 > col) || (col >= grid[row].length)
                || (grid[row][col] != '1')) {
            return;
        }

        grid[row][col] = 'X';

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
