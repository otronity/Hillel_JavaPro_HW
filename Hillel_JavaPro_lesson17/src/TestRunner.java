import myannotations.AfterSuite;
import myannotations.BeforeSuite;
import myannotations.Test;
import exceptions.AnnotationException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestRunner {


    public static void start(Class c) throws AnnotationException {

        if (Arrays.stream(c.getDeclaredMethods())
                .filter(method -> method.getAnnotations().length > 0)
                .findAny()
                .isPresent()) {
            System.out.println("Annotation is present");
        }
        if (Arrays.stream(c.getDeclaredMethods())
                .filter(method -> method.getAnnotations().length > 0)
                .findAny()
                .isPresent()) {
            if (Arrays.stream(c.getDeclaredMethods())
                    .filter(method -> method.isAnnotationPresent(BeforeSuite.class) == true)
                    .count() == 1) {
                if (Arrays.stream(c.getDeclaredMethods())
                        .filter(method -> method.isAnnotationPresent(AfterSuite.class) == true)
                        .count() == 1) {

                    Method mBS = Arrays.stream(c.getDeclaredMethods())
                            .filter(method -> method.isAnnotationPresent(BeforeSuite.class) == true)
                            .findFirst()
                            .get();
                    try {
                        System.out.println("Method with annotation BeforeSuite :");
                        mBS.invoke(c);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Methods with annotation Test :");
                    List<Method> methods1 = Arrays.stream(c.getDeclaredMethods())
                            .filter(method -> method.isAnnotationPresent(Test.class) == true)
                            .sorted(Comparator.comparing(o -> o.getAnnotation(Test.class).prior()))
                            .collect(Collectors.toList());

                    for (Method method : methods1) {
                        try {
                            method.invoke(c);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }

                    Method mAS = Arrays.stream(c.getDeclaredMethods())
                            .filter(method -> method.isAnnotationPresent(AfterSuite.class) == true)
                            .findAny().get();
                    try {
                        System.out.println("Method with annotation AfterSuite :");
                        mAS.invoke(c);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new AnnotationException("One more method with annotation AfterSuite");
                }
            } else {
                throw new AnnotationException("One more method with annotation BeforeSuite");
            }
        }
    }
}
