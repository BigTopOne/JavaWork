package j_4_11;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.StreamSupport;

public class WaitNotify {
    static boolean flag = true;

    static Object lock = new Object();

    public static void main(String[] args) {




       double a =  5340.90
                +6357.12+9659.97
                +21170.23
                +21170.23
                +21359.09
                +23493.09
                +21777.92
                +27677.79
                +22520.13
                +22783.14
                +22767.59
                +22311.42;

        System.out.println("a :"+a);


        Runnable target;
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();

    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            // 加锁，拥有 lock 的 Monitor
            synchronized (lock) {
                // 当条件不满足时，继续 wait，同时释放了 lock；
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true,wait @ " + DateUtils.getCurrTime());
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 条件满足时，完成工作；
                System.out.println(Thread.currentThread() + " flag is false. running @ " + DateUtils.getCurrTime());
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                // 获取 lock 的锁，然后进行通知，通知时，不会释放lock 的锁，
                // 直到当前线程释放了 lock 以后，WaitThread 才能从 wait 方法中返回；
                System.out.println(Thread.currentThread() + " hold lock ,notify @ " + DateUtils.getCurrTime());
                lock.notifyAll();
                flag = false;
            }

            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread() + " hold lock again ,sleep @ " + DateUtils.getCurrTime());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
