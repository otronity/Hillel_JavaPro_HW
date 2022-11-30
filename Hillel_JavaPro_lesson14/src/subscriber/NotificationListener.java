package subscriber;

import api.Subscriber;

public class NotificationListener implements Subscriber {

    private String Name;

    public NotificationListener(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    @Override
    public void update(String message) {
        System.out.println(Name + " Ви отримали нове повідомлення: " + message);
    }
}
