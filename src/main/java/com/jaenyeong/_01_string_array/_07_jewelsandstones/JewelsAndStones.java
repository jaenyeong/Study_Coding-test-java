package com.jaenyeong._01_string_array._07_jewelsandstones;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    /*
    [Question]
    You're given strings J representing the types of stones that ar jewels, and S representing the stones you have.
    Each character in S is a type of stone you have.
    You want to know how many of the stones you have are also jewels.
    The letters in J are guaranteed distinct, and all characters in J and S are letters.
    Letters are case sensitive, so "a" is considered a different type of stone from "A".

    [Input]
    J > "aA"
    S > "aAAbbbb"

    [Output]
    > 3

     */

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println(solve(jewels, stones));
    }

    static int solve(final String jewels, final String stones) {
        Set<Character> set = new HashSet<>();

        // a, A 삽입
        for (char jewel : jewels.toCharArray()) {
            set.add(jewel);
        }

        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (set.contains(stone)) {
                count++;
            }
        }

        return count;
    }
}
