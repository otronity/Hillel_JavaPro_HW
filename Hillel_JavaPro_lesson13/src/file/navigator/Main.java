package file.navigator;

public class Main {

    public static void main(String[] args) {

        FileNavigator fdn = new FileNavigator();
        fdn.add("C:\\", "test1.txt", (byte) 9);
        fdn.add("C:\\test\\", "test2.txt", (byte) 8);
        fdn.add("C:\\test\\", "test3.txt", (byte) 7);
        fdn.add("C:\\", "test4.txt", (byte) 5);
        fdn.add("C:\\test1\\", "test4.txt", (byte) 10);

        fdn.find("C:\\");
        fdn.filterBySize((byte) 8);
        fdn.remove("C:\\test1\\");
        fdn.sortBySize();
    }
}
