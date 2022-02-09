package com.citiustech.pms.auth.model;

public class MonthCount {

	private int datePart;
	private long count;
	
	public int getDatePart() {
		return datePart;
	}
	public void setDatePart(int datePart) {
		this.datePart = datePart;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (count ^ (count >>> 32));
		result = prime * result + datePart;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonthCount other = (MonthCount) obj;
		if (count != other.count)
			return false;
		if (datePart != other.datePart)
			return false;
		return true;
	}
	public MonthCount(int datePart, long count) {
		super();
		this.datePart = datePart;
		this.count = count;
	}
	public MonthCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
