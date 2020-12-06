package Threades;

/**
 * Created by mari.avetisyan on 01/12/2020.
 */

class Producer<T> {
    final T[] arr;
    int currentIndex = 0;
    boolean isProducerFinished = false;
    private int upperThreshold;
    private int producedElementCount = 0;
    private int size;

    Producer(int size, int upperThreshold) {
        this.arr = (T[]) new Object[size];
        this.size = size;
        this.upperThreshold = upperThreshold;
    }

    void produced(T elem) {
        synchronized(arr) {
            while (currentIndex >= upperThreshold) {
                try {
                    arr.wait();
                } catch (InterruptedException ignored) {
                }
            }

            arr[currentIndex] = elem;
            System.out.println("Producer produced: " + arr[currentIndex]);
            currentIndex++;
            producedElementCount++;

            if(producedElementCount == size) {
                isProducerFinished = true;
            }

            arr.notify();
        }
    }
}

class Consumer<T> {
    private Producer producer = null;
    int lowerThreshold;

    Consumer(Producer producer, int lowerThreshold) {
        this.producer = producer;
        this.lowerThreshold = lowerThreshold;
    }

    T consumed() {
        synchronized(producer.arr) {
            while (producer.currentIndex <= lowerThreshold && !producer.isProducerFinished) {
                try {
                    producer.arr.wait();
                } catch (InterruptedException ignored) {
                }
            }

            producer.currentIndex--;
            T tmp = (T) producer.arr[producer.currentIndex];
            producer.arr[producer.currentIndex] = null;
            producer.arr.notify();
            return tmp;
        }
    }
}

public class MultipleElementProducerConsumer {

    public static void main(String[] args) {
        Producer producer = new Producer(10, 5);
        Consumer consumer = new Consumer(producer, 3);

        Thread thread1 = new Thread(() -> {
           for (int i = 0; i < 10; ++i) {
               producer.produced(i);
           }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                System.out.println("Consumer consumed: " + consumer.consumed());
            }
        });

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
