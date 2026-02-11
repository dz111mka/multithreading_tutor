package org.example.track1.level_1;

/**
*Уровень 1 — база потоков
*Задача 1. Два потока
*Цель: понять Thread и Runnable.
*Создай 2 потока
*Первый печатает числа от 1 до 100
*Второй — от 100 до 1
*Гарантии порядка не нужны
*Ожидаю:
*Thread, Runnable, start() (не run() 😈)
**/

public class Task1 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(()-> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("Поток №1 выводит: " + i);
            }
        });

        Thread thread2 = new Thread(()-> {
            for (int i = 100; i >= 1; i--) {
                System.out.println("Поток №2 выводит: " + i);
            }
        });

        thread1.start();
        thread2.start();

    }
}
