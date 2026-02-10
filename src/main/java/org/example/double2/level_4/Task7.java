package org.example.double2.level_4;

/**
 * Задача 7. wait / notify
 * Цель: условная синхронизация
 * ТЗ:
 * Два потока печатают числа от 1 до 100
 * Один — только нечётные
 * Второй — только чётные
 * Строго по порядку
 */

public class Task7 {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Thread threadOdd = new Thread(() -> {
            try {
                buffer.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "ThreadOdd");

        Thread threadEven = new Thread(() -> {
            try {
                buffer.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "ThreadEven");

        threadOdd.start();
        threadEven.start();
    }
}

class Buffer {
    private int value = 1;
    private int max = 100;

    // методы wait(), notify() и notifyAll() работают только в блоке synchronized
    public synchronized void printOdd() throws InterruptedException {
        while (value < max) {
            while (value % 2 == 0) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " печатает " + value);
            value++;
            notifyAll();
        }
    }

    public synchronized void printEven() throws InterruptedException {
        while (value < max) {
            while (value % 2 != 0) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " печатает " + value);
            value++;
            notifyAll();
        }
    }
}
