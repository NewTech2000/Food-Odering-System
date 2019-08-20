package lk.ijse.dinemore.common.dto;

import java.io.Serializable;

public class ReciptionDTO implements Serializable {
    private int reciption_id;
    private String reciption_name;
    private String reciption_address;
    private String reciption_nic;
    private int reciption_mobile;

    public ReciptionDTO() {
    }

    public ReciptionDTO(int reciption_id, String reciption_name, String reciption_address, String reciption_nic, int reciption_mobile) {
        this.reciption_id = reciption_id;
        this.reciption_name = reciption_name;
        this.reciption_address = reciption_address;
        this.reciption_nic = reciption_nic;
        this.reciption_mobile = reciption_mobile;
    }



    public int getReciption_id() {
        return reciption_id;
    }

    public void setReciption_id(int reciption_id) {
        this.reciption_id = reciption_id;
    }

    public String getReciption_name() {
        return reciption_name;
    }

    public void setReciption_name(String reciption_name) {
        this.reciption_name = reciption_name;
    }

    public String getReciption_address() {
        return reciption_address;
    }

    public void setReciption_address(String reciption_address) {
        this.reciption_address = reciption_address;
    }

    public String getReciption_nic() {
        return reciption_nic;
    }

    public void setReciption_nic(String reciption_nic) {
        this.reciption_nic = reciption_nic;
    }

    public int getReciption_mobile() {
        return reciption_mobile;
    }

    public void setReciption_mobile(int reciption_mobile) {
        this.reciption_mobile = reciption_mobile;
    }

    @Override
    public String toString() {
        return "ReciptionDTO{" +
                "reciption_id=" + reciption_id +
                ", reciption_name='" + reciption_name + '\'' +
                ", reciption_address='" + reciption_address + '\'' +
                ", reciption_nic='" + reciption_nic + '\'' +
                ", reciption_mobile=" + reciption_mobile +
                '}';
    }
}
