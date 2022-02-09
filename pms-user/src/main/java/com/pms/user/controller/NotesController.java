package com.pms.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.user.dto.NotesDTO;
import com.pms.user.entity.Notes;
import com.pms.user.service.NotesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class NotesController {
	
	@Autowired
	public NotesService notesService;
	
	@GetMapping("/notes")
	public List<Notes> getAllNotes(){
		return notesService.getAllNotes();
	}
	
	@GetMapping("/notes/receiver/{receiverId}/status/{status}")
	public List<Notes> getNotesByReceiverId(@PathVariable String receiverId,@PathVariable String status) {
		return notesService.getNotesByReceiverId(receiverId,status);
	}
	
	@GetMapping("/notes/sender/{senderId}/status/{status}")
	public List<Notes> getNotesBySenderId(@PathVariable String senderId,@PathVariable String status) {
		return notesService.getNotesBySenderId(senderId,status);
	}
	
	@PostMapping("/notes")
	public String getNotes(@RequestBody NotesDTO notes) {
		return notesService.saveNotesDetails(notes);
	}
	
	@DeleteMapping("/notes/{notesId}")
	public String closeNotes(@PathVariable int notesId) {
		notesService.closeNotes(notesId);
		return "Closed Successfully";
	}

}
