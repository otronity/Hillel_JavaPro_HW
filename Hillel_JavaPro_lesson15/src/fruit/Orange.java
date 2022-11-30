package fruit;

public class Orange extends Fruit{

    private final String name = "orange";
    float weight;

    public Orange(float w) {
        this.weight = w;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }
}
