package com.ppe.assessment.assessment1.exception;

public class TaskNotFound extends Exception {
	private static final long serialVersionUID = -4492814610464719537L;

	public TaskNotFound(Long id) {
        super("Task with id: " + id + " not found.");
    }
}