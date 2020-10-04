package org.guipavarina.iqoption.enums;

public enum BinaryOptionId {
	
	TURBO(3),
	BINARY(1);
	
	private int id;
	
	private BinaryOptionId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public static BinaryOptionId getOptionIdByExpiration(int minutes) {
		if(minutes >= 1 && minutes <= 5)
			return TURBO;
		else 
			return BINARY;
		// TODO implement exception case it is lower than 1
	}

}
