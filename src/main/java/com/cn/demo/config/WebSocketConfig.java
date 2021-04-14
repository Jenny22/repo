package com.cn.demo.config;

import com.cn.demo.service.ClientWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.config.annotation.EnableWebSocket;



@Configuration
@EnableWebSocket
public class WebSocketConfig {

    @Bean
    public WebSocketConnectionManager webSocketConnectionManager() {
        String bearerToken = "eyJhbGciOiJFUzI1NiIsIng1dCI6IjhGQzE5Qjc0MzFCNjNFNTVCNjc0M0QwQTc5MjMzNjZCREZGOEI4NTAifQ.eyJvYWEiOiI3Nzc3NSIsImlzcyI6Im9hIiwiYWlkIjoiMTA5IiwidWlkIjoielE3UE1EZUJzRk5COXlrMXBwYmJGdz09IiwiY2lkIjoielE3UE1EZUJzRk5COXlrMXBwYmJGdz09IiwiaXNhIjoiRmFsc2UiLCJ0aWQiOiIyMDAyIiwic2lkIjoiZThjYzZlYjNiNmViNDE2ODkzNTczMThjYzU1M2FiOWIiLCJkZ2kiOiI4NCIsImV4cCI6IjE2MTg0NTA1MTgifQ.OiN5BgUA0glhCIUcYhBK7JALOD7LI3S81epdWRd_d6rn0SDcJtVZCpW1RVl81tnDTxr2ivlrz99KBeF2GHnYqA";
        String contextId = "explorer_1618364123021";
        WebSocketConnectionManager manager = new WebSocketConnectionManager(
                webSocketClient(),
                webSocketHandler(),
//                "wss://streaming.saxotrader.com/sim/openapi/streaming/connection/connect?transport=webSockets&connectionToken="+connectToken+"&authorization="+bearerToken+"&context="+contextId+"&tid="+tid
        "wss://streaming.saxobank.com/sim/openapi/streamingws/connect?ContextId="+contextId
        );

        manager.setAutoStartup(true);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(bearerToken);

        httpHeaders.setBearerAuth(bearerToken);
        httpHeaders.setConnection("Upgrade");
        httpHeaders.setUpgrade("Websocket");
        httpHeaders.set("Sec-WebSocket-Key", "gnPAlQRoyFI3zMnCgm3vlQ==");
        httpHeaders.set("Sec-WebSocket-Version", "13");
        httpHeaders.set("Host", "streaming.saxobank.com");
        manager.setHeaders(httpHeaders);

        return manager;
    }


    @Bean
    public WebSocketClient webSocketClient() {
        return new StandardWebSocketClient();
    }

    @Bean
    public WebSocketHandler webSocketHandler() {
        return new ClientWebSocketHandler();
    }
}
