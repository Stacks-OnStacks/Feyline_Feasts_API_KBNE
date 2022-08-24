package com.revature.project_1.util.interfaces;

import com.revature.project_1.Users.User;

import java.util.List;

import java.util.List;

public interface Crudable<T> {


    // Create
    T create(T newObject);

    //Read
    List<T> findAll();
    T findById(String id);

    // Update
    boolean update(T updatedObject);

    //Delete
    boolean delete(String id);
}
