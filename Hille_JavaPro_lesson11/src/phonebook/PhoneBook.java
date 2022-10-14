package phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBook {

    List<Record> records = new ArrayList<>();

    public void add(String name, String phone) {
        if (name != null) {
            if (phone != null) {
                records.add(new Record(name, phone));
            } else {
                System.out.println("Запис не створено: передан некорректний телефон: " + phone);
            }
        } else {
            System.out.println("Запис не створено: передане некоректне ім'я: " + name);
        }
    }

    public void find(String name) {
        System.out.println("Шукаємо запис по імені");
        if (name != null) {
            if (records.stream().filter(record -> name.contains(record.getName())).findAny().isPresent()) {
                Record rec = records.stream().filter(recordf -> name.equals(recordf.getName())).findAny().get();
                rec.printRec();
            } else {
                System.out.println("Запис з іменем " + name + " не знайдено");
            }
        } else {
            System.out.println("Ім'я не передано (null)");
        }
    }

    public void findAll(String name) {
        if (name != null) {
            System.out.println("Шукаємо всі записи по імені");
            if (records.stream().filter(record -> name.contains(record.getName())).findAny().isPresent()) {
                List<Record> recs = records.stream().filter(
                        recordf -> name.equals(recordf.getName())).collect(Collectors.toList());
                for (Record r : recs) {
                    r.printRec();
                }
            } else {
                System.out.println("Записів з іменем " + name + " не знайдено");
            }
        } else {
            System.out.println("Ім'я не передано (null)");
        }
    }
}
