package com.jaenyeong._04_graph._07_wordladder;

import java.util.*;

public class WordLadder {
    /*
    [Question]
    Given two words (beginWord and endWord), and a dictionary's word list,
    find the length of shortest transformation sequence from beginWord to endWord,
    such that : Only one letter can be changed at a time.
    Each transformed word must exist in the word list.
    Note that beginWord is not a transformed word.

    [Input]
    beginWord > "hit"
    endWord > "cog"
    wordList > ["hot", "dot", "dog", "lot", "log", "cog"]
    [Output]
    > 5

    [Note]
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

     */

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(solve(beginWord, endWord, wordList));
    }

    static int solve(final String beginWord, final String endWord, final List<String> wordList) {
        if ((wordList == null) || (!wordList.contains(endWord))) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> dictionary = new HashSet<>(wordList);
        dictionary.add(endWord);
        dictionary.remove(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            final int size = queue.size();

            for (int i = 0; i < size; i++) {
                final String word = queue.poll();

                assert word != null;
                // endWord 찾으면 반환
                if (word.equals(endWord)) {
                    return level;
                }

                for (String neighbor : findNeighbors(word, dictionary)) {
                    queue.offer(neighbor);
                }
            }

            level++;
        }

        return 0;
    }

    private static List<String> findNeighbors(final String word, final Set<String> dictionary) {
        List<String> foundWordList = new LinkedList<>();

        // 주어진 문자열 길이만큼 반복
        final int length = word.length();
        for (int i = 0; i < length; i++) {
            char[] wordChars = word.toCharArray();

            // 각 자리에 a~z 대입하여 문자열로 변경 후 비교
            for (char character = 'a'; character <= 'z'; character++) {
                wordChars[i] = character;
                final String neighborStr = String.valueOf(wordChars);

                // 문자열 리스트에 있는지 확인(제거) 후 반환 리스트에 추가
                if (dictionary.remove(neighborStr)) {
                    foundWordList.add(neighborStr);
                }
            }
        }

        return foundWordList;
    }
}
