package publisher;

import api.Publisher;
import api.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class EventManager implements Publisher {
    private List<Subscriber> subscriberList = new ArrayList<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    @Override
    public void sendMessage(String message) {
        for (Subscriber sub : subscriberList) {
             sub.update(message);
        }

    }
}
