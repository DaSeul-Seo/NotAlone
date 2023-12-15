package com.webprojectv1.notalone.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groovy.util.logging.Slf4j;

@Slf4j
@Service
public class UserDao {
    @Autowired
    private IUserRepository userRepository;
}
