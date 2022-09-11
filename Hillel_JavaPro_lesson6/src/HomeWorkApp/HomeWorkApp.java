package HomeWorkApp;

public class HomeWorkApp {

    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        long a = 25;
        long b = -43;
        if (interval1(a, b)) System.out.println(a + " + " + b + " входит в интурвал [10,20]");
        if (!interval1(a, b)) System.out.println(a + " + " + b + " не входит в интурвал [10,20]");
        interval2(-25);
        int c = -0;
        if (interval3((long) c)) System.out.println(c + " отрицательное");
        if (!interval3((long) c)) System.out.println(c + " положительное");
        printStr("Hello world!", 2);
        int year = 2022;
        if (checkYear(year)) System.out.println(year + " высокосный год");
        if (!checkYear(year)) System.out.println(year + " не высокосный год");

    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 8;
        int b = 1;
        if ((a + b) >= 0) {
            System.out.println("Сумма положительная (" + a + "+" + b + ")");
        }
        if ((a + b) < 0) System.out.println("Сумма отрицательная (" + a + "+" + b + ")");
    }

    public static void printColor() {
        int value = 8;
        if (value <= 0) System.out.println("Красный");

        if ((value > 0) && (value <= 100)) System.out.println("Желтый");

        if (value > 100) System.out.println("Зеленый");

    }

    public static void compareNumbers() {
        int a = 8;
        int b = 1;
        System.out.print("a = " + a + ", b = " + b + " - ");
        if (a >= b) System.out.println("a >= b");
        if (a < b) System.out.println("a < b");
    }

    public static boolean interval1(long a, long b) {
        return (((a + b) >= 10) && ((a + b) <= 20));
    }

    public static void interval2(long a) {
        if (a >= 0) System.out.println("Число " + a + " положительное");
        if (a < 0) System.out.println("Число " + a + " отрицательное");
    }

    public static boolean interval3(long a) {
        return (a < 0);
    }

    public static void printStr(String s, int iter) {
        for (int i = 1; i <= iter; i++) {
            System.out.println(s);
        }
    }

    public static boolean checkYear(int year) {
        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
    }

}
