/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.exception;

import org.wakeit.frame.exception.BasicException;
import org.wakeit.frame.model.enun.MessageSeverity;

import lombok.Getter;

/**
 * 
 * @author Edivando Alves
 * @date  10/02/2016
 * 
 */
public class ValidatorException extends BasicException {
	private static final long serialVersionUID = 1L;
	
	@Getter
	private int code;

	public ValidatorException(String message){
		this(0, null, message, null);
	}
	
	public ValidatorException(int code, String message){
		this(code, null, message, null);
	}
	
	public ValidatorException(int code, String title, String message, Throwable e){
		super(title, message, MessageSeverity.WARNING, e);
		this.code = code;
	}

}
