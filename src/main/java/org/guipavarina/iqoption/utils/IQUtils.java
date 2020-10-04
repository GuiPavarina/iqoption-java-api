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

}
