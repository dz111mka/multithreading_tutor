package org.example.level_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Задача 3. Счётчик
 * Цель: synchronized
 * Есть Counter с полем int value
 * 10 потоков увеличивают счётчик по 1000 раз
 * Итоговое значение должно быть 10000
 * ❗ Без AtomicInteger
 **/

public class Task3 {

    public static int value = 0;

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                inc();
            }
        };

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        System.out.println(value);

    }
    public static synchronized void inc() {
        value++;
    }
}
