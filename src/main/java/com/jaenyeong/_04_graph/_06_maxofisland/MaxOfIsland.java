package com.jaenyeong._04_graph._06_maxofisland;

public class MaxOfIsland {
    /*
    [Question]
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.
    Find the largest area of an island in a given 2D grid map.
    If there are no islands, the maximum area is 0.

    [Input]
    > [
          ['1', '1', '0', '1', '1'],
          ['0', '1', '1', '0', '0'],
          ['0', '0', '0', '0', '0'],
          ['1', '1', '0', '1', '1'],
          ['1', '0', '1', '1', '1'],
          ['1', '0', '1', '1', '1']
      ]
    [Output]
    > 8

    [Note]
    The length of each dimension in the given grid does not exceed 50.

     */

    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int rowLength = 0;
    static int colLength = 0;

    public static void main(String[] args) {
        int[][] grid = {
            {'1', '1', '0', '1', '1'},
            {'0', '1', '1', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'1', '1', '0', '1', '1'},
            {'1', '0', '1', '1', '1'},
            {'1', '0', '1', '1', '1'}
        };

        rowLength = grid.length;    // 6
        colLength = grid[0].length; // 5

        System.out.println(solve(grid));
    }

    static int solve(final int[][] grid) {
        if ((grid == null) || (rowLength <= 0)) {
            return 0;
        }

        int returnIslandSize = 0;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == '1') {
                    int islandSize = dfs(grid, row, col, 0);
                    returnIslandSize = Math.max(returnIslandSize, islandSize);
                }
            }
        }

        return returnIslandSize;
    }

    private static int dfs(final int[][] grid, final int row, final int col, int islandSize) {
        if ((0 > row) || (row >= rowLength)
            || (0 > col) || (col >= colLength)
            || (grid[row][col] == '0')
            || (grid[row][col] == 'X')) {
            return islandSize;
        }

        grid[row][col] = 'X';
        islandSize++;

        // DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // 상하좌우 확인
        for (int[] direction : DIRECTIONS) {
            islandSize = dfs(grid, row + direction[0], col + direction[1], islandSize);
        }

        return islandSize;
    }
}
