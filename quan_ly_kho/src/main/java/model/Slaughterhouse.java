package model;

public class Slaughterhouse {
    private int slaughterhouseId;
    private String slaughterhouseName;
    private String address;
    private int capacity; // Số lượng gia súc/gia cầm có thể giết mổ
    private String contactPerson;

    // Constructors
    public Slaughterhouse(int slaughterhouseId, String slaughterhouseName, String address, int capacity, String contactPerson) {
        this.slaughterhouseId = slaughterhouseId;
        this.slaughterhouseName = slaughterhouseName;
        this.address = address;
        this.capacity = capacity;
        this.contactPerson = contactPerson;
    }

    public Slaughterhouse(String slaughterhouseName, String address, int capacity, String contactPerson) {
        this.slaughterhouseName = slaughterhouseName;
        this.address = address;
        this.capacity = capacity;
        this.contactPerson = contactPerson;
    }

    public Slaughterhouse() {}

    // Getter and Setter
    public int getSlaughterhouseId() { return slaughterhouseId; }
    public void setSlaughterhouseId(int slaughterhouseId) { this.slaughterhouseId = slaughterhouseId; }

    public String getSlaughterhouseName() { return slaughterhouseName; }
    public void setSlaughterhouseName(String slaughterhouseName) { this.slaughterhouseName = slaughterhouseName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }

    @Override
    public String toString() {
        return "Slaughterhouse [slaughterhouseId=" + slaughterhouseId + ", slaughterhouseName=" + slaughterhouseName +
               ", address=" + address + ", capacity=" + capacity + ", contactPerson=" + contactPerson + "]";
    }
}
