/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@rocketti.com.br ( http://www.rocketti.com.br )
 * 
 * @copyright  	Copyright 2017 RocketTi Solutions, all rights reserved.
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
public class ServiceRuntimeException extends BasicRuntimeException {
	private static final long serialVersionUID = 1L;
	
	@Getter
	private int code;

	public ServiceRuntimeException(String message){
		this(0, null, message);
	}
	
	public ServiceRuntimeException(int code, String message){
		this(code, null, message);
	}
	
	public ServiceRuntimeException(String title, String message){
		super(title, message);
		this.code = 0;
	}
	
	public ServiceRuntimeException(int code, String title, String message){
		super(title, message);
		this.code = code;
	}
	
	
	public ServiceRuntimeException(String message, Throwable e){
		this(0, e.getClass().getSimpleName(), message, e);
	}
	
	public ServiceRuntimeException(int code, String message, Throwable e){
		this(code, e.getClass().getSimpleName(), message, e);
	}
	
	public ServiceRuntimeException(String title, String message, Throwable e){
		this(0, title, message, e);
	}
	
	public ServiceRuntimeException(int code, String title, String message, Throwable e){
		super(title, message, e);
		this.code = code;
	}
	

}
