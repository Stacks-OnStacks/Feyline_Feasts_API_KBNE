package com.revature.project_1.Dish;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dish")
public class Dish {

    @Id
    public String dishId;

    @Column(name = "dish_name")
    public String dishName;

    @Column(name = "cost")
    public double cost;

    @Column(name = "description")
    public String description;

    @Column(name = "is_vegetarian")
    public boolean isVegetarian;


    public Dish(){super();}

    public Dish( String dishName, double cost, String description, boolean isVegetarian) {

        this.dishName = dishName;
        this.cost = cost;
        this.description = description;
        this.isVegetarian = isVegetarian;
    }

    public String getDishId () {return dishId;}

    public void setDishId ( String dishId){this.dishId = dishId;}

    public String getDishName () {return dishName;}

    public void setDishName (String dishName){this.dishName = dishName;}

    public double getCost () {return cost;}

    public void setCost ( double cost){this.cost = cost;}

    public String getDescription () {return description;}

    public void setDescription (String description){this.description = description;}

    public boolean isVegetarian () {return isVegetarian;}

    public void setVegetarian ( boolean vegetarian){isVegetarian = vegetarian;}

}
