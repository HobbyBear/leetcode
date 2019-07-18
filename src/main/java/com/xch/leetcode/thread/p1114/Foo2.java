package com.xch.leetcode.thread.p1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 错误示范： 出现错误的原因在于如果线程1执行唤醒操作之后，线程2还没开始执行，由于唤醒只有一次，那么等到线程2执行的时候，线程2就会处于一直等待状态。
 */
class Foo2 {
    ReentrantLock lock = new ReentrantLock();
    Condition secondCondition = lock.newCondition();
    Condition thirdCondition = lock.newCondition();

    public Foo2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            printFirst.run();
            secondCondition.signal();
        } finally {
            lock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            secondCondition.await();
            printSecond.run();
            thirdCondition.signal();
            // printSecond.run() outputs "second". Do not change or remove this line.
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            thirdCondition.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
}
