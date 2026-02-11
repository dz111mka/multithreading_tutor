package org.example.completable_future_track.level_2;

import java.util.concurrent.CompletableFuture;

/**
 * Задача 4
 * Создай два async вычисления:
 * одно возвращает 10
 * второе возвращает 20
 * Сложи их через thenCombine.
 */

public class Task4 {

    public static void main(String[] args) {
        Integer join = CompletableFuture
                .supplyAsync(() -> 10)
                .thenCombine(
                        CompletableFuture
                                .supplyAsync(() -> 20),
                        Integer::sum
                )
                .join();

        System.out.println(join);
    }
}
