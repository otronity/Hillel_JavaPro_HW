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
import java.util.stream.Stream;

public class TestRunner {


    public static void start(Class c) throws AnnotationException {

        boolean annotationIsPresent = Arrays.stream(c.getDeclaredMethods())
                .filter(method -> method.getAnnotations().length > 0)
                .findAny()
                .isPresent();

        if (annotationIsPresent) {
            System.out.println("Annotations is present");

            long beforeSuiteCnt =  Arrays.stream(c.getDeclaredMethods())
                    .filter(method -> method.isAnnotationPresent(BeforeSuite.class) == true).count();
            long afterSuiteCnt = Arrays.stream(c.getDeclaredMethods())
                    .filter(method -> method.isAnnotationPresent(AfterSuite.class) == true).count();

            if (beforeSuiteCnt == 1) {
                if (afterSuiteCnt == 1) {
                    Method mBS = Arrays.stream(c.getDeclaredMethods())
                            .filter(method -> method.isAnnotationPresent(BeforeSuite.class) == true)
                            .findFirst().get();

                    System.out.println("Method with annotation BeforeSuite :");
                    invoke(mBS, c);

                    System.out.println("Methods with annotation Test :");
                    List<Method> methods1 = Arrays.stream(c.getDeclaredMethods())
                            .filter(method -> method.isAnnotationPresent(Test.class) == true)
                            .sorted(Comparator.comparing(o -> o.getAnnotation(Test.class).prior()))
                            .collect(Collectors.toList());

                    for (Method method : methods1) {
                        invoke(method, c);
                    }

                    Method mAS = Arrays.stream(c.getDeclaredMethods())
                            .filter(method -> method.isAnnotationPresent(AfterSuite.class) == true)
                            .findAny().get();
                    System.out.println("Method with annotation AfterSuite :");
                    invoke(mAS, c);
                } else {
                    throw new AnnotationException("More than 1 method with annotation AfterSuite");
                }
            } else {
                throw new AnnotationException("More than 1 method with annotation BeforeSuite");
            }
        }
    }

    public static void invoke(Method m, Class c){
        try {
            m.invoke(c);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
