package com.webprojectv1.notalone.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    private UserDao userDao;

    // C(Insert) & U(Update)
    public void insertAndUpdateUser(SiteUser userDto) {
        log.info("[UserService] User Insert And Update");
        userDao.insertUpdateUser(userDto);
    }

    // R(Select)
    public List<SiteUser> selectUserAll() {
        log.info("[UserService] User Select");
        List<SiteUser> userList = userDao.selectUserAll();
        return userList;
    }

    // D(Delete)
    public void deleteUser(long userId) {
        log.info("[UserService] User Delete");
        userDao.deleteUser(userId);
    }

    public SiteUser create(String username, String email, String password) {
        SiteUser user = new SiteUser();
        user.setUserName(username);
        user.setUserAddress(email);
        user.setUserPw(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }
}
