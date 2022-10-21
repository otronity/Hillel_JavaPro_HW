package coffee.order;

public class Order {
    String clientName;
    int orderNum;

    public Order(String clientName, int orderNum) {
        this.clientName = clientName;
        this.orderNum = orderNum;
    }

    public String getClientName() {
        return clientName;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public static int compare(Order o1, Order o2){
        if(o1.getOrderNum() > o2.getOrderNum())
            return 1;
        return -1;
    }
}
