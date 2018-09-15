package ru.innopolis.src;

import ru.innopolis.src.Annotation.ClearData;
import ru.innopolis.src.Annotation.Logger;
import ru.innopolis.src.Annotation.ResetData;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MathBoxInvocation implements InvocationHandler {

    MathBox mathBox;

    public MathBoxInvocation(MathBox mathBox) {
        this.mathBox = mathBox;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method classMethod = null;
        try{
            classMethod = getMathBoxMethod(method);
        } catch(NoSuchMethodException ex) {
            ex.getStackTrace();
        }
        if ( classMethod.getDeclaredAnnotation(Logger.class) != null){
            long startTime = logStartMethodInfo(method);
            Object result = callMethod(classMethod, args);
            logFinishMethodInfo(method, result, (System.currentTimeMillis() - startTime));
            return result;
        } else {
            return callMethod(classMethod, args);
        }
    }

    public Object callMethod(Method method, Object[] args) throws Throwable {
        Annotation[] annotations = method.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == ClearData.class) {
                System.out.println("Clear data in " + method + " method");
                mathBox.cleanData();
                System.out.println(mathBox);
            }
            if (annotation.annotationType() == ResetData.class) {
                System.out.println("Reset data in " + method + " method");
                mathBox.setNewData(GenerateIntArray.generateArray(10));
                System.out.println("New data:");
                System.out.println(mathBox);
                mathBox.cleanData();
            }
        }
        return method.invoke(mathBox, args);
    }

    private long logStartMethodInfo(Method method) {
        System.out.println("Start method " + method.getName());
        return System.currentTimeMillis();
    }

    private void logFinishMethodInfo(Method method, Object result, long workTime) {
        System.out.println("Finish method " + method.getName());
        System.out.println("Work time: " + workTime);
        if (result != null) {
            System.out.println("Result: " + result.toString());
        }
    }

    private Method getMathBoxMethod(Method method) throws NoSuchMethodException {
        return mathBox.getClass().getMethod(method.getName(), method.getParameterTypes());
    }
}
