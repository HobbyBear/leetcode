package com.xch.leetcode.thread.p1117;

import java.util.concurrent.Semaphore;

class H2O {

    private Semaphore hSemaphore = new Semaphore(2);

    private Semaphore oSemaphore = new Semaphore(0);


    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        if (hSemaphore.availablePermits() == 0) {
            oSemaphore.release(1);
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire();
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        hSemaphore.release(2);

    }
}