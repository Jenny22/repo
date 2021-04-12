package com.cn.demo.controller;


import com.cn.demo.config.WebSocketConfig;
import com.cn.demo.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

    @Autowired
    private WebSocketConfig webSocketConfig;
    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping("/get")
    public String get() {
        System.out.println("here");
        subscriptionService.call();

        return "bbbb";
    }
}
