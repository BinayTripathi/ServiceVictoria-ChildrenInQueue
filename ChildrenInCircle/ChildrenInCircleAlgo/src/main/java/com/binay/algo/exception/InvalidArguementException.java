package com.binay.algo.exception;

import lombok.extern.slf4j.Slf4j;


/**
 * 
 * @author Binay
 * Exception class to show invalid arguement
 *
 */
@Slf4j
public class InvalidArguementException extends Exception {

	private static final long serialVersionUID = -8125692421334239612L;
	
	public InvalidArguementException(String message) {
		
		super(message);
		log.error(message);
		
	}

}
