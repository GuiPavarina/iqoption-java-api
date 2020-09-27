package org.guipavarina.iqoption;

import org.guipavarina.iqoption.IQOptionWS.MessageHandler;
import org.guipavarina.iqoption.event.EventManager;
import org.guipavarina.iqoption.ws.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IQOptionMessageHandler implements MessageHandler {
	
	private final Logger logger = LoggerFactory.getLogger(IQOptionMessageHandler.class);
	
	private EventManager eventManager;
	
	public IQOptionMessageHandler(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	@Override
	public void handleMessage(String message) {	
		try {
			Message msg = new ObjectMapper().readValue(message, Message.class);
			this.eventManager.notif(msg.getName(), message);
		} catch (JsonMappingException e) {
			logger.error(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
		}
	}
	
}
