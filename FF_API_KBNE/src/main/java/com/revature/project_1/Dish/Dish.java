package com.revature.project_1.Dish;

public class Dish {

    public long dishId;
    public String dishName;
    public double cost;
    public String description;
    public boolean isVegetarian;

    public Dish(long dishId, String dishName, double cost, String description, boolean isVegetarian) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.cost = cost;
        this.description = description;
        this.isVegetarian = isVegetarian;
    }

    public long getDishId() {
        return dishId;
    }

    public void setDishId(long dishId) {
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
}
