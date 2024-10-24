package model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    private String id;

    private UserData userdata;

    public User(String id, UserData userdata) {
        this.id = id;
        this.userdata = userdata;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userdata=" + userdata +
                '}';
    }
}
