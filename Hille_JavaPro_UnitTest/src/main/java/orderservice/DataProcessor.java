package orderservice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class DataProcessor {

    private final DecimalFormat df = new DecimalFormat("0.00");

    public List<String> getDataByStore(Map.Entry<String, List<Order>> entry) {

        List<String> strListtoFile = new ArrayList<>();

        //список наименований продуктов
        Set<String> listName = entry.getValue().stream()
                .collect(Collectors.groupingBy(Order::getName))
                .keySet();
        String strByProd;
        for (String s : listName) {
            List<Order> lo = entry.getValue();
            String sumCnt = getSum(s, lo);
            String avgPrice = getAVG(s, lo);

            //формируем строку по продукту с подсчетом средней цены и общего кол-ва
            strByProd = s + ";" + avgPrice + ";" + sumCnt + ";\n";
            strListtoFile.add(strByProd);
        }
        return strListtoFile;
    }

    public String getSum(String prodname, List<Order> l) {
        return String.valueOf(l.stream()
                .filter(order -> prodname.equals(order.getName()))
                .mapToInt(Order::getCnt)
                .sum());
    }

    public String getAVG(String prodname, List<Order> l) {
        return String.valueOf(df.format(l.stream()
                .filter(order -> prodname.equals(order.getName()))
                .mapToDouble(value -> value.getPrice() * value.getCnt())
                .sum() / Integer.parseInt(getSum(prodname, l))));
    }

}
