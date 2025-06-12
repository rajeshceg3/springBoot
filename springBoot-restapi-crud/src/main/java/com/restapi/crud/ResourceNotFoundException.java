package com.restapi.crud;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	ResourceNotFoundException(String msg){
		super(msg);
	}

	public ResourceNotFoundException(String msg, Throwable throwable ){ // Made public for wider accessibility
		super(msg, throwable);
	}
}
