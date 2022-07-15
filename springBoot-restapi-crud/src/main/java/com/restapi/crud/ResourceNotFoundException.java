package com.restapi.crud;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RunTimeException{
	private static final long serialVersionUID = 1L;

	ResourceNotFoundException(String msg){
		super(msg);
	}

	ResourceNotFoundException(String msg, Throwable throwable ){
		super(msg, throwable);
	}
}