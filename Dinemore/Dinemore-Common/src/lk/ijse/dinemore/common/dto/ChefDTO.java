package lk.ijse.dinemore.common.dto;

import java.io.Serializable;

public class ChefDTO implements Serializable {
    private String chef_id;
    private String chef_name;
    private String chef_address;
    private int chef_mobile;
    private String chef_Nic;

    public ChefDTO() {
    }

    public ChefDTO(String chef_id, String chef_name, String chef_address, int chef_mobile, String chef_Nic) {
        this.chef_id = chef_id;
        this.chef_name = chef_name;
        this.chef_address = chef_address;
        this.chef_mobile = chef_mobile;
        this.chef_Nic = chef_Nic;
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
}
