package lk.ijse.dinamore.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class




Chef {
    @Id
    private String chef_id;
    private String chef_name;
    private String chef_address;
    private int chef_mobile;
    private String chef_Nic;
    @OneToMany(mappedBy = "chef",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    List<Orders> orders = new ArrayList <>();

    public Chef() {
    }

    public Chef(String chef_id, String chef_name, String chef_address, int chef_mobile, String chef_Nic) {
        this.chef_id = chef_id;
        this.chef_name = chef_name;
        this.chef_address = chef_address;
        this.chef_mobile = chef_mobile;
        this.chef_Nic = chef_Nic;
    }

    public Chef(String chef_name, String chef_address, int chef_mobile, String chef_Nic, List <Orders> orders) {
        this.chef_name = chef_name;
        this.chef_address = chef_address;
        this.chef_mobile = chef_mobile;
        this.chef_Nic = chef_Nic;
        this.orders = orders;
    }

    public List <Orders> getOrders() {
        return orders;
    }

    public void setOrders(List <Orders> orders) {
        this.orders = orders;
    }

    public String getChef_id() {
        return chef_id;
    }

    public void setChef_id(String chef_id) {
        this.chef_id = chef_id;
    }

    public String getChef_name() {
        return chef_name;
    }

    public void setChef_name(String chef_name) {
        this.chef_name = chef_name;
    }

    public String getChef_address() {
        return chef_address;
    }

    public void setChef_address(String chef_address) {
        this.chef_address = chef_address;
    }

    public int getChef_mobile() {
        return chef_mobile;
    }

    public void setChef_mobile(int chef_mobile) {
        this.chef_mobile = chef_mobile;
    }

    public String getChef_Nic() {
        return chef_Nic;
    }

    public void setChef_Nic(String chef_Nic) {
        this.chef_Nic = chef_Nic;
    }

    @Override
    public String toString() {
        return "Chef{" +
                "chef_id=" + chef_id +
                ", chef_name='" + chef_name + '\'' +
                ", chef_address='" + chef_address + '\'' +
                ", chef_mobile=" + chef_mobile +
                ", chef_Nic='" + chef_Nic + '\'' +
                ", orders=" + orders +
                '}';
    }
}
