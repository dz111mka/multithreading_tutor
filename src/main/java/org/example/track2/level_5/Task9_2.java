package org.example.track2.level_5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Задача 9. ExecutorService + Future
 * Цель: асинхронные вычисления
 * ТЗ:
 * Создай пул из 4 потоков
 * Отправь 10 задач
 * Каждая задача возвращает факториал числа
 * Собери и выведи сумму результатов
 */

public class Task9_2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<Long>> futures = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            Future<Long> submit = executorService.submit(() -> {
                return factorialIterativeWithResult(finalI);
            });

            futures.add(submit);
        }

        long result = 0;
        for (Future<Long> future : futures) {
            result = result + future.get();
        }

        executorService.shutdown();

        System.out.println(result);
    }

    public static long factorialIterativeWithResult(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
