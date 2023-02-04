package orderservice;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileProcessor {

    public static final List<Order> listOrders = new ArrayList<>();
    public static DataProcessor dataProcessor = new DataProcessor();

    public static void main(String[] args) {

        try {
            readFile("src/main/java/sources/order1.csv");
            readFile("src/main/java/sources/order2.csv");
            writeDataToFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        FileReader fr;
        try {
            fr = new FileReader(file);

            // считаем сначала первую строку
            String line;
            try (BufferedReader reader = new BufferedReader(fr)) {
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    // считываем остальные строки в цикле
                    String[] str = line.split(";");
                    listOrders.add(new Order(str[0], str[1], Double.parseDouble(str[2]), Integer.parseInt(str[3])));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, List<Order>> getMapStore(List<Order> listorders) {
        // магазины со списком заказов по нему
        return listorders.stream()
                .collect(Collectors.groupingBy(Order::getShopName));
    }

    public static List<String> getDataToFile(Map.Entry<String, List<Order>> entry){
        return dataProcessor.getDataByStore(entry);
    }

    public static void writeDataToFile() {
        // магазины со списком заказов по нему
        Map<String, List<Order>> mapbyShop = getMapStore(listOrders);

        Iterator<Map.Entry<String, List<Order>>> iterator = mapbyShop.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Order>> entry = iterator.next();
            writeFile(entry.getKey(), getDataToFile(entry));
        }
    }

    public static void writeFile(String shopname, List<String> list) {

        String filename = "src/main/java/" + shopname + ".csv";
        StringBuilder sb = new StringBuilder();
        sb.append("НАИМЕНОВАНИЕ;ЦЕНА;ШТ; \n");
        for (String s : list) {
            sb.append(s);
        }
        try (FileWriter writer = new FileWriter(filename, false)) {
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
