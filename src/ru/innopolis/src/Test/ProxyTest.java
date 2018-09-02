package ru.innopolis.src.Test;

import ru.innopolis.src.GenerateIntArray;
import ru.innopolis.src.IMathBox;
import ru.innopolis.src.MathBox;
import ru.innopolis.src.MathBoxInvocation;

import java.lang.reflect.Proxy;

public class ProxyTest {
    MathBox realMathBox;
    private IMathBox mathBoxProxy;

    public ProxyTest() {
        realMathBox = new MathBox(GenerateIntArray.generateArray(5));
        mathBoxProxy = (IMathBox) Proxy.newProxyInstance(MathBoxInvocation.class.getClassLoader(),
                new Class[]{IMathBox.class}, new MathBoxInvocation(realMathBox));
    }

    public void test() {
        System.out.println("Real math box:");
        System.out.println(realMathBox);
        System.out.println("summator:" + realMathBox.summator());
        System.out.println("splitter:" + realMathBox.splitter(2));
        System.out.println();
        System.out.println("Proxy math box");
        mathBoxProxy.summator();
        mathBoxProxy.splitter(2);
        System.out.println();

    }
}
