package lk.ijse.dinemore.common.dto;

import java.io.Serializable;

public class DeliveryDTO implements Serializable {
    private String delivery_id;
    private String name;
    private String del_Nic;
    private String address;
    private int mobileNo;
    private String bikeNo;

    public DeliveryDTO() {
    }

    public DeliveryDTO(String delivery_id, String name, String del_Nic, String address, int mobileNo, String bikeNo) {
        this.delivery_id = delivery_id;
        this.name = name;
        this.del_Nic = del_Nic;
        this.address = address;
        this.mobileNo = mobileNo;
        this.bikeNo = bikeNo;
    }

    public String getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(String delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDel_Nic() {
        return del_Nic;
    }

    public void setDel_Nic(String del_Nic) {
        this.del_Nic = del_Nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getBikeNo() {
        return bikeNo;
    }

    public void setBikeNo(String bikeNo) {
        this.bikeNo = bikeNo;
    }
}
