package org.example.completable_future_track.level_1;

import java.util.concurrent.CompletableFuture;

/**
 Задача 3

 Запусти async-задачу с задержкой 1 сек.
 После завершения выведи "Done" через thenRun.
 */

public class Task3 {

    public static void main(String[] args) {

        CompletableFuture<Void> done = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                        return 5;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .thenRun(() -> {
                    System.out.println("Done");
                });

        done.join();
    }
}
