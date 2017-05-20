package com.zhangjikai.bfs;

import java.util.*;

/**
 * Created by Jikai Zhang on 2017/5/11.
 */
public class WordLadder2 {
    static class Word {
        String text;
        List<String> textList;
        Set<String> textSet;
        int count;

        public Word(String text, List<String> list, int count) {
            this.text = text;
            this.count = count;
            textList = new ArrayList<>(list);
            textSet = new HashSet<>(list);
        }

        public Word() {
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>();
        for (String s : wordList) {
            wordSet.add(s);
        }
        Queue<Word> queue = new LinkedList<>();
        List<List<String>> allList = new ArrayList<>();
        List<String> reachedList = new ArrayList<>();
        reachedList.add(beginWord);
        queue.add(new Word(beginWord, reachedList, 1));
        int minCount = -1;

        while (!queue.isEmpty()) {
            Word word = queue.poll();
            String text = word.text;
            List<String> textList = word.textList;
            Set<String> textSet = word.textSet;
            int length = text.length();
            int count = word.count;

            if(minCount != -1 && count >= minCount) {
                continue;
            }
            for (int i = 0; i < length; i++) {
                char[] textChars = text.toCharArray();
                for (int j = 'a'; j <= 'z'; j++) {
                    textChars[i] = (char) j;
                    String textTmp = new String(textChars);

                    if (wordSet.contains(textTmp) && !textSet.contains(textTmp)) {

                        List<String> copyList = new ArrayList<>(textList);
                        copyList.add(textTmp);

                        if (textTmp.equals(endWord)) {
                            if (minCount == -1) {
                                minCount = count + 1;
                            }
                            allList.add(copyList);

                        } else {
                            queue.add(new Word(textTmp, copyList, count + 1));
                        }

                    }
                }
            }
        }


        return allList;
    }

}
