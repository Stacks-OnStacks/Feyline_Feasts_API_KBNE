package com.revature.project_1.Dish.DTO.response;

import com.revature.project_1.Dish.Dish;
import com.revature.project_1.Users.DTO.response.UserResponse;

public class DishResponse {

    public int dishId;

    public String dishName;

    public double cost;

    public String description;

    public boolean isVegetarian;

    public DishResponse() {}
    //is there a reason why this is used twice?


    public DishResponse(Dish dish){
        this.dishId = dish.dishId;
        this.dishName = dish.dishName;
        this.cost = dish.cost;
        this.description = dish.description;
        this.isVegetarian = dish.isVegetarian;

    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    @Override
    public String toString() {
        return "DishResponse{" +
                "dishId=" + dishId +
                ", dishName='" + dishName + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", isVegetarian=" + isVegetarian +
                '}';

    }
}


//    Dish
//                int dishId=
//                string dishName
//                int cost="
//                string description='
//                boolean isVegetarian=