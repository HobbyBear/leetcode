package com.xch.leetcode.thread.p1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    private int n;

    private Lock lock = new ReentrantLock();

    private Condition produceCondition = lock.newCondition();

    private Condition customerCondition = lock.newCondition();

    private volatile boolean produced = false;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (produced) {
                    produceCondition.await();

                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                produced = true;
                customerCondition.signal();
            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();

            try {
                if (!produced) {
                    customerCondition.await();

                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                produced = false;
                produceCondition.signal();
            } finally {
                lock.unlock();
            }

        }
    }
}