package com.jar;

import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import javassist.*;
import javassist.util.HotSwapper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GenerateClazzMethod2 {
    public static void main(String[] args) {
        ApiTest apiTest = new ApiTest();
        System.out.println(" 你到底有几个前女友?");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        System.out.println(apiTest.queryGirlFriendCount("谢飞机"));
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        try {
            HotSwapper hs = new HotSwapper(8000);
            ClassPool pool = ClassPool.getDefault();
            CtClass ctClass = pool.get(ApiTest.class.getName());
            // 获取方法
            CtMethod ctMethod = ctClass.getDeclaredMethod("queryGirlFriendCount");

            ctMethod.setBody("{ return $1 +\"的前女友数量：\"+(0L)+\"个\";}");
            //ctMethod.setBody("{ return $1 + \"的前女友数量:\" + (0L) + \" 个\";}");

            // 加载新的类
            System.out.println(":: 执行 HotSwapper 热插拔，修改谢飞机前女友数量为 0 个！");
            hs.reload(ApiTest.class.getName(), ctClass.toBytecode());
        } catch (IOException | IllegalConnectorArgumentsException | NotFoundException | CannotCompileException e) {
            e.printStackTrace();
        }

    }
}
