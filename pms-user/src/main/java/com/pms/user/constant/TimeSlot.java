package com.pms.user.constant;

public enum TimeSlot {
	SLOT_1("09:00"),
	SLOT_2("09:30"),
	SLOT_3("10:00"),
	SLOT_4("10:30"),
	SLOT_5("11:00"),
	SLOT_6("11:30"),
	SLOT_7("12:00"),
	SLOT_8("12:30"),
	SLOT_9("13:00"),
	SLOT_10("15:00"),
	SLOT_11("15:30"),
	SLOT_12("16:00"),
	SLOT_13("16:30"),
	SLOT_14("17:00"),
	SLOT_15("17:30"),
	SLOT_16("18:00"),
	SLOT_17("18:30"),
	SLOT_18("19:00"),
	SLOT_19("19:30"),
	SLOT_20("20:00");
	

	private String timeSlot;
	
	TimeSlot(String time) {
		this.timeSlot=time;
	}
	
	public String getTimeSlot() {
		return this.timeSlot;
	}
}
