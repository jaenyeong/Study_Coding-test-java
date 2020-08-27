package com.jaenyeong._04_graph._08_wordsearch;

public class WordSearch {
    /*
    [Question]
    Given a 2D board and a word, find if the word exists in the grid.
    The word can be constructed from letters of sequentially adjacent cell,
    where "adjacent" cells are those horizontally or vertically neighboring.
    The same letter cell may not be used more than once.

    [Input - grid]
    > [
          ['A', 'B', 'C', 'E'],
          ['S', 'F', 'C', 'S'],
          ['A', 'D', 'E', 'E']
      ]

    [Input - word]
    > "ABCCED"
    [Output]
    > true

    [Input - word]
    > "SEE"
    [Output]
    > true

    [Input - word]
    > "ABCB"
    [Output]
    > false

     */

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int gridRowLength = 0;
    static int gridColLength = 0;

    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String givenWord = "ABCCED";

        gridRowLength = grid.length;
        gridColLength = grid[0].length;

        System.out.println(solve(grid, givenWord));
    }

    static boolean solve(final char[][] grid, final String givenWord) {
        if ((grid == null) || (gridRowLength <= 0) || (gridColLength <= 0)
                || (givenWord == null) || (givenWord.length() <= 0)) {
            return false;
        }

        boolean[][] visited = new boolean[gridRowLength][gridColLength];

        for (int row = 0; row < gridRowLength; row++) {
            for (int col = 0; col < gridColLength; col++) {
                if (dfs(grid, visited, row, col, 0, givenWord)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(final char[][] grid, final boolean[][] visited,
                               final int row, final int col, final int start, final String givenWord) {

        if (start == givenWord.length()) {
            return true;
        }

        if ((0 > row) || (row >= gridRowLength)
                || (0 > col) || (col >= gridColLength)) {
            return false;
        }

        if (visited[row][col]) {
            return false;
        }

        if (grid[row][col] != givenWord.charAt(start)) {
            return false;
        }

        visited[row][col] = true;

        for (int[] direction : DIRECTIONS) {
            int rowDirection = row + direction[0];
            int colDirection = col + direction[1];
            if (dfs(grid, visited, rowDirection, colDirection, start + 1, givenWord)) {
                return true;
            }
        }

        visited[row][col] = false;

        return false;
    }
}
