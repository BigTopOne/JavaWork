public class Test12 {

    // 常量
    public final static String MAN_TYPE = "man";
    // 静态变量
    public static String WOMAN_TYPE = "woman";

    public static void main(String[] args) throws Exception {
        Teacher t1 = new Teacher();
        t1.setName("李四");
        t1.setSexType(MAN_TYPE);
        t1.setAge(36);
        for (int i = 0; i < 15; i++) {
            //主动触发GC 垃圾回收 15次--- T1存活
            System.gc();
        }
        Teacher t2 = new Teacher();
        t2.setName("张三");
        t2.setSexType(MAN_TYPE);
        t2.setAge(18);
        //线程休眠
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
