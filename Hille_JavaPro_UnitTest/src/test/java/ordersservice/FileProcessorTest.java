package ordersservice;

import orderservice.DataProcessor;
import orderservice.FileProcessor;
import orderservice.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

public class FileProcessorTest {

    @Test
    public void checkDataToFile(){
        Order order1 = new Order("АТБ", "Гречка", 30.25d, 1);
        Order order2 = new Order("АТБ", "Гречка", 32.25d, 2);
        Order order3 = new Order("АТБ", "Сахар", 21.25d, 10);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);

        List<String> dataFileList = new ArrayList<>();
        dataFileList.add("Сахар;1;3;\n");
        dataFileList.add("Гречка;1;3;\n");

        Map<String, List<Order>> map = new HashMap<>();
        map.put("АТБ", orderList);

        Map.Entry<String, List<Order>> entry = map.entrySet().iterator().next();

        DataProcessor mock = Mockito.mock(DataProcessor.class);

        Mockito.when(mock.getDataByStore(entry)).thenCallRealMethod();
        Mockito.when(mock.getSum(Mockito.anyString(), Mockito.anyList())).thenReturn("3");
        Mockito.when(mock.getAVG(Mockito.anyString(), Mockito.anyList())).thenReturn("1");

        List<String> ls = mock.getDataByStore(entry);
        Assertions.assertEquals(dataFileList, ls, "Результат проверки негативный");
    }
}
