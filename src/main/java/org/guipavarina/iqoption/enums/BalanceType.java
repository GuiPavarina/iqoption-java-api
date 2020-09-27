package org.guipavarina.iqoption.enums;

public enum BalanceType {

	REAL(1),
	PRACTICE(4);
	
	private int id;
	
	BalanceType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public static BalanceType get(int id) {
		for(BalanceType b: values()) {
			if(b.getId() == id) {
				return b;
			}
		}
		return null;
	}
	
}
