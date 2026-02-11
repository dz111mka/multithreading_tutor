package org.example.track2.level_1;

/**
 * Задача 1. Создание потоков
 * Цель: понять, что поток — это не магия
 * ТЗ:
 * Создай 2 потока
 * Первый печатает числа от 1 до 50
 * Второй — от 50 до 1
 * Запусти их параллельно
 * Запрещено:
 * ExecutorService
 * synchronized
 */

public class Task1 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                System.out.println(Thread.currentThread().getName() + " печатает " + i);
            }
        }, "asc printer");

        Thread thread2 = new MyThread();
        thread2.setName("desc printer");

        thread1.start();
        thread2.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 50; i >= 1; i--) {
            System.out.println(Thread.currentThread().getName() + " печатает " + i);
        }
    }
}
