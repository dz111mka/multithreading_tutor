package org.example.completable_future_track.level_1;

import java.util.concurrent.CompletableFuture;

/**
 Асинхронно верни число 5.
 Умножь его на 2 через thenApply.
 */

public class Task2 {

    public static void main(String[] args) {

        CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> 5)
                .thenApply(integer -> integer * 2);

        Integer join = future.join();
        System.out.println(join);
    }
}
