package com.jaenyeong._05_dynamic_programming._03_climbingstairs;

public class ClimbingStairs {
    /*
    [Question]
    You are climbing a stair case. It takes n steps to reach to the top.
    Each time you can either climb 1 or 2 steps.
    In how many distinct ways can you climb to the top?

    [Input]
    > 2
    [Output]
    > 2

    [Explanation]
    There are two ways to climb to the top.
    1 > 1 step + 1 step
    2 > 2 step

    [Note]
    Given n will be a positive integer.

     */

    public static void main(String[] args) {
        int stairs = 4;
//        int stairs = 5;

        System.out.println(solve(stairs));
    }

    static int solve(final int stairs) {
        if (stairs <= 0) return 0;
        if (stairs == 1) return 1;
        if (stairs == 2) return 2;

        // 초기화
        int[] howToUpStairs = new int[stairs + 1];
        howToUpStairs[0] = 0;
        howToUpStairs[1] = 1;
        howToUpStairs[2] = 2;

        // 3번째 계단 이후부터 처리
        for (int i = 3; i <= stairs; i++) {
            howToUpStairs[i] = howToUpStairs[i - 1] + howToUpStairs[i - 2];
        }

        return howToUpStairs[stairs];
    }
}
