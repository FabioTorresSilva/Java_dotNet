package pt.org.upskill.DTO;

public class StoreDTO {
    public String code;
    public String designation;
    public String address;

    public StoreDTO(String code, String designation, String address) {
        this.code = code;
        this.designation = designation;
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public String getCode() {
        return code;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "StoreDTO code=" + code + ", designation='" + designation + '\'' + ", address='" + address;
    }
}
