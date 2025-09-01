package Payloads;

public class UserPayload {

    private String name;
    private String job;

    public UserPayload() {
    }

    public UserPayload(String email, String job) {
        this.name = email;
        this.job = job;

    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }


}
