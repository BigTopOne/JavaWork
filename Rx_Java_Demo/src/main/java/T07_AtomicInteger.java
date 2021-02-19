import java.util.concurrent.atomic.AtomicInteger;

/*
 *  使用AtomicInteger 自带的线程同步机制
 */
public class T07_AtomicInteger {
    static AtomicInteger threadNo = new AtomicInteger(1);

    public static void main(String[] args) {
        final char[] aI = "1234567".toCharArray();
        final char[] aC = "ABCDEFG".toCharArray();


        new Thread() {
            @Override
            public void run() {
                for (char c : aI) {
                    while (threadNo.get() != 1) {
                        // block....
                    }
                    System.out.print(c);
                    threadNo.set(2);
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (char c : aC) {
                    while (threadNo.get() != 2) {
                        // block....
                    }

                    System.out.print(c);
                    threadNo.set(1);
                }
            }
        }.start();


    }
}
