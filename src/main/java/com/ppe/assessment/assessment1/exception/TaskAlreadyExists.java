package com.ppe.assessment.assessment1.exception;

public class TaskAlreadyExists extends Exception {
	private static final long serialVersionUID = 4622821263658145740L;
	private final String title;

    public TaskAlreadyExists(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
