package com.pms.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.user.entity.Appointment;
import com.pms.user.entity.AppointmentDiagnosis;
import com.pms.user.entity.AppointmentDiagnosisId;

@Repository
public interface AppointmentDiagnosisRepository extends CrudRepository<AppointmentDiagnosis,AppointmentDiagnosisId>{
	@Query(value="select * from Appointment_Diagnosis where Appointment_Diagnosis.Appointment_Id=?1",nativeQuery=true)
	List<AppointmentDiagnosis> findAppointmentDiagnosisByAppointment(Appointment appointment);

}
