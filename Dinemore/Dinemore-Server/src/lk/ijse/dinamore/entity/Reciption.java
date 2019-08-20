package lk.ijse.dinamore.entity;

import com.sun.org.apache.xpath.internal.operations.Or;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reciption {
    @Id
    private int reciption_id;
    private String reciption_name;
    private String reciption_address;
    private String reciption_Nic;
    private int reciption_mobile;
    @OneToMany(mappedBy = "reciption",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    List<Orders>orders=new ArrayList <>();

    public Reciption() {
    }

    public Reciption(int reciption_id, String reciption_name, String reciption_address, String reciption_Nic, int reciption_mobile) {
        this.reciption_id = reciption_id;
        this.reciption_name = reciption_name;
        this.reciption_address = reciption_address;
        this.reciption_Nic = reciption_Nic;
        this.reciption_mobile = reciption_mobile;
    }

    public Reciption(int reciption_id, String reciption_name, String reciption_address, String reciption_Nic, int reciption_mobile, List <Orders> orders) {
        this.reciption_id = reciption_id;
        this.reciption_name = reciption_name;
        this.reciption_address = reciption_address;
        this.reciption_Nic = reciption_Nic;
        this.reciption_mobile = reciption_mobile;
        this.orders = orders;
    }

    public int getReciption_id() {
        return reciption_id;
    }

    public void setReciption_id(int reciption_id) {
        this.reciption_id = reciption_id;
    }

    public String getReciption_name(Reciption entity) {
        return reciption_name;
    }

    public void setReciption_name(String reciption_name) {
        this.reciption_name = reciption_name;
    }

    public String getReciption_address() {
        return reciption_address;
    }


    public String getReciption_Nic() {
        return reciption_Nic;
    }


    public int getReciption_mobile() {
        return reciption_mobile;
    }

    public void setReciption_address(String reciption_address) {
        this.reciption_address = reciption_address;
    }

    public void setReciption_Nic(String reciption_Nic) {
        this.reciption_Nic = reciption_Nic;
    }

    public String getReciption_name() {
        return reciption_name;
    }

    public void setReciption_mobile(int reciption_mobile) {
        this.reciption_mobile = reciption_mobile;
    }

    public List <Orders> getOrders() {
        return orders;
    }

    public void setOrders(List <Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Reciption{" +
                "reciption_id=" + reciption_id +
                ", reciption_name='" + reciption_name + '\'' +
                ", reciption_address='" + reciption_address + '\'' +
                ", reciption_Nic='" + reciption_Nic + '\'' +
                ", reciption_mobile=" + reciption_mobile +
                ", orders=" + orders +
                '}';
    }
}
