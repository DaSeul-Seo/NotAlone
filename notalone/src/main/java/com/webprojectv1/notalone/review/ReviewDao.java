package com.webprojectv1.notalone.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groovy.util.logging.Slf4j;

@Slf4j
@Service
public class ReviewDao {
    @Autowired
    private IReviewRepository reviewRepository;
}
