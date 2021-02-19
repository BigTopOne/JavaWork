package chapter_10.ocp.client;

import chapter_10.ocp.IMyFactory;
import chapter_10.ocp.MyFactoryA;

public class ClientOne {
    public static void main(String[] args) {
        System.out.println("订购并受到产品："+order());
    }

    private static String order() {
        IMyFactory myFactory = new MyFactoryA();
        return myFactory.product();
    }
}
