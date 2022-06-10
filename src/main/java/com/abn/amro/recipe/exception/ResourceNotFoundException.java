package com.abn.amro.recipe.exception;
/**
 * CustomException class (ResourceNotFoundException) should extends the RuntimeException
 * So, the calling code method no need to use the throws clause.
 * 
 * @author gpvkki
 *
 */
public class ResourceNotFoundException extends RuntimeException{
	
    private static final long serialVersionUID = 1L; 	

	public ResourceNotFoundException(String message) {
		super(message);
   }

}
