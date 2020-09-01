package com.jaenyeong._05_dynamic_programming._02_coinchange;

import java.util.Arrays;

public class CoinChange {
    /*
    [Question]
    You are given coins of different denominations and a total amount of money amount.
    Write a function to compute the fewest number of coins that you need to make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return -1.

    [Input]
    coins > [1, 2, 5]
    amount > 11
    [Output]
    > 3

    [Explanation]
    11 = 5 + 5 + 1

     */
    static final int BAD_RESPONSE = -1;
    static int coinsLength;

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        coinsLength = coins.length;

        System.out.println(solve(coins, amount));
    }

    static int solve(final int[] coins, final int amount) {
        if (amount <= 0) {
            return BAD_RESPONSE;
        }

        // 맨 처음은 0 코인이라고 가정 후 연산하기 때문에 배열 길이를 amount + 1로 초기화
        final int max = amount + 1;
        int[] dpCoinPcs = new int[max];
        Arrays.fill(dpCoinPcs, max);
        // 맨 처음 0 코인
        dpCoinPcs[0] = 0;

        // 금액이 1일 때부터 주어진 amount까지 반복
        for (int amountIdx = 1; amountIdx <= amount; amountIdx++) {

            // 보유하고 있는 코인 종류의 수만큼 반복
            for (int coinIdx = 0; coinIdx < coinsLength; coinIdx++) {

                // 보유한 코인 중 amount보다 작은 코인만 처리
                if (amountIdx < coins[coinIdx]) {
                    continue;
                }

                // 각 코인마다 그 전에 넣어둔 최소 개수와 현재 개수를 비교하여 최소값 삽입
                dpCoinPcs[amountIdx] =
                    Math.min(dpCoinPcs[amountIdx], dpCoinPcs[amountIdx - coins[coinIdx]] + 1);
            }
        }

        return dpCoinPcs[amount] > amount ? BAD_RESPONSE : dpCoinPcs[amount];
    }
}
