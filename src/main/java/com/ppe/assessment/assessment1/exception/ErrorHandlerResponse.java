package com.ppe.assessment.assessment1.exception;

public class ErrorHandlerResponse {
	    private static final boolean FAILURE = false;
	    private final boolean success;
	    private final String message;

	    private ErrorHandlerResponse(boolean success, String message) {
	        this.success = success;
	        this.message = message;
	    }

	    public boolean isSuccess() {
	        return success;
	    }

	    public String getMessage() {
	        return message;
	    }

	    static ErrorHandlerResponse fail(String message) {
	        return new ErrorHandlerResponse(FAILURE, message);
	    }
}
