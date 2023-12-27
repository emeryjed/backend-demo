package com.ppe.assessment.assessment1.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppe.assessment.assessment1.entities.Tutorial;
import com.ppe.assessment.assessment1.exception.TaskAlreadyExists;
import com.ppe.assessment.assessment1.repositories.TutorialRepository;
import com.ppe.assessment.assessment1.services.TutorialService;

@Service
public class TutorialServiceImpl implements TutorialService {

	@Autowired TutorialRepository repo;
	
	@Override
	public void save(Tutorial tutorial) throws TaskAlreadyExists {
		
		if (tutorial.getTitle().equalsIgnoreCase("TaskAlreadyExistsException")) {
			throw new TaskAlreadyExists(tutorial.getTitle());
		} else {
			repo.save(tutorial);
		}
		
	}
	
	@Override
	public Optional<Tutorial> fetch(Long id) {
		
		return repo.findById(id); 
	} 
	
}
