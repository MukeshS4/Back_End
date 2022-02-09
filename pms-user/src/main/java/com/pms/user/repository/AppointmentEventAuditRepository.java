package com.pms.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.user.entity.Appointment;
import com.pms.user.entity.AppointmentEventAudit;

@Repository
public interface AppointmentEventAuditRepository extends CrudRepository<AppointmentEventAudit, String>{

	List<AppointmentEventAudit> findAllByAppointmentId(Appointment appointment);
}
