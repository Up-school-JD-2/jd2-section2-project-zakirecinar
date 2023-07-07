import java.io.Serializable;

public class Contacts implements Serializable {
    private String name;
    private String surname;
    private String email;
    private String tel;

    public Contacts() {

    }
    public Contacts(String name, String surname, String email, String tel) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.tel = tel;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
