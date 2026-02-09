package org.example.level_3;

/**
 Задача 7. Чёт / Нечёт
 Цель: координация потоков
 Два потока:
 первый печатает чётные
 второй — нечётные
 Вывод строго:
 1 2 3 4 5 ... 100
 */

public class Task7 {

    public static void main(String[] args) {
        BufferOrder buffer = new BufferOrder();

        Thread threadOdd = new Thread(() -> {
            try {
                buffer.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadEven = new Thread(() -> {
            try {
                buffer.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadOdd.start();
        threadEven.start();

    }
}

class BufferOrder {
    private int value = 1;
    private int max = 100;

    public synchronized void printOdd() throws InterruptedException {
        while (value < max) {
            while (value % 2 == 0) {
                wait();
            }
            System.out.println("Поток №1 выводит значение " + value);
            value++;
            notifyAll();
        }
    }

    public synchronized void printEven() throws InterruptedException {
        while (value <= max) {
            while (value % 2 != 0) {
                wait();
            }
            System.out.println("Поток №2 выводит значение " + value);
            value++;
            notifyAll();
        }
    }
}
