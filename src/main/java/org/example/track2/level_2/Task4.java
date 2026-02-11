package org.example.track2.level_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Задача 4. synchronized
 * Цель: устранить race condition
 * ТЗ:
 * Исправь задачу 3
 * Используй synchronized
 * Результат всегда должен быть корректным
 */

public class Task4 {

    private static int COUNTER = 0;

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(Task4::increment, "Thread #" + i);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(COUNTER);
    }

    private static synchronized void increment() {
        for (int j = 0; j < 1000; j++) {
            COUNTER++;
        }
    }
}
