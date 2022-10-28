package fruit;

public class Box<T extends Fruit> {

    protected int num = 0;
    protected final T fruit;

    public Box(int num, T fruit) {
        this.num = num;
        this.fruit = fruit;
    }

    public int getNum() {
        return num;
    }

    public T getFruit() {
        return fruit;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void add(T f) {
        if (f.getClass() == fruit.getClass()) {
            num++;
            System.out.println("Додаємо 1 " + fruit.getName());
        } else {
            System.out.println("В цю коробку можна складати тільки " + fruit.getName());
        }
    }

    public void addN(int n, T f) {
        if (f.getClass() == this.fruit.getClass()) {
            num += n;
            System.out.println("Додаємо " + n + " " + fruit.getName());
        } else {
            System.out.println("В цю коробку можна складати тільки " + fruit.getName());
        }
    }

    public float getWeight() {
        System.out.println("Вага " + fruit.getName() + " в коробці = " + (num * fruit.getWeight()));
        return num * fruit.getWeight();
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
        if (b.getFruit().getClass() == this.fruit.getClass()) {
            this.num += b.getNum();
            b.setNum(0);
            System.out.println(b.getFruit().getName() + " пересипані в одну коробку" + getWeight());
        } else {
            System.out.println("В коробках різні фрукти!");
        }

    }
}
