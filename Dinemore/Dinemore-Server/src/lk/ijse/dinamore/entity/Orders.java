package lk.ijse.dinamore.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Orders {
    @Id
    private int orderid;
    private String orderdate;
    private String orderTime;
    private double price;
    private String status;
    private int qty;
    private String startCooking;
    private String endCooking;
    private String startDeliver;
    private String endDeliver;
    private String payment_Status;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private Reciption reciption;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE,})
    private Chef chef;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private Delivery delivery;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private Customer customer;
    @OneToMany(mappedBy = "orders",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    List<OrderDetails> orderDetails=new ArrayList <>();

    public Orders(int anInt, int setInt, int i, String string, double aDouble, int anInt1) {
    }

    public Orders(){}

    public Orders(int orderid,Customer customer,  int qty,String orderdate, double price ) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.price = price;
        this.qty = qty;
        this.customer = customer;
    }

    public Orders(int orderid, String status, String endDeliver, String payment_Status) {
        this.orderid = orderid;
        this.status = status;
        this.endDeliver = endDeliver;
        this.payment_Status = payment_Status;

    }

    public Orders(int orderid, String orderdate, String orderTime, double price, String status, int qty, String startCooking, String endCooking, String startDeliver, String endDeliver, String payment_Status, Reciption reciption, Chef chef, Delivery delivery, Customer customer, List <OrderDetails> orderDetails) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.orderTime = orderTime;
        this.price = price;
        this.status = status;
        this.qty = qty;
        this.startCooking = startCooking;
        this.endCooking = endCooking;
        this.startDeliver = startDeliver;
        this.endDeliver = endDeliver;
        this.payment_Status = payment_Status;
        this.reciption = reciption;
        this.chef = chef;
        this.delivery = delivery;
        this.customer = customer;
        this.orderDetails = orderDetails;
    }

    public Orders(int orderid, int qty, double price, String status ) {
        this.orderid = orderid;
        this.qty = qty;
        this.price = price;
        this.status = status;

    }

    public Orders(int orderid, String status, Chef chef) {
        this.orderid = orderid;
        this.status = status;
        this.chef = chef;
    }

    public Orders(int orderid, String status, Delivery delivery) {
        this.orderid = orderid;
        this.status = status;
        this.delivery = delivery;
    }

    public Orders(int orderid, String orderdate, String orderTime, String status, int qty) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.orderTime = orderTime;
        this.status = status;
        this.qty = qty;
    }

    public Orders(int orderid, String orderdate, String orderTime, double price, String status, Reciption reciption, Chef chef, Delivery delivery, Menu menu, List <OrderDetails> orderDetails) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.orderTime = orderTime;
        this.price = price;
        this.status = status;
        this.reciption = reciption;
        this.chef = chef;
        this.delivery = delivery;
        this.orderDetails = orderDetails;
    }

    public Orders(int orderid, String orderdate, String orderTime, double price, String status, int qty, Reciption reciption, Chef chef, Delivery delivery, Menu menu, Customer customer, List <OrderDetails> orderDetails) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.orderTime = orderTime;
        this.price = price;
        this.status = status;
        this.qty = qty;
        this.reciption = reciption;
        this.chef = chef;
        this.delivery = delivery;
        this.customer = customer;
        this.orderDetails = orderDetails;
    }

    public String getStartCooking() {
        return startCooking;
    }

    public void setStartCooking(String startCooking) {
        this.startCooking = startCooking;
    }

    public String getEndCooking() {
        return endCooking;
    }

    public void setEndCooking(String endCooking) {
        this.endCooking = endCooking;
    }

    public String getStartDeliver() {
        return startDeliver;
    }

    public void setStartDeliver(String startDeliver) {
        this.startDeliver = startDeliver;
    }

    public String getEndDeliver() {
        return endDeliver;
    }

    public void setEndDeliver(String endDeliver) {
        this.endDeliver = endDeliver;
    }

    public String getPayment_Status() {
        return payment_Status;
    }

    public void setPayment_Status(String payment_Status) {
        this.payment_Status = payment_Status;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List <OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List <OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Reciption getReciption() {
        return reciption;
    }

    public void setReciption(Reciption reciption) {
        this.reciption = reciption;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }



    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
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

    @Override
    public String toString() {
        return "Orders{" +
                "orderid=" + orderid +
                ", orderdate='" + orderdate + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", qty=" + qty +
                ", reciption=" + reciption +
                ", chef=" + chef +
                ", delivery=" + delivery +
                ", customer=" + customer +
                ", orderDetails=" + orderDetails +
                '}';
    }


}
