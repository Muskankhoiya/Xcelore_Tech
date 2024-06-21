package com.xcelore.swagger.controller;

import com.xcelore.swagger.model.Tweet;
import com.xcelore.swagger.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TweetController {
    @Autowired
    private TweetService tweetService;

    @PostMapping("/add")
    public void addTweet() {
        tweetService.addTweet();
    }

    @GetMapping("/view")
    public List<Tweet> viewTweets() {
        return tweetService.getTweets();
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
}
