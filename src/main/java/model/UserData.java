package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserData {
    private String username;
    private String password;
    private String firstname;
    private String lastname;

    public UserData(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UserData() {
    }

    @Override
    public String toString() {
        return "UserData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
