package fruit;

public class Apple extends Fruit {

    private final String name = "apple";
    float weight;

    public Apple(float w) {
        this.weight = w;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }
}
