package org.example.double2.level_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Задача 9. ExecutorService + Future
 * Цель: асинхронные вычисления
 * ТЗ:
 * Создай пул из 4 потоков
 * Отправь 10 задач
 * Каждая задача возвращает факториал числа
 * Собери и выведи сумму результатов
 */

public class Task9 {

    public static AtomicLong COUNTER = new AtomicLong(0L);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            executorService.submit(() -> {
                long l = factorialIterative(finalI);
                COUNTER.addAndGet(l);
            });
        }
        executorService.shutdown();
        System.out.println(COUNTER);
    }

    public synchronized static long factorialIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал определен только для неотрицательных чисел");
        }

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
