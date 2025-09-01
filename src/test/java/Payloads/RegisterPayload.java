package Payloads;

public class RegisterPayload {


    private String registerEmail;
    private String registerPassword;

    public RegisterPayload() {
    }

    public RegisterPayload(String registerEmail, String registerPassword) {
        this.registerEmail = registerEmail;
        this.registerPassword = registerPassword;
    }

    //Getter
    public String getRegisterEmail() {
        return registerEmail;
    }

    public String getRegisterPassword() {
        return registerPassword;
    }

    //Setter
    public void setRegisterEmail(String registerEmail) {
        this.registerEmail = registerEmail;
    }

    public void setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword;
    }

}