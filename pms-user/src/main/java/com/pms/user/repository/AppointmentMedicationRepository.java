package com.pms.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.user.entity.Appointment;
import com.pms.user.entity.AppointmentMedication;
import com.pms.user.entity.AppointmentMedicationId;

@Repository
public interface AppointmentMedicationRepository extends CrudRepository<AppointmentMedication,AppointmentMedicationId>{

	@Query(value="select * from Appointment_Medication where Appointment_Medication.Appointment_id=?1",nativeQuery=true)
	List<AppointmentMedication> findAppointmentMedicationByAppointment(Appointment appointment);
}
