package com.patitas.mascotas.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(final String message) {
		super(message);
	}

}
