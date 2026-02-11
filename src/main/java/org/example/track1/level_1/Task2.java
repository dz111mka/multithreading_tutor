package org.example.track1.level_1;

/**
 * *Задача 2. Последовательный вывод
 * Цель: join()
 * Один поток печатает "A" 10 раз
 * Второй — "B" 10 раз
 * В консоли сначала все A, потом все B
 **/

public class Task2 {
    public static void main(String[] args) throws InterruptedException{
        
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("A");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("B");
            }
        });

        thread1.start();
        thread1.join();
        thread2.start();
    }
}
