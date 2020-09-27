package org.guipavarina.iqoption.factory;

import org.guipavarina.iqoption.event.Events;
import org.guipavarina.iqoption.ws.response.CandleRootMessage;
import org.guipavarina.iqoption.ws.response.ProfileRootMessage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseFactory {
	
	public static Object transform(Events ev, String message) {
		if(Events.CANDLE.equals(ev)) {
			return convert(message, CandleRootMessage.class);
		} else if (Events.PROFILE.equals(ev)) {
			return convert(message, ProfileRootMessage.class);
		}
		return null;
	}
	
	private static Object convert(String message, Class<?> c) {
		try {
			return new ObjectMapper().readValue(message, c);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
