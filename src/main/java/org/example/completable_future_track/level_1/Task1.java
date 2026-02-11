package org.example.completable_future_track.level_1;

import java.util.concurrent.CompletableFuture;

/**
 * Задача 1
 * Создай CompletableFuture, который возвращает число 10.
 * Выведи его результат.
 */

public class Task1 {

    public static void main(String[] args) {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10);
        Integer join = future.join();

        System.out.println(join);
    }
}
