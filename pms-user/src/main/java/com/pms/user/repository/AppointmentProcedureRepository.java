package com.pms.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.user.entity.Appointment;
import com.pms.user.entity.AppointmentProcedure;
import com.pms.user.entity.AppointmentProcedureId;

@Repository
public interface AppointmentProcedureRepository extends CrudRepository<AppointmentProcedure,AppointmentProcedureId>{

	@Query(value="select * from Appointment_Procedure where Appointment_Procedure.Appointment_id=?1",nativeQuery = true)
	List<AppointmentProcedure> findAppointmentProcedureByAppointment(Appointment appointment);
}
