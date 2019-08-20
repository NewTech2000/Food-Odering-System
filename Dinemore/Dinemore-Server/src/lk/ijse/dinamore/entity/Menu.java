package lk.ijse.dinamore.entity;

import lk.ijse.dinemore.common.dto.MenuDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {
    @Id
    private int food_id;
    private String foodName;
    private String category;
    private double unitprice;
    @OneToMany(mappedBy = "menu",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    List<OrderDetails> orderDetails = new ArrayList <>();

    public Menu() {
    }

    public Menu(int food_id, String foodName, String category, double unitprice) {
        this.food_id = food_id;
        this.foodName = foodName;
        this.category = category;
        this.unitprice = unitprice;
    }

    public Menu(String foodName, String category, double unitprice, List <OrderDetails> orderDetails) {
        this.foodName = foodName;
        this.category = category;
        this.unitprice = unitprice;
        this.orderDetails = orderDetails;
    }

    public List <OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List <OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getId() {
        return food_id;
    }

    public void setId(int id) {
        this.food_id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "food_id=" + food_id +
                ", foodName='" + foodName + '\'' +
                ", category='" + category + '\'' +
                ", unitprice=" + unitprice +
                '}';
    }


}
