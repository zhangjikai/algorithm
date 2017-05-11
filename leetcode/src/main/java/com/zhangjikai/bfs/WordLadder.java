package com.zhangjikai.bfs;

import java.util.*;

/**
 * Created by Jikai Zhang on 2017/5/11.
 */
public class WordLadder {

    static class Word {
        String text;
        int count;

        public Word(String text, int count) {
            this.text = text;
            this.count = count;
        }

        public Word() {
        }
    }
    public int ladderLength(String beginWord, String endWorld, List<String> wordList) {
        if(beginWord.equals(endWorld)) {
            return 0;
        }

        Set<String> wordSet = new HashSet<>();
        for(String s : wordList) {
            wordSet.add(s);
        }
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(beginWord, 1));

        while (!queue.isEmpty()) {
            Word word = queue.poll();
            String text = word.text;

            int length = text.length();

            for(int i = 0; i < length; i++) {
                char[] textChars = text.toCharArray();
                for(int j = 'a'; j <= 'z'; j++) {
                    textChars[i] = (char)j;
                    String textTmp = new String(textChars);
                    //System.out.println(textTmp);

                    if(wordSet.contains(textTmp)) {
                        if(textTmp.equals(endWorld)) {
                            return word.count + 1;
                        }
                        queue.add(new Word(textTmp, word.count+1));
                        wordSet.remove(textTmp);
                    }
                }
            }
        }
        return 0;
    }
}
