package org.example.double1.level_2;

/**
 * Задача 5. Исправь deadlock
 * Цель: порядок блокировок
 * Возьми код из задачи 4
 * Исправь так, чтобы deadlock больше не возникал
 **/

public class Task5 {

    public final static Object tieLock = new Object();

    public static void main(String[] args) {

        Object resource1 = new Object();
        Object resource2 = new Object();

        Thread thread1 = new Thread(() -> doInOrder(resource1, resource2, () -> {
            System.out.println("Thread 1: Захватил оба ресурса");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread 1: Завершил работу");
        }));
        Thread thread2 = new Thread(() -> doInOrder(resource2, resource1, () -> {
            System.out.println("Thread 2: Захватил оба ресурса");
            System.out.println("Thread 2: Завершил работу");
        }));

        thread1.start();
        thread2.start();
    }

    public static void doInOrder(Object o1, Object o2, Runnable runnable) {
        int h1 = o1.hashCode();
        int h2 = o2.hashCode();

        if (h1 < h2) {
            synchronized (o1) {
                synchronized (o2) {
                    runnable.run();
                }
            }
        } else if (h2 < h1) {
            synchronized (o2) {
                synchronized (o1) {
                    runnable.run();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (o1) {
                    synchronized (o2) {
                        runnable.run();
                    }
                }
            }
        }
    }
}

/**
 * Как вариант в будущем еще попробовать разные варианты
 */
