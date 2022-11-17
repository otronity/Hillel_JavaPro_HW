import exceptions.AnnotationException;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws AnnotationException, InvocationTargetException, IllegalAccessException {
        TestRunner tr = new TestRunner();
        ClassTest ct = new ClassTest();

        tr.start(ct.getClass());

    }
}
