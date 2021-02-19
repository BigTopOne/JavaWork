public class T06_cas {
    enum ReadyToRun {T1, T2}

    // 思考为什么必须是 volatile
    static volatile ReadyToRun r = ReadyToRun.T1;

    public static void main(String[] args) {
        String str;
        final char[] aI = "1234567".toCharArray();
        final char[] aC = "ABCDEFG".toCharArray();
        new Thread() {
            @Override
            public void run() {
                for (char c : aI) {
                    while (r != ReadyToRun.T1) {
                    }
                    System.out.print(c);
                    r = ReadyToRun.T2;
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (char c : aC) {
                    while (r != ReadyToRun.T2) {
                    }
                    System.out.print(c);
                    r = ReadyToRun.T1;
                }
            }
        }.start();


    }
}
