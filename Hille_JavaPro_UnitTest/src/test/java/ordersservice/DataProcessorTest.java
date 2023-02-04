package ordersservice;

import orderservice.DataProcessor;
import orderservice.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class DataProcessorTest {
    @Test
    public void getSumByStoreProductTest(){
        Order order1 = new Order("АТБ", "Гречка", 30.25d, 1);
        Order order2 = new Order("АТБ", "Гречка", 32.25d, 2);
        Order order3 = new Order("АТБ", "Сахар", 21.25d, 10);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);

        DataProcessor dp = new DataProcessor();
        String sum = dp.getSum("Гречка", orderList);
        Assertions.assertEquals("94.75", sum, "Результат проверки негативный");
    }

    @Test
    public void getAVGByStoreProductTest(){
        Order order1 = new Order("АТБ", "Гречка", 29.25d, 1);
        Order order2 = new Order("АТБ", "Гречка", 32.25d, 2);
        Order order3 = new Order("АТБ", "Сахар", 21.25d, 10);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);

        DataProcessor dp = new DataProcessor();
        String avg = dp.getAVG("Гречка", orderList);
        System.out.println(avg);
        Assertions.assertEquals("31.25", avg, "Результат проверки негативный");
    }
}
