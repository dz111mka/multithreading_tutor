package org.example.double2.level_3;

import org.example.double2.level_2.Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Задача 6. ReentrantLock
 * Цель: альтернатива synchronized
 * ТЗ:
 * Перепиши задачу 4
 * Используй ReentrantLock
 * Обязательно try / finally
 */

public class Task6 {

    private static int COUNTER = 0;

    private static final Lock LOCK = new ReentrantLock(true); // true в конструкторе означение справедливую блокировку

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(Task6::increment, "Thread #" + i);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(COUNTER);
    }

    private static void increment() {
        LOCK.lock();
        // блок try обязателен при использовании ReentrantLock
        try {
            for (int j = 0; j < 1000; j++) {
                COUNTER++;
            }
        } finally {
            LOCK.unlock();
        }
    }
}
