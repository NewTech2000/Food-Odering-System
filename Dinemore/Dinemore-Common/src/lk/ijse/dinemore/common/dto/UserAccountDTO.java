package lk.ijse.dinemore.common.dto;

import java.io.Serializable;

public class UserAccountDTO implements Serializable {
    private String username;
    private String password;
    private String confrimpassword;

    public UserAccountDTO() {
    }

    public UserAccountDTO(String username, String password, String confrimpassword) {
        this.username = username;
        this.password = password;
        this.confrimpassword = confrimpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfrimpassword() {
        return confrimpassword;
    }

    public void setConfrimpassword(String confrimpassword) {
        this.confrimpassword = confrimpassword;
    }

    @Override
    public String toString() {
        return "UserAccountDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confrimpassword='" + confrimpassword + '\'' +
                '}';
    }
}
