import java.util.concurrent.locks.LockSupport;

public class T08_LockSupport {
    static CharacterThread characterThread;
    static NumberThread numberThread;
    static String[] cStr = {"A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S",
            "T", "U", "V", "W", "X", "Y", "Z",
    };

    public static void main(String[] args) {
        characterThread = new CharacterThread();
        numberThread = new NumberThread();
        characterThread.start();
        numberThread.start();
    }

    static class CharacterThread extends Thread {
        public void run() {
            for (String s : cStr) {
                // print a char ....
                System.out.print(s);
                //  make other another available(NumberThread)....
                LockSupport.unpark(numberThread);
                // pause current thread......
                LockSupport.park();
            }
        }
    }

    static class NumberThread extends Thread {
        public void run() {
            for (int i = 1; i <= 26; i++) {
                // disables the current NumberThread,in order to CharacterThread can print a char.
                LockSupport.park();
                // print the single number....
                System.out.print(i + " ");
                // make CharacterThread available.......
                LockSupport.unpark(characterThread);
            }
        }
    }
}
