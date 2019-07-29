package com.xch.leetcode.datastructure;

/**
 * 固定大小的栈
 *
 * @author: xch
 * @create: 2019-07-22 11:49
 **/
public class MyStack {

    private int[] arr;

    /**
     * 栈的容量
     */
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

    public void put(int num) {
        if (size == capacity) {
            throw new RuntimeException("栈已满");
        }
        head = head + 1 == capacity ? 0 : head + 1;
        arr[head] = num;
        size++;
    }

    /**
     * 出栈
     *
     * @return
     */
    public int offer() {
        int res = arr[head];
        head = head == 0 ? capacity - 1 : head - 1;
        size--;
        return res;
    }


    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.put(1);
        myStack.put(2);
        System.out.println("stack 的大小是:" + myStack.getSize());
        int num = myStack.offer();
        System.out.println("取出" + num + "后的大小是" + myStack.getSize());
        myStack.put(3);
        System.out.println(myStack.offer());
        System.out.println(myStack.offer());
    }

}
