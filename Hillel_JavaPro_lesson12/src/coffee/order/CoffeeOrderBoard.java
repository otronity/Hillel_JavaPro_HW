package coffee.order;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {

    private int orderNum = 0;
    List<Order> orderList = new ArrayList<>();

    public void add(String name) {
        orderNum++;
        orderList.add(new Order(name, orderNum));
    }

    public void deliver() {
        if (!orderList.isEmpty()) {
            Order min = orderList.stream().min(Order::compare).get();
            orderList.remove(min);
        }
    }

    public void deliver(Integer orderNumD) {
        if (orderList.stream().filter(order -> orderNumD.equals(order.getOrderNum())).findAny().isPresent()) {
            orderList.remove(orderList.stream().filter(
                    order -> orderNumD.equals(order.getOrderNum())).findAny().get());
        } else {
            System.out.println("Замовлення з таким номером не існує");
        }
    }

    public void draw() {
        System.out.println("Num |  Name");
        for (Order order : orderList) {
            System.out.println(order.getOrderNum() + "   | " + order.getClientName());
        }

        if(orderList.isEmpty()){
            System.out.println("Список замовлень пустий");
        }
    }
}
