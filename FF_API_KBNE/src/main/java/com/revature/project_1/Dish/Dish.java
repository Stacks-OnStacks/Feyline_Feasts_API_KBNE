package com.revature.project_1.Dish;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.sql.Date;

public class Dish {


    @Id
    public long dishId;
    @Column(name = "dishName")
    public String dishName;
    @Column
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
