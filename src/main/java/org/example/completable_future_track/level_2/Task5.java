package org.example.completable_future_track.level_2;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Создай 5 CompletableFuture.
 * Используй allOf.
 * После завершения посчитай сумму.
 */

public class Task5 {

    public static void main(String[] args) {

        CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> 1);
        CompletableFuture<Integer> future1 = CompletableFuture
                .supplyAsync(() -> 2);
        CompletableFuture<Integer> future2 = CompletableFuture
                .supplyAsync(() -> 3);
        CompletableFuture<Integer> future3 = CompletableFuture
                .supplyAsync(() -> 123);
        CompletableFuture<Integer> future4 = CompletableFuture
                .supplyAsync(() -> 421);

        CompletableFuture<Integer> future5 = CompletableFuture.allOf(future, future1, future2, future3, future4)
                .thenApply(v ->
                        future.join() + future1.join() + future2.join() + future3.join() + future4.join()
                );
        System.out.println(future5.join());

    }
}
