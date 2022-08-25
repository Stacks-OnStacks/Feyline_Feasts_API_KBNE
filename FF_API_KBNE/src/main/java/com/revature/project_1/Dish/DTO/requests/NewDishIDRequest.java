package com.revature.project_1.Dish.DTO.requests;

public class NewDishIDRequest {

        public String dishId;
        public String dishName;
        public double cost;
        public String description;
        public boolean isVegetarian;

        public String getDishId() {
            return dishId;
        }

        public void setDishId(String dishId) {
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


//          "dishId=" + dishId +
//          ", dishName='" + dishName + '\'' +
//          ", cost=" + cost +
//          ", description='" + description + '\'' +
//          ", isVegetarian=" + isVegetarian +
//          '}';