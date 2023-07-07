import java.io.Serializable;

public class Telephone implements Serializable {
    private String brand;
    private String model;
    private String serialNo;
    private int storage;
    private String os;

    public Telephone(String brand, String model, String serialNo, int storage, String os) {
        this.brand = brand;
        this.model = model;
        this.serialNo = serialNo;
        this.storage = storage;
        this.os = os;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }



    public void showTelephoneInformation(){
        System.out.println("Brand of Telephone: " + brand);
        System.out.println("Model of Telephone: " + model);
        System.out.println("Serial No: " + serialNo);
        System.out.println("Storage of Telephone: " + storage);
        System.out.println("Operating System: " + os);
        System.out.println();
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", storage='" + storage + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
