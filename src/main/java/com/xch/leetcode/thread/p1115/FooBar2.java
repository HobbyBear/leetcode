package com.xch.leetcode.thread.p1115;

import java.util.concurrent.Semaphore;

/**
 * @author: xch
 * @create: 2019-07-18 15:17
 **/
public class FooBar2 {
    private int n;

    private Semaphore fooSemaphore = new Semaphore(0);

    private Semaphore barSemaphore = new Semaphore(1);

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            fooSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            barSemaphore.release();
        }
    }
}
