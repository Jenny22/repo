package com.cn.demo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SubscriptionService {

    private static final Logger log = LogManager.getLogger(SubscriptionService.class);

    public String call() {
        String bearerToken = "eyJhbGciOiJFUzI1NiIsIng1dCI6IjhGQzE5Qjc0MzFCNjNFNTVCNjc0M0QwQTc5MjMzNjZCREZGOEI4NTAifQ.eyJvYWEiOiI3Nzc3NSIsImlzcyI6Im9hIiwiYWlkIjoiMTA5IiwidWlkIjoielE3UE1EZUJzRk5COXlrMXBwYmJGdz09IiwiY2lkIjoielE3UE1EZUJzRk5COXlrMXBwYmJGdz09IiwiaXNhIjoiRmFsc2UiLCJ0aWQiOiIyMDAyIiwic2lkIjoiYTIyMjk5ZWIzZTdkNDI2N2JhYzY1YTkyMzZmOWFjMWEiLCJkZ2kiOiI4NCIsImV4cCI6IjE2MTgzMDA5MTIifQ._jGhhpeW1G3Yp8hJUQwzGzj-BE9uZtEwq0mI2TXMPvDblx6pjTXdN71Zc2xedMtXDN9mn23_HW-V3MqEZYSA2w";
        String contextId = "explorer_1618215607624";
        String accountKey = "zQ7PMDeBsFNB9yk1ppbbFw==";
        String referenceId = "I_555";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(bearerToken);
        String requestStr = "{" +
                "\"Arguments\": {" +
                "\"Activities\": [\"Orders\"]" +
                "}," +
                "\"ContextId\": \"explorer_1618215607624\"," +
                "\"ReferenceId\": \"I_555\"" +
                "}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(requestStr, headers);
        String result = restTemplate.postForObject("https://gateway.saxobank.com/sim/openapi/ens/v1/activities/subscriptions"
                ,requestEntity
                , String.class);
        log.info("call subscription");
        return result;

    }
}
