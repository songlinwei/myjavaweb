package com.springapp.service.impl;

import com.springapp.dao.UserDAO;
import com.springapp.model.User;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by songlinwei on 16/2/22.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    public int insertUser(User user) {
        return userDAO.insertUser(user);
    }
}
