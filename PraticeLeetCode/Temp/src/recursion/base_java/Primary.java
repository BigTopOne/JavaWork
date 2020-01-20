package recursion.base_java;

/**
 * 【Java学习路线】Java语言基础自测考试 - 初级难度
 * 我的错题。
 */
public class Primary {
    public static void main(String[] args) {
        System.out.println("tt1 : " + tt1());
        System.out.println("tt2 : " + tt2());
        System.out.println("tt3 : " + tt3());
        System.out.println("tt4 : " + tt4());
        System.out.println("tt5 : " + tt5());
        System.out.println("tt6 : " + tt6());
        System.out.println("tt7 : " + tt7());
        System.out.println("tt8 : " + tt8());
        System.out.println("tt9 : " + tt9());
        System.out.println("tt10 : " + tt10());




    }

    public static int tt1() {
        long num = 100;
        // 需要强转一下的
        int x = (int) (num + 2);
        return x;
    }

    public static int tt2() {
        //
        int num = 2147483647;
        num += 2;
        return num;
    }

    public static long tt3() {
        int num = 2147483647;
        long temp = num + 2L;
        return temp;
    }

    public static long tt4() {
        int num = 2147483647;
        num += 2L;
        return num;
    }

    public static char tt5() {
        int num = 68;
        char c = (char) num;
        return c;
    }

    public static int tt6() {
        int i = 1;
        int j = i++;
        if ((i == (++j)) && ((i++) == j)) {
            i += j;
        }
        System.out.println("tt6() :i = " + i);
        return 0;
    }

    /**
     * 为啥等于 0 ？
     *
     * @return
     */
    public static int tt7() {
        int sum = 0;
        for (int x = 0; x < 10; x++) {
            sum += x;
            if (x % 3 == 0) {
                break;
            }
        }
        return sum;
    }

    /**
     * 为啥等于 0 ？
     *
     * @return
     */
    public static int tt8() {
        char c = 'A';
        int num = 10;
        switch (c) {
            case 'B':
                num++;
            case 'A':
                num++;
            case 'Y':
                num++;
                break;
            default:
                num--;
        }
        return num;
    }


    public static int tt9() {
       int num =50;
       num = num++*2;
        return num;
    }


    public static String tt10() {
        boolean flag = 10%2 == 1 && 10 / 3 == 0 && 1 / 0 == 0 ;
        return  flag ? "mldn":"yootk";

    }





}






