package com.citiustech.pms.auth.model;

public class Statistics {
	
	private int physicianCount;
	private int nurseCount;
	private int inActivePhysician;
	private int inActiveNurse;
	private int lockedUsers;
	private int lockedPatients;
	private int inActivePatients;
	private int patientsCount;
	
	
	public int getPatientsCount() {
		return patientsCount;
	}
	public void setPatientsCount(int patientsCount) {
		this.patientsCount = patientsCount;
	}
	public int getPhysicianCount() {
		return physicianCount;
	}
	public void setPhysicianCount(int physicianCount) {
		this.physicianCount = physicianCount;
	}
	public int getNurseCount() {
		return nurseCount;
	}
	public void setNurseCount(int nurseCount) {
		this.nurseCount = nurseCount;
	}
	public int getInActivePhysician() {
		return inActivePhysician;
	}
	public void setInActivePhysician(int inActivePhysician) {
		this.inActivePhysician = inActivePhysician;
	}
	public int getInActiveNurse() {
		return inActiveNurse;
	}
	public void setInActiveNurse(int inActiveNurse) {
		this.inActiveNurse = inActiveNurse;
	}
	public int getLockedUsers() {
		return lockedUsers;
	}
	public void setLockedUsers(int lockedUsers) {
		this.lockedUsers = lockedUsers;
	}
	public int getLockedPatients() {
		return lockedPatients;
	}
	public void setLockedPatients(int lockedPatients) {
		this.lockedPatients = lockedPatients;
	}
	public int getInActivePatients() {
		return inActivePatients;
	}
	public void setInActivePatients(int inActivePatients) {
		this.inActivePatients = inActivePatients;
	}
	@Override
	public String toString() {
		return "Statistics [physicianCount=" + physicianCount + ", nurseCount=" + nurseCount + ", inActivePhysician="
				+ inActivePhysician + ", inActiveNurse=" + inActiveNurse + ", lockedUsers=" + lockedUsers
				+ ", lockedPatients=" + lockedPatients + ", inActivePatients=" + inActivePatients + "]";
	}
	public Statistics(int physicianCount, int nurseCount, int inActivePhysician, int inActiveNurse, int lockedUsers,
			int lockedPatients, int inActivePatients) {
		super();
		this.physicianCount = physicianCount;
		this.nurseCount = nurseCount;
		this.inActivePhysician = inActivePhysician;
		this.inActiveNurse = inActiveNurse;
		this.lockedUsers = lockedUsers;
		this.lockedPatients = lockedPatients;
		this.inActivePatients = inActivePatients;
	}
	public Statistics() {
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + inActiveNurse;
		result = prime * result + inActivePatients;
		result = prime * result + inActivePhysician;
		result = prime * result + lockedPatients;
		result = prime * result + lockedUsers;
		result = prime * result + nurseCount;
		result = prime * result + physicianCount;
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
		Statistics other = (Statistics) obj;
		if (inActiveNurse != other.inActiveNurse)
			return false;
		if (inActivePatients != other.inActivePatients)
			return false;
		if (inActivePhysician != other.inActivePhysician)
			return false;
		if (lockedPatients != other.lockedPatients)
			return false;
		if (lockedUsers != other.lockedUsers)
			return false;
		if (nurseCount != other.nurseCount)
			return false;
		if (physicianCount != other.physicianCount)
			return false;
		return true;
	}
	
	

}
