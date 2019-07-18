package com.xch.leetcode.thread.p1116;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * 多线程唤醒操作的时候注意问题，如果唤醒只有一次，那么得仔细考虑被唤醒得线程等待的时机。
 */
class ZeroEvenOdd {

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        IntStream.range(0,3).forEach(i->{
            if (i ==0){
                new Thread(()->{
                    try {
                        zeroEvenOdd.zero(new IntConsumer());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }else if (i == 1){
                new Thread(()->{
                    try {
                        zeroEvenOdd.even(new IntConsumer());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }else {
                new Thread(()->{
                    try {
                        zeroEvenOdd.odd(new IntConsumer());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

        });
    }


    private int n;

    /**
     * 下次打印的数字是什么
     * 0, --0
     * 偶数,--2
     * 奇数,--1
     */
    private volatile int state;

    /**
     * 打印下个偶数还是奇数
     */
    private boolean printNextEven;

    private Lock lock = new ReentrantLock();

    private Condition zeroCondition = lock.newCondition();

    private Condition evenCondition = lock.newCondition();

    private Condition oddCondition = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
        //下次打印的数字为0
        this.state = 0;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (state != 0) {
                    if (state == 1) {
                        //打印完奇数后被唤醒
                        oddCondition.await();
                    }
                    if (state == 2) {
                        //打印完偶数后被唤醒
                        evenCondition.await();
                    }
                }
                printNumber.accept(0);
                if (printNextEven) {
                    printNextEven = false;
                    state = 2;
                } else {
                    printNextEven = true;
                    state = 1;
                }
                zeroCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 偶数
     * @param printNumber
     * @throws InterruptedException
     */
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i + 2) {
            lock.lock();
            try {
                while (state != 2) {
                    zeroCondition.await();
                }
                printNumber.accept(i);
                state = 0;
                evenCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 奇数
     * @param printNumber
     * @throws InterruptedException
     */
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {
            lock.lock();
            try {
                while (state != 1) {
                    zeroCondition.await();
                }
                printNumber.accept(i);
                state = 0;
                oddCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

}

class IntConsumer {
    public void accept(Integer i) {
        System.out.print(i);
    }
}
