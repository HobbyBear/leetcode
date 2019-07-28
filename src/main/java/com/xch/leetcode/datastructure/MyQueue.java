package com.xch.leetcode.datastructure;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 固定大小的队列
 * @author: xch
 * @create: 2019-07-18 17:15
 **/
public class MyQueue {

    private int[] arr;

    private int size;

    /**
     * 队头
     */
    private int head;

    /**
     * 队尾
     */
    private int tail = -1;

    public MyQueue(int capacity) {
        this.arr = new int[capacity];
    }

    public void put(int num) {
        if (size >= arr.length) {
            throw new RuntimeException("队列已满");
        }
        if (size == 0) {
            head = 0;
        }
        tail = tail >= arr.length - 1 ? 0 : tail + 1;
        arr[tail] = num;
        size++;
    }

    public int take() {
        if (size == 0){
            throw new RuntimeException("队列为空");
        }
        int res = arr[head];
        head = head >= arr.length - 1 ? 0 : head + 1;
        size--;
        return res;
    }

    public int size() {
        return this.size;
    }


    @Override
    public String toString() {
        return "MyQueue{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(3);
        IntStream.range(0, 3).forEach(myQueue::put);
        System.out.println(myQueue);
        System.out.println("拿出队首" + myQueue.take());
        System.out.println(myQueue);
        System.out.println("放入3");
        myQueue.put(3);
        System.out.println(myQueue);
    }
}
