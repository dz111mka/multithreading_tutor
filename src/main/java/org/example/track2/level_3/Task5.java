package org.example.track2.level_3;

/**
 * Задача 5. Deadlock
 * Цель: понять почему deadlock возможен
 * ТЗ:
 * Создай 2 lock-объекта
 * 2 потока
 * Сделай намеренный deadlock
 * Опиши в комментарии, почему он происходит
 */

public class Task5 {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {

                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                synchronized (lock1) {

                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
