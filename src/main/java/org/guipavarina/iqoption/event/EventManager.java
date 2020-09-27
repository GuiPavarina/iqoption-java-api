package org.guipavarina.iqoption.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventManager {
	
	private final Logger logger = LoggerFactory.getLogger(EventManager.class);
	
	private Map<Events, List<EventListener>> subscribers = new HashMap<>();
	
	public EventManager() {
		
		for(Events ev: Events.values()) {
			subscribers.put(ev, new ArrayList<EventListener>());
		}
	}
	
	public void subscribe(Events ev, EventListener listener) {
		subscribers.get(ev).add(listener);
	}
	
	public void unsubscribe(Events ev, EventListener listener) {
		subscribers.get(ev).remove(listener);
	}
	
	public void notif(String messageName, String originalMessage) {
		Events ev = Events.get(messageName);
		
		if(ev == null) {
			logger.debug("Ignored: " + messageName);
			return;
		}
		logger.debug("not ignored: " + messageName);
		for(EventListener listener: subscribers.get(ev)) {
			listener.update(ev, originalMessage);
		}
		
	}
}
