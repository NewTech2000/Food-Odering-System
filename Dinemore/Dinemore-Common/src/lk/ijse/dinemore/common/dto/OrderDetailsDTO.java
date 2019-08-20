package lk.ijse.dinemore.common.dto;

import java.io.Serializable;

public class OrderDetailsDTO implements Serializable {
    private int orderid;
    private int foodid;
    private int orderd_qty;
    private double ordered_price;
    private MenuDTO menuDTO;

    public MenuDTO getMenuDTO() {
        return menuDTO;
    }

    public void setMenuDTO(MenuDTO menuDTO) {
        this.menuDTO = menuDTO;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public OrderDetailsDTO(int orderid, int foodid, int orderd_qty, double ordered_price) {
        this.orderid = orderid;
        this.foodid = foodid;
        this.orderd_qty = orderd_qty;
        this.ordered_price = ordered_price;
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }



    public OrderDetailsDTO(int orderd_qty, double ordered_price, MenuDTO menuDTO) {
        this.orderd_qty = orderd_qty;
        this.ordered_price = ordered_price;
        this.menuDTO = menuDTO;
    }

    public OrderDetailsDTO(int orderd_qty, double ordered_price) {
        this.orderd_qty = orderd_qty;
        this.ordered_price = ordered_price;
    }

    public int getOrderd_qty() {
        return orderd_qty;
    }

    public void setOrderd_qty(int orderd_qty) {
        this.orderd_qty = orderd_qty;
    }

    public double getOrdered_price() {
        return ordered_price;
    }

    public void setOrdered_price(double ordered_price) {
        this.ordered_price = ordered_price;
    }

    public int setFoodid() {
        return foodid;
    }
}
