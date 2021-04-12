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
        String bearerToken = "eyJhbGciOiJFUzI1NiIsIng1dCI6IjhGQzE5Qjc0MzFCNjNFNTVCNjc0M0QwQTc5MjMzNjZCREZGOEI4NTAifQ.eyJvYWEiOiI3Nzc3NSIsImlzcyI6Im9hIiwiYWlkIjoiMTA5IiwidWlkIjoielE3UE1EZUJzRk5COXlrMXBwYmJGdz09IiwiY2lkIjoielE3UE1EZUJzRk5COXlrMXBwYmJGdz09IiwiaXNhIjoiRmFsc2UiLCJ0aWQiOiIyMDAyIiwic2lkIjoiYTIyMjk5ZWIzZTdkNDI2N2JhYzY1YTkyMzZmOWFjMWEiLCJkZ2kiOiI4NCIsImV4cCI6IjE2MTgzMDA5MTIifQ._jGhhpeW1G3Yp8hJUQwzGzj-BE9uZtEwq0mI2TXMPvDblx6pjTXdN71Zc2xedMtXDN9mn23_HW-V3MqEZYSA2w";
        String contextId = "explorer_1618218099024";
        String connectToken = "FD5z3cTYboXTp%2Fy7gVAtA1A8gY%2F416XEOp6Nbapvc1IcZx5VEcJSVtSibzYPCS7nxwCnM64vIuWGmMnOWRNIYR8LMoFPbeLSpGXIXTSgWi%2FCQ9Dc";
        String tid = "3";
        WebSocketConnectionManager manager = new WebSocketConnectionManager(
                webSocketClient(),
                webSocketHandler(),
                "wss://streaming.saxotrader.com/sim/openapi/streaming/connection/connect?transport=webSockets&connectionToken=jCHxFf0mbsqo%2BiJF4wTPUDzb7cwoNneDZXa%2BjNvMmx6lzdKyOEfG7N1%2FJS9DB0sRN1GqbPn5RC3wsSK9NoORVnDa4v0bsSsxRE2EcIy8kohT%2BjHV&authorization=eyJhbGciOiJFUzI1NiIsIng1dCI6IjhGQzE5Qjc0MzFCNjNFNTVCNjc0M0QwQTc5MjMzNjZCREZGOEI4NTAifQ.eyJvYWEiOiI3Nzc3NSIsImlzcyI6Im9hIiwiYWlkIjoiMTA5IiwidWlkIjoielE3UE1EZUJzRk5COXlrMXBwYmJGdz09IiwiY2lkIjoielE3UE1EZUJzRk5COXlrMXBwYmJGdz09IiwiaXNhIjoiRmFsc2UiLCJ0aWQiOiIyMDAyIiwic2lkIjoiYTIyMjk5ZWIzZTdkNDI2N2JhYzY1YTkyMzZmOWFjMWEiLCJkZ2kiOiI4NCIsImV4cCI6IjE2MTgzMDA5MTIifQ._jGhhpeW1G3Yp8hJUQwzGzj-BE9uZtEwq0mI2TXMPvDblx6pjTXdN71Zc2xedMtXDN9mn23_HW-V3MqEZYSA2w&context=explorer_1618223191581&tid=5");

        manager.setAutoStartup(true);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setBearerAuth(bearerToken);

//        httpHeaders.setAccessControlAllowCredentials(true);
//        httpHeaders.setAccessControlAllowOrigin("https://www.developer.saxo");
//        httpHeaders.setOrigin("https://www.developer.saxo");
//        httpHeaders.setUpgrade("websocket");
//        httpHeaders.setConnection("Upgrade");
//        manager.setHeaders(httpHeaders);

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
