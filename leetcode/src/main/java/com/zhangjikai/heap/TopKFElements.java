package com.zhangjikai.heap;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Created by zhangjk on 2017/7/7.
 */
public class TopKFElements {

    class Element {
        Element(int key, int count) {
            this.key = key;
            this.count = count;
        }

        int key;
        int count;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null) {
            return new ArrayList<>();
        }

        List<Integer> results = new ArrayList<>();
        Map<Integer, Element> map = new HashMap<>();
        Element element;
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                element = map.get(nums[i]);
                element.count += 1;
            } else {
                element = new Element(nums[i], 1);
                map.put(nums[i], element);
            }
        }

        PriorityQueue<Element> priorityQueue = new PriorityQueue<>(k, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.count - o2.count;
            }
        });

        for (Element ele : map.values()) {
            if(priorityQueue.size() < k) {
                priorityQueue.add(ele);
            } else {
                Element top = priorityQueue.peek();
                if(top.count < ele.count) {
                    priorityQueue.poll();
                    priorityQueue.add(ele);
                }
            }


        }

        for (int i = 0; i <k; i++) {
            results.add(priorityQueue.poll().key);
        }

        List<Integer> resultCpy = new ArrayList<>();
        for(int i = results.size() - 1; i >= 0; i--) {
            resultCpy.add(results.get(i));
        }
        return resultCpy;
    }

    public static void main(String[] args) {
        System.out.println(new TopKFElements().topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2));
    }
}
