package phonebook;

public class Main {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Olha", "380953506625");
        phoneBook.add("Dmitro", "0957692977");
        phoneBook.add("Tatiana", "05080206624");
        phoneBook.add("Tatiana", "09530206612");
        phoneBook.add("Tatiana", null);

        phoneBook.find("Olha");
        phoneBook.find("Tatiana");
        phoneBook.find("Oleg");

        phoneBook.findAll("Tatiana");
        phoneBook.findAll("Oleg");

    }


}
