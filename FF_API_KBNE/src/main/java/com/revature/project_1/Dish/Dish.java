package com.revature.project_1.Dish;

import com.revature.project_1.Dish.DTO.response.DishResponse;

import javax.persistence.*;

@Entity(name="dishes")
@Table(name="dishes")
public class Dish {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public int dishId;

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

    public Dish(DishResponse byDishID) {
        this.dishId=byDishID.dishId;
        this.dishName=byDishID.dishName;
        this.description=byDishID.description;
        this.cost=byDishID.cost;
        this.isVegetarian=byDishID.isVegetarian;
    }

    public int getDishId () {return dishId;}

    public void setDishId (int dishId){this.dishId = dishId;}

    public String getDishName () {return dishName;}

    public void setDishName (String dishName){this.dishName = dishName;}

    public double getCost () {return cost;}

    public void setCost ( double cost){this.cost = cost;}

    public String getDescription () {return description;}

    public void setDescription (String description){this.description = description;}

    public boolean isVegetarian () {return isVegetarian;}

    public void setVegetarian (boolean vegetarian){isVegetarian = vegetarian;}

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", dishName='" + dishName + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", isVegetarian=" + isVegetarian +
                '}';
    }
}
