package coffee.order;

public class Main {

    public static void main(String[] args) {
        CoffeeOrderBoard cob = new CoffeeOrderBoard();

        cob.add("Olga");
        cob.add("Dmitro");
        cob.add("Oleg");
        cob.add("Daria");
        cob.add("Ivan");

        cob.draw();
        System.out.println("Deliver first");
        cob.deliver();
        cob.draw();

        System.out.println("Deliver one of..");
        cob.deliver(10);
        cob.draw();

        System.out.println("Deliver first");
        cob.deliver();
        cob.draw();

    }
}
