package Payloads;

public class LoginPayload {

    private String email;
    private String password;

    public LoginPayload() {
    }


    public LoginPayload(String email, String password) {
        this.email = email;
        this.password = password;

    }

    //Getter
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    //Setter
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
