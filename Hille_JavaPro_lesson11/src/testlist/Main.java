package testlist;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> flist = new ArrayList();
        flist.add("apple");
        flist.add("melon");
        flist.add("juice");
        flist.add("apple");
        flist.add("tree");
        flist.add("apple");
        flist.add("tree");
        flist.add("freeeedom");

        countOccurance(flist, "apple");

        int[] num = new int[]{1, 2, 3};

        toList(num);

        ArrayList<Double> flist1 = new ArrayList();
        flist1.add(1.2);
        flist1.add(1.2);
        flist1.add(1.2);
        flist1.add(2.3);
        flist1.add(2d);
        flist1.add(1d);
        flist1.add(5.8);
        flist1.add(7.9);
        flist1.add(9.8);
        findUnique(flist1);

        calcOccurance(flist);
        findOccurance(flist);
    }

    public static void countOccurance(ArrayList<String> l, String s) {
        int count = Collections.frequency(l, s);
        System.out.println("Слово " + s + " зустрічається в списку " + count + " раз");
    }

    public static void toList(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);
    }

    public static void findUnique(ArrayList<Double> list) {
        List<Double> uniqueList = list.stream().distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueList);
    }

    public static void calcOccurance(ArrayList<String> list) {
        List<String> uniqueList = list.stream().distinct()
                .collect(Collectors.toList());
        for (String ul: uniqueList) {
            System.out.println(ul + " зустрічається: " + Collections.frequency(list, ul));
        }
    }

    public static void findOccurance(ArrayList<String> list){
        List<ListWords> uniqueList = new ArrayList<>();
        Set<String> uniqueValues = new HashSet<>();
        for (String s : list) {
            if (uniqueValues.add(s)) {
                uniqueList.add(new ListWords(s, Collections.frequency(list, s)));
            }
        }
//        uniqueList.stream().forEach(ul -> ul.print());
        System.out.println("[");
        for (ListWords ul: uniqueList) {
            ul.print();
        }
        System.out.println("]");
    }
}
