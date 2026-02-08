package org.example.level_3;

/**
 * Задача 6. Producer / Consumer
 * Цель: wait() / notifyAll()
 * Один поток производит числа от 1 до 100
 * Второй — потребляет и печатает
 * Буфер размером 1 элемент
 * ❗ Без BlockingQueue
 */

public class Task6 {

    public static void main(String[] args) {

        Buffer buffer = new Buffer(null);

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                try {
                    buffer.put(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                try {
                    System.out.println(buffer.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}

class Buffer {

    private Integer value;
    private Boolean hasValue;

    public Buffer(Integer value) {
        this.value = null;
        this.hasValue = value != null;
    }

    public synchronized void put(Integer integer) throws InterruptedException {
        while (hasValue) {
            wait();
        }
        value = integer;
        hasValue = true;
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (!hasValue) {
            wait();
        }
        int result = value;
        value = null;
        hasValue = false;
        notifyAll();
        return result;
    }
}
