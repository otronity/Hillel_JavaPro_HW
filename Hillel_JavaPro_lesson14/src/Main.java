import publisher.EventManager;
import subscriber.NotificationListener;

public class Main {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        NotificationListener user1 = new NotificationListener("Ольга");
        NotificationListener user2 = new NotificationListener("Вася");
        NotificationListener user3 = new NotificationListener("Люба");

        eventManager.subscribe(user1);
        eventManager.subscribe(user2);
        eventManager.subscribe(user3);
        eventManager.sendMessage("Вітаємо!");

        eventManager.unsubscribe(user2);
        eventManager.sendMessage("Дякуємо за підписку");
    }
}
