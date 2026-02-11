package org.example.track2.level_4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Задача 8. BlockingQueue
 * Цель: готовые синхронизаторы
 * ТЗ:
 * Producer кладёт числа 1..100 в очередь
 * Consumer читает и печатает
 * Используй ArrayBlockingQueue
 * Запрещено: synchronized, wait, notify
 */

public class Task8 {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10, true);

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                queue.put(-1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        });

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    Integer take = queue.take();
                    if (take == -1) break;
                    System.out.println(take);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
