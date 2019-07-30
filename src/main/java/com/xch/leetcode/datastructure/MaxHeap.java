package com.xch.leetcode.datastructure;

import java.util.stream.IntStream;

/**
 * 最大堆
 * 数组构建的最大堆   节点索引i的父节点  索引值为(i-1)/2
 *
 * @author: xch
 * @create: 2019-07-28 12:22
 **/
public class MaxHeap {

    private int[] arr;

    private int capacity;

    private int size;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void add(int num) {
        if (size == capacity) {
            throw new RuntimeException("堆已满");
        }
        if (size == 0) {
            arr[++size - 1] = num;
            return;
        }
        arr[++size - 1] = num;
        shiftUp(size - 1);
    }


    public int offer() {
        if (size <= 0) {
            throw new RuntimeException("堆为空");
        }
        int res = arr[0];
        arr[0] = arr[size-- - 1];
        shiftDown(0);
        return res;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        IntStream.range(0, size).forEach(i -> {
            sb.append(arr[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        });
        sb.append("]");
        return sb.toString();
    }

    private void shiftDown(int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = (index + 1) * 2;
        if (leftIndex > size - 1) {
            //没有左节点
            return;
        }
        if (rightIndex > size - 1 && leftIndex <= size - 1) {
            //只有左节点
            if (arr[leftIndex] > arr[index]) {
                int num = arr[leftIndex];
                arr[leftIndex] = arr[index];
                arr[index] = num;
            }
            return;
        }
        //左右节点都有
        if (arr[leftIndex] >= arr[rightIndex]) {
            if (arr[leftIndex] > arr[index]) {
                int num = arr[leftIndex];
                arr[leftIndex] = arr[index];
                arr[index] = num;
                shiftDown(leftIndex);
            }
        } else {
            if (arr[rightIndex] > arr[index]) {
                int num = arr[rightIndex];
                arr[rightIndex] = arr[index];
                arr[index] = num;
                shiftDown(rightIndex);
            }
        }
    }


    private void shiftUp(int index) {
        if (index == 0) {
            return;
        }
        if (arr[(index - 1) / 2] >= arr[index]) {
            return;
        }
        int num = arr[index];
        arr[index] = arr[(index - 1) / 2];
        arr[(index - 1) / 2] = num;
        shiftUp((index - 1) / 2);
    }


    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(5);
        IntStream.range(0, 5).forEach(i -> {
            System.out.println(i);
            maxHeap.add(i);
        });
        System.out.println(maxHeap);
        System.out.println("取出" + maxHeap.offer());
        System.out.println(maxHeap);
    }
}
