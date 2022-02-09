package com.pms.user.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.user.dto.NotesDTO;
import com.pms.user.entity.Notes;
import com.pms.user.repository.NotesRepository;

@Service
public class NotesService {
	
	@Autowired
	private NotesRepository notesRepository;
	
	@Autowired
	private UserDataService userDataService;
	
	public String saveNotesDetails(NotesDTO notesDto) {
		if(notesDto.getReceiver()!=null)
		{
			try {
				Notes notes=new Notes();
				notes.setReceiverId(notesDto.getReceiver());
				notes.setDateTime(LocalDateTime.now());
				notes.setMessage(notesDto.getMessage());
				notes.setSenderId(userDataService.getUserDataByEmailId(notesDto.getSender()));
				notes.setPriority(notesDto.isPriority());
				notes.setParentNotesId(notesDto.getParentNotesId());
				notes.setStatus(notesDto.getStatus());
				notesRepository.save(notes);
			} catch (IllegalArgumentException e) {
				System.out.println("Exception while sending notes"+e.getMessage());
				e.printStackTrace();
			}
			return "Notes sent successfully";
		}
		else
			return "Notes cannot be sent";
		
	}
	
	public List<Notes> getNotesByReceiverId(String receiverId,String status){
		List<Notes> allNotes = new ArrayList<>();
		notesRepository.findNotesByReceiverIdAndStatus(userDataService.getUserDataByEmailId(receiverId),status).iterator().forEachRemaining(not->{
			allNotes.add(not);
		});
		return allNotes;
	}
	
	public List<Notes> getNotesBySenderId(String senderId,String status){
		List<Notes> allNotes = new ArrayList<>();
		notesRepository.findNotesBySenderIdAndStatus(userDataService.getUserDataByEmailId(senderId),status).iterator().forEachRemaining(not->{
			allNotes.add(not);
		});
		return allNotes;
	}
	
	public List<Notes> getAllNotes(){
		List<Notes> allNotes = new ArrayList<>();
		notesRepository.findAll().iterator().forEachRemaining(not->{
			allNotes.add(not);
		});
		return allNotes;
	}
	
	public Notes getNotesByNotesId(long notesId) {
		Optional<Notes> notes = null;
		notes = notesRepository.findById(notesId);
		return notes.orElse(null);
	}
	
	public void closeNotes(long notesId) {
		Optional<Notes> notes=notesRepository.findById(notesId);
		notes.get().setStatus("CLOSE");
		notesRepository.save(notes.get());
	}

}
