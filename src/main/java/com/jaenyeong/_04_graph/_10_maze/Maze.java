package com.jaenyeong._04_graph._10_maze;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    /*
    [Question]
    There is a ball in a maze with empty spaces and walls.
    The ball can go through empty spaces by rolling up, down, left or right,
    but it won't stop rolling until hitting a wall.
    Given the ball's start position, the destination and the maze,
    determine whether the ball could stop at the destination.
    The maze is represented by a binary 2D array.
    1 means the wall and 0 means the empty space.
    You may assume that the borders of the maze are all walls.
    The start and destination coordinates are represented by row and column indexes.

    [Input]
    maze > [
               [0, 0, 1, 0, 0],
               [0, 0, 0, 0, 0],
               [0, 0, 0, 1, 0],
               [1, 1, 0, 1, 1],
               [0, 0, 0, 0, 0]
           ]
    start coordinate > (0, 4)
    destination coordinate > (4, 4)
    [Output]
    > true

     */

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int EMPTY_SPACE = 0;
    static final int WALL = 1;

    static int mazeRowLength;
    static int mazeColLength;

    public static void main(String[] args) {
        int[][] mazeGrid = {
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0}
        };

        int[] startingPoint = {0, 4};
        int[] destination = {4, 4};
//        int[] destination = {3, 2}; // false
//        int[] destination = {4, 2}; // true

        mazeRowLength = mazeGrid.length;
        mazeColLength = mazeGrid[0].length;

//        System.out.println(Arrays.toString(startingPoint));
//        System.out.println(Arrays.toString(destination));

        System.out.println(solveBFS(mazeGrid, startingPoint, destination));
        System.out.println(solveDFS(mazeGrid, startingPoint, destination));
    }

    static boolean solveBFS(final int[][] mazeGrid, final int[] startingPoint, final int[] destination) {
        if ((mazeGrid == null) && (mazeColLength == 0)) {
            return false;
        }

        if (matchStartingPointAndDestination(startingPoint, destination)) {
            return true;
        }

        boolean[][] visited = new boolean[mazeRowLength][mazeColLength];
        visited[startingPoint[0]][startingPoint[1]] = true;

        Queue<int[]> queue = new LinkedList<>();

        final int[] copyStartingPoint = new int[]{startingPoint[0], startingPoint[1]};
        queue.offer(copyStartingPoint);

        while (!queue.isEmpty()) {
            final int[] currentPoint = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int rowPoint = currentPoint[0] + direction[0];
                int colPoint = currentPoint[1] + direction[1];

                // 벽을 만날때까지 이동
                assert mazeGrid != null;
                while ((0 <= rowPoint) && (rowPoint < mazeRowLength)
                    && (0 <= colPoint) && (colPoint < mazeColLength)
                    && (mazeGrid[rowPoint][colPoint] == EMPTY_SPACE)) {
                    rowPoint += direction[0];
                    colPoint += direction[1];
                }

                // 벽을 만나기 직전 지점으로 이동
                rowPoint -= direction[0];
                colPoint -= direction[1];

                if (visited[rowPoint][colPoint]) {
                    continue;
                }

                visited[rowPoint][colPoint] = true;

                // 목적지 확인
                if ((rowPoint == destination[0]) && (colPoint == destination[1])) {
                    return true;
                }

                queue.offer(new int[]{rowPoint, colPoint});
            }
        }

        return false;
    }

    private static boolean matchStartingPointAndDestination(final int[] startingPoint, final int[] destination) {
        return (startingPoint[0] == destination[0]) && (startingPoint[1] == destination[1]);
    }

    static boolean solveDFS(final int[][] mazeGrid, final int[] startingPoint, final int[] destination) {
        if ((mazeGrid == null) && (mazeColLength == 0)
            && matchStartingPointAndDestination(startingPoint, destination)) {
            return false;
        }

        boolean[][] visited = new boolean[mazeRowLength][mazeColLength];

        return dfs(mazeGrid, startingPoint, destination, visited);
    }

    private static boolean dfs(final int[][] mazeGrid, final int[] startingPoint, final int[] destination, final boolean[][] visited) {
        if ((0 > startingPoint[0]) || (startingPoint[0] >= mazeRowLength)
            || (0 > startingPoint[1]) || (startingPoint[1] >= mazeColLength)
            || visited[startingPoint[0]][startingPoint[1]]) {
            return false;
        }

        visited[startingPoint[0]][startingPoint[1]] = true;

        // 목적지 도착 여부 확인
        if ((startingPoint[0] == destination[0]) && (startingPoint[1] == destination[1])) {
            return true;
        }

        for (int[] direction : DIRECTIONS) {
            int rowPoint = startingPoint[0];
            int colPoint = startingPoint[1];

            while ((0 <= rowPoint) && (rowPoint < mazeRowLength)
                && (0 <= colPoint) && (colPoint < mazeColLength)
                && (mazeGrid[rowPoint][colPoint] != WALL)) {

                rowPoint += direction[0];
                colPoint += direction[1];
            }

            rowPoint -= direction[0];
            colPoint -= direction[1];

            if (dfs(mazeGrid, new int[]{rowPoint, colPoint}, destination, visited)) {
                return true;
            }
        }

        return false;
    }
}
