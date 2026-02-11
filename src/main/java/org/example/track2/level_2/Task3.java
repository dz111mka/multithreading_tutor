package org.example.track2.level_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Задача 3. Race condition
 * Цель: увидеть проблему shared state
 * ТЗ:
 * Есть counter = 0
 * 10 потоков увеличивают его 1000 раз
 * Выведи итог
 * Убедись, что результат иногда неправильный
 */

public class Task3 {
    
    private static int COUNTER = 0;

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    COUNTER++;
                }
            }, "Thread #" + i);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(COUNTER);
    }
}
