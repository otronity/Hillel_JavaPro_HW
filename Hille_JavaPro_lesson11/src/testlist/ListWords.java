package testlist;

public class ListWords {

    String name;
    int occurrence;

    public ListWords(String name, int occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    public void print(){
//        String s = "{name: " + name + ", occurrence: " + occurrence + "}";
//        return s;
        System.out.println("{name: " + name + ", occurrence: " + occurrence + "}");
    }
}
