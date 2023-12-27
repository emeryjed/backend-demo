package com.ppe.assessment.assessment1.services;

import java.util.Optional;

import com.ppe.assessment.assessment1.entities.Tutorial;
import com.ppe.assessment.assessment1.exception.TaskAlreadyExists;

public interface TutorialService {

	public void save(Tutorial tutorial) throws TaskAlreadyExists;
	public Optional<Tutorial> fetch(Long id);
	
}
