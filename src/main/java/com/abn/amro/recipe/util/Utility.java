package com.abn.amro.recipe.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utility {

	public static String getDate() {
		
		LocalDateTime dateTime = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	    String date = dateTime.format(formatter);
	    return date;
	}
}
