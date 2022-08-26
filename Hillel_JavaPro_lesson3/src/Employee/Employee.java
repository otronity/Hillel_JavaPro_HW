package Employee;

public class Employee {

    public String FIO;
    public String position;
    public String email;
    public String phone;
    public Integer age;

    public Employee (String FIO, String position, String email, String phone, Integer age){
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() { return phone;}

    public void setAge(Integer age) { this.age = age; }

    public Integer getAge() { return age; }
}
