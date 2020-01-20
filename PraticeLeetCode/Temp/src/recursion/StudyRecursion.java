package recursion;

/**
 * 目的是为了研究一下递归,
 */
public class StudyRecursion {
    public static void main(String[] args) {
        hanoi(3, 'a', 'b', 'c');

        int n = 3;
        System.out.println(n+" 小时以后的细胞数："+allCell(n));

    }

    /**
     * n 的阶乘。
     *
     * @param n
     * @return
     */
    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * 青蛙跳台阶，一个青蛙一次可以跳一个或两个台阶；
     * 问，当有 n 个台阶时，有多少种跳法?
     * <p>
     * 但仔细看题目，一只青蛙只能跳一步或两步台阶，自上而下地思考，
     * 也就是说如果要跳到 n 级台阶只能从 从 n-1 或 n-2 级跳，
     * 假如：青蛙想跳到第 4 个台阶，那么，必须从第2 个（跳 2 个台阶）或者第 3 个（跳1 个台阶）开始跳；
     * 所以问题就转化为跳上 n-1 和 n-2 级台阶的跳法了，如果 f(n) 代表跳到 n 级台阶的跳法，那么从以上分析可得 f(n) = f(n-1) + f(n-2),
     *
     * @param n 台阶数
     * @return
     */
    private static int frogJump(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return frogJump(n - 1) + frogJump(n - 2);

    }

    //------------------------------------------------------------
    //------------------------------------------------------------
    //---------以上的递归，存在这大量的重负运算，随着 n 的增大，f(n)的时间复杂度呈指数上升 ---
    //---------所以，要开始优化了。
    //------------------------------------------------------------
    //------------------------------------------------------------

    /**
     * 改造过以后的时间复杂度是 O(n),而且由于我们在计算过程中只定义了两个变量（pre，next），所以空间复杂度是O(1).
     *
     * @param n
     * @return
     */
    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int result = 0;
        int pre = 1;
        int next = 2;
        for (int i = 3; i < n + 1; i++) {
            result = pre + next;
            pre = next;
            next = result;
        }
        return result;
    }


    /**
     * 中级题
     * 在找问题的过程中 切忌把子问题层层展开,
     * 到汉诺塔这个问题上切忌再分析 n-3,n-4 怎么移，这样会把你绕晕，只要找到一层问题与子问题的关系得出可以用递归表示即可。
     *
     * @param n
     * @param a
     * @param b
     * @param c
     */
    public static void hanoi(int n, char a, char b, char c) {
        if (n <= 0) {
            return;
        }
        // 将上面的 n-1 个圆盘由C 移到 B。
        hanoi(n - 1, a, c, b);
        // 此时，将 A 底下的那块最大的圆盘移到 C。
        move(a, c);
        // 再将 B 上的 n-1 个盘子经由A移到 C 上。
        hanoi(n - 1, b, a, c);

    }

    private static void move(char t1, char t2) {
        System.out.println("move : " + t1 + " ----> " + t2);
    }

    /**
     * 进阶题
     * 现实中大厂中的很多递归题都不会用上面这些相对比较容易理解的题，更加地是对递归问题进行相应地变形， 来看下面这道题.
     * 细胞分裂 有一个细胞 每一个小时分裂一次，一次分裂一个子细胞，第三个小时后会死亡。那么n个小时候有多少细胞？
     * A 代表细胞的初始态, B代表幼年态(细胞分裂一次), C 代表成熟态(细胞分裂两次)，
     * C 再经历一小时后细胞死亡以 f(n) 代表第 n 小时的细胞分解数
     * fa(n) 代表第 n 小时处于初始态的细胞数,
     * fb(n) 代表第 n 小时处于幼年态的细胞数,
     * fc(n) 代表第 n 小时处于成熟态的细胞数
     * 则显然 f(n) =  fa(n)  + fb(n)  + fc(n)
     * 那么 fa(n) 等于多少呢，以n = 4 （即一个细胞经历完整的生命周期）为例
     * <p>
     * fa(n)  = fa(n-1) + fb(n-1) + fc(n-1), 当 n = 1 时，显然 fa(1) = 1
     *
     * @param n 小时
     * @return 第 n 个小时，细胞数
     */
    public  static int allCell(int n) {
        return aCell(n) + bCell(n) + cCell(n);

    }

    /**
     * @param n n 小时
     * @return 第 n 个小时，a 状态的细胞数
     */
    private static int aCell(int n) {
        if (n == 1) {
            return 1;
        }
        return allCell(n - 1) + bCell(n - 1) + cCell(n - 1);
    }


    /**
     * @param n n 小时
     * @return 第 n 个小时，b 状态的细胞数
     */
    private static int bCell(int n) {
        if (n == 1) {
            return 0;
        }
        return allCell(n - 1);
    }


    /**
     * @param n n 小时
     * @return 第 n 个小时，c 状态的细胞数
     */
    private static int cCell(int n) {
        if (n == 1 || n == 2) {
            return 0;
        }
        return bCell(n - 1);
    }


}
