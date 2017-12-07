package com.springapp.dao.impl;

import com.springapp.dao.UserDAO;
import com.springapp.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


/**
 * Created by songlinwei on 16/2/23.
 */
//@Repository("userDAO")
@Repository
public class UserDAOImpl implements UserDAO {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlSession;


    @Override
    public int insertUser(User user) {
        return sqlSession.insert("com.springapp.dao.UserDAO.insertUser", user);
    }

}
