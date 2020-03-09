package basic.threadStatus;

import java.util.concurrent.TimeUnit;

public class ThreadStatus {

    public static void main(String[] args) {
        // time_waiting
        new Thread(() -> {
            while(true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "timeWaiting").start();

        // waiting,
        new Thread(() -> {
            while(true) {
                synchronized (ThreadStatus.class) {
                    try {
                        ThreadStatus.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "waiting").start();

        new Thread(new BlockedDemo(), "BlockedDemo-01").start();
        new Thread(new BlockedDemo(), "BlockedDemo-02").start();

    }


    static class BlockedDemo extends Thread {
        public void run() {
            synchronized(BlockedDemo.class) {

                while(true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
