package org.example.track2.level_5;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 🔥 Задача 10 — CompletableFuture orchestration
 * 🎯 Цель
 * Научиться:
 * запускать несколько async-задач
 * комбинировать их
 * обрабатывать ошибки
 * работать с allOf
 * не блокироваться лишний раз
 * 📜 ТЗ
 * Есть список чисел от 1 до 10.
 * Для каждого числа асинхронно:
 * вычислить факториал
 * сделать искусственную задержку 200–500 мс (имитация I/O)
 * Если число равно 5 — выбросить исключение (проверка error handling).
 * Все задачи должны выполняться параллельно.
 * Нужно:
 * собрать все успешные результаты
 * проигнорировать упавшие задачи
 * посчитать сумму
 * Использовать:
 * CompletableFuture.supplyAsync
 * exceptionally
 * allOf
 * thenApply
 * ❌ Нельзя использовать Future
 * ❌ Нельзя использовать Atomic
 * ❌ Нельзя использовать synchronized
 */

public class Task10 {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
    }

    public static long factorialIterativeWithResult(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
