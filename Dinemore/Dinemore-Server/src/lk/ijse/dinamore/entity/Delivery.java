package lk.ijse.dinamore.entity;

import com.sun.org.apache.xpath.internal.operations.Or;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Delivery {
    @Id
    private String delivery_id;
    private String name;
    private String del_Nic;
    private String address;
    private int mobileNo;
    private String bikeNo;
    @OneToMany(mappedBy = "delivery",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    List<Orders>orders=new ArrayList <>();

    public Delivery() {
    }

    public Delivery(String delivery_id, String name, String del_Nic, String address, int mobileNo, String bikeNo) {
        this.delivery_id = delivery_id;
        this.name = name;
        this.del_Nic = del_Nic;
        this.address = address;
        this.mobileNo = mobileNo;
        this.bikeNo = bikeNo;
    }

    public Delivery(String name, String del_Nic, String address, int mobileNo, String bikeNo, List <Orders> orders) {
        this.name = name;
        this.del_Nic = del_Nic;
        this.address = address;
        this.mobileNo = mobileNo;
        this.bikeNo = bikeNo;
        this.orders = orders;
    }

    public Delivery(String delivery_id, String name, String del_Nic, String address, int mobileNo, String bikeNo, List<Orders> orders) {
        this.delivery_id = delivery_id;
        this.name = name;
        this.del_Nic = del_Nic;
        this.address = address;
        this.mobileNo = mobileNo;
        this.bikeNo = bikeNo;
        this.orders = orders;
    }

    public String getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(String delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getDel_Nic() {
        return del_Nic;
    }

    public void setDel_Nic(String del_Nic) {
        this.del_Nic = del_Nic;
    }

    public List <Orders> getOrders() {
        return orders;
    }

    public void setOrders(List <Orders> orders) {
        this.orders = orders;
    }

    public String getDeliveryid() {
        return delivery_id;
    }

    public void setDeliveryid(String delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelNic() {
        return del_Nic;
    }

    public void setDelNic(String del_Nic) {
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

    @Override
    public String toString() {
        return "Delivery{" +
                "delivery_id=" + delivery_id +
                ", name='" + name + '\'' +
                ", del_Nic='" + del_Nic + '\'' +
                ", address='" + address + '\'' +
                ", mobileNo=" + mobileNo +
                ", bikeNo=" + bikeNo +
                '}';
    }
}
