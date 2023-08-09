package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    User getUserById(int userId);
    User getUserByUsername(String username);

    int findIdByUsername(String username);

    List<User> getUser();




}
