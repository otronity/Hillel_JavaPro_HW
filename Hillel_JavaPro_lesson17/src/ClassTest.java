import myannotations.AfterSuite;
import myannotations.BeforeSuite;
import myannotations.Test;

public class ClassTest {

    @Test(prior = 1)
    public static void test1() {
        System.out.println("Method Test1");
    }

    ;

    @Test(prior = 2)
    @BeforeSuite
    public static void test2() {
        System.out.println("Method Test2");
    }

    ;

    @Test(prior = 3)
    public static void test3() {
        System.out.println("Method Test3");
    }

    ;

    @Test(prior = 4)
    @AfterSuite
    public static void test4() {
        System.out.println("Method Test4");
    }

    ;

    @Test(prior = 5)
    public static void test5() {
        System.out.println("Method Test5");
    }

    ;
}
