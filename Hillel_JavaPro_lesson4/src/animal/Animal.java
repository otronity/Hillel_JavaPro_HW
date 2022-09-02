package animal;

public class Animal {

    protected String name;
    private static int animalCNT;

    public Animal(String name) {
        this.name = name;
        animalCNT++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run(int distance){
        System.out.println(name + " пробіг " + distance + " м!");
    }

    public void swim(int distance) {System.out.println(name + " проплив " + distance + " м!");}

    public static int getAnimalCNT() {
        return animalCNT;
    }
}
