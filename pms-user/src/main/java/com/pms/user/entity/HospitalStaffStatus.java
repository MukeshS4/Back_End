/*
 * package com.pms.user.entity;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.Id; import javax.persistence.JoinColumn; import
 * javax.persistence.ManyToOne; import javax.persistence.OneToMany;
 * 
 * import org.hibernate.annotations.Check;
 * 
 * @Entity public class HospitalStaffStatus {
 * 
 * @Id
 * 
 * @Column(name = "Status_Id", columnDefinition = "serial", updatable = false)
 * private int statusId;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "Employee_Id", referencedColumnName = "Employee_Id")
 * private UserData employee;
 * 
 * @Check(constraints="'Active', 'Inactive'")
 * 
 * @Column(name="Staff_Status") private String staffStatus;
 * 
 * @Check(constraints="'Locked', 'Unlocked'")
 * 
 * @Column(name="Account_Status") private String accountStatus;
 * 
 * public int getStatusId() { return statusId; }
 * 
 * public void setStatusId(int statusId) { this.statusId = statusId; }
 * 
 * public UserData getEmployee() { return employee; }
 * 
 * public void setEmployee(UserData employee) { this.employee = employee; }
 * 
 * public String getStaffStatus() { return staffStatus; }
 * 
 * public void setStaffStatus(String staffStatus) { this.staffStatus =
 * staffStatus; }
 * 
 * public String getAccountStatus() { return accountStatus; }
 * 
 * public void setAccountStatus(String accountStatus) { this.accountStatus =
 * accountStatus; }
 * 
 * public HospitalStaffStatus(int statusId, UserData employee, String
 * staffStatus, String accountStatus) { super(); this.statusId = statusId;
 * this.employee = employee; this.staffStatus = staffStatus; this.accountStatus
 * = accountStatus; }
 * 
 * public HospitalStaffStatus() { super(); // TODO Auto-generated constructor
 * stub }
 * 
 * @Override public String toString() { return "HospitalStaffStatus [statusId="
 * + statusId + ", employee=" + employee + ", staffStatus=" + staffStatus +
 * ", accountStatus=" + accountStatus + "]"; }
 * 
 * 
 * }
 */