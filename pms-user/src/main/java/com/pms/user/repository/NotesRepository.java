package com.pms.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.user.entity.Notes;
import com.pms.user.entity.UserData;

@Repository
public interface NotesRepository extends CrudRepository<Notes, Long>{

	List<Notes> findNotesByReceiverIdAndStatus(UserData receiver,String status);
	
	List<Notes> findNotesBySenderIdAndStatus(UserData receiver,String status);
}
