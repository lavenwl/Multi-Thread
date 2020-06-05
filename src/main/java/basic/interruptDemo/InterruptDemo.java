package basic.interruptDemo;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {
    private static int i;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("before1:" + Thread.currentThread().isInterrupted());
                    Thread.interrupted();
                    System.out.println("after1:" + Thread.currentThread().isInterrupted());
                    Thread thread2 = new Thread(() -> {
                        while (true) {
                            if (Thread.currentThread().isInterrupted()) {
                                System.out.println("before2:" + Thread.currentThread().isInterrupted());
                                Thread.interrupted();
                                System.out.println("after2:" + Thread.currentThread().isInterrupted());

                            }
                        }
                    }, "interruptDemo2");
                }
            }
        }, "interruptDemo");



        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
