package fruit;

public abstract class Fruit {

    private final String name = "Fruit";
    float weight;

    public Fruit(float w) {
        this.weight = w;
    }

    protected Fruit() {
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

}
