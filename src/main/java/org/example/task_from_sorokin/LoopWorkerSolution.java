package org.example.task_from_sorokin;

/**
 * Роль: долгоживущий цикл с кооперативным завершением через interrupt()
 * Конуструктор: LoopWorker(String name) - задает имя потока
 * Методы/поведение:
 * - void start() - запускает внутренний Thread (user-thread)
 * - stopAsync() - вызываеь thread.interrupt()
 * - цикл раз в ~200-300 мс инкремент локального счетчика, лог состояния
 * <br>
 * Если пойман InterruptedException, восстановить флаг (Thread.currentthread().interrupt()) и выйти из цикла
 * Если Thread.interrupted() стал true - тоже выйти. Никаких пустых catch
 * <br>
 * Ожидаем: воркер корректно остановился и закончил работу при прерывании
 * Подниминте LoopWorker("worker-1"), дайте поработать 1.5 - 2.0 секунды, затем stopAsync() ->
 * поток должен закончится сам (восстанавлиявая флаг после interruptedException)
 */

public class LoopWorkerSolution {

    public static void main(String[] args) throws InterruptedException {
        LoopWorker loopWorker = new LoopWorker("worker-1");
        loopWorker.start();
        Thread.sleep(2000);
        loopWorker.stopAsync();
    }
}

class LoopWorker {
    private static int counter = 0;
    private final Thread thread;

    public LoopWorker(String name) {
        this.thread = new Thread(this::doWork, name);
    }

    public void start() {
        System.out.println(Thread.currentThread().getName() + " начал работу");
        thread.start();
    }

    public void doWork() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(10);
                counter++;
                System.out.println(Thread.currentThread().getName() + " увеличил счетчик и теперь он равен = " + counter);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void stopAsync() {
        System.out.println(Thread.currentThread().getName() + " закончил работу");
        this.thread.interrupt();
    }
}



