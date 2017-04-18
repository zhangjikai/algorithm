package com.zhangjikai.leetcode;

import java.util.*;

/**
 * Created by ZhangJikai on 2017/2/21.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) {

            return results;
        }
        /*for (int i = 0; i < nums.length; i++) {
            copyIntegers.add(nums[i]);
        }*/
        //Collections.sort(copyIntegers);


        //

        Arrays.sort(nums);
        twoSum(results, nums, 1, nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(results, nums, i + 1, nums[i]);
        }
        return results;
    }

    public void twoSum(List<List<Integer>> results, int[] nums, int start, int target) {

        int sum;
        int targetTmp = -target;
        int a, a2;
        for (int i = start, j = nums.length - 1; i < j; ) {


            if (i > start && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            if (j < nums.length - 1 && nums[j] == nums[j+1]) {
                j--;
                continue;
            }

            sum = nums[i] + nums[j];

            if (sum > targetTmp) {
                j--;
                continue;
            }

            if (sum < targetTmp) {
                i++;
                continue;
            }


            List<Integer> integers = new ArrayList<>();
            integers.add(target);
            integers.add(nums[i]);
            integers.add(nums[j]);
            results.add(integers);
            i++;
            j--;
        }

    }

    public List<List<Integer>> threeSum3(int[] nums) {

        Map<Integer, Integer> objectMap = new HashMap<>();
        Set<String> stringSet = new HashSet<>();
        List<Integer> copyIntegers = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            copyIntegers.add(nums[i]);
        }
        Collections.sort(copyIntegers);

        int tmp = 0;
        List<Integer> integers;

        String key;

        int index;
        int num, num2;


        for (int i = 0; i < copyIntegers.size(); i++) {
            objectMap.put(copyIntegers.get(i), i);
        }

        for (int i = 0; i < copyIntegers.size(); i++) {
            num = copyIntegers.get(i);
            if (num > 0) {
                break;
            }
            for (int j = copyIntegers.size() - 1; j > i; j--) {
                num2 = copyIntegers.get(j);
                if (num2 < 0) {
                    break;
                }

                tmp = -(num + num2);
                if (objectMap.containsKey(tmp)) {
                    index = objectMap.get(tmp);
                    if (index != i && index != j) {
                        integers = new ArrayList<>();
                        integers.add(num);
                        integers.add(num2);
                        integers.add(tmp);
                        if (tmp >= num2) {
                            key = String.valueOf(num) + String.valueOf(num2);
                        } else if (tmp < num) {
                            key = tmp + String.valueOf(num);
                        } else {
                            key = String.valueOf(num) + tmp;
                        }


                        if (!stringSet.contains(key)) {
                            stringSet.add(key);
                            resultList.add(integers);
                        }
                    }
                }
            }
        }
        return resultList;
    }

    public List<List<Integer>> threeSum2(int[] nums) {


        Map<Integer, Integer> objectMap = new HashMap<>();
        Map<String, List<Integer>> numMap = new HashMap<>();
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            objectMap.put(nums[i], i);
        }

        int tmp = 0;
        List<Integer> integers;
        String key;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                tmp = nums[i] + nums[j];
                tmp = -tmp;

                if (objectMap.containsKey(tmp) && objectMap.get(tmp) != i && objectMap.get(tmp) != j) {
                    integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[j]);
                    integers.add(tmp);
                    Collections.sort(integers);
                    key = "" + integers.get(0) + integers.get(1) + integers.get(2);
                    if (!numMap.containsKey(key)) {
                        numMap.put(key, integers);
                        resultList.add(integers);
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ThreeSum().threeSum(new int[]{});
        System.out.println(result);



        /*for (int i = 0; i < a.length() && i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                System.out.println(i);
                System.out.println(a.substring(i - 50, i + 50));
                System.out.println(b.substring(i - 50, i + 50));
                break;
            }
        }*/



        //System.out.println(a.equals(b));

        /*for (int i = 0; i < a.length() && i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                System.out.println(i);
                System.out.println(a.substring(i - 50, i + 50));
                System.out.println(b.substring(i - 50, i + 50));
                break;
            }
        }*/
    }
}
