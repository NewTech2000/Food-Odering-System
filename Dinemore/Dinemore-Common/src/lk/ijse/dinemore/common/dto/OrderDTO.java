package lk.ijse.dinemore.common.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDTO implements Serializable {
    private int foodid;
    private int orderid;
    private String orderdate;
    private String orderTime;
    private double price;
    private int qty;
    private int reciptionId;
    private String status;
    private String chefId;
    private String deliveryID;
    private CustomerDTO customerDTO;;
    List<OrderDetailsDTO> orderDetailsDTOS = new ArrayList<>();
    private DeliveryDTO deliveryDTO;
    private String startCooking;
    private String endCooking;
    private String startDeliver;
    private String endDeliver;
    private String payment_Status;

    public OrderDTO(int foodid, int orderid, String orderdate, String orderTime, double price, int qty, int reciptionId, String status, String chefId, String deliveryID, CustomerDTO customerDTO, List <OrderDetailsDTO> orderDetailsDTOS, DeliveryDTO deliveryDTO, String startCooking, String endCooking, String startDeliver, String endDeliver, String payment_Status) {
        this.foodid = foodid;
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.orderTime = orderTime;
        this.price = price;
        this.qty = qty;
        this.reciptionId = reciptionId;
        this.status = status;
        this.chefId = chefId;
        this.deliveryID = deliveryID;
        this.customerDTO = customerDTO;
        this.orderDetailsDTOS = orderDetailsDTOS;
        this.deliveryDTO = deliveryDTO;
        this.startCooking = startCooking;
        this.endCooking = endCooking;
        this.startDeliver = startDeliver;
        this.endDeliver = endDeliver;
        this.payment_Status = payment_Status;
    }

    public DeliveryDTO getDeliveryDTO() {
        return deliveryDTO;
    }

    public void setDeliveryDTO(DeliveryDTO deliveryDTO) {
        this.deliveryDTO = deliveryDTO;
    }



    public OrderDTO(String status,String deliveryID ,String startDeliver,int orderid){
        this.status=status;
        this.deliveryID=deliveryID;
        this.orderid=orderid;
        this.startDeliver=startDeliver;

    }

    public OrderDTO(int orderid, String status) {
        this.orderid = orderid;
        this.status = status;
    }

    public OrderDTO(int orderid, String orderdate, String orderTime, String status , int qty ) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.orderTime = orderTime;
        this.status = status;
        this.qty = qty;

    }



    public OrderDTO(int foodid, int orderid, String orderdate, String orderTime, double price, int qty, int reciptionId, String status, String chefId, String deliveryID, CustomerDTO customerDTO, List <OrderDetailsDTO> orderDetailsDTOS) {
        this.foodid = foodid;
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.orderTime = orderTime;
        this.price = price;
        this.qty = qty;
        this.reciptionId = reciptionId;
        this.status = status;
        this.chefId = chefId;
        this.deliveryID = deliveryID;
        this.customerDTO = customerDTO;
        this.orderDetailsDTOS = orderDetailsDTOS;
    }

    public OrderDTO(int orderid ,String chefId ,String status,String startCooking) {
        this.orderid =orderid;
        this.status = status;
        this.chefId = chefId;
        this.startCooking=startCooking;

    }

    public OrderDTO(String chefId,int orderid,String status,String endCooking){
        this.chefId=chefId;
        this.orderid=orderid;
        this.status=status;
        this.endCooking=endCooking;


    }

    public OrderDTO(String payment_Status, int orderid, String status, String endDeliver,String deliveryID ) {
        this.orderid = orderid;
        this.status = status;
        this.deliveryID = deliveryID;
        this.endDeliver = endDeliver;
        this.payment_Status = payment_Status;
    }

    public String getChefId() {
        return chefId;
    }

    public void setChefId(String chefId) {
        this.chefId = chefId;
    }

    public OrderDTO() {
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

    public OrderDTO(int orderid, int qty, double price, String status) {
        this.orderid = orderid;
        this.qty = qty;
        this.price = price;
        this.status = status;
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    public OrderDTO(int foodid, int orderid, String orderdate, String orderTime, double price, int qty, int reciptionId, String status, CustomerDTO customerDTO, List <OrderDetailsDTO> orderDetailsDTOS) {
        this.foodid = foodid;
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.orderTime = orderTime;
        this.price = price;
        this.qty = qty;
        this.reciptionId = reciptionId;
        this.status = status;
        this.customerDTO = customerDTO;
        this.orderDetailsDTOS = orderDetailsDTOS;
    }

    public OrderDTO(int orderid, String orderdate, String orderTime, double price, CustomerDTO customerDTO, List <OrderDetailsDTO> orderDetailsDTOS) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.orderTime = orderTime;
        this.price = price;
        this.customerDTO = customerDTO;
        this.orderDetailsDTOS = orderDetailsDTOS;
    }

    public OrderDTO(int orderid, String orderdate, String orderTime, double price, int qty, int reciptionId, String status, CustomerDTO customerDTO, List <OrderDetailsDTO> orderDetailsDTOS) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.orderTime = orderTime;
        this.price = price;
        this.qty = qty;
        this.reciptionId = reciptionId;
        this.status = status;
        this.customerDTO = customerDTO;
        this.orderDetailsDTOS = orderDetailsDTOS;
    }



    public String getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(String deliveryID) {
        this.deliveryID = deliveryID;
    }

    public int getReciptionId() {
        return reciptionId;
    }

    public void setReciptionId(int reciptionId) {
        this.reciptionId = reciptionId;
    }

//    public OrderDTO(int orderid, String orderdate, String orderTime, double price, CustomerDTO customerDTO) {
//        this.orderid = orderid;
//        this.orderdate = orderdate;
//        this.orderTime = orderTime;
//        this.price = price;
//        this.customerDTO = customerDTO;
//    }

    public OrderDTO(int orderid, String orderdate, String orderTime, double price) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.orderTime = orderTime;
        this.price = price;
//        this.status = status;
    }

    public OrderDTO(int orderid, String orderdate, String orderTime, double price, int qty, CustomerDTO customerDTO, List <OrderDetailsDTO> orderDetailsDTOS) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.orderTime = orderTime;
        this.price = price;
        this.qty = qty;
        this.customerDTO = customerDTO;
        this.orderDetailsDTOS = orderDetailsDTOS;
    }



    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public List <OrderDetailsDTO> getOrderDetailsDTOS() {
        return orderDetailsDTOS;
    }

    public void setOrderDetailsDTOS(List <OrderDetailsDTO> orderDetailsDTOS) {
        this.orderDetailsDTOS = orderDetailsDTOS;
    }

    public OrderDTO(int orderid, String orderdate, String orderTime, double price, String status, CustomerDTO customerDTO, OrderDetailsDTO orderDetailsDTO) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.orderTime = orderTime;
        this.price = price;
//        this.status = status;

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
        return "OrderDTO{" +
                "foodid=" + foodid +
                ", orderid=" + orderid +
                ", orderdate='" + orderdate + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", reciptionId=" + reciptionId +
                ", status='" + status + '\'' +
                ", chefId='" + chefId + '\'' +
                ", deliveryID='" + deliveryID + '\'' +
                ", customerDTO=" + customerDTO +
                ", orderDetailsDTOS=" + orderDetailsDTOS +
                ", deliveryDTO=" + deliveryDTO +
                '}';
    }

}
