/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@rocketti.com.br ( http://www.rocketti.com.br )
 * 
 * @copyright  	Copyright 2017 RocketTi Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.exception;

/**
 * 
 * @author Edivando Alves
 * @date  10/02/2016
 * 
 */
public class DAOException extends BasicException {
	private static final long serialVersionUID = 1L;
	
	public DAOException(String message){
		super(message);
	}
	
	public DAOException(String title, String message){
		super(title, message);
	}
	
	public DAOException(String message, Throwable e){
		super(e.getClass().getSimpleName(), message, e);
	}
}
