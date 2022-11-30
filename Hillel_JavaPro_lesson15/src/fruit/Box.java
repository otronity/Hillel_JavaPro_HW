package fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    protected List<T> fruit = new ArrayList<>();

    public Box(T fruit) {
        this.fruit.add(fruit);
    }

    public String getFruitName() {
        return fruit.stream().findFirst().get().getName();
    }

    public void add(T f) {
        if (f.getClass() == fruit.stream().findFirst().get().getClass()) {
            System.out.println("Додаємо 1 " + f.getName());
        } else {
            System.out.println("В цю коробку можна складати тільки " +
                    getFruitName());
        }
    }

    public void addN(List<T> fl) {
        if (fl != null) {
            boolean b = true;
            for (T t : fl) {
                if (t.getClass() != fruit.stream().findFirst().get().getClass()) {
                    b = false;
                }
            }
            if (b) {
                fruit.addAll(fl);
                System.out.println("Додаємо фрукти до ящика");
                getWeight();
            } else {
                System.out.println("В цю коробку можна складати тільки " + getFruitName());
            }
        } else {
            System.out.println("Передан пустий список фруктів");
        }
    }

    public float getWeight() {
        float weightAll = 0;
        for (T t : fruit) {
            weightAll += t.getWeight();
        }
        System.out.println("Вага фруктів в коробці = " + weightAll);
        return weightAll;
    }

    public boolean compare(Box b) {
        System.out.println("Порівнюємо вагу коробок:");
        if (getWeight() == b.getWeight()) {
            System.out.println("Вага коробок однакова!");
            return true;
        } else {
            System.out.println("Вага коробок різна!");
            return false;
        }
    }

    public void merge(Box b) {
        if (b.fruit.stream().findFirst().get().getClass() ==
                fruit.stream().findFirst().get().getClass()) {
            addN(b.fruit);
            b.fruit.clear();
            System.out.println( getFruitName() + " пересипані в одну коробку");
        } else {
            System.out.println("В коробках різні фрукти!");
        }
    }
}
