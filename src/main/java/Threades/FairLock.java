package Threades;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mari.avetisyan on 05/12/2020.
 */
public class FairLock {
    private Queue<Thread> buffer = new LinkedList<Thread>();

    synchronized private void lock() {
        Thread currentThread = Thread.currentThread();

        if(buffer.size() == 0) {
            System.out.println(currentThread.getName() + " starting");
            buffer.add(currentThread);
        } else {
            while (!buffer.contains(currentThread)) {
                try {
                    buffer.add(currentThread);
                    System.out.println(currentThread.getName() + " waiting");
                    wait();
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    synchronized private void unlock() {
        Thread currentThread = Thread.currentThread();

        if(buffer.peek() == currentThread) {
            buffer.remove();
            notify();
        }

        System.out.println(currentThread.getName() + " finished");
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();

        Thread thread1 = new Thread(() -> {
            fairLock.lock();
            System.out.println("1");
            fairLock.unlock();
        });
        thread1.setName("Thread-1");

        Thread thread2 = new Thread(() -> {
            fairLock.lock();
            System.out.println("2");
            fairLock.unlock();
        });
        thread2.setName("Thread-2");

        Thread thread3 = new Thread(() -> {
            fairLock.lock();
            System.out.println("3");
            fairLock.unlock();
        });
        thread3.setName("Thread-3");

        Thread thread4 = new Thread(() -> {
            fairLock.lock();
            System.out.println("4");
            fairLock.unlock();
        });
        thread4.setName("Thread-4");

        Thread thread5 = new Thread(() -> {
            fairLock.lock();
            System.out.println("5");
            fairLock.unlock();
        });
        thread5.setName("Thread-5");

        Thread thread6 = new Thread(() -> {
            fairLock.lock();
            System.out.println("6");
            fairLock.unlock();
        });
        thread6.setName("Thread-6");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
