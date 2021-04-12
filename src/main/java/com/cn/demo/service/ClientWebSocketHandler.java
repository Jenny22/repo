package com.cn.demo.service;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import org.apache.logging.log4j.LogManager;

@Component
public class ClientWebSocketHandler extends TextWebSocketHandler {
    private static final Logger log = LogManager.getLogger(ClientWebSocketHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Client connection opened");
        TextMessage message = new TextMessage("one-time message from client");
        log.info("Client sends: {}" + message);
        session.sendMessage(message);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("Client received: {}"+ message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("Client transport error: {}" + exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("Client connection closed: {}" + status);
    }

}
