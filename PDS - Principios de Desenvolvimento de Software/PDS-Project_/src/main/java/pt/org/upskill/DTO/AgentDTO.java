package pt.org.upskill.DTO;

public class AgentDTO {
    private String email;
    private String name;
    private String position;
    private int phone;

    public AgentDTO(String email, String name, String position, int phone){
        this.email=email;
        this.name=name;
        this.position=position;
        this.phone=phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "AgentDTO{" + "email='" + email  + ", name='" + name + ", position='" + position + ", phone=" + phone;
    }
}
