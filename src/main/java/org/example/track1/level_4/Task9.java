package org.example.track1.level_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Задача 9. Callable + Future
 * Цель: результат из потока
 * 10 задач считают факториал чисел от 1 до 10
 * Собери результаты
 * Выведи сумму всех факториалов
 */

public class Task9 {

    private static Long result = 0L;

    public static void main(String[] args) {


        try (ExecutorService service = Executors.newFixedThreadPool(10)) {

            for (int i = 0; i < 10; i++) {
                int factorial = i;
                service.submit(
                        () -> {
                            result = result + getFactorial(factorial);
                            return result;
                        }
                );
            }
        }

        System.out.println(result);
    }

    public static int getFactorial(int f) {
        if (f <= 1) {
            return 1;
        }
        else {
            return f * getFactorial(f - 1);
        }
    }
}


