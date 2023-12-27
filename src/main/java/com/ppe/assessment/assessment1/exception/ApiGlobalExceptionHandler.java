package com.ppe.assessment.assessment1.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ppe.assessment.assessment1.controller.TutorialController;

@ControllerAdvice(assignableTypes = {TutorialController.class})
public class ApiGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(TaskNotFound.class)
	public final ResponseEntity<ErrorHandlerResponse> handleTaskNotFoundException(TaskNotFound ex) {
		
		ex.getStackTrace();
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(TaskAlreadyExists.class)
	public final ResponseEntity<ErrorHandlerResponse> handleTaskAlreadyExistsException(TaskAlreadyExists ex) {
		
		String message = "Task with title: " + ex.getTitle() + " already exists";
		
		ex.getStackTrace();
		return ResponseEntity.ok(ErrorHandlerResponse.fail(message));
		
	}
}
