package com.zhangjikai.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhangJikai on 2017/2/27.
 */
public class LetterCombinationOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return results;
        }
        char[] digitArray = digits.toCharArray();

        if (digitArray.length <= 0) {
            return results;
        }
        if (digits.contains("1") || digits.contains("0")) {
            return results;
        }
        List<char[]> mapList = new ArrayList<>();
        char base = 'a';
        char[] array;
        for (int i = 2; i <= 9; i++) {
            if(i == 7 || i == 9) {
                array = new char[4];
                array[0] = base++;
                array[1] = base++;
                array[2] = base++;
                array[3] = base++;
                mapList.add(array);
                continue;
            }
            array = new char[3];
            array[0] = base++;
            array[1] = base++;
            array[2] = base++;
            mapList.add(array);

        }



        array = mapList.get(digitArray[0]-'2');

        for (int i = 0; i < array.length; i++) {
            String s = "" + array[i];
            recuCal(results, s, 0, digitArray, mapList);
        }

        /*for(int i = 0; i < digitArray.length; i++) {

        }*/
        return results;
    }


    public void recuCal(List<String> results, String resStr, int index, char[] listArray, List<char[]> mapList) {
        index++;
        if (index > listArray.length - 1) {
            results.add(resStr);
            return;
        }


        char[] array = mapList.get(listArray[index]-'2');

        for(int i = 0; i < array.length; i++) {
            String s  =  resStr + array[i];
            recuCal(results, s, index, listArray, mapList);
        }
    }

    public static void main(String[] args) {
        List<String> results = new LetterCombinationOfPhoneNumber().letterCombinations("23");
        System.out.println(results);
        //System.out.println('a' - 0);
    }

}
