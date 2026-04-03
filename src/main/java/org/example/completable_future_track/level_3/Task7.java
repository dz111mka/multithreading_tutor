package org.example.completable_future_track.level_3;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * Задача 7
 * Асинхронно:
 * Получить число
 * Умножить на 2
 * Преобразовать в строку
 * Вывести
 * Используй цепочку thenApply → thenAccept.
 */

public class Task7 {

    public static void main(String[] args) {

        Random random = new Random();

        CompletableFuture
                .supplyAsync(random::nextInt)
                .thenApply(integer -> integer * 2)
                .thenApply(String::valueOf)
                .thenAccept(System.out::println)
                .join();
    }
}
