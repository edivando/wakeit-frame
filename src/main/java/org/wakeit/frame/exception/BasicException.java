/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@rocketti.com.br ( http://www.rocketti.com.br )
 * 
 * @copyright  	Copyright 2017 RocketTi Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.exception;

import org.wakeit.frame.model.enun.MessageSeverity;

import lombok.Getter;


/**
 * 
 * @author Edivando Alves
 * @date  10/02/2016
 * 
 */
public class BasicException extends Exception {
	private static final long serialVersionUID = 1L;
	
	@Getter
	private String title;
	@Getter
	private MessageSeverity severity;
	
	public BasicException(String message){
		this("", message, null);
	}
	
	public BasicException(String title, String message){
		this(title, message, MessageSeverity.ERROR, null);
	}
	
	public BasicException(String title, String message, Throwable e){
		this(title, message, MessageSeverity.ERROR, e);
	}
	
	public BasicException(String title, String message, MessageSeverity severity, Throwable e){
		super(message, e);
		this.title = title;
		this.severity = severity;
	}
}
