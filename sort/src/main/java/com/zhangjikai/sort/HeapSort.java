package com.zhangjikai.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangJikai on 2017/3/1.
 */
public class HeapSort<T extends Comparable> implements Sort<T> {
    @Override
    public List<T> sort(List<T> randomData) {
        HeapTree<T> heapTree = new HeapTree<>();
        List<T> results = new ArrayList<>();
        for (T t : randomData) {
            heapTree.insertNode(t);
        }
        int length = heapTree.getLength();
        for (int i = 0; i < length; i++) {
            results.add(heapTree.deleteMin());
        }
        return results;
    }

    class Node<T extends Comparable> implements Comparable<Node<T>> {
        private Node<T> leftChild;
        private Node<T> rightChild;
        private T value;

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }


        @Override
        public int compareTo(Node<T> o) {
            return value.compareTo(o.getValue());
        }
    }

    class HeapTree<T extends Comparable> {
        private List<T> array = new ArrayList<>();
        private int length = 0;

        public void insertNode(T value) {
            array.add(value);
            length++;
            int index = length;
            int childPos, parentPos;

            while (index > 0 && index / 2 > 0) {
                childPos = index - 1;
                parentPos = index / 2 - 1;
                if (array.get(parentPos).compareTo(array.get(childPos)) > 0) {
                    T tmp = array.get(parentPos);
                    array.set(parentPos, array.get(childPos));
                    array.set(childPos, tmp);
                }
                index /= 2;
            }
        }

        public T deleteMin() {

            if (length <= 0) {
                return null;
            }
            T min, last;
            min = array.get(0);
            last = array.get(length - 1);
            array.set(0, last);
            length--;

            int index = 1;
            int childPos;
            while (index < length && index * 2 <= length) {

                childPos = index * 2 - 1;
                if (childPos + 1 < length && array.get(childPos + 1).compareTo(array.get(childPos)) < 0) {
                    childPos++;
                }

                if (array.get(childPos).compareTo(last) < 0) {
                    array.set(index - 1, array.get(childPos));
                    index = childPos + 1;
                } else {
                    break;
                }
            }

            array.set(index - 1, last);
            return min;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }


}
