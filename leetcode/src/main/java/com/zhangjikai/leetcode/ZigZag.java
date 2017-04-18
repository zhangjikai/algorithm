package com.zhangjikai.leetcode;

/**
 * Created by ZhangJikai on 2017/2/14.
 */
public class ZigZag {
    public String convert(String s, int numRows) {
        StringBuilder builderArray[] = new StringBuilder[numRows];
        for (int i = 0; i < builderArray.length; i++) {
            builderArray[i] = new StringBuilder();
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        int index = 0;
        while (index < length) {
            for(int i = 0; i < numRows && index < length; i++) {
                builderArray[i].append(chars[index++]);
            }
            for(int i = numRows -2; i >= 1 && index < length; i--) {
                builderArray[i].append(chars[index++]);
            }
        }

        StringBuilder convertBuilder = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            convertBuilder.append(builderArray[i].toString());
        }
        return convertBuilder.toString();
    }


    public String convert2(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        char tmp[][] = new char[numRows][s.length()];
        int rowIndex = 0, columnIndex = 0;
        int index = 0;
        int calRowNums;
        boolean oddCol = true;
        char initChar = (char) 0;
        calRowNums = numRows;


        if (numRows == 2) {
            for (int i = 0; i < s.length(); i++) {
                tmp[rowIndex][columnIndex] = s.charAt(i);

                index++;
                rowIndex++;
                if (index >= calRowNums) {
                    columnIndex++;
                    rowIndex = 0;
                    calRowNums = numRows;
                    index = 0;
                }
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                tmp[rowIndex][columnIndex] = s.charAt(i);
                if (oddCol) {
                    index++;
                    rowIndex++;
                    if (index >= calRowNums) {
                        columnIndex++;
                        rowIndex = numRows - 2;
                        calRowNums = numRows - 2;
                        index = calRowNums;
                        oddCol = false;
                    }

                } else {
                    index--;
                    rowIndex--;
                    if (index <= 0) {
                        columnIndex++;
                        rowIndex = 0;
                        calRowNums = numRows;
                        index = 0;
                        oddCol = true;

                    }
                }
            }
        }


        char convertChars[] = new char[s.length()];
        index = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (tmp[i][j] != initChar) {
                    convertChars[index++] = tmp[i][j];

                }
            }
        }
        return String.valueOf(convertChars);
    }

    public static void main(String[] args) {
        String s = new ZigZag().convert("A", 2);
        System.out.println(s);
    }
}
