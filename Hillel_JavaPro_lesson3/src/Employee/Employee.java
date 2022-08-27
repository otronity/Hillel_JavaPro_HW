package Employee;

import java.util.regex.Pattern;

public class Employee {

    private String FIO;
    private String position;
    private String email;
    private String phone;
    private Integer age;

    public Employee (String FIO, String position, String email, String phone, Integer age){
        setFIO( FIO);
        setPosition(position);
        setEmail(email);
        setPhone(phone);
        setAge(age);
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getFIO() { return FIO;}

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() { return position; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() { return email;  }

    public void setPhone(String phone) { this.phone = phone;  }

    public String getPhone() { return phone;}

    public void setAge(Integer age) { this.age = age;  }

    public Integer getAge() { return age; }
}
