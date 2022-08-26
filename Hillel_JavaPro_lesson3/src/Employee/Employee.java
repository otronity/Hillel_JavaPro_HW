package Employee;

import java.util.regex.Pattern;

public class Employee {

    private String FIO;
    private String position;
    private String email;
    private String phone;
    private Integer age;

    private static String regexpPattern_fio = "^[a-zA-Z]{2,100}[ ][a-zA-Z]{2,100}[ ][a-zA-Z]{2,100}$";
    private static String regexpPattern_email = "^(.+)@(\\S+)$";
    private static String regexpPattern_phone = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{1,3}[- .]?\\d{1,4}$";

    public Employee (String FIO, String position, String email, String phone, Integer age){
        setFIO( FIO);
        setPosition(position);
        setEmail(email);
        setPhone(phone);
        setAge(age);
    }

    public void setFIO(String FIO) {
        if (Pattern.compile(regexpPattern_fio).matcher(FIO).matches()) {this.FIO = FIO;}
        else System.out.println("FIO is incorrect");
    }

    public String getFIO() { return FIO;}

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() { return position; }

    public void setEmail(String email) {
        if (Pattern.compile(regexpPattern_email).matcher(email).matches()) {this.email = email;}
        else System.out.println("Email is incorrect");
    }

    public String getEmail() { return email;  }

    public void setPhone(String phone) {
        if (Pattern.compile(regexpPattern_phone).matcher(phone).matches()) {this.phone = phone;}
        else System.out.println("Phone is incorrect");
    }

    public String getPhone() { return phone;}

    public void setAge(Integer age) { if (age >= 18) {this.age = age;} else {
        System.out.println("The Age is incorrect"); }
    }

    public Integer getAge() { return age; }
}
