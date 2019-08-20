package lk.ijse.dinamore.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer  {
    @Id
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerNic;
    private int customerMobile;
    @OneToMany(mappedBy = "customer",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    List<Orders> orders=new ArrayList <>();

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerAddress, String customerNic, int customerMobile) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerNic = customerNic;
        this.customerMobile = customerMobile;
    }

    public Customer(int customerId, String customerName, String customerAddress, String customerNic, int customerMobile, ArrayList <Orders> orders) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerNic = customerNic;
        this.customerMobile = customerMobile;
        this.orders = orders;
    }

    public int getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(int customerMobile) {
        this.customerMobile = customerMobile;
    }

    public List <Orders> getOrders() {
        return orders;
    }

    public void setOrders(List <Orders> orders) {
        this.orders = orders;
    }

    public void setOrders(ArrayList <Orders> orders) {
        this.orders = orders;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerNic() {
        return customerNic;
    }

    public void setCustomerNic(String customerNic) {
        this.customerNic = customerNic;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerNic='" + customerNic + '\'' +
                '}';
    }
}
