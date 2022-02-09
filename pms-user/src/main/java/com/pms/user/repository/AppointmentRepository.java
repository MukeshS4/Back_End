package com.pms.user.repository;

import java.time.LocalDate;
import org.springframework.data.repository.query.Param;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.user.dto.AppointmentStats;
import com.pms.user.entity.Appointment;
import com.pms.user.entity.PatientData;
import com.pms.user.entity.UserData;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, String>{

	@Query("select time from Appointment where date=?1 and status!=?2 and employee = ?3")
	List<String> getBookedSlotByDateAndStatusAndEmployee(LocalDate localDate,int status, UserData employee);
	
	@Query(value="select * from Appointment where status in (?1)",nativeQuery = true)
	List<Appointment> getAllAppointmentByStatus(List<Integer> status);
	
	@Query(value="select * from Appointment where status in (?1) and employee_id=?2",nativeQuery=true)
	List<Appointment> getAllAppointmentByStatusAndEmployee(List<Integer> status,String userId);
	
	@Query(value="select new com.pms.user.dto.AppointmentStats(status,count(appointmentId) as appointmentCount) from Appointment group by status")
	List<AppointmentStats> findAppointmentStats_Named();
	
	@Query(value="select new com.pms.user.dto.AppointmentStats(status,count(appointmentId) as appointmentCount) from Appointment where employee=?1 group by status")
	List<AppointmentStats> findAppointmentStatsByEmployee_Named(UserData employee);
	
	List<Appointment> findAppointmentByEmployee(UserData user);
	
	List<Appointment> findAppointmentByDateAndStatus(LocalDate date,int status);
	
	List<Appointment> findAppointmentByDateAndStatusAndEmployee(LocalDate date,int status,UserData user);
	
	List<Appointment> findAppointmentByPatientDataAndStatus(PatientData patient,int status);
	
	@Query(value="select * from Appointment a where a.patient_id=:patientId where a.review=false and a.status=4",nativeQuery = true)
	List<Appointment> findByPatientId(@Param("patientId")int patientId);
}
