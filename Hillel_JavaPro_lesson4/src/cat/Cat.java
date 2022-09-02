package cat;

import animal.Animal;

public class Cat extends Animal{

    private static int catCNT;

    public Cat(String name) {
        super(name);
        catCNT++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            super.run(distance);} else {System.out.println("Кіт не може пробігти " + distance + "м. (максимально 200м.)!");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коти не вміють плавати!");
    }

    public static int getCatCNT() {
        return catCNT;
    }
}
