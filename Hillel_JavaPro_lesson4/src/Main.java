import animal.Animal;
import cat.Cat;
import dog.Dog;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Animal[] animalArray = new Animal[100];

        Scanner in = new Scanner(System.in);

        String animal;
        int i = 0;
        int distanceRun;
        int distanceSwim;
        String name;
        boolean nextAnimal = true;

        while (nextAnimal) {
            System.out.println("Кого створюємо: кота - c, собаку - d, вийти - other");
            animal = in.next();

            if (animal.equals("c") || animal.equals("d")) {
                System.out.print("Введіть ім'я: ");
                name = in.next();
                System.out.print("Введіть дистанцію для бігу: ");
                distanceRun = in.nextInt();
                System.out.print("Введіть дистанцію для плавання: ");
                distanceSwim = in.nextInt();
                nextAnimal = true;

                if (animal.equals("c")) {
                    animalArray[i] = new Cat(name);
                } else if (animal.equals("d")) {
                    animalArray[i] = new Dog(name);
                }

                animalArray[i].run(distanceRun);
                animalArray[i].swim(distanceSwim);
                if (i < 100) {i++;} else {
                    System.out.println("Більше тварин створити не можна!");
                    nextAnimal = false;
                    System.out.println("До зустрічі!");
                }

            } else {
                nextAnimal = false;
                System.out.println("До зустрічі!");
            }

            System.out.println("");
        }

        System.out.println("Створено тварин - " + Animal.getAnimalCNT());
        System.out.println("Створено котів - " + Cat.getCatCNT());
        System.out.println("Створено собак - " + Dog.getDogCNT());
    }
}
