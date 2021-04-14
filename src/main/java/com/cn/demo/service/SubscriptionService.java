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
        String bearerToken = "eyJhbGciOiJFUzI1NiIsIng1dCI6IjhGQzE5Qjc0MzFCNjNFNTVCNjc0M0QwQTc5MjMzNjZCREZGOEI4NTAifQ.eyJvYWEiOiI3Nzc3NSIsImlzcyI6Im9hIiwiYWlkIjoiMTA5IiwidWlkIjoielE3UE1EZUJzRk5COXlrMXBwYmJGdz09IiwiY2lkIjoielE3UE1EZUJzRk5COXlrMXBwYmJGdz09IiwiaXNhIjoiRmFsc2UiLCJ0aWQiOiIyMDAyIiwic2lkIjoiZThjYzZlYjNiNmViNDE2ODkzNTczMThjYzU1M2FiOWIiLCJkZ2kiOiI4NCIsImV4cCI6IjE2MTg0NTA1MTgifQ.OiN5BgUA0glhCIUcYhBK7JALOD7LI3S81epdWRd_d6rn0SDcJtVZCpW1RVl81tnDTxr2ivlrz99KBeF2GHnYqA";
        String contextId = "explorer_1618364123021";
        String accountKey = "zQ7PMDeBsFNB9yk1ppbbFw==";
        String referenceId = "I_555";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(bearerToken);
        headers.set("Host", "streaming.saxobank.com");
        String requestStr = "{\n" +
                "            \"Arguments\": {\n" +
                "            \"AssetType\": \"FxSpot\",\n" +
                "                    \"Uic\": 22\n" +
                "        },\n" +
                "            \"ContextId\": \"explorer_1618364123021\",\n" +
                "                \"ReferenceId\": \"IP44964\",\n" +
                "                \"RefreshRate\": 1000\n" +
                "        }";
        HttpEntity<String> requestEntity = new HttpEntity<String>(requestStr, headers);
        String result = restTemplate.postForObject("https://gateway.saxobank.com/sim/openapi/trade/v1/prices/subscriptions"
                ,requestEntity
                , String.class);
        log.info("call subscription" + result);
        return result;

    }
}
