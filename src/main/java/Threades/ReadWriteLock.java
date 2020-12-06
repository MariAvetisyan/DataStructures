package Threades;

/**
 * Created by mari.avetisyan on 05/12/2020.
 */

public class ReadWriteLock {
    private int readCount = 0;
    private int writeCount = 0;

    synchronized private void readLock() {
        while (writeCount != 0) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }

        readCount++;
    }

    synchronized private void readUnlock() {
        readCount--;
        notifyAll();
    }

    synchronized private void writeLock() {
        while(readCount != 0) {
            try {
                wait();
            } catch (InterruptedException ignored) {

            }
        }

        writeCount++;
    }

    synchronized private void writeUnlock() {
        writeCount--;
        notifyAll();
    }

    public static void main(String[] args) {
        ReadWriteLock customReadWriteLock = new ReadWriteLock();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; ++i) {
                customReadWriteLock.writeLock();
                System.out.println("I am writing");
                customReadWriteLock.writeUnlock();
            }
        });

        Thread thread2 = new Thread(() -> {
            customReadWriteLock.readLock();
            for (int i = 0; i < 15; ++i) {
                System.out.println("I am reading");
            }
            customReadWriteLock.readUnlock();
        });

        thread1.start();
        thread2.start();
    }
}
