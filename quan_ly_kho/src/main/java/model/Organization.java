package model;

public class Organization {
    private int organizationId;
    private String name;
    private String contactPerson;
    private String phone;
    private String email;
    private String organizationType;
    private String status;

    // Constructors
    public Organization(int organizationId, String name, String contactPerson, String phone, String email, String organizationType, String status) {
        this.organizationId = organizationId;
        this.name = name;
        this.contactPerson = contactPerson;
        this.phone = phone;
        this.email = email;
        this.organizationType = organizationType;
        this.status = status;
    }

    public Organization(String name, String contactPerson, String phone, String email, String organizationType, String status) {
        this.name = name;
        this.contactPerson = contactPerson;
        this.phone = phone;
        this.email = email;
        this.organizationType = organizationType;
        this.status = status;
    }

    public Organization() {}

    // Getter and Setter
    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Organization [organizationId=" + organizationId + ", name=" + name + ", contactPerson=" + contactPerson
                + ", phone=" + phone + ", email=" + email + ", organizationType=" + organizationType + ", status=" + status + "]";
    }
}
