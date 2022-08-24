package com.revature.project_1.Dish;

import com.revature.project_1.Dish.DTO.requests.EditDishRequest;
import com.revature.project_1.Dish.DTO.requests.NewDishIDRequest;
import com.revature.project_1.Dish.DTO.response.DishResponse;
import com.revature.project_1.Users.DTO.requests.EditUserRequests;
import com.revature.project_1.Users.DTO.requests.NewRegistrationRequest;
import com.revature.project_1.Users.DTO.response.UserResponse;
import com.revature.project_1.Users.User;
import com.revature.project_1.util.exceptions.InvalidUserInputException;
import com.revature.project_1.util.exceptions.ResourcePersistanceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class DishService {

    private final DishDao dishDao;

    private Dish sessionUser = null;

    private final Logger logger = LogManager.getLogger();

    public DishService(DishDao dishDao) {
        this.dishDao = dishDao;
    }


    public DishResponse findByDishID(String DishId) {

        Dish dish = dishDao.findByDishId(DishId);
        DishResponse dishResponse = new DishResponse(dish);
        return dishResponse;
    }

    public List<DishResponse> readAll() {
        List<DishResponse> dishes = dishDao.findAll()
                .stream()
                .map(DishResponse::new)
                .collect(Collectors.toList());

        return dishes;
    }

    public DishResponse registerDish(NewDishIDRequest newDish) {
        Dish requestDish = new Dish();

        requestDish.setDishName(newDish.getDishName());
        requestDish.setCost(newDish.getCost());
        requestDish.setDescription(newDish.getDescription());
        requestDish.setVegetarian(newDish.isVegetarian());

//        if (!isDishAvailable("" + requestDish.getDishId())) {
//            throw new InvalidUserInputException("Dish not available.");
//        }
        dishDao.create(requestDish);
        return new DishResponse(requestDish);

    }




//    private boolean isDishAvailable(String DishId) {
//        return dishDao.isDishAvailable(DishId);
//    }

    public boolean update(EditDishRequest editDish) {
        Dish foundDish= dishDao.findByDishId(editDish.getDishId());

        Predicate<String> notNullorEmt= (str) -> str !=null&& str.trim().equals("");

        if (notNullorEmt.test(editDish.getDishName())){
            foundDish.setDishName(editDish.getDishName());
        }
        if (0!=(editDish.getCost())){
            foundDish.setCost(editDish.getCost());
        }
        if (notNullorEmt.test(editDish.getDescription())){
            foundDish.setDescription(editDish.getDescription());
        }
        return dishDao.update(foundDish);

    }

    public boolean remove(String dish) {
        return dishDao.delete(dish);
    }
}
