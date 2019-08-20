package lk.ijse.dinemore.common.dto;

import java.io.Serializable;

public class MenuDTO implements Serializable {
    private int food_id;
    private String foodName;
    private String category;
    private double unitprice;

    public MenuDTO() {
    }

    public MenuDTO(int food_id, String foodName, String category, double unitprice) {
        this.food_id = food_id;
        this.foodName = foodName;
        this.category = category;
        this.unitprice = unitprice;
    }



    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
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
}
