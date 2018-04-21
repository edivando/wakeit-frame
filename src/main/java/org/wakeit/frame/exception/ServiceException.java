/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.exception;

import org.wakeit.frame.model.ExceptionJson;
import org.wakeit.util.exception.BasicException;

import lombok.Getter;

/**
 * 
 * @author Edivando Alves
 * @date  10/02/2016
 * 
 */
public class ServiceException extends BasicException {
	private static final long serialVersionUID = 1L;
	
	@Getter
	private int code;

	public ServiceException(String message){
		this(0, null, message);
	}
	
	public ServiceException(int code, String message){
		this(code, null, message);
	}
	
	public ServiceException(String title, String message){
		super(title, message);
		this.code = 0;
	}
	
	public ServiceException(int code, String title, String message){
		super(title, message);
		this.code = code;
	}
	
	
	public ServiceException(String message, Throwable e){
		this(0, e.getClass().getSimpleName(), message, e);
	}
	
	public ServiceException(int code, String message, Throwable e){
		this(code, e.getClass().getSimpleName(), message, e);
	}
	
	public ServiceException(String title, String message, Throwable e){
		this(0, title, message, e);
	}
	
	public ServiceException(int code, String title, String message, Throwable e){
		super(title, message, e);
		this.code = code;
	}
	
	public String toJSON(){
		return new ExceptionJson(code, getMessage(), getTitle()).toJSON();
	}
	
}
