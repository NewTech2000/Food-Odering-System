package lk.ijse.dinamore.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class OrderDetails implements Serializable {
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @Id
    private Orders orders;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @Id
    private Menu menu;
    private int orderd_qty;
    private double ordered_price;

    public OrderDetails() {
    }

    public OrderDetails(int orderd_qty, double ordered_price) {
        this.orderd_qty = orderd_qty;
        this.ordered_price = ordered_price;
    }

    public OrderDetails(Orders orders, Menu menu, int orderd_qty, double ordered_price) {
        this.orders = orders;
        this.menu = menu;
        this.orderd_qty = orderd_qty;
        this.ordered_price = ordered_price;
    }



    public OrderDetails(Orders orders, int orderd_qty,double ordered_price,Menu menu ) {
        this.orders = orders;
        this.menu = menu;
        this.orderd_qty = orderd_qty;
        this.ordered_price = ordered_price;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
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

    public int setMenu(int foodid) {
        return foodid;
    }
}
