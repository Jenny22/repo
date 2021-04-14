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
        String connectToken = "aKOob%2FmTsJTA6L7RlFbEbeVSxxQCHvLB6T%2FawtnWGzSVTRtED6sIq42B0IiEcsfXplKkapv742lzjxKbAghzHUlmiVHjkaE5%2FjxEg1YwCQSCAbln";
        String tid = "8";
        WebSocketConnectionManager manager = new WebSocketConnectionManager(
                webSocketClient(),
                webSocketHandler(),
//                "wss://streaming.saxotrader.com/sim/openapi/streaming/connection/connect?transport=webSockets&connectionToken="+connectToken+"&authorization="+bearerToken+"&context="+contextId+"&tid="+tid
        "wss://streaming.saxotrader.com/sim/openapi/streaming/connection/connect?transport=webSockets&connectionToken=aKOob%2FmTsJTA6L7RlFbEbeVSxxQCHvLB6T%2FawtnWGzSVTRtED6sIq42B0IiEcsfXplKkapv742lzjxKbAghzHUlmiVHjkaE5%2FjxEg1YwCQSCAbln&authorization=eyJhbGciOiJFUzI1NiIsIng1dCI6IjhGQzE5Qjc0MzFCNjNFNTVCNjc0M0QwQTc5MjMzNjZCREZGOEI4NTAifQ.eyJvYWEiOiI3Nzc3NSIsImlzcyI6Im9hIiwiYWlkIjoiMTA5IiwidWlkIjoielE3UE1EZUJzRk5COXlrMXBwYmJGdz09IiwiY2lkIjoielE3UE1EZUJzRk5COXlrMXBwYmJGdz09IiwiaXNhIjoiRmFsc2UiLCJ0aWQiOiIyMDAyIiwic2lkIjoiZThjYzZlYjNiNmViNDE2ODkzNTczMThjYzU1M2FiOWIiLCJkZ2kiOiI4NCIsImV4cCI6IjE2MTg0NTA1MTgifQ.OiN5BgUA0glhCIUcYhBK7JALOD7LI3S81epdWRd_d6rn0SDcJtVZCpW1RVl81tnDTxr2ivlrz99KBeF2GHnYqA&context=explorer_1618364123021&tid=8"
        );

        manager.setAutoStartup(true);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(bearerToken);

        httpHeaders.setAccessControlAllowCredentials(true);
        httpHeaders.setAccessControlAllowOrigin("https://www.developer.saxo");
        httpHeaders.setBearerAuth(bearerToken);
//        httpHeaders.set("contextId", contextId);
        httpHeaders.setConnection("Upgrade");
        httpHeaders.setUpgrade("websocket");
        httpHeaders.set("Sec-WebSocket-Key", "+/HfUonDSkDCMLcFwvSdcw==");
        httpHeaders.set("Sec-WebSocket-Version", "13");
//        httpHeaders.set("Sec-WebSocket-Extensions", "permessage-deflate; client_max_window_bits");
//        httpHeaders.set("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36");
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
