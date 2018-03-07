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
 * @author edivandoalves
 * @date Feb 25, 2018
 *
 */
public class DataException extends ServiceException {
	private static final long serialVersionUID = 1L;
	
	@Getter
	private int code;

	public DataException(String message){
		this(0, null, message);
	}
	
	public DataException(int code, String message){
		this(code, null, message);
	}
	
	public DataException(String title, String message){
		super(title, message);
		this.code = 0;
	}
	
	public DataException(int code, String title, String message){
		super(title, message);
		this.code = code;
	}
	
	
	public DataException(String message, Throwable e){
		this(0, e.getClass().getSimpleName(), message, e);
	}
	
	public DataException(int code, String message, Throwable e){
		this(code, e.getClass().getSimpleName(), message, e);
	}
	
	public DataException(String title, String message, Throwable e){
		this(0, title, message, e);
	}
	
	public DataException(int code, String title, String message, Throwable e){
		super(title, message, e);
		this.code = code;
//		new AppSystemBug().title(getClass().getSimpleName()+code+" - "+title).erro(e).save();
	}
	
}
