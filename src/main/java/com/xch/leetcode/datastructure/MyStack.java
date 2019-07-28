package com.xch.leetcode.datastructure;

/**
 * 固定大小的栈
 *
 * @author: xch
 * @create: 2019-07-22 11:49
 **/
public class MyStack {

    private int[] arr;

    private int capacity;
    /**
     * 栈的大小
     */
    private int size;

    /**
     * 栈头
     */
    private int head;


    public MyStack(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
        this.head = -1;
    }





}
