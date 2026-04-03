package org.example.completable_future_track.level_3;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Задача 8
 * Сделай имитацию 3 микросервисов:
 * userService
 * orderService
 * paymentService
 * Каждый async с задержкой.
 * Свяжи их в цепочку.
 */

public class Task8 {

    public static void main(String[] args) {

        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();

        List<CompletableFuture<Object>> completableFutures = List.of(CompletableFuture.supplyAsync(() -> {
            Object userObject = null;
            try {
                userObject = userService.doSmthUser();
            } catch (InterruptedException ignored) {
            }
            return userObject;
        }), CompletableFuture.supplyAsync(() -> {
            Object orderObject = null;
            try {
                orderObject = orderService.doSmthOrder();
            } catch (InterruptedException ignored) {
            }
            return orderObject;
        }), CompletableFuture.supplyAsync(() -> {
            Object paymentObject = null;
            try {
                paymentObject = paymentService.doSmthPayment();
            } catch (InterruptedException ignored) {
            }
            return paymentObject;
        }));

        for (CompletableFuture<Object> completableFuture : completableFutures) {
            completableFuture.join();
        }
    }

    static class UserService {
        Object doSmthUser() throws InterruptedException {
            Thread.sleep(1000);
            System.out.println("UserService is done");
            return new Object();
        }
    }

    static class OrderService {
        Object doSmthOrder() throws InterruptedException {
            Thread.sleep(2000);
            System.out.println("OrderService is done");
            return new Object();
        }
    }

    static class PaymentService {
        Object doSmthPayment() throws InterruptedException {
            Thread.sleep(1000);
            System.out.println("PaymentService is done");
            return new Object();
        }
    }
}
