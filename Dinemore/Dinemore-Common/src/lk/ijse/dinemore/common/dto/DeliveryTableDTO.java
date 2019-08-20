package lk.ijse.dinemore.common.dto;

import java.io.Serializable;

public class DeliveryTableDTO implements Serializable {
    private int orderid;
    private int customerid;
    private int foodid;
    private int qty;
    private double price;
    private String status;
    private String foodname;

    public DeliveryTableDTO() {
    }

    public DeliveryTableDTO(int orderid, int customerid, int foodid, int qty, double price, String status, String foodname) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.foodid = foodid;
        this.qty = qty;
        this.price = price;
        this.status = status;
        this.foodname = foodname;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    @Override
    public String toString() {
        return "DeliveryTableDTO{" +
                "orderid=" + orderid +
                ", customerid=" + customerid +
                ", foodid=" + foodid +
                ", qty=" + qty +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", foodname='" + foodname + '\'' +
                '}';
    }
}
