package org.example.double1.level_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Задача 8. Thread pool
 * Цель: ExecutorService
 * Создай пул из 4 потоков
 * Отправь 20 задач
 * Каждая задача печатает имя потока и номер задачи
 * Корректно заверши пул
 */

public class Task8 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 20; i++) {
            int taskNumber = i;
            service.submit(
                    () -> System.out.println(Thread.currentThread().getName() + " выполняет задачу " + taskNumber)
            );
        }
        service.shutdown();

    }
}
