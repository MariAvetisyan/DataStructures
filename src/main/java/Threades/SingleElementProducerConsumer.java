package Threades;

/**
 * Created by mari.avetisyan on 01/12/2020.
 */
public class SingleElementProducerConsumer<T> {

    private T element = null;

    synchronized private T take() {
        try {
            while (element == null) {
                try {
                    wait();
                } catch (InterruptedException ignored) {
                }
            }

            T tmp = element;
            element = null;
            return tmp;
        } finally {
            notify();
        }
    }

    synchronized private void put(T elem) {
        while (element != null) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }

        element = elem;
        System.out.println("producer put: " + element);
        notify();
    }

    public static void main(String[] args) {
        SingleElementProducerConsumer<Integer> singleElementQueue = new SingleElementProducerConsumer<>();

        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 10; ++i) {
                singleElementQueue.put(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 10; ++i) {
                System.out.println("consumer take: " + singleElementQueue.take());
            }
        });

        thread1.start();
        thread2.start();
    }
}
