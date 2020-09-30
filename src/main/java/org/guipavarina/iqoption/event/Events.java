package org.guipavarina.iqoption.event;

public enum Events {
	
	PROFILE("profile"),
	HEARTBEAT("heartbeat"),
	TIMESYNC("timeSync"),
	CANDLE("candles"),
	INITIALIZATION_DATA("initialization-data");
	
	private String eventName;
	
	Events(String eventName) {
		this.eventName = eventName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public static Events get(String event) {
		for(Events ev: values()) {
			if(ev.getEventName().equals(event))
				return ev;
		}
		return null;
	}

}
