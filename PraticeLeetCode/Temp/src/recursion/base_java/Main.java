package recursion.base_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String args[]) {
        long a = -100000, b = 9;
        String result = calculateSum(a, b);
        System.out.println(result);
    }
    private  static  String calculateSum(long a, long b) {
        long c = a + b;
        String strCast = String.valueOf(c);
        List<String> listStr = new ArrayList<>();
        char[] chars = strCast.toCharArray();
        int strLength = strCast.length();
        for (int i = strLength - 1; i >= 0; i--) {
            listStr.add(String.valueOf(chars[i]));
            if (i == strLength - 3) {
                listStr.add(",");
            }
        }
        Collections.reverse(listStr);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : listStr) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
