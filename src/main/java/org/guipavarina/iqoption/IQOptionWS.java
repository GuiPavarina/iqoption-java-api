package org.guipavarina.iqoption;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@ClientEndpoint
public class IQOptionWS {
	
	private final Logger logger = LoggerFactory.getLogger(IQOptionWS.class);

    Session userSession = null;
    private MessageHandler messageHandler;

    public IQOptionWS(URI endpointURI) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endpointURI);
        } catch (Exception e) {
        	logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @OnOpen
    public void onOpen(Session userSession) {
    	logger.info("Opening websocket");
        this.userSession = userSession;
    }

    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
    	logger.info("Closing websocket due to reason " + reason.getReasonPhrase());
        this.userSession = null;
    }

    @OnMessage
    public void onMessage(String message) {
        if (this.messageHandler != null) {
            this.messageHandler.handleMessage(message);
        }
    }
    
    public Session getUserSession() {
		return userSession;
	}

    public void addMessageHandler(MessageHandler msgHandler) {
        this.messageHandler = msgHandler;
    }

    public void sendMessage(Object message) {
    	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			String json = ow.writeValueAsString(message);
			this.userSession.getAsyncRemote().sendText(json);
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
		}
    }

    public static interface MessageHandler {
        public void handleMessage(String message);
    }
}