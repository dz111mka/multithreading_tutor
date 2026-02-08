package org.example.level_2;

/**
 *Задача 4. Deadlock
*Цель: понять проблему
*Создай намеренный deadlock с двумя lock-объектами
*Опиши в комментарии, почему он возникает
**/

public class Task4 {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            while (true) {
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();

    }
}
