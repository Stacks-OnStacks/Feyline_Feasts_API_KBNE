package com.revature.project_1.Users;

import com.revature.project_1.Users.DTO.requests.EditUserRequest;
import com.revature.project_1.Users.DTO.requests.NewUserRequest;
import com.revature.project_1.Users.DTO.response.UserResponse;
import com.revature.project_1.util.exceptions.InvalidUserInputException;
import com.revature.project_1.util.exceptions.ResourcePersistanceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserService {

    private final UserDao userDao;
    private User sessionUser= null;
    private final Logger logger= LogManager.getLogger();



    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public User login(String username, String password) {
        User user= userDao.loginCredCheck(username,password);
        sessionUser=user;
        return user;
    }

    public UserResponse findByUsername(String username) {

        User user=userDao.findById(username);
        UserResponse userResponse= new UserResponse(user);
        return userResponse;
    }

    public List<UserResponse> readAll() {
        List<UserResponse> users = userDao.findAll()
                .stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());

        return users;
    }

    public UserResponse registerUser(NewUserRequest newRegistration) {
        User newUser= new User();


        newUser.setUsername(newRegistration.username);
        newUser.setFname(newRegistration.fname);
        newUser.setLname(newRegistration.lname);
        newUser.setPassword(newRegistration.password);
        newUser.setDob(newRegistration.dob);
        newUser.setAdmin(newUser.isAdmin());

        logger.info("User registration service has begun with the provide: {}", newUser);
        if(!isUserValid(newUser)){
            throw new InvalidUserInputException("user input was invalid");
        }

        if(!isUsernameAvailable(newUser.getUsername())){
            throw new ResourcePersistanceException("Email is already registered please try logging in.");
        }
        userDao.create(newUser);

        return new UserResponse(newUser);
    }

    private boolean isUsernameAvailable(String username) {
        return userDao.isUsernameAvailable(username);
    }

    private boolean isUserValid(User newUser) {
        if(newUser==null)return false;

        if(newUser.getUsername()==null||newUser.getUsername().trim().equals("")) return false;
        if(newUser.getFname()==null||newUser.getFname().trim().equals("")) return false;
        if(newUser.getLname()==null||newUser.getLname().trim().equals("")) return false;
        if(newUser.getPassword()==null||newUser.getPassword().trim().equals("")) return false;
        if(newUser.getDob()==null) return false;
        return true;
    }

    public boolean update(EditUserRequest editUser) {
        User foundUser= userDao.findById(editUser.getId());
        System.out.println(editUser.toString());
        Predicate<String> notNullorEmt= (str) -> str !=null && !str.trim().equals("");

        if (notNullorEmt.test(editUser.getFname())){
            foundUser.setFname(editUser.getFname());
        }
        if (notNullorEmt.test(editUser.getLname())){
            foundUser.setLname(editUser.getLname());
        }
        if (notNullorEmt.test(editUser.getPassword())){
            foundUser.setPassword(editUser.getPassword());
        }
        System.out.println(foundUser.toString());
        return userDao.update(foundUser);

    }

    public boolean remove(String username) {
        return userDao.delete(username);
    }
}
