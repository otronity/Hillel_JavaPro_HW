import fruit.Apple;
import fruit.Box;
import fruit.Fruit;
import fruit.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String array[] = {"apple", "orange", "kiwi"};
//        List<String> list = toList(array);

        Apple apple = new Apple(1.0f);
        Apple apple1 = new Apple(1.1f);
        Orange orange = new Orange(1.5f);
        Orange orange1 = new Orange(1.3f);

        Box<Fruit> box1 = new Box<>(apple);
        Box<Fruit> box2 = new Box<>(orange);
        Box<Fruit> box3 = new Box<>(orange1);

        box1.add(apple);
        box1.add(orange);

        List<Fruit> l1 = new ArrayList<>();
        List<Fruit> l2 = new ArrayList<>();
        l1.add(apple);
        l1.add(apple1);
        l2.add(orange);

        box1.addN(l1);
        box1.addN(l2);
        box1.getWeight();
        box1.compare(box2);
        box1.merge(box2);
        box2.merge(box3);

    }

    public static <T> List<T> toList(T[] array){
        List<T> list = Arrays.asList(array);
        System.out.println("List: " + list);
        return list;
    }
}
