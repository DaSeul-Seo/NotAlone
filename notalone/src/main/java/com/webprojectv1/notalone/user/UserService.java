package com.webprojectv1.notalone.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    // C(Insert) & U(Update)
    public void insertAndUpdateUser(User userDto) {
        log.info("[UserService] User Insert And Update");
        userDao.insertUpdateUser(userDto);
    }

    // R(Select)
    public List<User> selectUserAll() {
        log.info("[UserService] User Select");
        List<User> userList = userDao.selectUserAll();
        return userList;
    }

    // D(Delete)
    public void deleteUser(long userId) {
        log.info("[UserService] User Delete");
        userDao.deleteUser(userId);
    }
}
