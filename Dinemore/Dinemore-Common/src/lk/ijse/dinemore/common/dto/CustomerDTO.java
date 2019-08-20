package lk.ijse.dinemore.common.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerNic;
    private int customerMobile;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, String customerName, String customerAddress, String customerNic, int customerMobile) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerNic = customerNic;
        this.customerMobile = customerMobile;
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

    public int getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(int customerMobile) {
        this.customerMobile = customerMobile;
    }
}
