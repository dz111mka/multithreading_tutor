package org.example.double1.level_2;

/**
 * Задача 4. Deadlock
 * Цель: понять проблему
 * Создай намеренный deadlock с двумя lock-объектами
 * Опиши в комментарии, почему он возникает
 **/

public class Task4 {

    public static void main(String[] args) throws InterruptedException {

        Object o1 = new Object();
        Object o2 = new Object();

        Thread thread1 = new Thread(() -> {
            int i1 = 0;
            synchronized (o1) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 1: " + i);
                    i1 = i1 + i;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Ожидание взять o2");
                    synchronized (o2) {
                        System.out.println("Взял o2");
                        System.out.println(i1);
                    }
                }
            }

        });
        Thread thread2 = new Thread(() -> {
            int i2 = 0;
            synchronized (o2) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 2: " + i);
                    i2 = i2 + i;
                }

                System.out.println("Ожидание взять o1");
                synchronized (o1) {
                    System.out.println("Взял o1");
                    System.out.println(i2);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

/* Дедлок происходит потому что первый поток не отпустив первый лок, пытается захватить второй, но не может этого сделать, так как второй поток захватил второй лок, а также не может его отпустить пока не захватит первый, что привело к зацикленности
*/