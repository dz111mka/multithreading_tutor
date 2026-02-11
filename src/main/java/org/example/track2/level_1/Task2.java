package org.example.track2.level_1;

/**
 * Задача 2. Join и порядок выполнения
 * Цель: управление жизненным циклом потока
 * ТЗ:
 * Поток A печатает "A"
 * Поток B печатает "B"
 * Сделай так, чтобы B начал только после завершения A
 */

public class Task2 {

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + " печатает A");
            }
        });
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + " печатает B");
            }
        });

        threadA.start();
        threadA.join();
        threadB.start();
    }
}
