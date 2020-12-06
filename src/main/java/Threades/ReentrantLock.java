package Threades;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by mari.avetisyan on 05/12/2020.
 */
public class ReentrantLock {
    private AtomicStampedReference<Thread> atomicStampedReference = new AtomicStampedReference<Thread>(null, 0);

    private void lock() {
        Thread currentThread = Thread.currentThread();

        while(true) {
            int currentThreadLockCount = atomicStampedReference.getStamp();
            if(currentThreadLockCount == 0) {
                if(atomicStampedReference.compareAndSet(null, currentThread, 0, 1)) {
                    break;
                }
            } else {
                if (atomicStampedReference.compareAndSet(currentThread, currentThread, currentThreadLockCount, currentThreadLockCount + 1)) {
                    break;
                }
            }
        }
    }

    private void unlock() {
        Thread currentThread = Thread.currentThread();

        while(true) {
            int currentThreadLockCount = atomicStampedReference.getStamp();
            if(currentThreadLockCount == 1) {
                if(atomicStampedReference.compareAndSet(currentThread, null, 1, 0)) {
                    break;
                }
            } else {
                if (atomicStampedReference.compareAndSet(currentThread, currentThread, currentThreadLockCount, currentThreadLockCount - 1)) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            reentrantLock.lock();
            for(int j = 0; j < 10; ++j) {
                System.out.println("thread1: " + j);
            }
            reentrantLock.unlock();
        });

        Thread thread2 = new Thread(() -> {
            reentrantLock.lock();
            for(int j = 0; j > -10; --j) {
                System.out.println("thread2: " + j);
            }
            reentrantLock.unlock();
        });

        thread1.start();
        thread2.start();
    }
}
