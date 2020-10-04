package org.guipavarina.iqoption.utils;

import java.time.Instant;

public class IQUtils {
	
	/**
	 * returns current time epoch in seconds
	 * @return long
	 */
	public static long getCurrentTime() {
		return Instant.now().getEpochSecond();
	}
	
	public static long getExpiration(int minutes) {
		long now = getCurrentTime();
		if(minutes >= 1 && minutes  <= 5) {
            if ((now % 60) > 30)
                return now - (now % 60) + 60 * (minutes + 1);
            else
            	return now - (now % 60) + 60 * (minutes);
		} else if (minutes > 5) {
//			TODO
			return 0;
		}
		return 0;
	}

}
