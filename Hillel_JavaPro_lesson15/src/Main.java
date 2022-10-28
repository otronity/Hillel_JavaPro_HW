import fruit.Apple;
import fruit.Box;
import fruit.Fruit;
import fruit.Orange;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String array[] = {"apple", "orange", "kiwi"};
        List<String> list = toList(array);

        Apple apple = new Apple();
        Apple apple1 = new Apple();
        Orange orange = new Orange();

        Box<Fruit> box1 = new Box<>(1, apple);
        Box<Fruit> box2 = new Box<>(1, orange);
        Box<Fruit> box3 = new Box<>(3, orange);

        box1.add(apple);
        box1.add(orange);

        box1.addN(5, apple1);
        box1.addN(5, orange);
        box1.getWeight();
        box1.compare(box2);
        box1.merge(box2);
        box3.merge(box2);

    }

    public static <T> List<T> toList(T[] array){
        List<T> list = Arrays.asList(array);
        System.out.println("List: " + list);
        return list;
    }
}
