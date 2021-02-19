import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.LockSupport;

public class T11_MyBuffer {
    static volatile Stack<Integer> rawData = new Stack<Integer>();
    static UseThread useThread = new UseThread();
    static WorkThread workThread = new WorkThread();

    public static void main(String[] args) {
        workThread.start();
        useThread.start();

    }


    static class UseThread extends Thread {
        @Override
        public void run() {
            for (; ; ) {

                if (rawData.size() <= 0) {
                    LockSupport.unpark(workThread);
                    System.out.println("UseThread 锁住， workThread 开始add....");
                    LockSupport.park();
                    continue;
                }
                Integer pop = rawData.pop();
                try {
                    Thread.sleep(600);
                    System.out.println("UseThread pop :" + pop + " , 剩下大小：" + rawData.size());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    static class WorkThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            for (; ; ) {
                i++;
                if (rawData.size() <= 20) {
                    try {
                        Thread.sleep(150);
                        rawData.add(i);
                        System.out.println("WorkThread add : " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;

                }

                i = 0;
                LockSupport.park();
                System.out.println("WorkThread 锁住， useThread 开始pop....rawData 大小：" + rawData.size());
                LockSupport.unpark(useThread);

            }
        }
    }
}
