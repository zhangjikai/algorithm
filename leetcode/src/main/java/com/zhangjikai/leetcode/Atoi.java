package com.zhangjikai.leetcode;

/**
 * Created by ZhangJikai on 2017/2/16.
 */
public class Atoi {

    public int myAtoi(String str) {
        /*if(str == null || str.length() < 1) {
            return 0;
        }*/
        int start = '0';
        int end = '9';
        int whiteSpace = ' ';
        int posTag = '+';
        int negTag = '-';
        boolean posFlag = true;
        char numArr[] = str.toCharArray();
        int numBeginIndex = 0;
        long sum = 0;


        if(numArr.length > 0) {
            while (numArr[numBeginIndex] == whiteSpace) {
                numBeginIndex++;
            }
            if (numArr[numBeginIndex] == posTag) {
                posFlag = true;
                numBeginIndex++;
            } else if (numArr[numBeginIndex] == negTag) {
                posFlag = false;
                numBeginIndex++;
            }
        }

        for(int i = numBeginIndex; i < numArr.length; i++) {
            if(numArr[i] >= start && numArr[i] <= end) {
                sum *= 10;
                sum += (numArr[i] - start);
                if(sum > Integer.MAX_VALUE) {
                    if(posFlag) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                break;
            }
        }


        if(posFlag) {
            return (int) sum;
        } else {
            return -(int)sum;
        }
    }
    public int myAtoi2(String str) {
        int start = (int) '0';
        int end = (int) '9';
        int posTag = '+';
        int negTag = '-';
        int whiteSpace = ' ';
        boolean numStart = false;
        boolean signStart = false;
        int posSignValue = 1;
        long total = 0;
        long tmp = 0;
        long base = 1;
        boolean posFlag = true;
        boolean hasOver = false;
        char[] numArr = str.toCharArray();
        char[] validArr = new char[numArr.length];
        int validLength = 0;
        int i = 0;

        for (i = 0; i < numArr.length; i++) {

            if(numArr[i] == whiteSpace) {
                if(!numStart && !signStart) {
                    continue;
                }
            }
            if (numArr[i] == posTag) {
                if(numStart) {
                    break;
                } else {
                    if(signStart) {
                        return 0;
                    } else {
                        signStart = true;
                        continue;
                    }

                }

            }

            if (numArr[i] == negTag) {
                if(numStart) {
                    break;
                } else {
                    if(signStart) {
                        return 0;
                    } else {
                        signStart = true;
                        posFlag = false;
                        continue;
                    }

                }
            }

            if (numArr[i] >= start && numArr[i] <= end) {
                validArr[validLength++] = numArr[i];
                numStart = true;
                continue;
            }

            if(numStart) {
                break;
            } else {
                return 0;
            }
        }

        for (int j = validArr.length - 1; j >= 0; j--) {
            if (validArr[j] >= start && validArr[j] <= end) {

                tmp = (validArr[j] - start) * base;
                if (base > Integer.MAX_VALUE) {
                    hasOver = true;
                    break;
                }

                if (tmp > Integer.MAX_VALUE) {
                    hasOver = true;
                    break;
                }
                total += tmp;
                if (total > Integer.MAX_VALUE) {
                    hasOver = true;
                    break;
                }
                base *= 10;


            }

        }
        if (hasOver) {
            if (posFlag) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        if (posFlag) {
            return (int)total;
        } else {
            return (int)-total;
        }
    }

    public static void main(String[] args) {
        int value = new Atoi().myAtoi("");
        System.out.println(value);
        //System.out.println(Integer.MAX_VALUE * 10);
    }

}
