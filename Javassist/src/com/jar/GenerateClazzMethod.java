package com.jar;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GenerateClazzMethod {
    public static void main(String[] args) {
        HelloWorld.main(null);
        ClassPool pool = ClassPool.getDefault();

        try {
            // 创建类 classname：创建类路径和名称
            CtClass ctClass = pool.makeClass("com.jar.HelloWorld");
            CtMethod mainMethod = new CtMethod(CtClass.shortType, "main", new CtClass[]{pool.get(String[].class.getName())}, ctClass);

            mainMethod.setModifiers(Modifier.PUBLIC + Modifier.STATIC);

            mainMethod.setBody("{System.out.println(\"......我是新的，，，，\");}");
            ctClass.addMethod(mainMethod);


            CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, ctClass);
            ctConstructor.setBody("{}");
            ctClass.addConstructor(ctConstructor);
            ctClass.writeFile();
            Class clazz = ctClass.toClass();
            Object obj = clazz.newInstance();
            Method main = clazz.getDeclaredMethod("main", String[].class);
            main.invoke(obj, (Object) new String[1]);


        } catch (CannotCompileException | IOException | NotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
