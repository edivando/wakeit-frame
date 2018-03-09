/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.exception;

import lombok.Getter;


/**
 * 
 * @author Edivando Alves
 * @date  10/02/2016
 * 
 */
public class BasicRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	@Getter
	private String title;
	@Getter
	private String severity;
	
	public BasicRuntimeException(String message){
		this("", message, null);
	}
	
	public BasicRuntimeException(String title, String message){
		this(title, message, "ERROR", null);
	}
	
	public BasicRuntimeException(String title, String message, Throwable e){
		this(title, message, "ERROR", e);
	}
	
	public BasicRuntimeException(String title, String message, String severity, Throwable e){
		super(message, e);
		this.title = title;
		this.severity = severity;
	}
}
