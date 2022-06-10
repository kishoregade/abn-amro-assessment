package com.abn.amro.recipe.exception;

import lombok.Data;
/**
 * Error details will Map to this Class.
 * @author gpvkki
 *
 */
@Data
public class ErrorDetails {
	
	private String date;
	private String details;
	private String message;
	
	
	public ErrorDetails(String date, String details, String message) {
		super();
		this.date = date;
		this.details = details;
		this.message = message;
	}
		

}
