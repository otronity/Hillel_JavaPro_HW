package dog;

import animal.Animal;

public class Dog extends Animal{

    private static int dogCNT;

    public Dog(String name) {
        super(name);
        dogCNT++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            super.run(distance);} else { System.out.println("Собака не може пробігти " + distance + "м. (максимально 500м.)!");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            super.run(distance);} else { System.out.println("Собака не може проплисти " + distance + "м. ( максимально 10м.)!");
        }
    }

    public static int getDogCNT() {
        return dogCNT;
    }
}
