package lk.ijse.dinemore.common.dto;

import java.io.Serializable;

public class PlaceOrderDTO implements Serializable {
    private int menucode;
    private String menuname;
    private double unitPrice;
    private double total;
    private String date;
    private int qty;


    public PlaceOrderDTO() {
    }

    public PlaceOrderDTO(int menucode, String menuname, double unitPrice, double total, String date, int qty) {
        this.menucode = menucode;
        this.menuname = menuname;
        this.unitPrice = unitPrice;
        this.total = total;
        this.date = date;
        this.qty = qty;
    }

    public int getMenucode() {
        return menucode;
    }

    public void setMenucode(int menucode) {
        this.menucode = menucode;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
